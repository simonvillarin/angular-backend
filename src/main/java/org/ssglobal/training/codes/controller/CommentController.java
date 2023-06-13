package org.ssglobal.training.codes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.training.codes.model.Comment;
import org.ssglobal.training.codes.service.impl.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {
	
	private final CommentServiceImpl commentServiceImpl;
	
	@GetMapping("/comments/{id}")
	public ResponseEntity<List<Comment>> getAllComments(@PathVariable("id") Integer productId) {
		return ResponseEntity.ok(commentServiceImpl.getAllComments(productId));
	}
	
	@PostMapping("/comment")
	public void addComment(@RequestBody Comment comment) {
		commentServiceImpl.addComment(comment);
	}
	
	@PutMapping("/comment/{id}")
	public void updateComment(@PathVariable("id") Integer commentId, @RequestBody Comment comment) {
		commentServiceImpl.updateComment(commentId, comment);
	}
	
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable("id") Integer commentId) {
		commentServiceImpl.deleteComment(commentId);
	}
}
