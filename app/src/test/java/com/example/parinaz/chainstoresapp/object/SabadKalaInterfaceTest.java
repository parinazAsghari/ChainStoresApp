package com.example.parinaz.chainstoresapp.object;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//TODO
public class SabadKalaInterfaceTest {

    SabadKalaInterface sabadKalaTest;

   @Before
    public void setUp() throws Exception {
        sabadKalaTest = new SabadKalaImpl();
    }

   @After
    public void tearDown() throws Exception {
    }

    @Test
    public  void calculateRowPriceOfSabadKalaList(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setPrice(1000);
        p2.setPrice(2500);
        productList.add(p1);
        productList.add(p2);
       Assert.assertEquals(3500,sabadKalaTest.getRowPrice(productList));
       //OR
       /* Boolean b = false;
        if(sabadKalaTest.getRowPrice(productList)==3500){
            b = true;
        }
        Assert.assertTrue("if rowPrice==3500",b);*/
    }
    @Test
    public void showAllProducts(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        Product p2 =new Product();
        p1.setName("شامپو");
        p2.setName("شیر");
        productList.add(p1);
        productList.add(p2);
        Assert.assertEquals(productList,sabadKalaTest.getPoducts(productList));
    }

    @Test
    public void priceWithDiscount(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        Product p2 =new Product();
       p1.setPrice(5000);
       p1.setDiscount(20);
       p2.setPrice(2000);
       p2.setDiscount(10);
        productList.add(p1);
        productList.add(p2);
        Assert.assertEquals(5800,sabadKalaTest.getPriceWithDiscount(productList));

    }
    @Test
    public void quantityOfProductListShouldBeCorrect(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setCode(1);
        p2.setCode(2);
      productList.add(p1);
      productList.add(p2);
        Assert.assertEquals(2,sabadKalaTest.getProductsQuantity(productList));
    }
    @Test
    public void quantityOfProductListMustNotBeNull(){
        List<Product> productList = new ArrayList<>();
        /*Product p1 = new Product();
        Product p2 = new Product();
        p1.setCode(1);
        p2.setCode(2);
        productList.add(p1);
        productList.add(p2);*/
        Assert.assertEquals(0,sabadKalaTest.getProductsQuantity(productList));
    }



   @Test
    public void addProductMustNotChangeProduct() {
        Product product = new Product();
        product.setCode(1);
        sabadKalaTest.addProduct(product);
        Assert.assertEquals(product, sabadKalaTest.getProductByCode(product.getCode()));
    }

    /*@Test
    public void removeProductFromList(){
        Product product = new Product();
        product.setCode(1);
        sabadKalaTest.addProduct(product);
        Assert.assertEquals(,sabadKalaTest.removeProduct(product));
    }*/



}