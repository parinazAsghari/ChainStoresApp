package com.example.parinaz.chainstoresapp.object;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//TODO
class SabadKalaImpl implements SabadKalaInterface {
    Product product = new Product();
   public List<Product> sabadKalaProducts = new ArrayList<>();

    int sumOfreducedPrice=0;
    Product productbycode;


    @Override
    public int getRowPrice(List<Product> priceList) {
        int sumofprice = 0;

        for(Product p : priceList){
          sumofprice = sumofprice + p.getPrice() ;
        }
        return sumofprice;


    }

    @Override
    public int getProductsQuantity(List<Product> products) {
        return products.size();

    }


    @Override
    public int getPriceWithDiscount(List<Product> products) {
        for (Product p :products) {
            sumOfreducedPrice= sumOfreducedPrice + p.getPrice() * (100 - p.getDiscount()) / 100;
        }
        return sumOfreducedPrice;

    }

    @Override
    public List<Product> getPoducts(List<Product> products) {

            return products;

    }

    @Override
    public List addProduct(Product product) {
        sabadKalaProducts.add(product);
        return sabadKalaProducts;
    }

    @Override
    public int removeProduct(Product product) {
        sabadKalaProducts.remove(product);
        return sabadKalaProducts.size();

    }

    @Override
    public Product getProductByCode(int code) {

        for (Product p :sabadKalaProducts) {

            if (p.getCode()==code)
                productbycode = p ;


        }
        return productbycode;

    }

    public List getallProducts() {
        product.setCode(1);
        product.setCategory(1);
        product.setDiscount(20);
        product.setName("شامپو");
        product.setPrice(12000);
        product.setReducedPrice(product.getPrice() * (100 - product.getDiscount()) / 100);
        product.setStock(1);
        product.setCode(2);
        product.setCategory(2);
        product.setDiscount(10);
        product.setName("پنیر کاله");
        product.setPrice(6000);
        product.setReducedPrice(product.getPrice() * (100 - product.getDiscount()) / 100);
        product.setStock(1);
        product.setCode(3);
        product.setCategory(3);
        product.setDiscount(15);
        product.setName("بیسکوییت گرجی");
        product.setPrice(8000);
        product.setReducedPrice(product.getPrice() * (100 - product.getDiscount()) / 100);
        product.setStock(1);
        sabadKalaProducts.add(product);
        return sabadKalaProducts;
    }


}
