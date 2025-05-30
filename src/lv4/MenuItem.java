package lv4;

/*개별 음식 항목을 관리하는 클래스*/
public class MenuItem {
    private final String name;
    private final int price;
    private final String description;

    MenuItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}