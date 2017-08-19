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

public class OrderCardsAlbumAdapter extends RecyclerView.Adapter<OrderCardsAlbumAdapter.MyHorizontalViewHolder> {

    private Context mContext;
    private List<HorizontalAlbum> albumList;

    public class MyHorizontalViewHolder extends RecyclerView.ViewHolder {
        public TextView title, priceQuantity,lineTotal;
        public ImageView thumbnail;

        public MyHorizontalViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            priceQuantity = (TextView) view.findViewById(R.id.price_quantity);
            lineTotal = (TextView) view.findViewById(R.id.line_total);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public OrderCardsAlbumAdapter(Context mContext, List<HorizontalAlbum> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public OrderCardsAlbumAdapter.MyHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_album_card, parent, false);

        return new OrderCardsAlbumAdapter.MyHorizontalViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final OrderCardsAlbumAdapter.MyHorizontalViewHolder holder, final int position) {
        final HorizontalAlbum album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.priceQuantity.setText(album.getQuantity()+" X "+album.getPrice());
        holder.lineTotal.setText(String.valueOf(album.getQuantity()*album.getPrice()));

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

//        holder.addToOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Log.d("click desert --> ", "at : "+position+" quantity :"+holder.quantity.getSelectedItem());
//            }
//        });
    }



    @Override
    public int getItemCount() {
        return albumList.size();
    }
}

