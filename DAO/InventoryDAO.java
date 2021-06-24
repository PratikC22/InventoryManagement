package DAO;

import InventoryModel.Inventory;
import InventoryService.InventoryServiceInterface;
import Util.UserInputOutput;

import java.util.ArrayList;
import java.util.List;

public class InventoryDAO implements InventoryServiceInterface {

    ArrayList<Inventory> productList = new ArrayList<>();

    @Override
    public void addInventory(Inventory inventory) {
        productList.add(inventory);
    }

    @Override
    public void deleteInventory(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)){
                productList.remove(i);
            }
        }
    }

    @Override
    public void editInventory(String name, double price, double weight) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)){
                productList.get(i).setPrice(price);
                productList.get(i).setWeight(weight);
            }
        }
    }

    @Override
    public boolean findByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)){
                return true;
            }
        }

        return false;

    }

    @Override
    public void calculateInventory(String name, double price, double weight) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)){
                double totalPrice = productList.get(i).getPrice() * productList.get(i).getWeight();
                System.out.println("The price of product is : "+totalPrice);
            }
        }
    }

    @Override
    public List<Inventory> findAll(){
        return productList;
    }

}