package osaProjekat.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;
import osaProjekat.entity.User;

public interface CommentServiceInterface {

	List<Comment> findAll();
	
	Comment findById(Long commentId);
	
	List<Comment> findByPost(Post post);
	
	List<Comment> findAllByOrderByLikes();
	
	List<Comment> findByPost(Post post,Sort sort);
	
	List<Comment> findByAuthor(User user);
	
	Comment save(Comment comment);
	
	void remove(Long id);
}