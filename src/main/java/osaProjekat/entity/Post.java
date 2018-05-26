package osaProjekat.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="post")
public class Post implements Serializable{
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="post_id", unique=true, nullable=false)
	private Long id;
	 
	
	@Column(name="title", unique=false, nullable=false)
	private String title;
	  
	@Column(name="description", unique=false, nullable=false)
	private String description;
	
	@Lob
	@Column(name="photo", unique=false, nullable=true)
	private byte[] photo;
	
	@ManyToOne
	@JoinColumn(name="author_id", referencedColumnName="user_id", nullable=false)
	private User author;
	
	@Column(name="likes", unique=false, nullable=false)
	private Integer likes;
	
	@Column(name="dislikes", unique=false, nullable=false)
	private Integer dislikes;
	
	@Column(name="date", unique=false, nullable=false)
	private Date date;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "post")
    private Set<Comment> comments=new HashSet<Comment>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "tags_post",joinColumns = { @JoinColumn(name = "post_id") },
    			inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tag> tags = new HashSet<Tag>();
    
	
	@Column(name="longitude", unique=false, nullable=false)
	private float longitude;
	
	@Column(name="latitude", unique=false, nullable=false)
	private float latitude;
	
	
	public void add(Comment comment) {
		if(comment.getPost()!= null) {
			comment.getPost().getComments().remove(comment);
		}
		comment.setPost(this);
		getComments().add(comment);
	}
	
	public void remove(Comment comment) {
		comment.setPost(null);
		getComments().remove(comment);
	}
	
	public void Tag(Tag tag) {
		tags.add(tag);
		tag.getPosts().add(this);
	}
	
	public void remove(Tag tag) {
		tags.remove(tag);
		tag.getPosts().remove(this);
	}
	
	
	public Post() {
    }

	

	public Post(Long id, String title, String description, byte[] photo, User author, Integer likes, Integer dislikes,
			Date date, Set<Comment> comments, Set<osaProjekat.entity.Tag> tags, float longitude, float latitude) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.author = author;
		this.likes = likes;
		this.dislikes = dislikes;
		this.date = date;
		this.comments = comments;
		this.tags = tags;
		this.longitude = longitude;
		this.latitude = latitude;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
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
