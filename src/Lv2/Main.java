package Lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*메뉴 설정하는 메서드
     * MenuItem에 메뉴를 추가한다.
     * MenuItem의 정보를 List에 넣고 반환한다.*/
    private List<MenuItem> setMenuItem() {
        MenuItem shackBurger = new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거");
        return new ArrayList<>(List.of(shackBurger, smokeShack, cheeseburger, hamburger));
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
                return true;
            default:
                System.out.println("선택지에 없습니다.\n");
        }
        return false;
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

    /*프로그램 실행*/
    public static void main(String[] args) {
        Main main = new Main();

        // 메뉴를 설정한다.
        List<MenuItem> menuItems = main.setMenuItem();

        while (true) {
            // main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력한다.
            System.out.println("[ SHAKESHACK MENU ]");
            int num = 0;
            for (MenuItem menuItem : menuItems) {
                System.out.println(++num + ". " + menuItem.getName() + "\t| W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription());
            }
            System.out.println("0. 종료      | 종료");

            // 번호를 입력한다.
            int choice = main.getChoice();

            // 선택한 결과를 진행한다.
            if (main.showResult(choice, menuItems)) break;
        }
        System.out.println("프로그램을 종료합니다.");
    }
}