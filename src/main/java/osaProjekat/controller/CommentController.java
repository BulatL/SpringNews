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

import osaProjekat.dto.CommentDTO;
import osaProjekat.entity.Comment;
import osaProjekat.service.CommentServiceInterface;
import osaProjekat.service.PostServiceInterface;
import osaProjekat.service.UserServiceInterface;


@RestController
@RequestMapping(value="/api/comments")
public class CommentController {

	@Autowired
	private CommentServiceInterface commentServiceInterface;
	
	@Autowired
	private PostServiceInterface postServiceInterface;
	
	@Autowired 
	private UserServiceInterface userServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<CommentDTO>> getAllComments(){
		List<Comment> comments = commentServiceInterface.findAll();
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for(Comment c:comments) {
			commentsDTO.add(new CommentDTO(c));
		}
		return new ResponseEntity<List<CommentDTO>>(commentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CommentDTO> getCommentById(@PathVariable("id") Long id){
		Comment comment = commentServiceInterface.findById(id);
		if(comment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/post/{id}")
	public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable("id") Long id){
		List<Comment> commentByPost = commentServiceInterface.findByPost(postServiceInterface.findOne(id));
		
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for(Comment c:commentByPost) {
			commentsDTO.add(new CommentDTO(c));
		}
		
		return new ResponseEntity<List<CommentDTO>>(commentsDTO,HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO){
		Comment comment = new Comment();
		comment.setTitle(commentDTO.getTitle());
		comment.setDescription(commentDTO.getDescription());
		comment.setDate(commentDTO.getDate());
		comment.setLikes(commentDTO.getLikes());
		comment.setDislikes(commentDTO.getDislikes());
		comment.setAuthor(userServiceInterface.findOne(commentDTO.getAuthor().getId()));
		comment.setPost(postServiceInterface.findOne(commentDTO.getPost().getId()));
		
		comment = commentServiceInterface.save(comment);
		return new ResponseEntity<CommentDTO>(HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO,@PathVariable("id") Long id){
		Comment comment = commentServiceInterface.findById(id);
		
		if(comment == null) {
			return new ResponseEntity<CommentDTO>(HttpStatus.BAD_REQUEST);
		}
		comment.setTitle(commentDTO.getTitle());
		comment.setDescription(commentDTO.getDescription());
		comment.setDate(commentDTO.getDate());
		comment.setLikes(commentDTO.getLikes());
		comment.setDislikes(commentDTO.getDislikes());
		comment.setAuthor(userServiceInterface.findOne(commentDTO.getAuthor().getId()));
		comment.setPost(postServiceInterface.findOne(commentDTO.getPost().getId()));
		
		comment = commentServiceInterface.save(comment);
		return new ResponseEntity<CommentDTO>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long id){
		Comment comment = commentServiceInterface.findById(id);
		if(comment != null) {
			commentServiceInterface.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}