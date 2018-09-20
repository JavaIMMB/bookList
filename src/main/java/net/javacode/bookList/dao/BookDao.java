package net.javacode.bookList.dao;

import net.javacode.bookList.model.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(int id);

    Book getById(int id);

    List<Book> getAll();

}
