package com.bookmanager.book_managing_service.web;

import com.bookmanager.book_managing_service.dto.books.BooksDeleteRequestDto;
import com.bookmanager.book_managing_service.dto.books.BooksSaveRequestDto;
import com.bookmanager.book_managing_service.dto.books.BooksUpdateRequestDto;
import com.bookmanager.book_managing_service.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private BooksService booksService;

    @PostMapping("books/insert")
    public Long saveBooks(@RequestBody BooksSaveRequestDto dto){
        return booksService.save(dto);
    }

    @PostMapping("books/delete")
    public Long deleteBooks(@RequestBody BooksDeleteRequestDto dto) {
        return booksService.delete(dto);
    }

    @PostMapping("books/update")
    public Long updateBooks(@RequestBody BooksUpdateRequestDto dto){
        return booksService.update(dto);
    }
}
