package osaProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import osaProjekat.entity.Post;
import osaProjekat.entity.Tag;
import osaProjekat.entity.User;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	List<Post> findAll();

	/*@Query("SELECT p.post_id,p.date,p.description,p.dislikes,p.latitude,p.likes,p.latitude,p.photo,p.title,p.author_id FROM post p INNER JOIN user u ON p.author_id=u.user_id WHERE u.username like '%:authorName%'")
	List<Post> findByAuthor(@Param("authorName")String authorName);*/
	
	List<Post> findByAuthor(User user);
	
	List<Post> findByTagsId(Long tagId);
	
	List<Post> findAllByOrderByLikesDesc();

	List<Post> findByTagsName(String tagName);

}
