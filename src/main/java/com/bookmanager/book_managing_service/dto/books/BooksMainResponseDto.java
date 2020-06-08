package com.bookmanager.book_managing_service.dto.books;

import com.bookmanager.book_managing_service.domain.books.Books;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class BooksMainResponseDto {

    private Long id;
    private String kinds;
    private String title;
    private String author;
    private Integer counts;
    private Integer price;
    private String createdDate;
    private String modifiedDate;

    public BooksMainResponseDto(Books entity){
        id = entity.getId();
        kinds = entity.getKinds();
        title = entity.getTitle();
        author = entity.getAuthor();
        counts = entity.getCounts();
        price = entity.getPrice();
        createdDate = toStringDateTime(entity.getCreatedDate());
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
