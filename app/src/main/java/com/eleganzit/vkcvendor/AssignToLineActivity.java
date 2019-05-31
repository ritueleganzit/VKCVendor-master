package com.eleganzit.vkcvendor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eleganzit.vkcvendor.adapter.PlanAdapter;

import java.util.ArrayList;

public class AssignToLineActivity extends AppCompatActivity {

    String[] animals = {"L1440", "L1447", "L1446", "L14455", "L1445"};
    String[] art = {"13913 ladies blue", "13913 ladies mrn"};
ArrayList<String> arrayList=new ArrayList<>();
    ImageView addarticle,closearticle;
    TextInputEditText ed_line_number,arted;
    LinearLayout lineararticle2,save;
    RecyclerView rc_article_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_to_line);
        //closearticle=findViewById(R.id.closearticle);
        addarticle=findViewById(R.id.addarticle);
        rc_article_list=findViewById(R.id.rc_article_list);
        arted=findViewById(R.id.arted);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(AssignToLineActivity.this,LinearLayoutManager.VERTICAL,false);
        rc_article_list.setLayoutManager(layoutManager);
        ed_line_number=findViewById(R.id.ed_line_number);
        lineararticle2=findViewById(R.id.lineararticle2);
        save=findViewById(R.id.save);
        ed_line_number.setText(""+animals[0]);

        arted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AssignToLineActivity.this);

// add a list
                builder.setItems(art, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: arted.setText(""+art[which]);
                            case 1: arted.setText(""+art[which]);
                            case 2: arted.setText(""+art[which]);
                            case 3: arted.setText(""+art[which]);
                            case 4: arted.setText(""+art[which]);
                        }


                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }


        });
        ed_line_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AssignToLineActivity.this);

// add a list
                builder.setItems(animals, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: ed_line_number.setText(""+animals[which]);
                            case 1: ed_line_number.setText(""+animals[which]);
                            case 2: ed_line_number.setText(""+animals[which]);
                            case 3: ed_line_number.setText(""+animals[which]);
                            case 4: ed_line_number.setText(""+animals[which]);
                        }

                        final Dialog d=new Dialog(AssignToLineActivity.this,
                                R.style.Theme_Dialog);
                        d.setContentView(R.layout.manpower_dialog);

                        TextView ok=d.findViewById(R.id.ok);
                        TextView cancel=d.findViewById(R.id.cancel);
                        final EditText ed_email=d.findViewById(R.id.ed_email);

                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
d.dismiss();
                            }
                        });

                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                d.dismiss();

                            }
                        });

                        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        if(!isFinishing())
                        {
                            d.show();
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        addarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arrayList.add("Hello");
                rc_article_list.setAdapter(new MyArticleAdapter(arrayList,AssignToLineActivity.this));

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*closearticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineararticle2.setVisibility(View.GONE);

            }
        });*/

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }

    public  class MyArticleAdapter extends RecyclerView.Adapter<MyArticleAdapter.MyViewHolder> {

        ArrayList<String> campaigns;
        Context context;
        Activity activity;

    public MyArticleAdapter(ArrayList<String> campaigns, Context context) {
            this.campaigns = campaigns;
            this.context = context;
            activity = (Activity) context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_addarticles,viewGroup,false);
            MyViewHolder myViewHolder=new MyViewHolder(v);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {
        holder.tvarticle.setHint("Article "+(i+2));
        holder.tvarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AssignToLineActivity.this);

// add a list
                builder.setItems(art, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: holder.tvarticle.setText(""+art[which]);
                            case 1: holder.tvarticle.setText(""+art[which]);
                            case 2: holder.tvarticle.setText(""+art[which]);
                            case 3: holder.tvarticle.setText(""+art[which]);
                            case 4: holder.tvarticle.setText(""+art[which]);
                        }


                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

holder.closearticle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        removeAt(i);
    }
});

        }

        private void removeAt(int position) {

            arrayList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, arrayList.size());
            notifyItemChanged(position);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView closearticle;
            TextInputEditText tvarticle;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                closearticle=itemView.findViewById(R.id.closearticle);
                tvarticle=itemView.findViewById(R.id.tvarticle);

            }
        }
    }
}
