<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="/resources/test/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<link rel="stylesheet"
		href="/resources/test/jquery-ui-1.12.1.custom/jquery-ui.min.css">
		<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
	<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css"
	rel="stylesheet">
<script src="/resources/editor/dist/summernote.js"></script>
<script src="/resources/editor/dist/lang/summernote-ko-KR.js"></script>
<script src="/resources/js/editorFunction.js"></script>
	<script type="text/javascript">
$(function(){
	callSummernote();
	$("#dialog").hide();
	// 팝업창 초기화
		$("#dialog").dialog({
			autoOpen : false,
			modal : true, //모달대화상자
			resizable : false, //크기 조절 못하게
			width : 500,
			height : 1000,
			// draggable: false,
			position : {
				my : "center"
			},
			buttons : {
				"확인" : function() {
					$(this).dialog("close");
				},
				"취소" : function() {
					$(this).dialog("close");
				}
			}

		});

 	// 빌린책 팝업창 클릭
	$("#borrowList").on("click", function(){
				console.log("팝업창 클릭");
				$("#dialog").show();
				$("#dialog").dialog("open");
				var member_no = 10;
				$.getJSON("/ajax/borrowedBook/" + member_no, function(data) {
					
					console.log(data);
					var template=Handlebars.compile($("#books").html());
					var html = template(data);
					$("#bookList").html(html);
				});

	});
	
	// 빌린책 리스트중 하나를 클릭 하면 히든값으로 배치됨
	$("#bookList").on("click", "#book", function(){
		console.log("책 클릭");
		console.log($(this));
		var ebook_no = $(this).data('data-ebookno');
		var src = $(this).attr(src);
		$("#ebook").val(ebook_no);
		$("#display").text(ebook_no);
		$("#setImg").attr("src", src);
	}); 

	 $("#save").on("click", function(event){
		
		event.preventDefault();
		
 
		$("#registerForm").submit();
		
	}); 
	
});
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="registerForm" action="/sample/reviewWrite" method="post">
	<input type="hidden" id="ebook_no" name="ebook_no" value="" >
	<input type="hidden" name="member_no" value="${login}">
	<input type="text" name="evaluate" value="3.0">
	<p>작성자 : <input type="text" name="nickname" value="${nickname.NICKNAME}"></p>
	<p>책 이미지파일 : <img id="setImg" alt="" src="">
	<p>제목 : <input type="text" name="title"></p>
<p>	내용 : <textarea id='summernote' name="contents" rows="" cols=""></textarea></p>
	<button type="button" id="borrowList"  name="button">my book list</button>
	<div class="form-group">
			<ul class="list-group">
			</ul>
	</div>
	<input type="button" id="save" value="저장하기">
	</form>
	<div id="display"></div>
	
	
	
	
	<div id="dialog" title="대여한책">
		<div id="bookList">
			<p><img src="" alt="책이미지" /></p>
			<p>책이름</p>
		</div>


	</div>
<script id="books" type="text/x-handlebars-template">
{{#each .}}
<p><a id="book" href="#" data-ebookno={{EBOOK_NO}} data-src={{COVERURL}} ><img src='{{COVER_URL}}' alt="책이미지" />
</a></p>
			<p>{{TITLE}}</p>
{{/each}}
</script>

</body>
</html>
