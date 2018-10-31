package com.pt.khanh.movie.utils;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.pt.khanh.movie.BuildConfig;
import com.pt.khanh.movie.screen.genre.GridSpacingItemDecoration;
import com.pt.khanh.movie.screen.movies.EndLessRecyclerOnScrollListener;
import com.rd.PageIndicatorView;

public final class BindingUtils {
    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelectedListener(
            BottomNavigationView view,
            BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter("currentItem")
    public static void setCurrentItem(ViewPager viewPager, int position) {
        viewPager.setCurrentItem(position);
    }

    @BindingAdapter("setAdapterViewPager")
    public static void setAdapterViewPager(ViewPager viewPager, PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter("setViewPagerIndicator")
    public static void setViewPagerIndicator(PageIndicatorView pageIndicatorView,
                                             ViewPager viewPager) {
        pageIndicatorView.setViewPager(viewPager);
    }

    @BindingAdapter({"addDecoration"})
    public static void addDecoration(RecyclerView recyclerView,
                                     GridSpacingItemDecoration itemDecoration) {
        recyclerView.addItemDecoration(itemDecoration);
    }

    @BindingAdapter({"imageDrawable"})
    public static void loadImg(ImageView imageView, int resource) {
        Glide.with(imageView.getContext())
                .load(resource)
                .into(imageView);
    }

    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("onInitializedListener")
    public static void setOnInitializedListener(
            YouTubePlayerView youTubePlayerView, YouTubePlayer.OnInitializedListener listener) {
        if (listener != null)
            youTubePlayerView.initialize(BuildConfig.YOUTUBE_KEY, listener);
    }

    @BindingAdapter("onEditorActionListener")
    public static void setOnEditorActionListener(EditText editText,
                                                 TextView.OnEditorActionListener listener) {
        if (listener != null)
            editText.setOnEditorActionListener(listener);
    }

    @BindingAdapter({"setOnScroll"})
    public static void setScroll(RecyclerView recyclerView,
                                 EndLessRecyclerOnScrollListener listener) {
        recyclerView.addOnScrollListener(listener);
    }
}
