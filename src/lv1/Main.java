package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /*햄버거 메뉴를 출력하는 메서드*/
    private void showMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료      | 종료");
    }

    /*입력에 맞는 문구를 출력하는 메서드
    * 1~4 : 선택한 메뉴를 보여준다.
    * 그외 : 선택지에 없다는 문구 출력 => false 리턴 : 프로그램 계속 진행됨
    * 0 : 프로그램 종료 => true 리턴 : 프로그램 종료됨 */
    private boolean processMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.print("선택한 메뉴 : ");
                System.out.println("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                System.out.println();
                break;
            case 2:
                System.out.print("선택한 메뉴 : ");
                System.out.println("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                System.out.println();
                break;
            case 3:
                System.out.print("선택한 메뉴 : ");
                System.out.println("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                System.out.println();
                break;
            case 4:
                System.out.print("선택한 메뉴 : ");
                System.out.println("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                System.out.println();
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
    private int inputChoice() {
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
        while (true) {
            // 메뉴를 보여준다.
            main.showMenu();

            // 번호를 입력한다.
            int choice = main.inputChoice();

            // 선택한 결과를 진행한다.
            if (main.processMenu(choice)) break;
        }
        System.out.println("프로그램을 종료합니다.");
    }
}