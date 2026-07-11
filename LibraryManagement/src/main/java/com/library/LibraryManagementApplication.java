package com.library;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookService bookService) {
        return args -> {
            // Seed library with sample books
            bookService.saveBook(new Book("Clean Code", "Robert C. Martin"));
            bookService.saveBook(new Book("Design Patterns", "Erich Gamma"));
            bookService.saveBook(new Book("Effective Java", "Joshua Bloch"));
            
            System.out.println("--- Library seeded with initial books. Running getAllBooks to trigger AOP logging aspect: ---");
            bookService.getAllBooks();
        };
    }
}
