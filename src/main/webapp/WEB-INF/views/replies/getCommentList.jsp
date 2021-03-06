<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- comment -->
<c:forEach items="${commentList}" var="commentList" varStatus="status">
				<div class="comment-up" id="comment-up">
						<p>${commentList.contents}</p>
						<!-- comment-delete -->
						<p>
							${commentList.nickName}/
							<fmt:formatDate value="${commentList.reg_date}" pattern="yyyy-MM-dd"/>/ 
							<a href="#" onclick="return false;" class="comment-delete" id="comment-delete"  data-parent_no="${parent_no}"  data-member_no="${commentList.member_no}"  data-reply_no="${commentList.reply_no}">삭제</a>
						</p>
				</div>
</c:forEach>
				<textarea class="comment-textarea" rows="5" id="commentContents${parent_no}" placeholder="이 곳에 댓글을 남겨주세요"></textarea>
				<button type="button" class="comment-regi addComment" id="addComment"  data-parent_no="${parent_no}">등록하기</button>
			