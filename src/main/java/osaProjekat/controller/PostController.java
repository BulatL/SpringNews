package osaProjekat.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import osaProjekat.entity.Comment;
import osaProjekat.entity.Post;
import osaProjekat.entity.Tag;
import osaProjekat.service.CommentServiceInterface;
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
	
	@Autowired
	private CommentServiceInterface commentServiceInterface;
	
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		List<Post> posts = postServiceInterface.findAll();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/author/{authorName}")
	public ResponseEntity<List<PostDTO>> searchPostByAuthor(@PathVariable("authorName") String authorName){
		List<Post> posts = postServiceInterface.findByAuthor(userServiceInterface.findByUsername(authorName));
		if(posts.size() < 1) {
			return new ResponseEntity<List<PostDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<PostDTO> postsDTO = new ArrayList<PostDTO>();
			for(Post p:posts) {
				postsDTO.add(new PostDTO(p));
			}
			return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/tagName/{tagName}")
	public ResponseEntity<List<PostDTO>> searchPostByTagName(@PathVariable("tagName") String tagName){
		System.out.println(tagName + "\n");
		Tag tag = tagServiceInterface.findByName(tagName);
		System.out.println("\n"+tag + " \n");
		List<Post> posts = postServiceInterface.findByTag_Name(tagName);
		System.out.println("\n"+posts + " \n");
		if(posts.size() == 0) {
			return new ResponseEntity<List<PostDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<PostDTO> postsDTO = new ArrayList<PostDTO>();
			for(Post p:posts) {
				postsDTO.add(new PostDTO(p));
			}
			return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Long id){
		Post post = postServiceInterface.findOne(id);
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@GetMapping(value="/tagId/{id}")
	public ResponseEntity<List<PostDTO>> getPostByTag(@PathVariable("id") Long id){
		List<Post> postByTag = postServiceInterface.findByTag_Id(id);
		if(postByTag.size() == 0) {
			return new ResponseEntity<List<PostDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<PostDTO> postsDTO = new ArrayList<PostDTO>();
			for(Post p:postByTag) {
				postsDTO.add(new PostDTO(p));
			}
			return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/sort/bycomments")
	public ResponseEntity<List<PostDTO>> getPostsSortedCom(){
		List<Post> posts = postServiceInterface.findAll();
		for(Post p:posts) {
			List<Comment> comments = commentServiceInterface.findByPost(p);
			Set<Comment> setComments=new HashSet<Comment>(comments);
			p.setComments(setComments);
		}
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();

		Collections.sort(posts, new Comparator<Post>() {
			@Override
			public int compare(Post o1, Post o2) {
				System.out.println(o1.getComments() +"\n");
				return o1.getComments().size() - o2.getComments().size();
			}
		});
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/sort/bylikes")
	public ResponseEntity<List<PostDTO>> getPostsSortByLikes(){
		List<Post> posts = postServiceInterface.findAllByOrderByLikesDesc();
		List<PostDTO> postsDTO = new ArrayList<>();
		for(Post p:posts){
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
	}

	@PostMapping(consumes="application/json")
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO){
		Post post = new Post();
		System.out.println(postDTO.getPhoto() + "\n");
		System.out.println(postDTO.getPhoto().toString() + "\n");
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setDate(postDTO.getDate());
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		post.setPhoto(postDTO.getPhoto());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setAuthor(userServiceInterface.findByUsername(postDTO.getAuthor().getUsername()));
		
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
		post.setAuthor(userServiceInterface.findByUsername(postDTO.getAuthor().getUsername()));
		
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