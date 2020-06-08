package com.bookmanager.book_managing_service.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query("SELECT b " +
            "FROM Books b " +
            "ORDER BY b.id DESC")
    Stream<Books> findAllDesc();

    Stream<Books> findByTitle(String title);
}
