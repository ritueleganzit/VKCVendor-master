package com.eleganzit.vkcvendor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.vkcvendor.adapter.PlanAdapter;
import com.eleganzit.vkcvendor.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends Fragment {

    public PlanFragment() {
        // Required empty public constructor
    }
    ArrayList<String> arrayList=new ArrayList<>();

    RecyclerView rc_plan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_plan, container, false);


        rc_plan=v.findViewById(R.id.rc_plan);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_plan.setLayoutManager(layoutManager);
        rc_plan.setAdapter(new PlanAdapter(arrayList,getActivity()));
        return v;
    }

}
