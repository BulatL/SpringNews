package osaProjekat.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment implements Serializable{
    
    @Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="comment_id", unique=true, nullable=false)
	private Long id;
	 
	
	@Column(name="title", unique=false, nullable=false)
	private String title;
	  
	@Column(name="description", unique=false, nullable=false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="author_id", referencedColumnName="user_id", nullable=false)
	private User author;

	@Column(name="date", unique=false, nullable=false)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="post_id", referencedColumnName="post_id", nullable=false)
	private Post post;

	@Column(name="likes", unique=false, nullable=true)
	private Integer likes;
	  
	@Column(name="dislikes", unique=false, nullable=true)
	private Integer dislikes;
	
	public Comment() {
		
	}

	public Comment(Long id, String title, String description, User author, Date date, Post post, Integer likes,
			Integer dislikes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.date = date;
		this.post = post;
		this.likes = likes;
		this.dislikes = dislikes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}
	
	
}
