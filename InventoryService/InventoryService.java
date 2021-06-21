package InventoryService;

import DAO.InventoryDAO;
import InventoryModel.Inventory;

import java.util.List;


public class InventoryService implements InventoryServiceInterface {
    InventoryDAO inventoryDAO = new InventoryDAO();

    @Override
    public void addInventory(Inventory inventory) {
        inventoryDAO.addInventory(inventory);
    }

    @Override
    public void deleteInventory(String name) {
        inventoryDAO.deleteInventory(name);
    }

    @Override
    public void editInventory(String name, double price, double weight) {
        inventoryDAO.editInventory(name, price, weight);
    }

    @Override
    public boolean findByName(String name) {

        return inventoryDAO.findByName(name);

    }

    @Override
    public List<Inventory> findAll() {

        return inventoryDAO.findAll();
    }
}
