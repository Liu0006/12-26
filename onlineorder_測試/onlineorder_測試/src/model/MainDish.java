package model;

public class MainDish extends MenuItem {
    public MainDish(String name, int price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "主餐";
    }
}
