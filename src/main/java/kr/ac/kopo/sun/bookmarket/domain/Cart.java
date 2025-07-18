package kr.ac.kopo.sun.bookmarket.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Cart {

    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart() {
        cartItems = new HashMap<String, CartItem>();
        grandTotal = BigDecimal.ZERO; // = new BigDecimal(0);
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();

        if (cartItems.containsKey(bookId)) {
            CartItem cartItem = cartItems.get(bookId);
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
            cartItems.put(bookId, cartItem);
        } else {
            cartItems.put(bookId, item);
        }
        updateGrandTotal();
    }
    
    // 전체 주문 총액을 업데이트하는 메소드
    public void updateGrandTotal() {
        BigDecimal total = new BigDecimal(0);
        for (CartItem cartItem : cartItems.values()) {
            grandTotal = grandTotal.add(cartItem.getTotalPrice());
        }
    }

    public void removeCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();
        if (cartItems.containsKey(bookId)) {
            cartItems.remove(bookId);
            updateGrandTotal();
        }
    }
}