package com.example.test.adapter;

import com.example.test.controllers.model.GoogleBooksResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleBooksClient", url = "https://www.googleapis.com")
public interface GoogleBooksClient {

    @GetMapping("/books/v1/volumes")
    GoogleBooksResponse getBooks(
            @RequestParam("maxResults") int maxResults,
            @RequestParam("orderBy") String orderBy,
            @RequestParam("q") String query,
            @RequestParam("key") String apiKey
    );
}
