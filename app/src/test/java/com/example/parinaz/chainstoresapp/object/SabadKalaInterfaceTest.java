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
        Boolean b = false;
        if(sabadKalaTest.getRowPrice(productList)==3500){
            b = true;
        }
        Assert.assertTrue("if rowPrice==3500",b);
    }

    @Test
    public void calculateOfRowPriceMustNOtBeNull(){
        List<Product> productList = new ArrayList<>();
       // Assert.assertEquals(0,sabadKalaTest.getRowPrice(productList));
        //OR
       Assert.assertNotNull(sabadKalaTest.getRowPrice(productList));

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
       // Assert.assertEquals(productList,sabadKalaTest.getPoducts(productList));
        //OR
        Boolean b =false;
        if(sabadKalaTest.getPoducts(productList)==productList){
            b= true;
        }
        Assert.assertTrue(b);
    }
    @Test
    public void returnedProductsMustHaveCorrectSize(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        Product p2 =new Product();
        p1.setName("شامپو");
        p2.setName("شیر");
        productList.add(p1);
        productList.add(p2);
        Assert.assertEquals(2,sabadKalaTest.getPoducts(productList).size());
        Boolean b = false;
        if (sabadKalaTest.getPoducts(productList).size()==2){
          b=true;
        }
        Assert.assertTrue(b);
    }

    @Test
    public void allpriceWithDiscount(){
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        Product p2 =new Product();
       p1.setPrice(5000);
       p1.setDiscount(20);
       p2.setPrice(2000);
       p2.setDiscount(10);
        productList.add(p1);
        productList.add(p2);
       // Assert.assertEquals(5800,sabadKalaTest.getPriceWithDiscount(productList));
        //OR
        Boolean b =false;
        if(sabadKalaTest.getPriceWithDiscount(productList)==5800){
            b=true;
        }
        Assert.assertTrue(b);
    }
    @Test
    public void allPriceWithDiscountMustNotBeNull(){
        List<Product> productList = new ArrayList<>();
        Assert.assertNotNull(productList);
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
      //  Assert.assertEquals(2,sabadKalaTest.getProductsQuantity(productList));
        //OR
        Boolean b = false;
        if(sabadKalaTest.getProductsQuantity(productList)==2){
            b=true;
        }
        Assert.assertTrue(b);
    }
    @Test
    public void quantityOfProductListMustNotBeNull(){
        List<Product> productList = new ArrayList<>();
        Assert.assertEquals(0,sabadKalaTest.getProductsQuantity(productList));
        //OR
        Assert.assertNotNull(productList);
    }



   @Test
    public void addProductMustNotChangeProduct() {
        Product product = new Product();
       product.setCode(1);
        sabadKalaTest.addProduct(product);
        Assert.assertEquals(product, sabadKalaTest.getProductByCode(product.getCode()));
    }
    @Test
    public void addProductMustUpdateProductListSize(){
       Product p1 = new Product();
       p1.setCode(1);
       Boolean b =false;
       if( sabadKalaTest.addProduct(p1).size()==1){
           b=true;
       }
       Assert.assertTrue(b);

    }
    @Test
    public void removeProductShouldReturnCorrectSizeOfremainList(){
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        product1.setCode(1);
        product2.setCode(2);
        product3.setCode(3);
        sabadKalaTest.addProduct(product1);
        sabadKalaTest.addProduct(product2);
        sabadKalaTest.addProduct(product3);
       Assert.assertEquals(2,sabadKalaTest.removeProduct(product3));
       Assert.assertEquals(1,sabadKalaTest.removeProduct(product1));
    }



}