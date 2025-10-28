package com.bnpkata.developmentbooks.Controllers;

import com.bnpkata.developmentbooks.Services.CartTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartTotalService cartTotalService;


    @PostMapping("/list")
    public double cart(){
        List<String> books = List.of(
                "Clean Code", "Clean Code",
                "The Clean Coder", "The Clean Coder",
                "Clean Architecture", "Clean Architecture",
                "Test Driven Development by Example","Test Driven Development by Example"

        );

        return cartTotalService.calculatePrice(books);
    }
}
