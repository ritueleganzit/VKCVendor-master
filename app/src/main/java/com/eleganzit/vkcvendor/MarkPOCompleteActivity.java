package com.eleganzit.vkcvendor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eleganzit.vkcvendor.adapter.MarkPOCompleteAdapter;
import com.eleganzit.vkcvendor.adapter.RecyclerViewPOAdapter;

import java.util.ArrayList;

public class MarkPOCompleteActivity extends AppCompatActivity {
RecyclerView rc_po_complete_list;
    ArrayList<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_pocomplete);
        rc_po_complete_list=findViewById(R.id.rc_po_complete_list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MarkPOCompleteActivity.this,LinearLayoutManager.VERTICAL,false);
        rc_po_complete_list.setLayoutManager(layoutManager);

        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");

        rc_po_complete_list.setAdapter(new MarkPOCompleteAdapter(MarkPOCompleteActivity.this,arrayList));
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
