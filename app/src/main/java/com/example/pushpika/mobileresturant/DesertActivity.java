package com.example.pushpika.mobileresturant;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DesertActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DesertHorizontalAlbumsAdapter adapter;
    private List<HorizontalAlbum> albumList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new DesertHorizontalAlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DesertActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.desert_category).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.deserts));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.desert_vanila,
                R.drawable.desert_chcolate,
                R.drawable.desert_strawberry,
                R.drawable.desert_yogurt,
                R.drawable.desert_biscuit_pudding,
                R.drawable.desert_caramel_pudding,
                R.drawable.desert_watalappan};

        boolean va1 = false,va2 = false,va3 = false,va4 = false,va5 = false,va6 = false,va7 = false;
        for (int i = 0; i < MainActivity.orderList.size(); i++) {
            if(MainActivity.orderList.get(i).getName().equals("Vanilla Ice Cream")) { va1 = true; }
            else if(MainActivity.orderList.get(i).getName().equals("Chocolate Ice Cream")) { va2 = true; }
            else if(MainActivity.orderList.get(i).getName().equals("Strawberry Ice Cream")) { va3 = true; }
            else if(MainActivity.orderList.get(i).getName().equals("Yogurt")) { va4 = true; }
            else if(MainActivity.orderList.get(i).getName().equals("Biscuit Pudding")) { va5 = true; }
            else if(MainActivity.orderList.get(i).getName().equals("Caramel Pudding")) { va6 = true; }
            else if(MainActivity.orderList.get(i).getName().equals("Watalappan")) { va7 = true; }
        }
        HorizontalAlbum a = new HorizontalAlbum("Vanilla Ice Cream", (float) 50.00, 1, va1, covers[0]);
        albumList.add(a);

        a = new HorizontalAlbum("Chocolate Ice Cream", (float) 50.00, 1, va2, covers[1]);
        albumList.add(a);

        a = new HorizontalAlbum("Strawberry Ice Cream", (float) 50.00, 1, va3, covers[2]);
        albumList.add(a);

        a = new HorizontalAlbum("Yogurt", (float) 35.00, 1, va4, covers[3]);
        albumList.add(a);

        a = new HorizontalAlbum("Biscuit Pudding", (float) 60.00, 1, va5, covers[4]);
        albumList.add(a);

        a = new HorizontalAlbum("Caramel Pudding", (float) 70.00, 1, va6, covers[5]);
        albumList.add(a);

        a = new HorizontalAlbum("Watalappan", (float) 70.00, 1, va7, covers[6]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}

