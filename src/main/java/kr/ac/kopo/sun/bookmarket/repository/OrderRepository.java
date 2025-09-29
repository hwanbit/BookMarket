package kr.ac.kopo.sun.bookmarket.repository;

import kr.ac.kopo.sun.bookmarket.domain.Order;

public interface OrderRepository {
    // 주문 목록 저장
    Long saveOrder(Order order);
}
