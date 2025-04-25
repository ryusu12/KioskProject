package challenge.lv1;

public class CartItem {
    // 메뉴명
    MenuItem menuItem;
    int price;
    int count;

    CartItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.price = menuItem.getPrice();
        this.count = 1;
    }

    int getPrice() {
        return this.price;
    }

    MenuItem getMenuItem() {
        return menuItem;
    }

    public int getCount() {
        return count;
    }

    void setCount() {
        this.count += 1;
    }
}