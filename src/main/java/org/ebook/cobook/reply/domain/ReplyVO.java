package org.ebook.cobook.reply.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.context.support.StaticApplicationContext;

@Alias("ReplyVO")
public class ReplyVO {
	public static final int limit = 3 ;	//더보기 페이징 단위 
	
 // 댓글번호, 회원번호, 부모번호, 게시물번호, 부모타입, 내용, 날짜
	private Integer reply_no;	//댓글번호
	private Integer member_no;	//작성자 번호
	private Integer parent_no;	//리플의 부모 번호
	private Integer board_no;	//몇번게시글인지
	private String parent_type;	//어떤 게시판인지
	private String contents;	//내용
	private Date reg_date;		//작성날짜
	private Integer starRating; //별점 
	private String nickName;	//닉네임
	private int likeCount; 		//좋아요 갯수
	private int commentCount;   //코멘트 갯수
	private int moreCnt;	    //더보기 카운트
	private int likeOk;  		//해당 사용자의 좋아요 유무 
	
	
	
	public int getLikeOk() {
		return likeOk;
	}
	public void setLikeOk(int likeOk) {
		this.likeOk = likeOk;
	}
	public int getMoreCnt() {
		return moreCnt;
	}
	public void setMoreCnt(int moreCnt) {
		this.moreCnt = moreCnt;
	}
	public static int getLimit() {
		return limit;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getStarRating() {
		return starRating;
	}
	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}
	public Integer getReply_no() {
		return reply_no;
	}
	public void setReply_no(Integer reply_no) {
		this.reply_no = reply_no;
	}
	public Integer getMember_no() {
		return member_no;
	}
	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}
	public Integer getParent_no() {
		return parent_no;
	}
	public void setParent_no(Integer parent_no) {
		this.parent_no = parent_no;
	}
	public Integer getBoard_no() {
		return board_no;
	}
	public void setBoard_no(Integer board_no) {
		this.board_no = board_no;
	}
	public String getParent_type() {
		return parent_type;
	}
	public void setParent_type(String parent_type) {
		this.parent_type = parent_type;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", member_no=" + member_no + ", parent_no=" + parent_no + ", board_no="
				+ board_no + ", parent_type=" + parent_type + ", contents=" + contents + ", reg_date=" + reg_date + " moreCnt = "+moreCnt+  "]";
	}
	
	
	
	
}
