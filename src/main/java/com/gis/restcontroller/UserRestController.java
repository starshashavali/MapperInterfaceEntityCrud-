package com.gis.restcontroller;

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

import com.gis.dto.UserDto;
import com.gis.service.UserServiceImpl;

@RestController
public class UserRestController {
	@Autowired

	private UserServiceImpl userService;

	@PostMapping("/save")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
	userService.createUser(userDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
		UserDto userDto = userService.getUserById(userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.CREATED);
	}



	@DeleteMapping("delete/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
