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

    //Add a discount mapping and compute price when all books are distinct
    public double calculatePrice(List<String> basket) {
        if (basket == null || basket.isEmpty()) return 0.0;

        Set<String> distinct = Set.copyOf(basket);
        int distinctCount = distinct.size();

        if (basket.size() == distinctCount) {
            double discount = DISCOUNTS.getOrDefault(distinctCount, 0.0);
            return distinctCount * BOOK_PRICE * (1 - discount);
        }

        return 0.0;
    }


}
