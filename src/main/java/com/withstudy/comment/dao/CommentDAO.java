package com.withstudy.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.withstudy.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	// 댓글
	public int insertComment(
			@Param("userId") int userId,
			@Param("studyId") int studyId,
			@Param("content") String content);
	
	public List<Comment> selectcommentListByUserId(Integer userId);
	
	// 댓글 데이터
	public List<Comment> selectcommentListByStudyId(int studyId);
}
