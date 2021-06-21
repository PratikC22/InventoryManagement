/**
 * This program reads in inventory such as product name, price, weight and stores it in array list.
 * also has feature to edit list.
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

        InventoryService inventoryService = new InventoryService();

        while (true) {
            int choice = UserInputOutput.getUserChoice();

            switch (choice) {
                case 1:
                    Inventory inventory = readDataFromConsole();
                    inventoryService.addInventory(inventory);
                    break;
                case 2:
                    String editName = UserInputOutput.getProductName();
                    if (inventoryService.findByName(editName)) {

                        double price = UserInputOutput.getProductPrice();
                        double weight = UserInputOutput.getProductWeight();

                        inventoryService.editInventory(editName, price, weight);
                    }
                    break;
                case 3:
                    String name = UserInputOutput.getProductName();
                    if (inventoryService.findByName(name)) {
                        inventoryService.deleteInventory(name);
                    }
                    break;
                case 4:
                    UserInputOutput.display(inventoryService.findAll());
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
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