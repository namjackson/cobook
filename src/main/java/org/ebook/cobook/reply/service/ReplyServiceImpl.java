package org.ebook.cobook.reply.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ebook.cobook.likeIt.domain.Like_itVO;
import org.ebook.cobook.reply.domain.ReplyVO;
import org.ebook.cobook.reply.domain.StarVO;
import org.ebook.cobook.reply.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDao;
	/*
	 * (non-Javadoc)
	 * @see org.ebook.cobook.reply.service.ReplyService#addReply(org.ebook.cobook.reply.domain.ReplyVO)
	 * 리플과 코멘트 등록
	 */
	@Override
	public String addReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub 
		String result="FAIL";
		//이미 작성한댓글이있는지 체크 select 
		if(vo.getParent_type().equals("EBOOK")){
			if(replyDao.addReplyCheck(vo)==null){
				replyDao.addReply(vo);
				replyDao.addStarRating(vo);
				result="SUCCESS";
			}else{
				result="FAIL";
			}
		}else{
			replyDao.addReply(vo);
			result="SUCCESS";
		}
		return result;
	}
	@Override
	public void addComment(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.addComment(vo);
	}

	@Override
	public List<Map<String, Object>> replyAndLike_itList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.replyList(map);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.updateReply(vo);
	}

	@Override
	public void deleteReply(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		replyDao.deleteReply(rno);
	}

	
	@Override
	public void addLikeIt(Like_itVO vo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.addLikeIt(vo);
	}

	@Override
	public void deleteLikeIt(Like_itVO vo)throws Exception{
		// TODO Auto-generated method stub
		replyDao.deleteLikeIt(vo);
	}

	@Override
	public List<Map<String, Object>> getLikeList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.getLikeList(paramMap);
	}

	@Override
	public int getReplyCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.getReplyCount(map);
	}
	
	

	

}
