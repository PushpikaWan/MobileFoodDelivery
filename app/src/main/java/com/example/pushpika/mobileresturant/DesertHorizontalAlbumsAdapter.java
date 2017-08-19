package com.example.pushpika.mobileresturant;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class DesertHorizontalAlbumsAdapter extends RecyclerView.Adapter<DesertHorizontalAlbumsAdapter.MyHorizontalViewHolder> {

    private Context mContext;
    private List<HorizontalAlbum> albumList;

    public class MyHorizontalViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView thumbnail, overflow;
        public Spinner quantity;

        public MyHorizontalViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            quantity = (Spinner) view.findViewById(R.id.quantity);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public DesertHorizontalAlbumsAdapter(Context mContext, List<HorizontalAlbum> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_album_card, parent, false);

        return new MyHorizontalViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final MyHorizontalViewHolder holder, final int position) {
        HorizontalAlbum album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.price.setText(" LKR "+album.getPrice());
        //holder.quantity.getSelectedItem();

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click deseert --> ", "at : "+position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return albumList.size();
    }
}

