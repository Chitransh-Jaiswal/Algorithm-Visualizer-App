package com.example.algorithmvisualier.selection_sort;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.algorithmvisualier.R;


public class SelectionSortIterations extends AppCompatActivity {

    int[] nums;
    int size;
    int iteration = -1;
    TableLayout storage;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_sort_iterations);
        getSupportActionBar().hide();

        storage = (TableLayout) findViewById(R.id.store);

        Bundle b = this.getIntent().getBundleExtra("b1");
        nums = b.getIntArray("array");
        Intent intent = getIntent();
        size = intent.getIntExtra("size", 0);
        tv = (TextView) findViewById(R.id.heading_selection_sort_iteration);
//        tv.setText(Integer.toString(size));
        String temp = "";
        for(int i=0; i<size; i++){
            temp += Integer.toString(nums[i]);
            temp += " ";
        }

        tv.setText(temp);
    }

    public void prevClicked(View view) {
        iteration--;
        int[] arr = nums.clone();
        if(iteration<0){
            finish();
        }
        tv.setText("Iteration no. "+Integer.toString(iteration+1));
        singleSelectionSort(arr, size, iteration);
    }

    public void nextClicked(View view) {
        int[] arr = nums.clone();
        iteration++;
        if(iteration == size-1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You have reached the end of all iterations...").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog alert = builder.create();
            alert.setTitle("THE END!");
            alert.show();
        }
        else if(iteration == size){
            finish();
        }
        else {
            singleSelectionSort(arr, size, iteration);
            tv.setText("Iteration no. "+Integer.toString(iteration+1));
        }
    }


    void singleSelectionSort(int[] arr, int size, int iteration){
        storage.removeAllViews();
        int temp = 0;
        try {
            for (int i = 0; i < size; i++) {
                System.out.println(iteration);
                if (i == iteration) {
                    for (int j = i;j <size-1;j++) {
                        if (arr[j+1] < arr[i]) {

                            TableRow tr = new TableRow(this);
                            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                            lp.topMargin=50;
                            tr.setLayoutParams(lp);

                            for (int k = 0; k < (size); k++) {
                                Button b = new Button(this);
                                b.setText(Integer.toString(arr[k]));
                                if (k == i || k == j+1) b.setBackgroundColor(Color.GREEN);
                                tr.addView(b);
                            }
                            storage.addView(tr);

                            TextView tvv = new TextView(this);
                            tvv.setText("As you can see, In the "+Integer.toString(i)+"th iteration, the selection sort algo " +
                                    "\ntraversed the array from beginning to end " +
                                    "\nand whenever we encounter a element which is less then the key element, " +
                                    "\nwe swap them and keep traversing. All such swaps are shown via Green colour.");
                            tvv.setTextSize(21.0F);
                            tvv.setTextColor(Color.BLACK);
                            storage.addView(tvv);
//                            storage.addView(tr1);
                            //swap elements
                            temp = arr[j+1];
                            arr[j+1] = arr[i];
                            arr[i] = temp;
                        }
                    }

                    TextView tvv = new TextView(this);
                    tvv.setText("\n\n No swaps left in this iteration...\n\n\nTHE FINAL ARRAY AFTER THIS ITERATION...");
                    tvv.setTextSize(21.0F);
                    tvv.setTextColor(Color.BLACK);
                    Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                    tvv.setTypeface(typeface);
                    storage.addView(tvv);

                    TableRow tr = new TableRow(this);
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    lp.topMargin=50;
                    tr.setLayoutParams(lp);
                    for (int k = 0; k < (size); k++) {
                        Button b = new Button(this);
                        b.setText(Integer.toString(arr[k]));
                        tr.addView(b);
                    }
                    storage.addView(tr);
                    return;
                } else {
                    for (int j = i; j < size-1; j++) {
                        if (arr[j+1] < arr[i]) {
                            //swap elements
                            temp = arr[j+1];
                            arr[j+1] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}