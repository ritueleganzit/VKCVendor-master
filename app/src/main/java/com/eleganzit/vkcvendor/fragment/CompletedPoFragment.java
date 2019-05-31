package com.eleganzit.vkcvendor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.vkcvendor.R;
import com.eleganzit.vkcvendor.adapter.CompletedPOAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedPoFragment extends Fragment {

RecyclerView rc_completed_list;
ArrayList<String> arrayList=new ArrayList<>();
    public CompletedPoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=inflater.inflate(R.layout.fragment_completed_po, container, false);
        rc_completed_list=v.findViewById(R.id.rc_completed_list);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_completed_list.setLayoutManager(layoutManager);
        rc_completed_list.setAdapter(new CompletedPOAdapter(arrayList,getActivity()));

        return v;
    }

}
