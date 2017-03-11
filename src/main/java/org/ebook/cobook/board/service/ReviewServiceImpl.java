package org.ebook.cobook.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ebook.cobook.board.domain.Criteria;
import org.ebook.cobook.board.domain.ReviewVO;
import org.ebook.cobook.board.persistence.ReviewDAO;
import org.ebook.cobook.fileUpload.domain.FilesVO;
import org.ebook.cobook.fileUpload.persistence.FilesDAO;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Inject
	private ReviewDAO reviewDAO;
	
	@Inject
	private FilesDAO filesDAO;

	// 회원의 대출목록을 가져오는 함수
	@Override
	public List<Map<String, Object>> borrowBookList(Integer member_no) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.getBorrowedBook(member_no);
	}

	// 리뷰게시물 등록과 파일등록을 수행 하는 함수
	@Override
	public void writeReview(ReviewVO reviewVO, FilesVO filesVO) throws Exception {
		// TODO Auto-generated method stub
		// selectKey태그에 의해 review_no값을 ReviewVO객체에 자동으로 셋팅된다
		reviewDAO.create(reviewVO);
		// 방금 저장한 게시물의 번호를 가져와서 
		// 파일테이블에 book_no값을 넣어줘야함
		filesVO.setBook_no(reviewVO.getReview_no());
		filesVO.setBook_type("bookreview");
		
		String[] files = filesVO.getFiles();
		if(files == null){return;}
		
		filesDAO.multiFile(files, filesVO);
	}
	
	// 리뷰게시판에 뿌려줄 게시물목록
	@Override
	public List<ReviewVO> getBookReviewList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.bookReviewList(cri);
	}

	// 페이징 처리를 위한 전체 게시물 갯수를 리턴
	@Override
	public int getBookReviewCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.getCount(cri);
	}

	// 특정 게시물 읽어오기
	@Override
	public Map<String, Object> readBookReview(Integer review_no) throws Exception {
		// TODO Auto-generated method stub
		
		reviewDAO.increseHit(review_no);
		return reviewDAO.readBookReview(review_no);
	}

	// 게시물 수정
	@Override
	public void modifyBookReview(ReviewVO reviewVO, FilesVO filesVO) throws Exception {
		// TODO Auto-generated method stub
	
		// 기존에 등록된 파일과 사용자가 수정한 파일을 비교해서 db에
		// 등록할경우 로직이 더추가 되기때문에 간결하게 하기위해서 파일을 일괄삭제
		filesDAO.deleteFile(filesVO);
		// 삭제한후 수정된 게시물 등록 & 파일 재등록
		reviewDAO.updateBookReview(reviewVO);
		// 회원이 파일을 등록햇는지 검사
		String[] files = filesVO.getFiles();
		if(files == null){return;}
		
		filesDAO.multiFile(files, filesVO);
	}

	// 게시물 삭제
	@Override
	public void removeBookReview(Integer review_no, FilesVO filesVO) throws Exception {
		// TODO Auto-generated method stub
	// 리뷰게시물을 삭제하기전에 참조관계인 파일목록을 지워야한다
		filesDAO.deleteFile(filesVO);
		reviewDAO.deleteBookReview(review_no);
	}
	
}