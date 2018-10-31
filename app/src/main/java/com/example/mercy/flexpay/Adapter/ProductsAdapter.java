package com.example.mercy.flexpay.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mercy.flexpay.Model.ProductsOffers;
import com.example.mercy.flexpay.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private Context context;
    private List<ProductsOffers> list;
    public ProductsAdapter(Context context, List<ProductsOffers> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView offer_quantity, product_name, offer_price;
        public ViewHolder(View itemView) {
            super(itemView);
            offer_quantity = itemView.findViewById(R.id.offer_quantity);
            product_name = itemView.findViewById(R.id.product_name);
            offer_price = itemView.findViewById(R.id.offer_price);
        }
    }
}
