package com.luck.backend.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luck.backend.entity.User;
import com.luck.backend.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody User user) {
		
		try {
			return new ResponseEntity<Object>(userService.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody User user) {
		
		try {
			return new ResponseEntity<Object>(userService.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		
		try {
			return new ResponseEntity<Object>(userService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
		
		try {
			return new ResponseEntity<Object>(userService.findById(id).get(), HttpStatus.OK);
			
		} catch (NoSuchElementException elementException) {
			
			return new ResponseEntity<Object>("User não encontrado! ", HttpStatus.OK);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
		
		try {
			userService.deleteById(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());
		}
	}

}
