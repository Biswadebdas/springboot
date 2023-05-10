package com.nagarro.assignment5api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment5api.model.Authors;

public interface AuthorRepo extends JpaRepository<Authors,Long> {

}
