package com.bookmanager.book_managing_service.dto.books;

import com.bookmanager.book_managing_service.domain.books.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BooksDeleteRequestDto {

    private Long id;

    @Builder
    public BooksDeleteRequestDto(Books entity){
        id = entity.getId();
    }
}
