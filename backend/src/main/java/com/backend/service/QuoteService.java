package com.backend.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {

        this.quoteRepository = quoteRepository;
    }

    public Quotes getRandomQuotes() {
        long totalQuotes = quoteRepository.count();

        if (totalQuotes == 0) {
            throw new IllegalArgumentException("No quotes found in the database");
        }

        long randomId = ThreadLocalRandom.current().nextLong(1, totalQuotes + 1);
        return quoteRepository.findById(randomId)
                .orElseThrow(() -> new IllegalArgumentException("Quote not not found with id: " + randomId));
    }
}
