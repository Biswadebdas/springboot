package com.nagarro.assignment5api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment5api.model.Authors;
import com.nagarro.assignment5api.repository.AuthorRepo;

@RestController
public class AuthorController {

	@Autowired
	private AuthorRepo authorRepo;

	@GetMapping(value = "/authors")
	public List<Authors> findAll() {
		return authorRepo.findAll();
	}

	@PostMapping(value = "/saves")
	public ResponseEntity<Authors> createAuthor(@Validated @RequestBody Authors author) {
		authorRepo.save(author);
		return ResponseEntity.status(HttpStatus.CREATED).body(author);

	}

	@PutMapping("/{ids}")
	public ResponseEntity<Authors> updateAuthor(@PathVariable Long ids, @Validated @RequestBody Authors authorDetails) {
		Authors author = authorRepo.findById(ids).get();
		author.setBookName(authorDetails.getBookName());
		author.setAuthor(authorDetails.getAuthor());
		Authors updatedBook = authorRepo.save(author);
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{ids}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long ids) {
		authorRepo.deleteById(ids);
		return ResponseEntity.noContent().build();
	}
}
