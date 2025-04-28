package challenge.lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*키오스크 프로그램의 사용자 입력을 처리하는 클래스*/
class Kiosk {
    /*번호를 입력받는 메서드
     * int형 외의 것을 입력받으면 -1 리턴 */
    private int inputChoice() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    /*상위 카테고리 메뉴 진행하는 메서드*/
    void start(List<Menu> menuList) {
        Cart cart = new Cart();
        while (true) {
            // 상위 카테고리 메뉴 보여주기
            Display display = new Display();
            display.showMenuList(menuList, cart);
            int choice = inputChoice();

            // 선택한 결과 진행하기
            if (choice >= 1 && choice <= menuList.size()) {
                // 하위 카테고리의 메뉴 진행하기
                startCategory(menuList.get(choice - 1), cart);
            } else if ((choice == menuList.size() + 1) && !cart.isEmptyCart()) {
                // Orders를 선택한 경우
                startOrders(cart);
            } else if ((choice == menuList.size() + 2) && !cart.isEmptyCart()) {
                // Cancel을 선택한 경우
                startCancel(cart);
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                display.showInvalidOption();
                System.out.println();
            }
        }
    }

    /*장바구니 주문을 진행하는 메서드*/
    private void startOrders(Cart cart) {
        while (true) {
            // Orders 옵션 보여주기
            Display display = new Display();
            display.showOrders(cart);
            int choice = inputChoice();

            if (choice == 1) {
                // 주문하기
                System.out.println("주문이 완료되었습니다. 금액은 W " + cart.getTotalPrice() + " 입니다.\n");
                cart.initCart();
                break;
            } else if (choice == 2) {
                // 처음으로 돌아가기
                System.out.println();
                break;
            } else {
                display.showInvalidOption();
            }
        }
    }

    /*장바구니의 주문 메뉴를 취소하는 메서드*/
    private void startCancel(Cart cart) {
        while (true) {
            // Cancel 옵션 보여주기
            Display display = new Display();
            display.showCancel(cart);
            int choice = inputChoice();

            if (choice >= 1 && choice <= cart.getCartSize()) {
                // 주문 취소하기
                cart.deleteCart(choice - 1);
                System.out.println("주문이 취소되었습니다.");
            } else if (choice == 0) {
                // 처음으로 돌아가기
                System.out.println();
                break;
            } else {
                display.showInvalidOption();
            }
        }
    }

    /*하위 카테고리 메뉴 진행하는 메서드*/
    private void startCategory(Menu menu, Cart cart) {
        while (true) {
            // 하위 카테고리 메뉴 보여주기
            Display display = new Display();
            display.showCategoryMenu(menu);
            int choice = inputChoice();

            // 선택한 결과 진행하기
            if (choice >= 1 && choice <= menu.getMenuItemsSize()) {
                MenuItem menuItem = menu.getMenuItem(choice - 1);
                // 선택한 메뉴 확인하기
                System.out.print("선택한 메뉴 : ");
                display.showSelectMenu(menuItem);
                // 장바구니에 추가하기
                startAddCart(menuItem, cart);
                break;
            } else if (choice == 0) {
                // 처음으로 돌아가기
                System.out.println();
                break;
            } else {
                display.showInvalidOption();
            }
        }
    }

    /*장바구니에 추가하는 메서드*/
    private void startAddCart(MenuItem menuItem, Cart cart) {
        while (true) {
            Display display = new Display();
            display.showAddCart(menuItem);
            int choice = inputChoice();

            if (choice == 1) {
                cart.addCart(new CartItem(menuItem));
                System.out.println(menuItem.getName() + " 이(가) 장바구니에 추가되었습니다.\n");
                break;
            } else if (choice == 2) {
                System.out.println();
                break;
            } else {
                display.showInvalidOption();
            }
        }
    }
}