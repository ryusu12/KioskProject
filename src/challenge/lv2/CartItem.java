package challenge.lv2;

/*장바구니에 담기는 메뉴를 관리하는 클래스*/
class CartItem {
    private final String name;
    private final int price;
    private int count;

    CartItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
        this.count = 1;
    }

    /*Getter*/
    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    int getCount() {
        return count;
    }

    /*Setter*/
    void setCount() {
        this.count += 1;
    }
}