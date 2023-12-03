package com.example.algorithmvisualier.quick_sort;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithmvisualier.R;

public class QuickSortVisualise extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort_visualise);
        getSupportActionBar().hide();


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onGenArrPressed(View view) {

    }

    public void seeIterationsPress(View view) {



    }

}