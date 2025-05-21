package kr.ac.kopo.sun.bookmarket.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.sun.bookmarket.domain.Book;
import kr.ac.kopo.sun.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {

    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // 도서 번호(ID) 유효성 검사 메서드
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Book book = null;
        try {
            book = bookService.getBookById(s); // s = 입력한 값 (검증할 값)
        }catch (RuntimeException e) {
            return true;
        }

        if(book != null) {
            return false; // 유효성 검사를 통과하지 못했을 때
        }
        return true; // 유효성 검사를 통과했을 때
    }

}