package challenge.lv1;

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

    /*Getter*/
    List<MenuItem> getMenuItems() {
        return menuItems;
    }

    String getCategory() {
        return category;
    }

    /*Setter*/
    void addMenuItems(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}