package Lv4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*키오스크 프로그램의 사용자 입력을 처리하는 클래스*/
public class Kiosk {
    /*번호를 입력받는 메서드
     * int형 외의 것을 입력받으면 -1 리턴 */
    private int getChoice() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    /*프로그램 실행*/
    public void start(List<Menu> menuList) {
        while (true) {
            // 상위 카테고리 메뉴 보여주기
            showMenu(menuList);

            // MAIN MENU: 숫자 입력 받기
            int mainChoice = getChoice();
            if (mainChoice >= 1 && mainChoice <= menuList.size()) {
                Menu categoryMenu = menuList.get(mainChoice - 1);
                System.out.println();
                while (true) {
                    // 하위 카테고리 메뉴 보여주기
                    showCategoryMenu(categoryMenu);
                    // MENU: 숫자 입력 받기
                    int choice = getChoice();
                    if (choice >= 1 && choice <= categoryMenu.getMenuItems().size()) {
                        MenuItem menuItem = categoryMenu.getMenuItems().get(choice - 1);
                        showSelectMenu(menuItem);
                        break;
                    } else if (choice == 0) {
                        System.out.println();
                        break;
                    } else {
                        System.out.println("선택지에 없습니다.\n");
                    }
                }

            } else if (mainChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("선택지에 없습니다.\n");
            }
        }
    }

    /*상위 카테고리 메뉴를 출력하는 메서드*/
    private void showMenu(List<Menu> menuList) {
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
        // Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
        menu.showMenuItems();
        System.out.println("0. 뒤로가기");
    }

    /*선택한 메뉴 정보를 출력한다.
     * 1~4 선택시 실행된다.*/
    private void showSelectMenu(MenuItem menuItem) {
        System.out.print("선택한 메뉴 : ");
        // 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근한다.
        System.out.println(menuItem.getName() + "\t| W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "\n");
    }
}