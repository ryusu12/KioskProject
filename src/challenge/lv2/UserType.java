package challenge.lv2;

/*할인 정보를 담는 열거형*/
enum UserType {
    NATIONAL("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반인", 0);

    private final String name;
    private final int discount;

    UserType(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    String getName() {
        return name;
    }

    int getDiscount() {
        return discount;
    }
}