package osaProjekat.service;

import java.util.List;
import java.util.Optional;

import javax.validation.OverridesAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import osaProjekat.repository.CommentRepository;
import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;
import osaProjekat.entity.User;

@Service
public class CommentService implements CommentServiceInterface{

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment findById(Long commentId) {
		return commentRepository.getOne(commentId);
	}

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findByAuthor(User user){
		return commentRepository.findByAuthor(user);
	}
	
	@Override
	public List<Comment> findAllByOrderByLikes() {
		return commentRepository.findAllByOrderByLikes();
	}
	
	@Override
	public List<Comment> findByPost(Post post, Sort sort) {
		return commentRepository.findByPost(post,sort);
	}
	@Override
	public List<Comment> findByPost(Post post) {
		return commentRepository.findByPost(post);
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void remove(Long id) {
		commentRepository.deleteById(id);
	}
}
