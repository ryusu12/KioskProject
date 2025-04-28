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

    /*Setter*/
    // List에 메뉴 추가하는 메서드
    void addMenuItems(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}