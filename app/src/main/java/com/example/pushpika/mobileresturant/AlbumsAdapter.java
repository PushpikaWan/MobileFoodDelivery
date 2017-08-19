package com.example.pushpika.mobileresturant;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("item clicked -->", "image at pos" + position);
                if (position == 0){
                   // Intent intent = new Intent(mContext,BreakfastActivity.class);
                   // mContext.startActivity(intent);
                }

                else if (position == 1){
                    Intent intent = new Intent(mContext,LunchActivity.class);
                    mContext.startActivity(intent);
                }

                else if (position == 2){
                    //Intent intent = new Intent(mContext,ShorteatsActivity.class);
                    //mContext.startActivity(intent);
                }

                else if (position == 3){
                    Intent intent = new Intent(mContext,DrinksActivity.class);
                    mContext.startActivity(intent);
                }

                else if (position == 4){
                    Intent intent = new Intent(mContext,DesertActivity.class);
                    mContext.startActivity(intent);
                }

                else if (position == 5){
                    Intent intent = new Intent(mContext,FruitsActivity.class);
                    mContext.startActivity(intent);
                }

                else if (position == 6){
                    Intent intent = new Intent(mContext,FruitJuiceActivity.class);
                    mContext.startActivity(intent);
                }
            }

        });


    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
