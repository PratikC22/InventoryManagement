/**
 * This program reads in inventory such as product name, price, weight and stores it in array list.
 * also has feature to edit list and calculate total product price.
 *
 * @author Pratik Chaudhari
 * @since 19/06/2021
 */
package InventoryController;

import InventoryModel.Inventory;
import InventoryService.InventoryService;
import Util.UserInputOutput;

public class InventoryMain {

    public static void main(String[] args) {

        System.out.println("Welcome to the inventory management program");

        InventoryService inventoryService = new InventoryService();
        Inventory inventory = new Inventory();

        while (true) {
            int choice = UserInputOutput.getUserChoice();
            switch (choice) {
                case 1 -> {
                    inventory = readDataFromConsole();
                    inventoryService.addInventory(inventory);
                }
                case 2 -> {
                    String editName = UserInputOutput.getProductName();
                    if (inventoryService.findByName(editName)) {

                        double price = UserInputOutput.getProductPrice();
                        double weight = UserInputOutput.getProductWeight();

                        inventoryService.editInventory(editName, price, weight);
                    }
                }
                case 3 -> {
                    String name = UserInputOutput.getProductName();
                    if (inventoryService.findByName(name)) {
                        inventoryService.deleteInventory(name);
                    }
                }
                case 4 -> UserInputOutput.display(inventoryService.findAll());
                default -> System.out.println("Invalid Input!");

                case 5 -> {
                    String name = UserInputOutput.getProductName();
                    if (inventoryService.findByName(name)) {
                        inventoryService.calculateInventory(name, inventory.getPrice(), inventory.getWeight());
                    }
                }
            }
            if (choice == 6) break;
        }
    }

    public static Inventory readDataFromConsole() {
        Inventory inventory = new Inventory();
        System.out.println("Add Inventory");

        String name = UserInputOutput.getProductName();
        inventory.setName(name);

        double price = UserInputOutput.getProductPrice();
        inventory.setPrice(price);

        double weight = UserInputOutput.getProductWeight();
        inventory.setWeight(weight);

        return inventory;
    }
}