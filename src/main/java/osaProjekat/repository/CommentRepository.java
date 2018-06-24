package osaProjekat.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;
import osaProjekat.entity.User;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByPost(Post post);
	
	List<Comment> findByAuthor(User user);
	
	List<Comment> findAllByOrderByLikes();
	
	List<Comment> findByPost(Post post, Sort sort);
}