package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<CartItem> cart = new ArrayList<>();

    /*get*/
    List<CartItem> getCart() {
        return cart;
    }

    double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getPrice() * cartItem.getCount();
        }
        return totalPrice / 1000.0;
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

    void deleteCart(int index) {
        cart.remove(index);
    }
}