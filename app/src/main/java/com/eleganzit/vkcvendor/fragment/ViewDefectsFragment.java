package com.eleganzit.vkcvendor.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eleganzit.vkcvendor.GalleryActivity;
import com.eleganzit.vkcvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewDefectsFragment extends Fragment {

LinearLayout alldefects;
    public ViewDefectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_view_defects, container, false);
        alldefects=v.findViewById(R.id.alldefects);
        alldefects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(getActivity(), GalleryActivity.class));

            }
        });
        return v;
    }

}
