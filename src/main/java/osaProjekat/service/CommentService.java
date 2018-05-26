package osaProjekat.service;

import java.util.List;
import java.util.Optional;

import javax.validation.OverridesAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import osaProjekat.repository.CommentRepository;
import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;

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
