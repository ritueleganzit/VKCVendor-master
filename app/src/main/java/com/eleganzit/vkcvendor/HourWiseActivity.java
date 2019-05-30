package com.eleganzit.vkcvendor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eleganzit.vkcvendor.adapter.RecyclerViewWithFooterAdapter;

import java.util.ArrayList;

public class HourWiseActivity extends AppCompatActivity {
RecyclerView rc_hour;
    ArrayList<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_wise);
        rc_hour=findViewById(R.id.rc_hour_list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(HourWiseActivity.this,LinearLayoutManager.VERTICAL,false);
        rc_hour.setLayoutManager(layoutManager);

        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        rc_hour.setAdapter(new RecyclerViewWithFooterAdapter(HourWiseActivity.this,arrayList));
        //RecyclerViewWithFooterAdapter

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
