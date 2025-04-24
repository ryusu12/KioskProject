package Lv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스*/
public class Kiosk {
    private final List<MenuItem> menuItems;

    /*메뉴 설정하는 생성자*/
    public Kiosk(MenuItem menu1, MenuItem menu2, MenuItem menu3, MenuItem menu4) {
        this.menuItems = new ArrayList<>(List.of(menu1, menu2, menu3, menu4));
    }

    /*프로그램 실행*/
    public void start() {
        while (true) {
            // 햄버거 메뉴를 출력한다.
            showMenu();

            // 번호를 입력한다.
            int choice = getChoice();

            // 선택한 결과를 진행한다.
            if (showResult(choice, menuItems)) break;
        }
    }

    /*번호를 입력받는 메서드
     * int형 외의 것을 입력받으면 -1 리턴 -> 결과 출력시, default로 이동 */
    private int getChoice() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    /*햄버거 메뉴를 출력하는 메서드*/
    private void showMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        int num = 0;
        for (MenuItem menuItem : menuItems) {
            System.out.println(++num + ". " + menuItem.getName() + "\t| W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription());
        }
        System.out.println("0. 종료      | 종료");
    }

    /*입력에 맞는 문구를 출력하는 메서드
     * 1~4 : 선택한 메뉴를 보여준다.
     * 그외 : 선택지에 없다는 문구 출력 => false 리턴 : 프로그램 계속 진행됨
     * 0 : 프로그램 종료 => true 리턴 : 프로그램 종료됨 */
    private boolean showResult(int choice, List<MenuItem> menuItems) {
        switch (choice) {
            case 1:
                showSelectMenu("ShackBurger", menuItems);
                break;
            case 2:
                showSelectMenu("SmokeShack", menuItems);
                break;
            case 3:
                showSelectMenu("Cheeseburger", menuItems);
                break;
            case 4:
                showSelectMenu("Hamburger", menuItems);
                break;
            case 0:
                System.out.println("프로그램을 종료합니다.");
                return true;
            default:
                System.out.println("선택지에 없습니다.\n");
        }
        return false;
    }

    /*선택한 메뉴 정보를 출력한다.
     * 1~4 선택시 실행된다.*/
    private void showSelectMenu(String menu, List<MenuItem> menuItems) {
        System.out.print("선택한 메뉴 : ");
        // 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근한다.
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equals(menu)) {
                System.out.println(menuItem.getName() + "\t| W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "\n");
            }
        }
    }
}