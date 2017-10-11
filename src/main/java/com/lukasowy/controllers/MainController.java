package com.lukasowy.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukasowy.models.Book;
import com.lukasowy.services.DaoService;

@Controller // This means that this class is a Controller
public class MainController {

	@Autowired
	private DaoService daoService;

	@RequestMapping(path = "/") // This means URL's start with / (after Application path)
	public String hello(HttpServletRequest req) {
		req.setAttribute("books", daoService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "hello";
	}

	@GetMapping(path = "/updateBook") // This means URL's start with /updateBook (after Application path)
	public String hello(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("book", daoService.findOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "hello";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@PostMapping("/save")
	public void save(@ModelAttribute("book") Book book, BindingResult bindingResult, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		daoService.saveBook(book);
		book = null;
		req.setAttribute("books", null);
		req.setAttribute("books", daoService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		resp.sendRedirect("/");
	}

	@GetMapping(path = "/newBook")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_NEW");
		return "hello";
	}

	@GetMapping(path = "/deleteBook")
	public void deleteBook(@RequestParam long id, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		daoService.deleteBook(id);
		req.setAttribute("books", daoService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		resp.sendRedirect("/");
	}
}
