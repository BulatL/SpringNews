package osaProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import osaProjekat.entity.Post;
import osaProjekat.entity.Tag;
import osaProjekat.entity.User;
import osaProjekat.repository.PostRepository;

@Service
public class PostService implements PostServiceInterface{

	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	/*@Override
	public List<Post> findByAuthor(String authorName) {
		return postRepository.findByAuthor(authorName);
	}*/
	
	@Override
	public List<Post> findByAuthor(User user) {
		return postRepository.findByAuthor(user);
	}
	
	@Override
	public List<Post> findByTag_Name(String tagName) {
		return postRepository.findByTagsName(tagName);
	}
	
	@Override
	public List<Post> findAllByOrderByLikesDesc() {
		return postRepository.findAllByOrderByLikesDesc();
	}


	@Override
	public Post findOne(Long postId) {
		return postRepository.getOne(postId);
	}

	@Override
	public List<Post> findByTag_Id(Long tagId) {
		return postRepository.findByTagsId(tagId);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void remove(Long id) {
		postRepository.deleteById(id);
		
	}
}
