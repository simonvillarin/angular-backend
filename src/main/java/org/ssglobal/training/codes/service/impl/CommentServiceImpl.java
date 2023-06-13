package org.ssglobal.training.codes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.ssglobal.training.codes.model.Comment;
import org.ssglobal.training.codes.repository.CommentRepository;
import org.ssglobal.training.codes.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	private final CommentRepository commentRepository;

	@Override
	public List<Comment> getAllComments(Integer productId) {
		return commentRepository.findByProductId(productId);
	}

	@Override
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public void updateComment(Integer commentId, Comment comment) {
		Optional<Comment> commentOpt = commentRepository.findById(commentId);
		if (commentOpt.isPresent()) {
			Comment _comment = commentOpt.get();
			if (comment.getCommentator() != null) {
				_comment.setCommentator(comment.getCommentator());
			}
			if (comment.getRating() != null) {
				_comment.setRating(comment.getRating());
			}
			if (comment.getCommentDate() != null) {
				_comment.setCommentDate(comment.getCommentDate());
			}
			if (comment.getComment() != null) {
				_comment.setComment(comment.getComment());
			}
			commentRepository.save(_comment);
		} else {
			throw new RuntimeException("Comment not found");
		}
	}

	@Override
	public void deleteComment(Integer commentId) {
		Optional<Comment> commentOpt = commentRepository.findById(commentId);
		if (commentOpt.isPresent()) {
			commentRepository.deleteById(commentId);
		} else {
			throw new RuntimeException("Comment not found");
		}
	}

}
