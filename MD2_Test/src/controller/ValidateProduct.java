package controller;

import model.Product;

import java.util.List;
import java.util.Scanner;

public class ValidateProduct {
    public int getIndexID(int id, List<Product> productList){

        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    Scanner scanner = new Scanner(System.in);
    public int validateID(List<Product> productList){
        while (true){
            try {
                System.out.println("Nhập mã sp: ");
                int id = Integer.parseInt(scanner.nextLine());
                if(getIndexID(id, productList) != -1){
                    throw new Exception();
                }
                return id;
            }catch (Exception e){
                System.out.println("Mã sản phẩm đã tồn tại hoặc hãy nhập số!");
            }
        }
    }
    public String validateString(String name){
        while (true){
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if (str.equals("")){
                System.out.println("Không được để trống!");
                continue;
            }
            return str;
        }
    }
    public int validatePrice(){
        while (true){
            try {
                System.out.println("Nhập giá sản phẩm");
                int price = Integer.parseInt(scanner.nextLine());
                return price;
            }catch (Exception e){
                System.out.println("Nhập vào số!");
            }
        }
    }
    public int validateQuantity(){
        while (true){
            try {
                System.out.println("Nhập vào số lượng sản phẩm: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                return quantity;
            }catch (Exception e){
                System.out.println("Nhập vào số!");
            }
        }
    }
    public int validateEditID(List<Product> productList){
        while (true){
            try {
                System.out.println("Nhập mã sp: ");
                int id = Integer.parseInt(scanner.nextLine());
                if(getIndexID(id, productList) != -1){
                    throw new Exception();
                }
                return id;
            }catch (Exception e){
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
            }
        }
    }
}
