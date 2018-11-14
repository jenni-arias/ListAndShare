package jenn.arga.listandshare.features.products.model;

import java.util.ArrayList;

public class Product {

    public String product_name;
    public String product_description;
    public int product_quantity;
    public ArrayList<String> list_product;

    public Product() {
    }

    public Product(String product_name, String product_description, int product_quantity) {
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_quantity = product_quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_item) {
        this.product_name = product_item;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public ArrayList<String> getList_product() {
        return list_product;
    }

    public void setList_product(ArrayList<String> list_product) {
        this.list_product = list_product;
    }
}
