package Util;

import InventoryModel.Inventory;
import java.util.List;
import java.util.Scanner;

public class UserInputOutput {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getProductName() {
        System.out.println("Enter product name :");
        return scanner.next();
    }

    public static Double getProductPrice() {
        System.out.println("Enter price : ");
        return scanner.nextDouble();
    }

    public static Double getProductWeight() {
        System.out.println("Enter weight : ");
        return scanner.nextDouble();
    }

    public static int getUserChoice() {

        System.out.println("Press 1 - Add Products ");
        System.out.println("Press 2 - Edit Products ");
        System.out.println("Press 3 - Delete Products ");
        System.out.println("Press 4 - Display Products ");

        return scanner.nextInt();
    }
    public static void display(List<Inventory> productList){
        System.out.println(productList);
    }
}