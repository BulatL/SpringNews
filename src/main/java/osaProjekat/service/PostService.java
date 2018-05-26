package osaProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import osaProjekat.entity.Post;
import osaProjekat.repository.PostRepository;

@Service
public class PostService implements PostServiceInterface{

	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
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
