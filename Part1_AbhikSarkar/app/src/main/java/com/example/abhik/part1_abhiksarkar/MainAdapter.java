package com.example.abhik.part1_abhiksarkar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by abhik on 04/02/18.
 */

public class MainAdapter
        extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public static final String TAG = "adptr";

    private Context context;
    private ArrayList<Main2.Country> mains;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public MainAdapter(Context context, ArrayList<Main2.Country> mains){
        Log.d(TAG, "MainAdapter: ");
        this.context = context;
        this.mains = mains;
    }

    public void updateMains (ArrayList<Main2.Country> mains){
        Log.d(TAG, "updateMains: " + mains.size());
        this.mains = mains;
        notifyDataSetChanged();
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView  = li.inflate(R.layout.list_item_main, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        final Main2.Country countries = mains.get(position);
        Log.d(TAG, "" + countries.getRank());
        //ArrayList<Main2.Country> countries = thisMain.getWorldpopulation();
        Picasso.with(context).load(countries.getFlag()).into(holder.imgView);
        holder.tv1.setText("" + countries.getRank());
        holder.tv2.setText(countries.getPopulation());
        holder.tv3.setText(countries.getCountry());

        holder.layt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PicDisplay.class);
                i.putExtra("intent" , countries.getFlag());
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mains.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        LinearLayout layt1;
        LinearLayout layt2;
        TextView tv1,tv2,tv3;
        ImageView imgView;
        public MainViewHolder(View itemView){
            super(itemView);

            tv1 =  (TextView) itemView.findViewById(R.id.tv_rank);
            tv2 = (TextView) itemView.findViewById(R.id.tv_population);
            tv3 = (TextView) itemView.findViewById(R.id.tv_country);
            layt1 = (LinearLayout) itemView.findViewById(R.id.lin_layt_rv);
            layt2 = (LinearLayout) itemView.findViewById(R.id.layt2);
            imgView = (ImageView)itemView.findViewById(R.id.img_view);
        }
    }
}
