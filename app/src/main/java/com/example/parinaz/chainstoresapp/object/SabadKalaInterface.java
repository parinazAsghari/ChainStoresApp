package com.example.parinaz.chainstoresapp.object;

import java.util.List;

public interface SabadKalaInterface {

    int getRowPrice(List<Product> priceList );//قیمت خالص

  int getProductsQuantity(List<Product> products);//تعداد محصولات سبد کالا

    int getPriceWithDiscount(List<Product> products);//قیمت با محاسبه تخفیف

   List<Product> getPoducts(List<Product> products);

    void addProduct(Product product);

    void removeProduct(Product product);

    Product getProductByCode(int code);
}
