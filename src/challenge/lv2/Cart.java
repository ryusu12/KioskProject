package challenge.lv2;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<CartItem> cart = new ArrayList<>();

    /*get*/
    double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getPrice() * cartItem.getCount();
        }
        return totalPrice / 1000.0;
    }

    int getCartSize() {
        return cart.size();
    }

    boolean isEmptyCart() {
        return cart.isEmpty();
    }

    CartItem getCartItem(int index) {
        return cart.get(index);
    }

    /*Setter*/
    void addCart(CartItem addItem) {
        // 만약 카트에 같은 메뉴가 있으면, 그 메뉴를 가져옴
        CartItem item = cart.stream()
                .filter(cartItem -> cartItem.getName().equals(addItem.getName()))
                .findFirst().orElse(null);
        // 같은 메뉴가 없다면, 카트에 추가하고
        if (item == null) {
            cart.add(addItem);
        } else {
            // 있으면 수량을 증가시킨다.
            item.setCount();
        }
    }

    void initCart() {
        cart.clear();
    }

    void deleteCart(CartItem deleteItem) {
        CartItem item = cart.stream()
                .filter(cartItem -> cartItem.getName().equals(deleteItem.getName()))
                .findFirst().orElse(null);
        if (item == null) {
            System.out.println("삭제할 수 없습니다.");
        } else {
            cart.remove(item);
        }
    }
}