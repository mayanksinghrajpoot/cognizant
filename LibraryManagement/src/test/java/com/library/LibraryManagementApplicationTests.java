package com.library;

import com.library.entity.Book;
import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryManagementApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        assertNotNull(bookService);
    }

    @Test
    void testAopLoggingAndCRUD() {
        Book book = new Book("Spring Boot in Action", "Craig Walls");
        Book saved = bookService.saveBook(book);
        assertNotNull(saved.getId());

        List<Book> books = bookService.getAllBooks();
        assertTrue(books.size() >= 4); // 3 seeded + 1 added
    }
}
