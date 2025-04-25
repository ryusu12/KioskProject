package challenge.lv1;

public class CartItem {
    String name;
    int price;
    int count;

    CartItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
        this.count = 1;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    /*Setter*/
    void setCount() {
        this.count += 1;
    }
}