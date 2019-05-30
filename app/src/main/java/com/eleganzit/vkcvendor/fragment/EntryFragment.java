package com.eleganzit.vkcvendor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.vkcvendor.adapter.EntryAdapter;
import com.eleganzit.vkcvendor.adapter.PlanAdapter;
import com.eleganzit.vkcvendor.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryFragment extends Fragment {
    RecyclerView rc_entry;


    public EntryFragment() {
        // Required empty public constructor
    }
    ArrayList<String> arrayList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_entry, container, false);


        rc_entry=v.findViewById(R.id.rc_entry);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_entry.setLayoutManager(layoutManager);
        rc_entry.setAdapter(new EntryAdapter(arrayList,getActivity()));
        return v;
    }

}
