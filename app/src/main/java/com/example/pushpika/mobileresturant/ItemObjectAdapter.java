package com.example.pushpika.mobileresturant;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by pushpika on 8/20/17.
 */

public class ItemObjectAdapter extends RecyclerView.Adapter<ItemObjectAdapter.MyHorizontalViewHolder> {

    private Context mContext;
    private List<ItemObject> albumList;

    public class MyHorizontalViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView thumbnail;
        public Spinner quantity;
        public Button addToOrder;

        public MyHorizontalViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            quantity = (Spinner) view.findViewById(R.id.quantity);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            addToOrder = (Button) view.findViewById(R.id.add_to_order);
        }
    }


    public ItemObjectAdapter(Context mContext, List<ItemObject> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public ItemObjectAdapter.MyHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_album_card, parent, false);

        return new ItemObjectAdapter.MyHorizontalViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final ItemObjectAdapter.MyHorizontalViewHolder holder, final int position) {
        final ItemObject album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.price.setText(" LKR "+album.getPrice());
        //holder.quantity.getSelectedItem();
        if (album.getIsOrdered()){
            holder.addToOrder.setText(R.string.order_added);
            holder.addToOrder.setTextColor(Color.parseColor("#FF4081"));
            holder.addToOrder.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.addToOrder.setEnabled(false);
        }

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.addToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click deseert --> ", "at : "+position+" quantity :"+holder.quantity.getSelectedItem());
                album.setIsOrdered(true);
                album.setQuantity(Integer.parseInt(String.valueOf(holder.quantity.getSelectedItem())));
                MainActivity.orderList.add(album);
                holder.addToOrder.setText(R.string.order_added);
                holder.addToOrder.setTextColor(Color.parseColor("#FF4081"));
                holder.addToOrder.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.addToOrder.setEnabled(false);
            }
        });
    }



    @Override
    public int getItemCount() {
        return albumList.size();
    }
}

