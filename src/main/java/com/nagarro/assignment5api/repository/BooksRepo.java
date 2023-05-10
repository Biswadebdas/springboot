package com.nagarro.assignment5api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment5api.model.Books;

public interface BooksRepo extends JpaRepository<Books,Long>{

}
