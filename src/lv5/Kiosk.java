package lv5;

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

    /*프로그램 진행하는 메서드
    * 번호에 맞게 입력하면, 해당 카테고리 메뉴 선택 진행
    * 0은 프로그램 종료
    * 그외는 다시 입력받음*/
    void start(List<Menu> menuList) {
        while (true) {
            // 상위 카테고리 메뉴 보여주기
            showMenuList(menuList);
            int choice = inputChoice();

            // 선택한 결과 진행하기
            if (choice >= 1 && choice <= menuList.size()) {
                Menu menu = menuList.get(choice - 1);
                System.out.println();
                // 선택한 카테고리의 메뉴 선택 진행하기
                startCategory(menu);
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("선택지에 없습니다.\n");
            }
        }
    }

    /*선택한 카테고리의 메뉴 선택을 진행하는 메서드
    * 번호에 맞게 입력하면, 선택한 메뉴 정보 보여주기 -> 상위 카테고리 메뉴로 이동
    * 0은 상위 카테고리로 이동
    * 그외는 다시 입력받음*/
    private void startCategory(Menu menu) {
        while (true) {
            // 하위 카테고리 메뉴 보여주기
            showCategoryMenu(menu);
            int choice = inputChoice();

            // 선택한 결과 진행하기
            if (choice >= 1 && choice <= menu.getMenuItemsSize()) {
                showSelectMenu(menu.getMenuItem(choice - 1));
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
    private void showMenuList(List<Menu> menuList) {
        System.out.println("[ MAIN MENU ]");
        int num = 0;
        for (Menu menu : menuList) {
            System.out.println(++num + ". " + menu.getCategory());
        }
        System.out.println("0. 종료      | 종료");
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