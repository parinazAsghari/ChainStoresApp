package com.example.parinaz.chainstoresapp.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.parinaz.chainstoresapp.AppController;
//import com.example.parinaz.chainstoresapp.MarkedProductsDBHelper;
import com.example.parinaz.chainstoresapp.R;
import com.example.parinaz.chainstoresapp.roomdb.MarkedViewModel;
import com.example.parinaz.chainstoresapp.roomdb.markedDatabase;
import com.example.parinaz.chainstoresapp.roomdb.markedEntity;
import com.example.parinaz.chainstoresapp.data.DataLoader;
import com.example.parinaz.chainstoresapp.data.Url;
import com.example.parinaz.chainstoresapp.data.VolleyCallbackCategories;
import com.example.parinaz.chainstoresapp.object.Category;
import com.example.parinaz.chainstoresapp.object.Store;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    TextView name , reducedPrice , price , discount , storeName , categoryName , stock;
    ImageView image   ;
    Button toolbarBackIcon;
    Intent intent;
    Button retry ;
    int productStock;
    int productCategory , productId , branchId ,productPrice , productReducedPrice , productDiscount;
    RelativeLayout loading ;
    String productImage, productName  , productStoreName , imageUrl, storeIconUrl;
    ToggleButton mark ;
   // MarkedProductsDBHelper dbHelper ;
    markedEntity  markedEntity;
    List<markedEntity> markedp;
    private MarkedViewModel markedViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        intent = getIntent();
        //dbHelper = new MarkedProductsDBHelper(this);
        markedViewModel= ViewModelProviders.of(this).get(MarkedViewModel.class);
        markedEntity   = new markedEntity();
        productId = intent.getIntExtra("productCode", 0);
        productName = intent.getStringExtra("productName");
        productPrice = intent.getIntExtra("productPrice", 0);
        productDiscount = intent.getIntExtra("productDiscount", 0);
        productReducedPrice = intent.getIntExtra("productReducedPrice", 0);
        productImage = intent.getStringExtra("productImage");
        productCategory = intent.getIntExtra("productCategory", 0);
        productStock = intent.getIntExtra("stock", 1);
        branchId = intent.getIntExtra("productStoreBranchId", 0);
        loading = (RelativeLayout) findViewById(R.id.loading_layout);
        retry = (Button) findViewById(R.id.network_try_again);
        fill();

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.connection_error_layout).setVisibility(View.GONE);
                fill();
            }
        });


    }



    @Override
    public void onBackPressed() {
        finish();
    }

    private void fill() {
        loading.setVisibility(View.VISIBLE);
        image = (ImageView) findViewById(R.id.product_details_image);
        name = (TextView) findViewById(R.id.product_details_name);
        reducedPrice = (TextView) findViewById(R.id.product_details_reduced_price);
        price = (TextView) findViewById(R.id.product_details_price);
        discount = (TextView) findViewById(R.id.product_details_discount);
        mark = (ToggleButton) findViewById(R.id.marked_btn);
        toolbarBackIcon = (Button) findViewById(R.id.back_icon);
        storeName = (TextView) findViewById(R.id.store_name);
        categoryName = (TextView) findViewById(R.id.category_name);
        stock = (TextView) findViewById(R.id.product_details_stock);

        new DataLoader().getCategory( getWindow().getDecorView() , new VolleyCallbackCategories() {
            @Override
            public void onSuccess(List<Category> categories) {
                for (Category category : categories)
                    if (category.getId() == productCategory) {
                        categoryName.setText(category.getName());
                    }
                loading.setVisibility(View.GONE);
            }
        });

        if(intent.hasExtra("storeName")){
            productStoreName = intent.getStringExtra("storeName");
        }else{
            for (Store s : AppController.getInstance().getStores()) {
                if (s.getBranchId() == branchId) {
                    productStoreName = s.getName();
                    storeIconUrl = Url.storesImageUrl + s.getPicAddress();
                }
            }
        }
        //if(dbHelper.isMarked(productId , branchId)) {
            if (markedViewModel.ismarked(productId,branchId)) {
              ////  markedDatabase.getInstance(getBaseContext()).markedDAO().isMarked(productId, branchId)(قبلا تو شرط ایف بوده)
                Log.i("it is marked", "det");

                mark.setChecked(true);
                mark.setBackground(getResources().getDrawable(R.drawable.ic_mark_on));
            //}
        }
            else{
                mark.setChecked(false);
                mark.setBackground(getResources().getDrawable(R.drawable.ic_mark_off));

            }
        if(productStock == 0){
            stock.setVisibility(View.VISIBLE);
            reducedPrice.setVisibility(View.GONE);
            discount.setVisibility(View.GONE);
            price.setVisibility(View.GONE);
        }else if(productDiscount == 0){
            reducedPrice.setVisibility(View.GONE);
            discount.setVisibility(View.GONE);
            price.setTextColor(getResources().getColor(R.color.text_color));
            price.setTextSize(20);
        }else{
            reducedPrice.setText(productReducedPrice + " تومان");
            discount.setText(productDiscount + "% تخفیف");
            price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        name.setText(productName);
        price.setText(productPrice + " تومان");
        storeName.setText(productStoreName);
        if(intent.hasExtra("image"))
            imageUrl = intent.getStringExtra("image");
        else
            imageUrl = Url.productsImageUrl + productImage ;
        Picasso.with(this).load(imageUrl).into(image);
        mark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                markedEntity.setProduct_category(productCategory);
                markedEntity.setProduct_branchid(branchId);
                markedEntity.setProduct_code(productId);
                markedEntity.setProduct_discount(productDiscount);
                markedEntity.setProduct_image(productImage);
                markedEntity.setProduct_name(productName);
                markedEntity.setProduct_price(productPrice);
                markedEntity.setProduct_storeicon(storeIconUrl);
                markedEntity.setProduct_stock(productStock);
                markedEntity.setProduct_reducedprice(productReducedPrice);
                markedEntity.setProduct_storename(productStoreName);
                if(isChecked){
                    //dbHelper.insert(productId ,productName, productPrice, productDiscount, productReducedPrice , productCategory , imageUrl, storeIconUrl, productStoreName, branchId , productStock);
                    //  markedEntity   = new markedEntity();

                   // markedp.add(markedEntity);

                    ////markedDatabase.getInstance(getBaseContext()).markedDAO().insert(markedEntity);(قبلا بود)
                    markedViewModel.insert(markedEntity);

                    mark.setBackground(getResources().getDrawable(R.drawable.ic_mark_on));
                }
                else{


                   // Log.i("pp",markedEntity.getProduct_name());

                      ///// markedDatabase.getInstance(getBaseContext()).markedDAO().deleteAll(markedEntity.getProduct_code(),markedEntity.getProduct_branchid());(قبلا بود)
                   markedViewModel.delete(markedEntity.getProduct_code(),markedEntity.getProduct_branchid());
                    // markedDatabase.getInstance(getBaseContext()).markedDAO().delete(markedEntity);
                   ///// Log.i("kk",markedDatabase.getInstance(getBaseContext()).markedDAO().getAll()+"");


                   // markedDatabase.getInstance(getBaseContext()).markedDAO().delete(markedEntity);
                    //dbHelper.delete(productId , branchId);
                    mark.setBackground(getResources().getDrawable(R.drawable.ic_mark_off));

                }

            }
        });

        toolbarBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}


