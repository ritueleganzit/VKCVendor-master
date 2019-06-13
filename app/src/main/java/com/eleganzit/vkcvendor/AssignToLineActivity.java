package com.eleganzit.vkcvendor;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.eleganzit.vkcvendor.adapter.PlanAdapter;
import com.eleganzit.vkcvendor.api.RetrofitAPI;
import com.eleganzit.vkcvendor.api.RetrofitInterface;
import com.eleganzit.vkcvendor.model.ArticleSelection;
import com.eleganzit.vkcvendor.model.article.ArticleResponse;
import com.eleganzit.vkcvendor.model.line.LineResponse;
import com.eleganzit.vkcvendor.util.UserLoggedInSession;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignToLineActivity extends AppCompatActivity {

    List<String> stateArrayList=new ArrayList();
    List<String> stateArrayListnum=new ArrayList();

    List<String> articlelist=new ArrayList();
    List<ArticleSelection> articlelistnum=new ArrayList();
    MyArticleAdapter myArticleAdapter;
    String[] art = {"13913 ladies blue", "13913 ladies mrn"};
ArrayList<String> arrayList=new ArrayList<>();
    ImageView addarticle,closearticle;
    TextInputEditText ed_line_number,arted;
    LinearLayout lineararticle2,save;
    RecyclerView rc_article_list;
    UserLoggedInSession userLoggedInSession;
    ProgressDialog progressDialog;
    private String stateid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_to_line);
        //closearticle=findViewById(R.id.closearticle);
        userLoggedInSession=new UserLoggedInSession(AssignToLineActivity.this);

myArticleAdapter=new  MyArticleAdapter(articlelistnum,AssignToLineActivity.this);
        progressDialog=new ProgressDialog(AssignToLineActivity.this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        addarticle=findViewById(R.id.addarticle);
        rc_article_list=findViewById(R.id.rc_article_list);
        arted=findViewById(R.id.arted);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(AssignToLineActivity.this,LinearLayoutManager.VERTICAL,false);
        rc_article_list.setLayoutManager(layoutManager);
        rc_article_list.setAdapter(myArticleAdapter);

        ed_line_number=findViewById(R.id.ed_line_number);
        lineararticle2=findViewById(R.id.lineararticle2);
        save=findViewById(R.id.save);
/*
        ed_line_number.setText(""+animals[0]);
*/

        arted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListAdapter adapter = new ArrayAdapter(AssignToLineActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, articlelist);

                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(AssignToLineActivity.this, R.style.AlertDialogCustom));

                builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

String olddata=arted.getText().toString();
String newdata=articlelist.get(i);

                        arted.setText(newdata);
                        articlelist.remove(i);
                        articlelist.add(olddata);



                    }
                });
                builder.show();
            }


        });
        ed_line_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListAdapter adapter = new ArrayAdapter(AssignToLineActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, stateArrayList);

                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(AssignToLineActivity.this, R.style.AlertDialogCustom));

                builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();


                        ed_line_number.setText(stateArrayList.get(i));
                        stateid=stateArrayListnum.get(i);

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
                builder.show();


            }
        });
        addarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleSelection art=new ArticleSelection(articlelist);

                articlelistnum.add(art);

                myArticleAdapter.notifyDataSetChanged();

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

        getVendorLine();
        getArticleList();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getVendorLine() {
        progressDialog.show();
        RetrofitInterface myInterface = RetrofitAPI.getRetrofit().create(RetrofitInterface.class);

        Call<LineResponse> call=myInterface.getVendorLine(userLoggedInSession.getUserDetails().get(UserLoggedInSession.USER_ID));
        call.enqueue(new Callback<LineResponse>() {
            @Override
            public void onResponse(Call<LineResponse> call, Response<LineResponse> response) {


                if (response.isSuccessful())
                {
                    Log.d("stattelist","--"+response.body().getMessage()    );

                    for (int i=0;i<response.body().getData().size();i++)
                    {
                        stateArrayList.add(response.body().getData().get(i).getLineNumber());
                        stateArrayListnum.add(response.body().getData().get(i).getLineId());
                        ed_line_number.setText(stateArrayList.get(0));

                    }

                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<LineResponse> call, Throwable t) {

            }
        });
    }

    private void getArticleList() {
        progressDialog.show();
        RetrofitInterface myInterface = RetrofitAPI.getRetrofit().create(RetrofitInterface.class);

        Call<ArticleResponse> call=myInterface.getArticleList(userLoggedInSession.getUserDetails().get(UserLoggedInSession.USER_ID));
        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {


                if (response.isSuccessful())
                {
                    Log.d("stattelist","--"+response.body().getMessage()    );

                    for (int i=0;i<response.body().getData().size();i++)
                    {
                        articlelist.add(response.body().getData().get(i).getArticle());


                    }
                    arted.setText(articlelist.get(0));

                    articlelist.remove(0);

                    Log.d("stattelist","--"+articlelist    );

                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }

    public  class MyArticleAdapter extends RecyclerView.Adapter<MyArticleAdapter.MyViewHolder> {

     List<ArticleSelection> campaigns;
        Context context;
        Activity activity;

    public MyArticleAdapter(List<ArticleSelection> campaigns, Context context) {
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
        holder.tvarticle.setHint("Select Article "+(i+2));
            final ArticleSelection articleSelection=campaigns.get(i);
        holder.tvarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListAdapter adapter = new ArrayAdapter(AssignToLineActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, articlelist);

                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(AssignToLineActivity.this, R.style.AlertDialogCustom));

                builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        String olddata= holder.tvarticle.getText().toString();
                        String newdata=articlelist.get(i);

                        holder.tvarticle.setText(newdata);
                        articlelist.remove(i);
                        articlelist.add(holder.tvarticle.getText().toString());
                        /*articlelist.remove(i);
                        articlelist.add(olddata);
*/


                    }
                });
                builder.show();
            }
        });

holder.closearticle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        removeAt(i,holder.tvarticle);
    }
});

        }

        private void removeAt(int position, TextInputEditText tvarticle) {

            campaigns.remove(position);
            String olddata= tvarticle.getText().toString();

            articlelist.add(olddata);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, campaigns.size());
            notifyItemChanged(position);
        }

        @Override
        public int getItemCount() {
            return campaigns.size();
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
