package com.eleganzit.vkcvendor.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eleganzit.vkcvendor.adapter.EntryAdapter;
import com.eleganzit.vkcvendor.adapter.PlanAdapter;
import com.eleganzit.vkcvendor.R;
import com.eleganzit.vkcvendor.api.RetrofitAPI;
import com.eleganzit.vkcvendor.api.RetrofitInterface;
import com.eleganzit.vkcvendor.model.plan.PNumber;
import com.eleganzit.vkcvendor.model.plan.PlanResponse;
import com.eleganzit.vkcvendor.util.UserLoggedInSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryFragment extends Fragment {
    RecyclerView rc_entry;
    ProgressDialog progressDialog;

    UserLoggedInSession userLoggedInSession;

    public EntryFragment() {
        // Required empty public constructor
    }
    ArrayList<PNumber> arrayList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_entry, container, false);

        userLoggedInSession = new UserLoggedInSession(getActivity());

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        rc_entry=v.findViewById(R.id.rc_entry);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_entry.setLayoutManager(layoutManager);

        getAllPoDetail();
        return v;
    }

    private void getAllPoDetail() {
        progressDialog.show();
        RetrofitInterface myInterface = RetrofitAPI.getRetrofit().create(RetrofitInterface.class);
        Call<PlanResponse> call = myInterface.getAllPoDetail(userLoggedInSession.getUserDetails().get(UserLoggedInSession.USER_ID));
        call.enqueue(new Callback<PlanResponse>() {
            @Override
            public void onResponse(Call<PlanResponse> call, Response<PlanResponse> response) {


                List<PNumber> arrayList=new ArrayList<>();
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().toString().equalsIgnoreCase("1")) {
                        for(int i=0;i<response.body().getData().size();i++)
                        {
                            if(response.body().getData().get(i).getMapping().equalsIgnoreCase("yes"))
                            {
                                arrayList.add(response.body().getData().get(i));
                            }
                        }
                        rc_entry.setAdapter(new EntryAdapter(arrayList, getActivity(),userLoggedInSession.getUserDetails().get(UserLoggedInSession.USER_NAME)));

                    }
                }

            }

            @Override
            public void onFailure(Call<PlanResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Server or Internet Error", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
