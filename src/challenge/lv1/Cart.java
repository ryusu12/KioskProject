package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<CartItem> cart = new ArrayList<>();

    void addCart(CartItem addItem) {
        // 만약 카트에 같은 메뉴가 있으면, 그 메뉴를 가져옴
        CartItem item = cart.stream().filter(cartItem -> cartItem.getMenuItem().equals(addItem.getMenuItem()))
                .findFirst().orElse(null);
        // 같은 메뉴가 없다면, 카트에 추가하고
        if (item == null) {
            cart.add(addItem);
        } else {
            // 있으면 수량을 증가시킨다.
            item.setCount();
        }
    }

    List<CartItem> getCart() {
        return cart;
    }

    void showCart() {
        int num = 0;
        for (CartItem cartItem : cart) {
            MenuItem menuItem = cartItem.getMenuItem();
            System.out.printf(++num + ". %-17s | W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + " | " + cartItem.getCount() + "개 %n", menuItem.getName());
        }
    }

    double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getPrice() * cartItem.getCount();
        }
        totalPrice /= 1000.0;
        System.out.println("\n[ Total ]");
        System.out.println("W " + totalPrice + "\n");
        return totalPrice;
    }

    void initCart() {
        cart.clear();
    }

    void deleteCart(int index) {
        cart.remove(index);
    }

    boolean isEmptyCart() {
        return cart.isEmpty();
    }
}