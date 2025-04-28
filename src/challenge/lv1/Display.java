package challenge.lv1;

import java.util.List;

class Display {
    /*옵션을 잘못 선택했을 때 출력하는 메서드*/
    void showInvalidOption() {
        System.out.println("선택지에 없습니다.");
    }

    /*상위 카테고리 메뉴를 보여주는 메서드*/
    void showMenuList(List<Menu> menuList, Cart cart) {
        System.out.println("[ MAIN MENU ]");
        int num = 0;
        for (Menu menu : menuList) {
            System.out.println(++num + ". " + menu.getCategory());
        }
        System.out.println("0. 종료      | 종료");
        if (!cart.isEmptyCart()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    /*하위 카테고리 메뉴를 보여주는 메서드*/
    void showCategoryMenu(Menu menu) {
        System.out.println("\n[ " + menu.getCategory() + " MENU ]");
        for (int i = 0; i < menu.getMenuItemsSize(); i++) {
            System.out.print(i + 1 + ". ");
            showSelectMenu(menu.getMenuItem(i));
        }
        System.out.println("0. 뒤로가기");
    }

    /*Orders 옵션을 보여주는 메서드*/
    void showOrders(Cart cart) {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        showCart(cart);
        showTotalPrice(cart);
        System.out.println("1. 주문      2. 메뉴판");
    }

    /*Cancel 옵션을 보여주는 메서드*/
    void showCancel(Cart cart) {
        System.out.println("\n[ Cancel ]");
        showCart(cart);
        System.out.println("0. 뒤로가기");
        showTotalPrice(cart);
        System.out.println("몇번의 메뉴를 취소 하시겠습니까?");
    }

    /*장바구니 추가 옵션을 보여주는 메서드*/
    void showAddCart(MenuItem menuItem) {
        System.out.println();
        showSelectMenu(menuItem);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    /*메뉴 정보를 출력하는 메서드.*/
    void showSelectMenu(MenuItem menuItem) {
        System.out.printf("%-17s | W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "%n", menuItem.getName());
    }

    /*장바구니 목록을 출력하는 메서드*/
    private void showCart(Cart cart) {
        for (int i = 0; i < cart.getCartSize(); i++) {
            System.out.printf(i + 1 + ". %-17s | W " + cart.getCartItem(i).getPrice() / 1000.0 + " | " + cart.getCartItem(i).getCount() + "개 %n", cart.getCartItem(i).getName());
        }
    }

    /*장바구니의 총 금액을 출력하는 메서드*/
    private void showTotalPrice(Cart cart) {
        System.out.println("\n[ Total ]");
        System.out.println("W " + cart.getTotalPrice() + "\n");
    }
}