package kr.ac.kopo.sun.bookmarket.service;

import kr.ac.kopo.sun.bookmarket.domain.Cart;
import kr.ac.kopo.sun.bookmarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImple implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }

    @Override
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }
}