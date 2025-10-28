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

        Map<String, Long> counts = basket.stream()
                .collect(Collectors.groupingBy(b -> b, Collectors.counting()));

        // Find minimum possible price via recursive exploration of groupings
        return findMinPrice(counts);
    }

    private double findMinPrice(Map<String, Long> counts) {
        // base case: no remaining books
        if (counts.values().stream().allMatch(c -> c == 0)) {
            return 0.0;
        }

        double best = Double.MAX_VALUE;

        // list currently available distinct titles (count > 0)
        List<String> available = counts.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(Map.Entry::getKey)
                .toList();

        int maxGroupSize = Math.min(available.size(), 5);

        // explore all possibilities for group sizes from max down to 1
        for (int size = maxGroupSize; size > 0; size--) {
            // generate all combinations (subsets) of 'available' of this 'size'
            List<List<String>> subsets = combinations(available, size);
            for (List<String> subset : subsets) {
                // consume one copy of each book in subset
                Map<String, Long> newCounts = new HashMap<>(counts);
                for (String book : subset) {
                    newCounts.put(book, newCounts.get(book) - 1);
                }

                // price for this group + best price for the rest
                double cost = groupPrice(size) + findMinPrice(newCounts);
                if (cost < best) best = cost;
            }
        }

        // round to two decimals for currency-like output
        return Math.round(best * 100.0) / 100.0;
    }

    private List<List<String>> combinations(List<String> books, int size) {
        List<List<String>> result = new ArrayList<>();
        combineHelper(books, size, 0, new ArrayList<>(), result);
        return result;
    }

    private void combineHelper(List<String> books, int size, int start,
                               List<String> current, List<List<String>> result) {
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < books.size(); i++) {
            current.add(books.get(i));
            combineHelper(books, size, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private double groupPrice(int size) {
        double discount = DISCOUNTS.getOrDefault(size, 0.0);
        return size * BOOK_PRICE * (1 - discount);
    }


}
