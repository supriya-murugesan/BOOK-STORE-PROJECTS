package com.bookstore.service;

import java.util.List;

import com.bookstore.constants.Category;
import com.bookstore.domain.Book;
import com.bookstore.service.dto.BookDto;
import com.bookstore.service.dto.SellDto;

public interface BookStoreService {
    void addNewBook(BookDto bookDto);

    void addBook(Integer id, int quantityToAdd);

    BookDto getBookById(Integer id);

    List<BookDto> getAllBooks();

    int getNumberOfBooksById(Integer id);

    void updateBook(Integer id, BookDto bookDto);

    void sellBook(Integer id);

    void sellBooks(List<SellDto> sellDtos);
    void deleteBook(Book bookDto);

    List<BookDto> getBookByCategoryKeyWord(String keyword, Category category);

    int getNumberOfBooksSoldByCategoryAndKeyword(String keyword, Category category);

}
