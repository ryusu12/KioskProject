package challenge.lv2;

/*개별 음식 항목을 관리하는 클래스*/
class MenuItem {
    private final String name;
    private final int price;
    private final String description;

    MenuItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /*Getter*/
    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    String getDescription() {
        return description;
    }
}