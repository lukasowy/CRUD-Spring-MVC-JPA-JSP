package com.lukasowy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lukasowy.models.Book;

//This will be AUTO IMPLEMENTED by Spring into a Bean called daoRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface DaoRepository extends CrudRepository<Book, Long> {

}
