package model;

import java.util.ArrayList;

public class ComboMeal {
    private String main;
    private int mainPrice;
    private String side;
    private int sidePrice;
    private Beverage drink;
    private int quantity = 1;
    private ArrayList<String> customizations = new ArrayList<>();
    private boolean isCombo = false; // 套餐標記

    public ComboMeal(String main, int mainPrice, String side, int sidePrice, Beverage drink) {
        this.main = main;
        this.mainPrice = mainPrice;
        this.side = side;
        this.sidePrice = sidePrice;
        this.drink = drink;
    }

    public void setQuantity(int q) { this.quantity = q; }
    public void increaseQuantity(int q) { this.quantity += q; }
    public void addCustomization(String text, boolean chargeable) { customizations.add(text); }
    public void setCombo(boolean combo) { this.isCombo = combo; }
    public boolean isCombo() { return isCombo; }

    public int getTotalPrice() {
        int sum = mainPrice + sidePrice + (drink != null ? drink.getPrice() : 0);
        sum *= quantity;
        return sum;
    }

    public int getDiscountedPrice() {
        if(isCombo) return (int)(getTotalPrice() * 0.85);
        else return getTotalPrice();
    }

    public void printDetail() { System.out.println(toFileString(isCombo)); }

    public String toFileString(boolean applyDiscount) {
        StringBuilder sb = new StringBuilder();
        sb.append("數量: ").append(quantity).append("\n");
        if(!main.isEmpty()) sb.append("主餐: ").append(main).append(" ").append(mainPrice).append(" 元\n");
        if(!side.isEmpty()) sb.append("附餐: ").append(side).append(" ").append(sidePrice).append(" 元\n");
        if(drink != null && !drink.getName().isEmpty()) sb.append("飲料: ").append(drink.getName())
                .append(" ").append(drink.getPrice()).append(" 元 ").append(drink.getIceLevel()).append("\n");
        if(!customizations.isEmpty()){
            sb.append("客製化: ");
            for(String c : customizations) sb.append(c).append(" ");
            sb.append("\n");
        }
        if(applyDiscount && isCombo){
            sb.append("原價: ").append(getTotalPrice()).append(" 元 → 折扣後: ").append(getDiscountedPrice()).append(" 元\n");
        } else {
            sb.append("小計: ").append(getTotalPrice()).append(" 元\n");
        }
        return sb.toString();
    }
}
