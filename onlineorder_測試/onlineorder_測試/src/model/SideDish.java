package model;

public class SideDish extends MenuItem {
    public SideDish(String name, int price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "附餐";
    }
}
