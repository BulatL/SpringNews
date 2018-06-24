package osaProjekat.service;

import java.util.List;

import osaProjekat.entity.Tag;

public interface TagServiceInterface {

	List<Tag> findAll();
	
	Tag findOne(Long tagId);
	
	List<Tag> findByPost_Id(Long tagId);
	
	Tag findByName(String name);
	
	Tag save(Tag tag);
	
	void remove(Long id);
}