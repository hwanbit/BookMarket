package kr.ac.kopo.sun.bookmarket.repository;

import kr.ac.kopo.sun.bookmarket.domain.Cart;

public interface CartRepository {

    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);

}