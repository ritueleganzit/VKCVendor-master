package com.eleganzit.vkcvendor.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.eleganzit.vkcvendor.AssignToLineActivity;
import com.eleganzit.vkcvendor.HourWiseActivity;
import com.eleganzit.vkcvendor.HourWiseEntry;
import com.eleganzit.vkcvendor.R;

import java.util.ArrayList;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.MyViewHolder> {

    ArrayList<String> campaigns;
    Context context;
    Activity activity;

    public EntryAdapter(ArrayList<String> campaigns, Context context) {
        this.campaigns = campaigns;
        this.context = context;
        activity = (Activity) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_entry,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

        if (i==0) {
            holder.cardviewsuccess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, HourWiseEntry.class));
                    activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
        else
        {
            holder.frame.setBackgroundColor(context.getResources().getColor(R.color.transparent));

        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
CardView cardviewsuccess;
FrameLayout frame;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardviewsuccess=itemView.findViewById(R.id.cardviewsuccess);
            frame=itemView.findViewById(R.id.frame);

        }
    }
}
