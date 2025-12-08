function addToCart(bookId) {
    if (confirm("장바구니에 도서를 추가할까요?")) {
        document.addForm.action = "/BookMarket/cart/book/" + bookId;
        document.addForm.submit();
    }
}

function removeFromCart(bookId, cartId) {
    document.removeForm.action = "/BookMarket/cart/book/" + bookId;
    document.removeForm.submit();
    setTimeout('location.reload()', 10);
}

function clearCart(cartId) {
    if (confirm("모든 도서를 장바구니에서 삭제할까요?") == true) {
        document.clearForm.submit();
        setTimeout('location.reload()', 10);
    }
}

function deleteConfirm(id){
    if (confirm("정말로 삭제할까요?") == true) location.href ="/BookMarket/books/delete?id="+id;
    else  return;
}