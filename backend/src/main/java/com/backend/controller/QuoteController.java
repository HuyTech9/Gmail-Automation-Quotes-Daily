package com.backend.controller;


import com.backend.model.Quotes;
import com.backend.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    public final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public ResponseEntity<Map<String, Object>> getRandomQuote() {
        Quotes quotes = quoteService.getRandomQuotes();
        Map<String, Object> response = new HashMap<>();
        response.put("id", quotes.getId());
        response.put("text", quotes.getText());
        response.put("author", quotes.getAuthor());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
