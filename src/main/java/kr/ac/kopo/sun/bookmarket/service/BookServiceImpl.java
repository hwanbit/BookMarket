package kr.ac.kopo.sun.bookmarket.service;

import kr.ac.kopo.sun.bookmarket.domain.Book;
import kr.ac.kopo.sun.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = bookRepository.getBookById(bookId);
        return book;
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
        return booksByCategory;
    }
}