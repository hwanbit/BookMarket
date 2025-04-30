package kr.ac.kopo.sun.bookmarket.controller;

import kr.ac.kopo.sun.bookmarket.domain.Book;
import kr.ac.kopo.sun.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestBookList(Model model) {
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList);
        return "books"; // templates 이름과 동일
    }

    @GetMapping("/all")
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView requestAllBookList() {
        ModelAndView modelV = new ModelAndView();
        modelV.setViewName("books");
        List<Book> bookList = bookService.getAllBookList();
        modelV.addObject("bookList", bookList);
        return modelV; // ModelAndView 이름과 동일
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {

        Book book = bookService.getBookById(bookId);

        model.addAttribute("book", book);

        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String category, Model model) {
        List<Book> booksByCategory = bookService.getBookByCategory(category);
        model.addAttribute("bookList", booksByCategory);
        return "books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter")Map<String, List<String>> bookFilter, Model model) {

        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);

        return "books";
    }
}