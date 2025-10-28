package com.bnpkata.developmentbooks.Controllers;

import com.bnpkata.developmentbooks.Models.CartRequest;
import com.bnpkata.developmentbooks.Models.CartResponse;
import com.bnpkata.developmentbooks.Services.CartTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartTotalService cartTotalService;


    @PostMapping("/list")
    public CartResponse cart(@RequestBody CartRequest cartRequest){
        List<String> books = cartRequest.getCart();
        CartResponse cartResponse = new CartResponse();

//                List.of(
//                "Clean Code", "Clean Code",
//                "The Clean Coder", "The Clean Coder",
//                "Clean Architecture", "Clean Architecture",
//                "Test Driven Development by Example","Test Driven Development by Example"
//
//        );
        double price = cartTotalService.calculatePrice(books);
        cartResponse.setCartTotal(price);
        return cartResponse;
    }
}
