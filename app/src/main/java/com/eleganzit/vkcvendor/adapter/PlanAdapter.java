package com.eleganzit.vkcvendor.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eleganzit.vkcvendor.AssignToLineActivity;
import com.eleganzit.vkcvendor.R;
import com.eleganzit.vkcvendor.model.plan.PNumber;

import java.util.ArrayList;
import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder> {

    List<PNumber> campaigns;
    Context context;
    Activity activity;

    public PlanAdapter(List<PNumber> campaigns, Context context) {
        this.campaigns = campaigns;
        this.context = context;
        activity = (Activity) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_plan, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

        PNumber pNumber = campaigns.get(i);
        holder.ptxtnumber.setText(pNumber.getPurDocNum());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rc_art.setLayoutManager(layoutManager);
        holder.rc_art.setAdapter(new ArticleAdapter(pNumber.getArticledata(), context));
        holder.rc_art.setNestedScrollingEnabled(false);

        holder.cardviewsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, AssignToLineActivity.class));
                activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardviewsuccess;
        TextView ptxtnumber;
        RecyclerView rc_art;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardviewsuccess = itemView.findViewById(R.id.cardviewsuccess);
            rc_art = itemView.findViewById(R.id.rc_art);
            ptxtnumber = itemView.findViewById(R.id.ptxtnumber);

        }
    }
}
