package com.eleganzit.vkcvendor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HourWiseEntry extends AppCompatActivity {

    LinearLayout next;
    TextInputEditText ed_line_number,arted;

    String[] animals = {"L1440", "L1447", "L1446", "L14455", "L1445"};
    String[] art = {"13913 ladies blue", "13913 ladies mrn"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_wise_entry);
        next=findViewById(R.id.next);
        arted=findViewById(R.id.arted);
        ed_line_number=findViewById(R.id.ed_line_number);
        ed_line_number.setText(""+animals[0]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HourWiseEntry.this,HourWiseActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        arted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(HourWiseEntry.this);

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
                AlertDialog.Builder builder = new AlertDialog.Builder(HourWiseEntry.this);

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


                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
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
}
