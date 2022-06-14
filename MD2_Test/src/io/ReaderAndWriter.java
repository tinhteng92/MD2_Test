package io;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    File file = new File("C:\\CodeGym\\Hoc-lieu-Java\\DemoCode\\MD2_finalExam\\MD2_Test\\src\\data\\products.csv");
    public void write(List<Product> productList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id, name, price, quantity, description");
            bufferedWriter.newLine();
            for (Product s: productList) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Product> read(){
        List<Product> productList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null){
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int price = Integer.parseInt(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                String description = arr[4];

                productList.add(new Product(id, name, price, quantity, description));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("File chua ton tai");
        }
        return productList;
    }
}