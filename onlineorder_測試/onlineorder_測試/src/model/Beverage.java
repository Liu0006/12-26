package model;

import java.awt.*;

public class Beverage extends MenuItem {
    private String iceLevel; // 去冰 / 少冰 / 正常冰

    public Beverage(String name, int price) {
        super(name, price);
        this.iceLevel = "正常冰";
    }

    public String getIceLevel() {
        return iceLevel;
    }

    public void setIceLevel(String iceLevel) {
        this.iceLevel = iceLevel;
    }

    @Override
    public String getType() {
        return "飲料";
    }
}
