package com.example.alexandr.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleviewHolder> {
    private ArrayList<ExampleIetm> mExampleList;
    private static final String TAG = "myLogs";
    private Context context;
    private MyCustomDialog dialog;


    public ExampleAdapter(ArrayList<ExampleIetm> exampleList, Context context) {
        this.mExampleList = exampleList;
        this.context = context;
    }

    @Override
    public ExampleviewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleviewHolder evh = new ExampleviewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleviewHolder holder, int position) {
        ExampleIetm currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getmText1());
        holder.mTextView2.setText(currentItem.getmText2());

        holder.setOnClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                //Fragment mFragment = new MyCustomDialog();
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();

               /* Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));*/

                dialog = new MyCustomDialog();
                dialog.show(manager, "dlg1");

                //MyCustomDialog dialog = new MyCustomDialog();
                //dialog.setTargetFragment(ExampleAdapter.this, 1);
                //dialog.show(getFragmentManager(), "MyCustomDialog");

                if(isLongClick) {
                    Toast.makeText(context, "Long CLICK: " + mExampleList.get(position), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "click: " + mExampleList.get(position), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ExampleviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public CheckBox mCheckBox;
        private ItemClickListener itemClickListener;


        public ExampleviewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textSmall);




            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox);

            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        Log.d(TAG, "checked");
                        mImageView.setImageResource(R.drawable.ocean);
                        Log.d(TAG, "myLogs" + getItemCount());
                    } else {
                        Log.d(TAG, "unChecked");
                        mImageView.setImageResource(R.drawable.globus);
                    }
                }
            });

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public void setOnClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }

    }
}

