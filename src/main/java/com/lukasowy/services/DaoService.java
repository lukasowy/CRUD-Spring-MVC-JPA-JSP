package com.lukasowy.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukasowy.dao.DaoRepository;
import com.lukasowy.models.Book;

@Service
public class DaoService {
	@Autowired
	private DaoRepository daoRepository;

	public Collection<Book> findAllBooks() {
		List<Book> books = new ArrayList<Book>();
		for (Book book : daoRepository.findAll()) {
			books.add(book);

		}
		return books;
	}

}
