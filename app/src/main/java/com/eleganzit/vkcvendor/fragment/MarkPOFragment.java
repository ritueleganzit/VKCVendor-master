package com.eleganzit.vkcvendor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.vkcvendor.HourWiseActivity;
import com.eleganzit.vkcvendor.R;
import com.eleganzit.vkcvendor.adapter.RecyclerViewPOAdapter;
import com.eleganzit.vkcvendor.adapter.RecyclerViewWithFooterAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarkPOFragment extends Fragment {
    ArrayList<String> arrayList=new ArrayList<>();

RecyclerView rc_po_list;
    public MarkPOFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_mark_po, container, false);
        rc_po_list=v.findViewById(R.id.rc_po_list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_po_list.setLayoutManager(layoutManager);

        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        arrayList.add("fsdfsfsd");
        rc_po_list.setAdapter(new RecyclerViewPOAdapter(getActivity(),arrayList));
        return v;
    }

}
