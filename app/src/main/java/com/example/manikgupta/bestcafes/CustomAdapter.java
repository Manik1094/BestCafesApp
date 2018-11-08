package com.example.manikgupta.bestcafes;


import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v4.view.PagerAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class CustomAdapter extends PagerAdapter {

    private static final String LOG_TAG = CustomAdapter.class.getSimpleName();
    private ArrayList<CustomCafes> mCustomCafesList = new ArrayList<>();
    private Context mContext;

    public CustomAdapter(Context context, ArrayList<CustomCafes> customCafesList) {
        super();
        this.mContext = context;
        mCustomCafesList = customCafesList;
    }

    @Override
    public int getCount() {
        Log.e(LOG_TAG,"Size is"+mCustomCafesList.size());

        return mCustomCafesList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view  == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        CustomCafes customCafes = mCustomCafesList.get(position);

        View view = LayoutInflater.from(mContext).inflate(R.layout.rec_view_list,container,false);

        TextView name;
        TextView cost;
        TextView description;
        TextView location;
        ImageView imageView;

        name = (TextView) view.findViewById(R.id.name);
        cost  = (TextView) view.findViewById(R.id.cost);
        description  = (TextView) view.findViewById(R.id.description);
        location  = (TextView)  view.findViewById(R.id.location);
        imageView  = (ImageView) view.findViewById(R.id.image);




             name.setText(customCafes.getName());
             description.setText(customCafes.getDescription());
             location.setText(customCafes.getLocation());
             cost.setText(customCafes.getCost());

        Glide.with(mContext)
                .load(customCafes.getImage())
                .apply(new RequestOptions().override(120, 120))
                .into(imageView);

        container.addView(view);

        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }



}
