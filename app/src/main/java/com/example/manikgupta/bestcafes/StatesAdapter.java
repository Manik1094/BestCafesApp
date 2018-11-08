package com.example.manikgupta.bestcafes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.StatesViewHolder> {


    private Context context;

    private ArrayList<CustomState> mStatesName;

    public StatesAdapter(Context context , ArrayList<CustomState> StatesName){
        this.context = context;
        this.mStatesName  = StatesName;
    }
    @Override
    public StatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_list, parent,false);

        return new StatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatesViewHolder holder, int position) {

        final CustomState customState = mStatesName.get(position);

        holder.textView.setText(customState.getmName());
        holder.imageView.setImageResource(customState.getmImages());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("statename", customState.getmName());
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mStatesName.size();
    }

    public class StatesViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public StatesViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image_view);
            textView  = (TextView) view.findViewById(R.id.text_view);


        }
    }

}
