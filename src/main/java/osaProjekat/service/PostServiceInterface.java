package osaProjekat.service;

import java.util.List;

import osaProjekat.entity.Post;

public interface PostServiceInterface {
	
	List<Post> findAll();
	
	Post findOne(Long postId);
	
	List<Post> findByTag_Id(Long tagId);
	
	Post save(Post post);
	
	void remove(Long id);
}