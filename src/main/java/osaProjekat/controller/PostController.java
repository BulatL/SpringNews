package osaProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import osaProjekat.dto.PostDTO;
import osaProjekat.entity.Post;
import osaProjekat.entity.Tag;
import osaProjekat.service.PostServiceInterface;
import osaProjekat.service.TagServiceInterface;
import osaProjekat.service.UserServiceInterface;


@RestController
@RequestMapping(value="/api/posts")
public class PostController {

	@Autowired
	private PostServiceInterface postServiceInterface;
	
	@Autowired 
	private UserServiceInterface userServiceInterface;
	
	@Autowired
	private TagServiceInterface tagServiceInterface;
	
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		List<Post> posts = postServiceInterface.findAll();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Long id){
		Post post = postServiceInterface.findOne(id);
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@GetMapping(value="/tag/{id}")
	public ResponseEntity<List<PostDTO>> getPostByTag(@PathVariable("id") Long id){
		List<Post> postByTag = postServiceInterface.findByTag_Id(id);
		
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:postByTag) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
	}

	@PostMapping(consumes="application/json")
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO){
		Post post = new Post();
		
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setDate(postDTO.getDate());
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		post.setPhoto(postDTO.getPhoto());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setAuthor(userServiceInterface.findOne(postDTO.getAuthor().getId()));
		
		post = postServiceInterface.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.CREATED);
	}
	
	@PostMapping(value="/setTags/{postId}/{tagId}")
	public ResponseEntity<PostDTO> setTagsInPost(@PathVariable("postId") Long postId,@PathVariable("tagId") Long tagId){
		Post post = postServiceInterface.findOne(postId);
		Tag tag = tagServiceInterface.findOne(tagId);
		
		if(post == null || tag == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		
		post.getTags().add(tag);
		tag.getPosts().add(post);
		
		
		post = postServiceInterface.save(post);
		tag = tagServiceInterface.save(tag);
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,@PathVariable("id") Long id){
		Post post = postServiceInterface.findOne(id);
		
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setDate(postDTO.getDate());
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		post.setPhoto(postDTO.getPhoto());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setAuthor(userServiceInterface.findOne(postDTO.getAuthor().getId()));
		
		post = postServiceInterface.save(post);
		
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id){
		Post post = postServiceInterface.findOne(id);
		if(post != null) {
			postServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}