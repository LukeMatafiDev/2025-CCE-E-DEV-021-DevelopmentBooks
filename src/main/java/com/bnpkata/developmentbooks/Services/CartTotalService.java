package com.bnpkata.developmentbooks.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartTotalService {

    public double calculatePrice(List<String> basket) {
        if (basket == null || basket.isEmpty()) {
            return 0.0;
        }
        if (basket.size() == 1) return basket.size()*50.0;
        return 0.0;
    }


}
