package com.withstudy.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withstudy.comment.dao.CommentDAO;
import com.withstudy.comment.model.Comment;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentdao;
	
	//select
	// 댓글 데이터 가져오기
	public List<Comment> getcommentListByStudyId(int studyId) {
		
		return commentdao.selectcommentListByStudyId(studyId);
	}
	
	//insert
	//댓글
	public int addComment(int userId, int studyId, String content) {
		
		return commentdao.insertComment(userId, studyId, content);
	}
}
