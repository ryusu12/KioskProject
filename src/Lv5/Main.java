package Lv5;

import java.util.List;

class Main {
    /*프로그램 설정하는 클래스*/
    public static void main(String[] args) {
        // 메뉴를 설정한다.
        // 버거
        Menu burgers = new Menu("Burgers");
        burgers.addMenuItems(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItems(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItems(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItems(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료
        Menu drinks = new Menu("Drinks");
        drinks.addMenuItems(new MenuItem("ShackCoffee", 5000, "쉑 블렌드 원두를 사용한 밸런스 좋은 블랙 커피"));
        drinks.addMenuItems(new MenuItem("Lemonade", 4500, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.addMenuItems(new MenuItem("IcedTea", 3700, "직접 유기농 홍차를 우려낸 아이스 티"));
        drinks.addMenuItems(new MenuItem("HotTea", 2900, "보성 유기농 찻잎을 우려낸 녹차, 홍차, 페퍼민트 & 레몬그라스"));

        // 디저트
        Menu desserts = new Menu("Desserts");
        desserts.addMenuItems(new MenuItem("Fries", 4900, "바삭하고 담백한 크링클 컷 프라이"));
        desserts.addMenuItems(new MenuItem("CheeseFries", 6000, "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이"));
        desserts.addMenuItems(new MenuItem("CupCones", 5700, "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림 (바닐라/초콜릿)"));
        desserts.addMenuItems(new MenuItem("HoneyButterCrunch", 6200, "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트"));

        // 프로그램을 실행한다.
        Kiosk kiosk = new Kiosk();
        kiosk.start(List.of(burgers, drinks, desserts));
    }
}