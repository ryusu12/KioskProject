package lv4;

import java.util.ArrayList;
import java.util.List;

/*MenuItem 클래스를 관리하는 클래스*/
public class Menu {
    private final List<MenuItem> menuItems;
    private final String category;

    // 생성자
    public Menu(String category) {
        this.menuItems = new ArrayList<>();
        this.category = category;
    }

    // 메뉴를 리스트에 추가
    public void addMenuItems(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // List에 들어있는 MenuItem을 순차적으로 보여줌
    public void showMenuItems() {
        int num = 0;
        for (MenuItem menuItem : menuItems) {
            System.out.printf(++num + ". %-17s | W " + menuItem.getPrice() / 1000.0 + " | " + menuItem.getDescription() + "%n", menuItem.getName());
        }
    }

    // List를 리턴
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 메뉴 카테고리 이름을 반환
    public String getCategory() {
        return category;
    }
}