package com.example.parinaz.chainstoresapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parinaz.chainstoresapp.R;
import com.example.parinaz.chainstoresapp.RoomDb.markedEntity;
import com.example.parinaz.chainstoresapp.object.MarkedProducts;
import com.example.parinaz.chainstoresapp.object.Store;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MarkedProductsAdapter extends RecyclerView.Adapter<MarkedProductsAdapter.ViewHolder> {

    List<markedEntity> productList ;
    List<Store> storeList;
    Context context;
    int xmlView ;

    public MarkedProductsAdapter(List<markedEntity> productList,List<Store> storeList , Context context , int xmlView ) {
        this.productList =(productList == null) ? new ArrayList<markedEntity>() : productList;
        this.storeList = (storeList == null) ? new ArrayList<Store>() : storeList;
        this.context = context;
        this.xmlView = xmlView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(xmlView , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        markedEntity markedEntity = productList.get(position);
        holder.bind(markedEntity);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , price , reducedPrice , discount , stock;
        ImageView image , storeIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name_tv);
            price = itemView.findViewById(R.id.price_tv);
            reducedPrice = itemView.findViewById(R.id.reduced_price_tv);
            discount = itemView.findViewById(R.id.discount_tv);
            image = itemView.findViewById(R.id.product_image);
            stock = itemView.findViewById(R.id.product_stock);
            storeIcon = itemView.findViewById(R.id.product_store_icon);
        }
        public void bind(markedEntity product) {
            if(product.getProduct_discount() == 0){
                discount.setVisibility(View.GONE);
                reducedPrice.setVisibility(View.GONE);
                price.setTextColor(context.getResources().getColor(R.color.text_color));
                price.setTextSize(TypedValue.COMPLEX_UNIT_PX,context.getResources().getDimension(R.dimen.largeTextSize));
            } else {
                discount.setText(product.getProduct_discount() + "% تخفیف");
                reducedPrice.setText(product.getProduct_reducedprice() + " تومان");
                price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            name.setText(product.getProduct_name());
            price.setText(product.getProduct_price() + " تومان");
            Picasso.with(context).load(product.getProduct_image()).into(image);
            Picasso.with(context).load(product.getProduct_storeicon()).into(storeIcon);
            if(product.getProduct_stock() == 0) {
                stock.setVisibility(View.VISIBLE);
                price.setVisibility(View.GONE);
                reducedPrice.setVisibility(View.GONE);
                discount.setVisibility(View.GONE);
            }else {
                stock.setVisibility(View.GONE);
            }
        }
    }
    public void productListOnclickListener(int position , Intent intent){
        intent.putExtra("productName" , productList.get(position).getProduct_name());
        intent.putExtra("productDiscount" , productList.get(position).getProduct_discount());
        intent.putExtra("productPrice" , productList.get(position).getProduct_price());
        intent.putExtra("productReducedPrice" , productList.get(position).getProduct_reducedprice());
      intent.putExtra("productImage" , productList.get(position).getProduct_image());
        intent.putExtra("productCode" , productList.get(position).getProduct_code());
        intent.putExtra("productCategory" , productList.get(position).getProduct_category());
        intent.putExtra("productStoreBranchId" , productList.get(position).getProduct_branchid());
        intent.putExtra("stock" , productList.get(position).getProduct_stock());
        intent.putExtra("image" , productList.get(position).getProduct_image());
        intent.putExtra("storeIcon" , productList.get(position).getProduct_storeicon());
        intent.putExtra("storeName" , productList.get(position).getProduct_storename());

    }
}
