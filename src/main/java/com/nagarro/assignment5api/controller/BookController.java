package com.nagarro.assignment5api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment5api.model.Books;
import com.nagarro.assignment5api.repository.BooksRepo;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3006")
public class BookController {

	@Autowired
	private BooksRepo booksRepo;

	@GetMapping(value = "/")
	public List<Books> findAll() {
		return booksRepo.findAll();
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Books> createBook(@Validated @RequestBody Books book) {
		booksRepo.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable Long id, @Validated @RequestBody Books bookDetails) {
		Books book = booksRepo.findById(id).get();
		book.setBookName(bookDetails.getBookName());
		book.setAuthor(bookDetails.getAuthor());
		Books updatedBook = booksRepo.save(book);
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		booksRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
