package com.lukasowy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lukasowy.models.Book;

@Repository
public interface DaoRepository extends CrudRepository<Book, Long> {

}
