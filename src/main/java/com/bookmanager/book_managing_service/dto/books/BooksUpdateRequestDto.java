package com.bookmanager.book_managing_service.dto.books;

import com.bookmanager.book_managing_service.domain.books.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BooksUpdateRequestDto {

    private Long id;
    private String kinds;
    private String title;
    private String author;
    private Integer counts;
    private Integer price;

    @Builder
    public BooksUpdateRequestDto(Long id, String kinds, String title, String author, Integer counts, Integer price){
        this.id = id;
        this.kinds = kinds;
        this.title = title;
        this.author = author;
        this.counts = counts;
        this.price = price;
    }

    public Books toEntity(){
        return Books.builder()
                .id(id)
                .kinds(kinds)
                .title(title)
                .author(author)
                .counts(counts)
                .price(price)
                .build();
    }
}
