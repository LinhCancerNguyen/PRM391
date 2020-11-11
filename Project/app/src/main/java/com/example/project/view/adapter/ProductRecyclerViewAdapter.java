package com.example.project.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project.R;
import com.example.project.data.model.Product;
import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductRecyclerViewHolder> {
    private Context context;
    private List<Product> list;

    public ProductRecyclerViewAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.product_recycler_item, parent, false);
        final ProductRecyclerViewHolder viewHolder = new ProductRecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerViewAdapter.ProductRecyclerViewHolder holder, int position) {
        Bitmap bitmap = BitmapFactory.decodeFile("C:\\Users\\LinhCancerNguyen\\Desktop\\img2\\img\\category_1.png");
        holder.imgProduct.setImageBitmap(bitmap);
        holder.txtProductName.setText(list.get(position).getName());
        //holder.txtProductPrice.setText((int) list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ProductRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgProduct, imgIcBuy;
        TextView txtProductName, txtProductPrice;
        LinearLayout linearProduct;

        public ProductRecyclerViewHolder(View itemView) {
            super(itemView);

            linearProduct = itemView.findViewById(R.id.linearProduct);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            imgIcBuy = itemView.findViewById(R.id.imgIcBuy);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
