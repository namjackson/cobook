<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<style type="text/css">

/* #combox{

 position: absolute; left: 500px; top: 150px;

} */
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script>
	$(function() {

		var board_no = 3;

		var parent_type = 'BOOKREVIEW';

		var member_no = 1;

		var test = '${login}';

		var page = '${cri.page}'

		var perPageNum = '${cri.perPageNum}';

		var replyPage = 1;

		getReplyList(1, 10);

		console.log(test);

		console.log("회원번호: " + member_no);

		// 좋아요 처리

		function paramAjax(url, reply_no, member_no) {

			console.log(url);

			$.ajax({

				type : "post",

				url : url,

				headers : {

					"Content-Type" : "application/json",

					"X-HTTP-Method-Override" : "POST"

				},

				dataType : "text",

				data : JSON.stringify({

					member_no : member_no,

					reply_no : reply_no

				}),

				success : function(result) {

					console.log(result);

				}

			});

		}

		$("#addReply").on("click", function() {

			var contents = $("#contents").val();

			$.ajax({

				type : 'post',

				url : '/cobook/replies/',

				headers : {

					"Content-Type" : "application/json",

					"X-HTTP-Method-Override" : "POST"

				},

				dataType : 'text',

				data : JSON.stringify({

					member_no : member_no,

					parent_type : parent_type,

					board_no : board_no,

					contents : contents

				}),

				success : function(result) {

					getReplyList(1, 10);

				}

			});

		});

		// 댓글 리스트 출력

		function getReplyList(replyPage, perPageNum) {

			var replyURL = "/cobook/replies/" + parent_type + "/" + board_no
					+ "/"

					+ replyPage + "/" + perPageNum;

			$.getJSON(replyURL, function(data) {

				console.log(data);

				console.log(data.listMap.replyList);

				// 템플릿에 잇는 html을 뽑아온후

				// handlebars 컴파일시킴 

				// 그런다음 template = 틀 에 데이터를 끼워넣은 후 replies에 html 넣어줌

				// 진입시 보여주는 리플이랑 더보기버튼이랑 분리시킴

				if (replyPage == 1) {

					printData(data.listMap.replyList, $("#replies"),

					$("#reply-template"));

				} else {

					appendPrintData(data.listMap.replyList, $("#replies"),

					$("#reply-template"));

				}

			});

		}

		// 좋아요 클릭시 이벤트처리

		$("#replies").on("click", ".like", function() {

			var linkObj = $(this);

			var imgObj = linkObj.children().first();

			var isLike = imgObj.attr("data-islike");

			var reply_no = $(this).attr("data-replyno");

			var likeObj = linkObj.next();

			var likeVal = likeObj.text();

			console.log(likeObj);

			console.log("reply_no : " + reply_no);

			if (isLike.indexOf("0") != -1) {

				console.log("isLike 타입: " + typeof isLike);

				paramAjax("/cobook/replies/addLike", reply_no, member_no);

				imgObj.attr("src", "/cobook/resources/img/light-like.png");

				imgObj.attr("data-islike", "1");

				likeObj.text(Number(likeVal) + 1);

			} else {

				paramAjax("/cobook/replies/deleteLike", reply_no, member_no);

				imgObj.attr("src", "/cobook/resources/img/like.png");

				imgObj.attr("data-islike", "0");

				likeObj.text(Number(likeVal) - 1);

			}

		});

		// 더보기 버튼 클릭시 replyPage값 1씩 증가

		$(".moreBtn").on("click", function() {

			replyPage++;

			getReplyList(replyPage, 10);

		});

		// 댓글쓰기 답글 창이 열림

		$("#replies").on("click", "#openComment", function() {

			var combox = $("#combox");

			var activation = combox.attr("data-activation");

			var parent_no = $(this).attr("data-parentNo");

			checkActivation(combox, activation);

			$("#replyData").attr("data-parentNo", parent_no);

			$("#replyData").text(parent_no);

			$("#commentTxt").focus();

		});

		// ajax로 답글 데이터 보냄

		$("#commentBtn").on("click", function() {

			var parent_no = $("#replyData").attr("data-parentNo");

			var parent_type = "BOOKREVIEW";

			var contents = $("#commentTxt").val();

			console.log(contents);

			$.ajax({

				type : 'post',

				url : '/cobook/replies/comment',

				headers : {

					"Content-Type" : "application/json",

					"X-HTTP-Method-Override" : "POST"

				},

				dataType : 'text',

				data : JSON.stringify({

					member_no : member_no,

					parent_no : parent_no,

					parent_type : parent_type,

					board_no : board_no,

					contents : contents

				}),

				success : function(result) {

					console.log(result);

					$("#commentTxt").val("");

					getReplyList(1, 10);

				}

			});

		});

		// 수정

		$("#replies").on("click", "#modBtn", function() {

			var textAreaObj = $(this).parents("li").children().eq(2);
			console.log(textAreaObj);
			var contents = $(this).text();
			console.log("수정값 확인: " + contents);
			var reply_no = $(this).attr("data-parentNo");

			$.ajax({

				type : "PUT",

				url : "/cobook/replies/" + reply_no,

				headers : {

					"Content-Type" : "application/json",

					"X-HTTP-Method-Override" : "POST"

				},

				dataType : 'text',

				data : JSON.stringify({

					contents : contents

				}),

				success : function(result) {

					console.log(result);

				}

			});

		});

		$("#replies").on("click", "#rmBtn", function() {

			
			
			
			
		});

		function checkActivation(target, checkValue) {

			if (checkValue == "false") {

				target.attr("style", "display:block");

				target.attr("data-activation", "true");

			} else {

				target.attr("style", "display:none");

				target.attr("data-activation", "false");

			}

		}

	});
