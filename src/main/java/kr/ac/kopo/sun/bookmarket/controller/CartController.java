package kr.ac.kopo.sun.bookmarket.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.ac.kopo.sun.bookmarket.domain.Book;
import kr.ac.kopo.sun.bookmarket.domain.Cart;
import kr.ac.kopo.sun.bookmarket.domain.CartItem;
import kr.ac.kopo.sun.bookmarket.exception.BookIdException;
import kr.ac.kopo.sun.bookmarket.service.BookService;
import kr.ac.kopo.sun.bookmarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestCartId(HttpServletRequest request) {
        System.out.println("Call requestCartId");
        String sessionId = request.getSession().getId();
        return "redirect:/cart/" + sessionId;
    }

    @PostMapping
    public @ResponseBody Cart createCart(@RequestBody Cart cart) {
        System.out.println("Call createCart");
        return cartService.create(cart);
    }

    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value="cartId") String cartId, Model model) {
        System.out.println("Call requestCartList");
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PutMapping("/{cartId}")
    public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId) {
        System.out.println("Call read");
        return cartService.read(cartId);
    }

    @PutMapping("/book/{bookId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void addCartByNewItem(@PathVariable("bookId") String bookId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if(cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Book book = bookService.getBookById(bookId);
        if(book == null) {
            throw new IllegalArgumentException(new BookIdException(bookId));
        }

        cart.addCartItem(new CartItem(book));

        cartService.update(sessionId, cart);
    }

    @DeleteMapping("/book/{bookId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable("bookId") String bookId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if(cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Book book = bookService.getBookById(bookId);
        if(book == null) {
            throw new IllegalArgumentException(new BookIdException(bookId));
        }

        cart.removeCartItem(new CartItem(book));

        cartService.update(sessionId, cart);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable("cartId") String cartId) {
        cartService.delete(cartId);
    }
}