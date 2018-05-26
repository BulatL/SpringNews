package osaProjekat.dto;

import java.io.Serializable;
import osaProjekat.entity.Tag;

public class TagDTO implements Serializable{

	private Long id;
	private String name;
	
	public TagDTO() {
		super();
	}

	public TagDTO(Tag tag) {
		this(tag.getId(),tag.getName());
	}
	
	public TagDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
