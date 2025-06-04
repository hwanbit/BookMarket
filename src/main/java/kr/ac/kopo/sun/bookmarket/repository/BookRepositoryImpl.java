package kr.ac.kopo.sun.bookmarket.repository;

import kr.ac.kopo.sun.bookmarket.domain.Book;
import kr.ac.kopo.sun.bookmarket.exception.BookIdException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookId("isbn0001");
        book1.setName("SpringBoot");
        book1.setUnitPrice(BigDecimal.valueOf(35000));
        book1.setAuthor("Miyoung Song");
        book1.setDescription("All about Spring Boot!");
        book1.setPublisher("gilbut");
        book1.setCategory("Framework");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2024/12/31");
        book1.setCondition("New");
        book1.setFileName("isbn0001.jpg");

        listOfBooks.add(book1);

        Book book2 = new Book();
        book2.setBookId("isbn0002");
        book2.setName("Java");
        book2.setUnitPrice(BigDecimal.valueOf(26000));
        book2.setAuthor("Sehong Park");
        book2.setDescription("Everyone needs Java~");
        book2.setPublisher("Hanbit");
        book2.setCategory("Language");
        book2.setUnitsInStock(500);
        book2.setReleaseDate("2021/10/29");
        book2.setCondition("Used");
        book2.setFileName("isbn0002.jpg");

        listOfBooks.add(book2);

        Book book3 = new Book();
        book3.setBookId("isbn0003");
        book3.setName("Android Studio");
        book3.setUnitPrice(BigDecimal.valueOf(34000));
        book3.setAuthor("Jaenam Woo");
        book3.setDescription("Android Studio = Android Programming");
        book3.setPublisher("Hanbit");
        book3.setCategory("Framework");
        book3.setUnitsInStock(700);
        book3.setReleaseDate("2024/01/19");
        book3.setCondition("New");
        book3.setFileName("isbn0003.jpg");

        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }

    @Override
    public Book getBookById(String bookId) {
        Book bookInfo = null;

        for(Book book : listOfBooks) {
            if (book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
                bookInfo = book;
                break;
            }
        }
        if(bookInfo == null) {
            throw new BookIdException(String.format("Book id \"%s\" not found", bookId));
//            throw new IllegalArgumentException("도서번호: " + bookId + "의 도서를 찾을 수 없습니다.");
        }
        return bookInfo;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<>();
        for(Book book : listOfBooks) {
            if (book.getCategory() != null && book.getCategory().equals(category)) {
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {

        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if(booksByFilter.contains("publisher")) {
            for (int i=0; i<filter.get("publisher").size(); i++) {
                String publisherName = filter.get("publisher").get(i);
                for (Book book : listOfBooks) {
                    if (publisherName.equals(book.getPublisher())) {
                        booksByPublisher.add(book);
                    }
                }
            }
        }
        if(booksByFilter.contains("category")) {
            for (int i=0; i<filter.get("category").size(); i++) {
                String categoryName = filter.get("category").get(i);
                List<Book> list = getBookListByCategory(categoryName);
                booksByCategory.addAll(list);
            }
        }

        // 저장된 Book 객체 중에서 2개의 Set을 비교하여 같은 값만 남기고 나머지는 제거 (교집합)
        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }

    @Override
    public void setNewBook(Book book) {
        listOfBooks.add(book);
    }
}