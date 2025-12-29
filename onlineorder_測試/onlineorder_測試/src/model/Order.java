package model;

import java.util.ArrayList;

public class Order {
    private String customerName;
    private String restaurantName;
    private int deliveryFee;
    private int peakFee;
    private ArrayList<ComboMeal> comboMeals = new ArrayList<>();

    public Order(String customerName, String restaurantName) {
        this.customerName = customerName;
        setRestaurantName(restaurantName);
    }

    public void setCustomerName(String name) { this.customerName = name; }
    public void setRestaurantName(String name) { this.restaurantName = (name == null || name.isEmpty()) ? "未指定餐廳" : name; }
    public String getRestaurantName() { return restaurantName; }
    public void setDeliveryFee(int fee) { this.deliveryFee = fee; }
    public void setPeakFee(int fee) { this.peakFee = fee; }
    public int getPeakFee() { return peakFee; }
    public int getDeliveryFee() { return deliveryFee; }
    public void addComboMeal(ComboMeal c) { comboMeals.add(c); }

    public int getTotal() {
        int sum = deliveryFee + peakFee;
        for(ComboMeal c : comboMeals){
            sum += c.isCombo() ? c.getDiscountedPrice() : c.getTotalPrice();
        }
        return sum;
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== 新訂單 =====\n");
        sb.append("顧客：" + customerName + "\n");
        sb.append("餐廳：" + restaurantName + "\n");
        for(ComboMeal c : comboMeals){
            sb.append(c.toFileString(c.isCombo())).append("\n");
        }
        sb.append("外送費：" + deliveryFee + " 元\n");
        sb.append("尖峰費：" + peakFee + " 元\n");
        sb.append("總金額：" + getTotal() + " 元\n");
        sb.append("-----------------------------------\n\n");
        return sb.toString();
    }
}
