package kr.ac.kopo.sun.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // 아이디
    private String country; // 국가명
    private String zipcode; // 우편번호
    private String addressName; // 기본 주소
    private String detailName; // 상세 주소
}