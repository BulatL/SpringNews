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

import osaProjekat.dto.UserDTO;
import osaProjekat.entity.User;
import osaProjekat.service.UserServiceInterface;

@RestController
@RequestMapping(value="api/users")
public class UserController {
	
	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(){
		List<User> users = userServiceInterface.findAll();
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		for(User u:users) {
			userDTO.add(new UserDTO(u));
		}
		return new ResponseEntity<List<UserDTO>>(userDTO, HttpStatus.OK);
	}
	 @GetMapping(value = "/{id}")
	    public ResponseEntity<UserDTO>getUser(@PathVariable("id") Long id){
	        User user=userServiceInterface.findOne(id);
	        if(user ==null)
	            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
	        return  new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
	    }
	 
	 @GetMapping(value="/{username}/{password}")
		public ResponseEntity<UserDTO> getUserByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password){
			User user = userServiceInterface.findByUsernameAndPassword(username, password);
			if(user == null) {
				return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
		}

	    @GetMapping(value = "/user/{username}")
	    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username){
	        User user=userServiceInterface.findByUsername(username);
	        if(user ==null)
	            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
	        return  new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
	    }

	    @PostMapping(consumes = "application/json")
	    public ResponseEntity<UserDTO>saveUser(@RequestBody UserDTO userDTO){
	        User user=new User();
	        user.setName(userDTO.getName());
	        user.setUsername(userDTO.getUsername());
	        user.setPassword(userDTO.getPassword());
	        user.setPhoto(userDTO.getPhoto());
	        user=userServiceInterface.save(user);
	        return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.CREATED);

	    }

	    @PutMapping(value = "/{id}",consumes = "application/json")
	    public ResponseEntity<UserDTO>editUser(@RequestBody UserDTO userDTO,@PathVariable("id") Long id){
	        User user=userServiceInterface.findOne(id);
	        if(user == null)
	            return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
	        user.setName(userDTO.getName());
	        user.setPassword(userDTO.getPassword());
	        user.setPhoto(userDTO.getPhoto());

	        user=userServiceInterface.save(user);

	        return new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
	    }

	    @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Void>deleteUser(@PathVariable("id")Long id){
	        User user=userServiceInterface.findOne(id);
	        if(user != null)
	        {
	        	userServiceInterface.remove(id);
	            return  new ResponseEntity<Void>(HttpStatus.OK);

	        }
	        return  new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	    }
}