</script>

<script>
	Handlebars.registerHelper("prettifyDate", function(timeValue) {

		var dateObj = new Date(timeValue);

		var year = dateObj.getFullYear();

		var month = dateObj.getMonth() + 1;

		var date = dateObj.getDate();

		return year + "/" + month + "/" + date;

	});

	// reply html을 동적으로 생성하는 메서드

	// 리플 데이타, html추가시킬 타켓, 템플릿 html

	function printData(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);

		target.html(html);

	}

	function appendPrintData(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);

		target.append(html);

	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<body>

	<h1>리플 테스트</h1>

	<p>

		작성자:&nbsp;<input type="text" id="writer" name="writer">

	</p>

	<p>

		내용:&nbsp;<input type="text" id="contents" name="contents">

	</p>

	<button id="addReply">글쓰기</button>

	<div id="replies"></div>

	<button class="moreBtn">더보기</button>





	<div id="combox" data-activation="false"
		style="position: absolute; left: 500px; top: 150px; display: none;">

		<div id="replyData" data-parentNo=""></div>

		<textarea id="commentTxt" name="contents" rows="" cols=""></textarea>

		<button id="commentBtn">답글입력</button>

	</div>





	<script id="reply-template" type="text/x-handlebars-template">

<ul>

{{#each .}}	

			<li>

				<div>reply_no : {{REPLY_NO}}, parent_no : {{PARENT_NO}}

				isLike : {{isLike}}

				</div>

				<div>No{{REPLY_NO}}:{{NICKNAME}}&nbsp;{{prettifyDate REG_DATE}}</div>

				<textarea id="replyCont">{{CONTENTS}}</textarea>

				

<a href="#" class="like" data-islike={{isLike}} data-replyNo={{REPLY_NO}}><img data-islike={{isLike}} width="30px" height="30px" src={{checkLike isLike}}></a>



				<span id="likeCount">{{LIKECOUNT}}</span>	

				<br />

				<p>

				<button id="openComment" data-parentNo={{PARENT_NO}}>답글쓰기</button>

				<button id="rmBtn">삭제</button>

				<button id="modBtn" data-parentNo={{PARENT_NO}}>수정</button>

				</p>

					

			</li>

{{/each}}			

		</ul>





	</script>

	<script>
		Handlebars.registerHelper('checkLike', function(isLike) {

			console.log("isLike : " + isLike);

			var linkURL = "";

			if (isLike.indexOf("1") != -1) {

				linkURL = "/cobook/resources/img/light-like.png";

			} else {

				linkURL = "/cobook/resources/img/like.png";

			}

			console.log("링크값: " + linkURL);

			return linkURL;

		});
	</script>



</body>

</html>