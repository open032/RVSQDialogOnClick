package com.example.alexandr.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTEST2);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 2",Toast.LENGTH_SHORT).show();
            }
        });

        TextView tv1 = view.findViewById(R.id.textView2);
        TextView tv2 = view.findViewById(R.id.textView3);
        TextView tv3 = view.findViewById(R.id.textView4);
        TextView tv4 = view.findViewById(R.id.textView6);
        TextView tv5 = view.findViewById(R.id.textView7);
        TextView tv6 = view.findViewById(R.id.textView8);
        TextView tv7 = view.findViewById(R.id.textView9);
        TextView tv8 = view.findViewById(R.id.textView10);

        int number = 10;
        int number2 = 10;
        int number3 = 10;
        int number4 = 10;
        tv5.setText("" + number++);
        tv6.setText("" + ++number2);
        tv7.setText("" + number3--);
        tv8.setText("" + --number4);
        return view;
    }
}