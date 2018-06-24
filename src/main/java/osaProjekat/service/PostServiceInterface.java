package osaProjekat.service;

import java.util.List;

import osaProjekat.entity.Post;
import osaProjekat.entity.Tag;
import osaProjekat.entity.User;

public interface PostServiceInterface {
	
	List<Post> findAll();
	
	//List<Post> findByAuthor(String authorName);
	
	List<Post> findByAuthor(User user);
	
	List<Post> findByTag_Name(String tagName);
	
	Post findOne(Long postId);
	
	List<Post> findAllByOrderByLikesDesc();
	
	List<Post> findByTag_Id(Long tagId);
	
	Post save(Post post);
	
	void remove(Long id);
	
}