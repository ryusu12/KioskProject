package lv5;

import java.util.ArrayList;
import java.util.List;

/*MenuItem 클래스를 관리하는 클래스*/
class Menu {
    private final List<MenuItem> menuItems;
    private final String category;

    // 생성자
    Menu(String category) {
        this.menuItems = new ArrayList<>();
        this.category = category;
    }

    // List에 메뉴 추가하는 메서드
    void addMenuItems(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 메서드
    void showMenuItems() {
        int num = 0;
        for (MenuItem menuItem : menuItems) {
            System.out.printf(++num + ". %-17s | W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "%n", menuItem.getName());
        }
    }

    // List 크기를 리턴하는 메서드
    int getMenuItemsSize() {
        return menuItems.size();
    }

    // List에 들어있는 MenuItem를 인덱스로 하나 리턴하는 메서드
    MenuItem getMenuItem(int index) {
        return menuItems.get(index);
    }

    // 메뉴 카테고리 이름을 반환
    String getCategory() {
        return category;
    }

}