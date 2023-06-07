package com.eswagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/saveBook")
    public ResponseEntity<Object> saveBook(@RequestBody BookDTO bookDTO) {
        try {
            Book book = bookService.saveBook(bookDTO);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while saving book :", e);
            return new ResponseEntity<>("Error while saving book", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getBook/{id}")
    public ResponseEntity<Object> getBook(@PathVariable(name = "id") int id) {
        try {
            Book book = bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while getting book :", e);
            return new ResponseEntity<>("Error while getting book", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/getBooks")
    public ResponseEntity<Object> getBooks() {
        try {
            List<Book> books = bookService.getBooks();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while getting books :", e);
            return new ResponseEntity<>("Error while getting books", HttpStatus.BAD_GATEWAY);
        }
    }

}
