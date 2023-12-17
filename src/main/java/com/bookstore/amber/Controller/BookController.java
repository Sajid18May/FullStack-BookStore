package com.bookstore.amber.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.amber.Entiry.Books;
import com.bookstore.amber.Service.BService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	BService bs;

	@PostMapping("/addBook")
	public Books addBooks(@RequestBody Books book) {

		return bs.addBooks(book);
	}

	@GetMapping("/getBooks")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Books> getAllBooks() {
		return bs.fetchAllBooks();
	}

	@GetMapping("/getBooks/{id}") // localhost:8080/getBooks/5
	public Books getBooksById(@PathVariable int id) {
		return bs.getBooksById(id);
	}

	@DeleteMapping("/Books/{id}")
	public Books deleteBooks(@PathVariable int id) {
		return bs.deleteBooksById(id);
	}

	@PutMapping("updateBook/{book_id}")
	public Books updateBook(@PathVariable int book_id, @RequestBody Books updatedBook) {
		return bs.updateBook(book_id, updatedBook);
	}

}
