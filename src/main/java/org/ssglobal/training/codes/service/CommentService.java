package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.model.Comment;

public interface CommentService {
	List<Comment> getAllComments(Integer productId);
	void addComment(Comment comment);
	void updateComment(Integer commentId, Comment comment);
	void deleteComment(Integer commentId);
}
