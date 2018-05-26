package osaProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByPost(Post post);
}