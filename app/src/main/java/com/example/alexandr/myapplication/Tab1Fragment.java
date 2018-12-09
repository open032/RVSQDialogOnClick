package com.example.alexandr.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Tab1Fragment extends Fragment implements MyCustomDialog.OnInputSelected {

    private static final String TAG = "MainFragment";

    @Override
    public void sendInput(String position) {
        Log.d(TAG, "sendInput: found incoming input: " + position);

        mExampleList.add(0, new ExampleIetm(R.drawable.globus, position , "This is Line 2", true));
        mAdapter.notifyItemInserted(0);
    }


    private ArrayList<ExampleIetm> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        createExampleList();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ExampleAdapter(mExampleList, requireContext());
        mRecyclerView.setAdapter(mAdapter);

        fab = view.findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCustomDialog dialog = new MyCustomDialog();
                dialog.setTargetFragment(Tab1Fragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");
            }
        });


        return view;
    }

    public  void createExampleList() {

        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleIetm(R.drawable.globus, "Line 1", "Line 2", true));
        mExampleList.add(new ExampleIetm(R.drawable.globus, "Line 3", "Line 4",true));
        mExampleList.add(new ExampleIetm(R.drawable.globus, "Line 5", "Line 6",true));
    }
}