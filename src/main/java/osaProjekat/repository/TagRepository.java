package osaProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import osaProjekat.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

	List<Tag> findByPostsId(Long postId);
	
	Tag findByName(String name);
}
