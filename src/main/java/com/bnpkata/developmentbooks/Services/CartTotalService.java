package com.bnpkata.developmentbooks.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartTotalService {

    private static final double BOOK_PRICE = 50.0;

    public double calculatePrice(List<String> basket) {
        if (basket == null || basket.isEmpty()) {
            return 0.0;
        }
        Set<String> distinct = Set.copyOf(basket);
        int distinctCount = distinct.size();

        if (basket.size() == distinctCount) {
            // all distinct: apply discounts for 1..5 as needed (we'll add mapping next)
            if (distinctCount == 1) return BOOK_PRICE;
            if (distinctCount == 2) return 2 * BOOK_PRICE * 0.95;
        }

        return 0.0;
    }


}
