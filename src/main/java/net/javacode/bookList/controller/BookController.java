package net.javacode.bookList.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.javacode.bookList.model.Book;
import net.javacode.bookList.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAll());

        return "books";
    }

    @RequestMapping(value = "books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookService.add(book);
        } else
            bookService.update(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "remove/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        model.addAttribute("bookList", bookService.getAll());

        return "books";
    }

    @RequestMapping(value = "bookbata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getById(id));

        return "bookdata";
    }





}
