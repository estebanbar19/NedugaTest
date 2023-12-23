package com.test.nedugatest.ui.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.test.nedugatest.R;
import com.test.nedugatest.domain.model.Product;
import com.test.nedugatest.ui.views.Modal;

import java.util.List;

public class ProductsRecyclerViewAdapters extends RecyclerView.Adapter<ProductsRecyclerViewAdapters.ViewHolder>{

    private List<Product> products;

    public ProductsRecyclerViewAdapters(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductsRecyclerViewAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent, false);
        return new ProductsRecyclerViewAdapters.ViewHolder(productItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsRecyclerViewAdapters.ViewHolder holder, int position) {
        holder.addProduct(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id, title, price;
        private CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.product_item_card);
            id = itemView.findViewById(R.id.product_item_id);
            title = itemView.findViewById(R.id.product_item_title);
            price = itemView.findViewById(R.id.product_item_price);
        }

        private void addProduct(Product product){
            id.setText(Html.fromHtml("<b>Id:</b> " + product.getId()));
            title.setText(Html.fromHtml("<b>Titulo:</b> " + product.getTitle()));
            price.setText(Html.fromHtml("<b>Precio:</b> " + product.getPrice()));
            card.setOnClickListener(v -> Modal.Create(product, itemView.getContext()).show());
        }
    }
}
