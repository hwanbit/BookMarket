package kr.ac.kopo.sun.bookmarket.service;

import kr.ac.kopo.sun.bookmarket.domain.Cart;

public interface CartService {

    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}