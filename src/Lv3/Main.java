package Lv3;

import java.util.List;

public class Main {
    /*프로그램 설정하는 클래스*/
    public static void main(String[] args) {
        // 메뉴를 설정한다.
        MenuItem shackBurger = new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거");
        // main 함수에서 Kiosk 객체를 생성할 때 값을 넘겨준다.
        Kiosk kiosk = new Kiosk(List.of(shackBurger, smokeShack, cheeseburger, hamburger));

        // 프로그램을 실행한다.
        kiosk.start();
    }
}