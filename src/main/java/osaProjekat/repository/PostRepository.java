package osaProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import osaProjekat.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	List<Post> findByTagsId(Long tagId);
}
