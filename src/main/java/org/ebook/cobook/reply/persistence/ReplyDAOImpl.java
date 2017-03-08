package org.ebook.cobook.reply.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ebook.cobook.board.domain.Criteria;
import org.ebook.cobook.likeIt.domain.Like_itVO;
import org.ebook.cobook.reply.domain.ReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	
	private final String namespace = "org.ebook.cobook.mapper.ReplyMapper";

	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertReply", vo);
	}

	@Override
	public List<Map<String, Object>> replyList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".replyList", map);
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateReply", vo);
	}

	@Override
	public void deleteReply(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteReply", rno);
	}

	@Override
	public void insertComment(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertComment", vo);
	}

	@Override
	public void insertLike_it(Like_itVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertLike_it", vo);
	}

	@Override
	public void deleteLike_it(Integer like_it_no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteLike_it", like_it_no);
	}
	
	

}
