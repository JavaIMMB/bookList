package net.javacode.bookList.service;

import net.javacode.bookList.model.Book;

import java.util.List;

public interface BookService {
    void add(Book book);

    void update(Book book);

    void delete(int id);

    Book getById(int id);

    List<Book> getAll();
}
