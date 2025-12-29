package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String name;
    private ArrayList<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public MenuItem getMenuItem(int index) {
        return menu.get(index);
    }

    public void showMenu() {
        System.out.println("=== " + name + " 菜單 ===");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName()
                    + " $" + item.getPrice()
                    + " (" + item.getType() + ")");
        }
        System.out.println("0. 結束點餐");
    }

    // 輸入菜單
    public void inputMenu(Scanner sc) {
        System.out.print("請輸入餐點數量：");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("第 " + (i + 1) + " 個餐點：");
            System.out.print("餐點名稱：");
            String name = sc.nextLine();
            System.out.print("餐點價格：");
            int price = sc.nextInt();
            sc.nextLine();
            System.out.print("餐點類型 (1=主餐 2=附餐 3=飲料)：");
            int type = sc.nextInt();
            sc.nextLine();

            MenuItem item;
            if (type == 1) item = new MainDish(name, price);
            else if (type == 2) item = new SideDish(name, price);
            else if (type == 3) item = new Beverage(name, price);
            else {
                System.out.println("無效類型，預設為主餐");
                item = new MainDish(name, price);
            }

            addMenuItem(item);
        }
    }
}
