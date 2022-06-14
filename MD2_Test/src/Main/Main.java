package Main;

import controller.ProductManagement;

public class Main {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        while (true) {
            productManagement.menu();
        }
    }
}
