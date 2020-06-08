package com.bookmanager.book_managing_service.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main(){
        return "main";
    }
}
