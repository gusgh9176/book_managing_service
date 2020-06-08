package com.bookmanager.book_managing_service.domain.books;

import com.bookmanager.book_managing_service.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Books extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String kinds; // 종류

    @Column(length = 255, nullable = false)
    private String title; // 제목

    @Column(length = 255, nullable = false)
    private String author; // 작가

    @Column(length = 255, nullable = false)
    private Integer counts; // 재고

    @Column(nullable = false)
    private Integer price; // 가격

    @Builder
    public Books(Long id, String kinds, String title, String author, int counts, int price){
        this.id = id;
        this.kinds = kinds;
        this.title = title;
        this.author = author;
        this.counts = counts;
        this.price = price;
    }
}
