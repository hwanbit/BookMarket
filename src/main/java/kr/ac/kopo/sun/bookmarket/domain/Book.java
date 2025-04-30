package kr.ac.kopo.sun.bookmarket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
public class Book {
    private String bookId; //도서번호
    private String name; //도서명
    private BigDecimal unitPrice; //단가
    private String author; //저자
    private String description; //도서설명
    private String publisher; //출판사
    private String category; // 도서분류
    private long unitsInStock; //재고량
    private String releaseDate; //출판일
    private String condition; //신규도서인지 중고도서인지 전자책인지
}