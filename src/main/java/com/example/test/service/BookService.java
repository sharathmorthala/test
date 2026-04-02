package com.example.test.service;

import com.example.test.adapter.GoogleBooksClient;
import com.example.test.controllers.model.BookVO;
import com.example.test.controllers.model.GoogleBooksResponse;
import com.example.test.controllers.model.Item;
import com.example.test.entity.Book;
import com.example.test.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private GoogleBooksClient googleBooksClient;

    public BookService(BookRepository bookRepository, GoogleBooksClient googleBooksClient) {
        this.bookRepository = bookRepository;
        this.googleBooksClient = googleBooksClient;
    }

    public BookVO saveBook(BookVO bookVO){
        Book book = new Book();
        book.setId(bookVO.getId());
        book.setName(bookVO.getName());

        bookRepository.save(book);

        bookVO.setId(book.getId());

        return bookVO;
    }

    //TODO 3 use feign client bookAdapter to retrieve books
    public List<BookVO> retrieveBookFromGoogle() {
        GoogleBooksResponse response = googleBooksClient.getBooks(5, "relevance",
                "Nathan Carlin");

        List<BookVO> result = new ArrayList<>();

        if (response.getItems() != null) {
            for (Item item : response.getItems()) {
                String title = item.getVolumeInfo().getTitle();
                BookVO bookVO = new BookVO();
                bookVO.setName(title);

                result.add(bookVO);
            }
        }

        return result;
    }
}
