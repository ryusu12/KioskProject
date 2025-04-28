package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<CartItem> cart = new ArrayList<>();

    /*get*/
    // 총 금액을 리턴하는 메서드
    double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getPrice() * cartItem.getCount();
        }
        return totalPrice / 1000.0;
    }

    // 장바구니 크기 확인하는 메서드
    int getCartSize() {
        return cart.size();
    }

    // 장바구니가 비어있는지 확인하는 메서드
    boolean isEmptyCart() {
        return cart.isEmpty();
    }

    // 장바구니 내의 메뉴를 인덱스로 하나 리턴하는 메서드
    CartItem getCartItem(int index) {
        return cart.get(index);
    }

    /*Setter*/
    // 장바구니에 메뉴를 추가하는 메서드
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

    // 장바구니를 비우는 메서드
    void initCart() {
        cart.clear();
    }

    // 장바구니 내의 메뉴를 인덱스로 하나 삭제하는 메서드
    void deleteCart(int index) {
        try {
            cart.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 수 없습니다.");
        }
    }
}