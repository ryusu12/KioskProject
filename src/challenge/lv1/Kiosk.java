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
            showMenuList(menuList, cart);
            int choice = inputChoice();

            // 선택한 결과 진행하기
            if (choice >= 1 && choice <= menuList.size()) {
                Menu menu = menuList.get(choice - 1);
                System.out.println();
                // 하위 카테고리의 메뉴 진행하기
                startCategory(menu, cart);
            } else if (choice == menuList.size() + 1) {
                // Orders를 선택한 경우
                //todo: Orders를 진행하는 메서드
                while (true) {
                    System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
                    System.out.println("[ Orders ]");
                    // 장바구니 목록 가져오기
                    cart.showCart();
                    cart.showTotalPrice();
                    System.out.println("1. 주문      2. 메뉴판");

                    choice = inputChoice();
                    if (choice == 1) {
                        // 장바구니 초기화
                        System.out.println("주문이 완료되었습니다. 금액은 W " + cart.getTotalPrice() + " 입니다.\n");
                        cart.initCart();
                        break;
                    } else if (choice == 2) {
                        System.out.println();
                        break;
                    } else {
                        System.out.println("선택지에 없습니다.");
                    }
                }
            } else if (choice == menuList.size() + 2) {
                // Cancel을 선택한 경우
                //todo: Cancel을 진행하는 메서드
                System.out.println("[ Cancel ]");
                while (true) {
                    int num = cart.getCart().size();
                    System.out.println("\n[ Cancel ]");
                    cart.showCart();
                    System.out.println("0. 뒤로가기");
                    cart.showTotalPrice();

                    System.out.println("몇번의 메뉴를 취소 하시겠습니까?");
                    choice = inputChoice();
                    if (choice >= 1 && choice <= num) {
                        cart.deleteCart(choice - 1);
                        System.out.println("주문이 취소되었습니다.");
                    } else if (choice == 0) {
                        System.out.println();
                        break;
                    } else {
                        System.out.println("선택지에 없습니다.");
                    }
                }
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("선택지에 없습니다.\n");
            }
        }
    }

    /*하위 카테고리 메뉴 진행하는 메서드*/
    private void startCategory(Menu menu, Cart cart) {
        while (true) {
            // 하위 카테고리 메뉴 보여주기
            showCategoryMenu(menu);
            int choice = inputChoice();

            // 선택한 결과 진행하기
            if (choice >= 1 && choice <= menu.getMenuItems().size()) {
                MenuItem menuItem = menu.getMenuItems().get(choice - 1);
                //todo: 장바구니 추가 메서드 생성
                //선택한 메뉴 확인하기
                showSelectMenu(menuItem);
                while (true) {
                    System.out.println("\"" + menuItem.getName() + "\t| W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "\"\n");
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    choice = inputChoice();
                    if (choice == 1) {
                        cart.addCart(new CartItem(menuItem));
                        System.out.println(menuItem.getName()+" 이 장바구니에 추가되었습니다.\n");
                        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
                        break;
                    } else if (choice == 2) {
                        System.out.println();
                        break;
                    } else {
                        System.out.println("선택지에 없습니다.\n");
                    }
                }
                break;
            } else if (choice == 0) {
                System.out.println();
                break;
            } else {
                System.out.println("선택지에 없습니다.\n");
            }


        }
    }

    /*상위 카테고리 메뉴를 출력하는 메서드*/
    private void showMenuList(List<Menu> menuList, Cart cart) {
        System.out.println("[ MAIN MENU ]");
        int num = 0;
        for (Menu menu : menuList) {
            System.out.println(++num + ". " + menu.getCategory());
        }
        System.out.println("0. 종료      | 종료");
        if (!cart.getCart().isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    /*하위 카테고리 메뉴를 출력하는 메서드*/
    private void showCategoryMenu(Menu menu) {
        System.out.println("[ " + menu.getCategory() + " MENU ]");
        menu.showMenuItems();
        System.out.println("0. 뒤로가기");
    }

    /*선택한 메뉴 정보를 출력하는 메서드.*/
    private void showSelectMenu(MenuItem menuItem) {
        System.out.print("선택한 메뉴 : ");
        System.out.println(menuItem.getName() + "\t| W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "\n");
    }
}