package com.eleganzit.vkcvendor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AssignToLineActivity extends AppCompatActivity {

    String[] animals = {"L1440", "L1447", "L1446", "L14455", "L1445"};

    ImageView addarticle,closearticle;
    TextInputEditText ed_line_number;
    LinearLayout lineararticle2,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_to_line);
        closearticle=findViewById(R.id.closearticle);
        addarticle=findViewById(R.id.addarticle);
        ed_line_number=findViewById(R.id.ed_line_number);
        lineararticle2=findViewById(R.id.lineararticle2);
        save=findViewById(R.id.save);
        ed_line_number.setText(""+animals[0]);
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
                lineararticle2.setVisibility(View.VISIBLE);


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        closearticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineararticle2.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }
}
