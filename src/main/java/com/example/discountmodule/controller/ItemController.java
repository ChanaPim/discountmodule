package com.example.discountmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.discountmodule.model.Cart;
import com.example.discountmodule.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Controller
public class ItemController {

    @GetMapping("/")
    public String showItems(Model model) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/sample-input.json");
            Cart cart = mapper.readValue(is, Cart.class);

            model.addAttribute("items", cart.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "items"; // -> items.html
    }
}
