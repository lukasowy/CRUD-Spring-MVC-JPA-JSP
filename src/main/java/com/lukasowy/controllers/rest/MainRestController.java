package com.lukasowy.controllers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukasowy.models.Book;
import com.lukasowy.services.DaoService;

@RestController
public class MainRestController {

	@Autowired
	private DaoService daoService;
	
	@GetMapping("/")
	public Collection<Book> getAllBooks(){
		return daoService.findAllBooks();
	}
	
}
