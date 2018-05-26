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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private Long id;
	 
	
	@Column(name="name", unique=false, nullable=false)
	private String name;
	  
	@Column(name="username", unique=false, nullable=false)
	private String username;
	  
	@Column(name="password", unique=false, nullable=false)
	private String password;
	  
	  
	@Column(name="photo", unique=false, nullable=true)
	private byte[] photo;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "author")
    private Set<Comment> comments=new HashSet<Comment>();

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "author")
    private Set<Post> posts=new HashSet<Post>();
	
	public User() {
		  
	}

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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	  
	  
}
