package controller;

import io.ReaderAndWriter;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    List<Product> productList = new ArrayList<>();
    ValidateProduct validateProduct = new ValidateProduct();
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    Scanner scanner = new Scanner(System.in);

    public void menu(){
        System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số(để tiếp tục");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                hienThiDS();
                break;
            case 2:
               addProduct();
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sort();
                break;
            case 6:
                findMostExpensiveProduct();
                break;
            case 7:
                productList = readerAndWriter.read();
                System.out.println("Đọc thành công");
                break;
            case 8:
                System.out.println("Bạn có muốn lưu file không?");
                System.out.println("Xác nhận muốn xóa sản phẩm, nhập 'Y' ");
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase("y")){
                    readerAndWriter.write(productList);
                    System.out.println("Lưu thành công!");
                }else {
                    System.out.println("Ấn enter để quay lại menu");
                    scanner.nextLine();
                    menu();
                }
                break;
            case 9:
                System.exit(0);
        }
    }
    public void hienThiDS(){
        if(productList.size() == 0){
            System.out.println("Chưa có danh sách nào!");
        }
        for (int i = 0; i < productList.size(); i++) {
            if((i+1) % 5 == 0){
                System.out.println(productList.get(i));
                scanner.nextLine();
            }else {
                System.out.println(productList.get(i));
            }
        }
    }
    public Product creatProduct(){
        int id = validateProduct.validateID(productList);
        String name = validateProduct.validateString("tên sản phẩm");
        int price = validateProduct.validatePrice();
        int quantity = validateProduct.validateQuantity();
        String description = validateProduct.validateString("mô tả về sản phẩm");
        return new Product(id, name, price, quantity, description);
    }
    public void addProduct(){
        productList.add(creatProduct());
    }
    public void editProduct(){
        try {
            System.out.println("Nhập mã sản phẩm cần sửa thông tin: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
                    System.out.println("Nhập tên: ");
                    String name = scanner.nextLine();
                    productList.get(i).setName(name);
                    System.out.println("Nhập giá sản phẩm: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    productList.get(i).setPrice(price);
                    System.out.println("Nhập giá số lượng sản phẩm: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    productList.get(i).setQuantity(quantity);
                    System.out.println("Nhập miêu tả sản phẩm: ");
                    String description = scanner.nextLine();
                    productList.get(i).setDescription(description);
                    System.out.println(productList.get(i).toString());
                    menu();
                }else {
                    throw new Exception();
                }
            }

        }catch (Exception e){
            System.out.println("Sản phẩm không tồn tại!");
            menu();
        }


    }
    public void deleteProduct(){
        System.out.println("Nhập mã số sản phẩm muốn xóa: ");
        int msv = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexID(msv, productList);
        if(index != -1){
            System.out.println("Xác nhận muốn xóa sản phẩm, nhập 'Y' ");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("y")){
                productList.remove(index);
            }else {
                System.out.println("Ấn enter để quay lại menu");
                scanner.nextLine();
                menu();
            }
        }else {
            System.out.println("Sản phẩm này không tồn tại!");
        }
    }
    public void sort(){
        System.out.println("---- Sắp xếp sản phẩm theo giá ---");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp giá tăng dần");
        System.out.println("2. Sắp xếp giá giảm dần");
        System.out.println("3. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2){
            case 1:
                productList.sort(new SortByPriceUp());
                hienThiDS();
                sort();
                break;
            case 2:
                productList.sort(new SortByPriceDown());
                hienThiDS();
                sort();
                break;
            case 3:
                menu();
                break;

        }
    }
    public void findMostExpensiveProduct(){
        productList.sort(new SortByPriceDown());
        System.out.println("Sản phẩm có giá đắt nhất: " + productList.get(0));
        menu();
    }

}
