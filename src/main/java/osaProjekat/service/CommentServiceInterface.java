package osaProjekat.service;

import java.util.List;

import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;

public interface CommentServiceInterface {

	List<Comment> findAll();
	
	Comment findById(Long commentId);
	
	List<Comment> findByPost(Post post);
	
	Comment save(Comment comment);
	
	void remove(Long id);
}