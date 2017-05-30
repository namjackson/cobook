package org.ebook.cobook.member.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ebook.cobook.member.domain.MemberVO;
import org.ebook.cobook.member.persistence.MemberDAO;
import org.ebook.cobook.mypage.persistence.MyPageDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;
	private MyPageDAO mypageDAO;
	
	
	@Override
	public void joinMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.joinMember(vo);
	}

	@Override
	public void modifyMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.modifyMember(vo);
	}

	@Override
	public boolean checkEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		MemberVO member = memberDAO.getEmail(email);
		if (member != null) {
			return true;
		}

		return false;
	}

	@Override
	public MemberVO getMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.getMember(vo);
	}

/*	@Override
	public MemberVO getMyPoint(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		 
		return memberDAO.getMyPoint(vo);
	}
*/
	@Override
	public MemberVO chargePoint(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.chargePoint(vo);
		return memberDAO.getMyPoint(vo);
	}

	@Override
	public List<Map<String, Object>> getMyBookReviewList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getUserMybookList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getMyborrowList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
