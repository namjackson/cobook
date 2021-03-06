package org.ebook.cobook.mypage.persistence;

import java.util.List;
import java.util.Map;

public interface MyPageDAO {

	
	// 내가 작성한 리뷰 리스트
	public List<Map<String, Object>> getMyBookReviewList(Map<String, Object> paramMap)throws Exception;

	// 내가쓴 마이북 리뷰 리스트
	public List<Map<String, Object>> getUserMybookList(Map<String, Object> paramMap)throws Exception;

	// 내가 빌린 책 리스트
	public List<Map<String, Object>> getMyborrowList(Map<String, Object> paramMap)throws Exception;

	
}
