package osaProjekat.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag implements Serializable{

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="tag_id", unique=true, nullable=false)
	private Long id;
	 
	
	@Column(name="name", unique=false, nullable=false)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "tags")
    private Set<Post> posts = new HashSet<Post>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Tag() {
	}

	public Tag(Long id, String name, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.posts = posts;
	}
}
