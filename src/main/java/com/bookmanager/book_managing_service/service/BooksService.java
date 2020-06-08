package com.bookmanager.book_managing_service.service;

import com.bookmanager.book_managing_service.domain.books.BooksRepository;
import com.bookmanager.book_managing_service.dto.books.BooksDeleteRequestDto;
import com.bookmanager.book_managing_service.dto.books.BooksMainResponseDto;
import com.bookmanager.book_managing_service.dto.books.BooksSaveRequestDto;
import com.bookmanager.book_managing_service.dto.books.BooksUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BooksService {

    private BooksRepository booksRepository;

    @Transactional
    public Long save(BooksSaveRequestDto dto){
        return booksRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long delete(BooksDeleteRequestDto dto){
        booksRepository.deleteById(dto.getId());
        return dto.getId();
    }

    @Transactional
    public Long update(BooksUpdateRequestDto dto){
        return booksRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<BooksMainResponseDto> findAllDesc(){
        return booksRepository.findAllDesc()
                .map(BooksMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
