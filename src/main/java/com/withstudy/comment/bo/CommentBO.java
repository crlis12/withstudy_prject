package com.withstudy.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.comment.dao.CommentDAO;
import com.withstudy.comment.model.Comment;
import com.withstudy.comment.model.CommentView;
import com.withstudy.user.bo.UserBO;
import com.withstudy.user.model.User;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentdao;
	
	@Autowired
	private UserBO userBO;
	//select
	// 댓글 데이터 가져오기
	public List<Comment> getcommentListByStudyId(int studyId) {
		
		return commentdao.selectcommentListByStudyId(studyId);
	}
	
	public List<Comment> getcommentListByUserId(Integer userId){
		
		return commentdao.selectcommentListByUserId(userId);
	}
	
	//insert
	//댓글
	public int addComment(int userId, int studyId, String content) {
		
		return commentdao.insertComment(userId, studyId, content);
	}
	
	//댓글 리스트
	public List<CommentView> getCommentViewList(int studyId){
		List<CommentView> resultList = new ArrayList<>();
		List<Comment> commentList = getcommentListByStudyId(studyId); 
		
		for(Comment comment : commentList) {
			CommentView commentView = new CommentView();
			
			commentView.setComment(comment);
			User user = userBO.getUserByuserId(comment.getUserId());
			
			commentView.setUser(user);
			
			resultList.add(commentView);
		}
		return resultList;
	}
	
}
