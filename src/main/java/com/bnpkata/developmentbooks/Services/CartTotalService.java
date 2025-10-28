package com.bnpkata.developmentbooks.Services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartTotalService {

    private static final double BOOK_PRICE = 50.0;
    private static final Map<Integer, Double> DISCOUNTS = Map.of(
            1, 0.0,
            2, 0.05,
            3, 0.10,
            4, 0.20,
            5, 0.25
    );

    //Add a discount mapping and compute price when all books are distinct removing duplicates
    public double calculatePrice(List<String> basket) {
        if (basket == null || basket.isEmpty()) return 0.0;

        Map<String, Integer> counts = new HashMap<>();
        for (String b : basket) counts.put(b, counts.getOrDefault(b, 0) + 1);

        double total = 0.0;
        while (counts.values().stream().anyMatch(c -> c > 0)) {

            List<String> group = new ArrayList<>();
            for (String book : new ArrayList<>(counts.keySet())) {
                if (counts.get(book) > 0) {
                    group.add(book);
                    counts.put(book, counts.get(book) - 1);
                }
            }
            int size = group.size();
            double discount = DISCOUNTS.getOrDefault(size, 0.0);
            total += size * BOOK_PRICE * (1 - discount);
        }
        return Math.round(total * 100.0) / 100.0;
    }


}
