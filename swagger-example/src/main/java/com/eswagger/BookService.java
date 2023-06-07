package com.eswagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(BookDTO bookDTO) {
        Book book = Book.builder().name(bookDTO.getName()).author(bookDTO.getAuthor()).build();
        return bookRepository.save(book);
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with this id"));
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

}
