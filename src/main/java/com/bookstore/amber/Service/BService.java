package com.bookstore.amber.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.amber.Entiry.Books;
import com.bookstore.amber.Repo.BRepo;
@Service
public class BService {
    @Autowired
    BRepo br;

    public Books addBooks(Books book){

        return br.save(book);
    }
    public List<Books> fetchAllBooks() {	
		return br.findAll();
	}

	public Books getBooksById(int id) {
		Optional<Books> order = br.findById(id);

		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	
	public Books deleteBooksById(int id) {
        Optional <Books> nuke=br.findById(id);
		if(nuke.isPresent()) {
			br.deleteById(id);
			return nuke.get();
		}
		return null;
	}

	 public Books updateBook(int bookId,Books updatedBook) {
        Optional<Books> existingBook = br.findById(bookId);

        if (existingBook.isPresent()) {
             Books newdata=existingBook.get();
            newdata.setTitle(updatedBook.getTitle());
            newdata.setAuthor_name(updatedBook.getAuthor_name());
            newdata.setGenre(updatedBook.getGenre());
            newdata.setPrice(updatedBook.getPrice());
            newdata.setStar(updatedBook.getStar());
            br.save(newdata);

            return newdata;
        } else {
            return null;
        }
    }
}
