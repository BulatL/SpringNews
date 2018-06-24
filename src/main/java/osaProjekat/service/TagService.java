package osaProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import osaProjekat.entity.Tag;
import osaProjekat.repository.TagRepository;

@Service
public class TagService implements TagServiceInterface{

	@Autowired
	TagRepository tagRepository;
	
	@Override
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findOne(Long tagId) {
		return tagRepository.getOne(tagId);
	}

	@Override
	public List<Tag> findByPost_Id(Long tagId) {
		return tagRepository.findByPostsId(tagId);
	}
	
	@Override
	public Tag findByName(String name) {
		return tagRepository.findByName(name);
	}

	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public void remove(Long id) {
		tagRepository.deleteById(id);
	}
}