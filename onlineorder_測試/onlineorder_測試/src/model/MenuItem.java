package model;

public abstract class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 類別特有描述，可讓子類覆寫
    public abstract String getType();
}
