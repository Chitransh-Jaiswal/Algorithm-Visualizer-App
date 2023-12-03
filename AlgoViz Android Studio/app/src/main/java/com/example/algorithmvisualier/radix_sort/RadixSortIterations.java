package com.example.algorithmvisualier.radix_sort;

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

public class RadixSortIterations extends AppCompatActivity {

    int[] nums;
    int size;
    int iteration = -1;
    TableLayout storage;
    TextView tv;
    int total_iterations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radix_sort_iterations);
        getSupportActionBar().hide();

        storage = (TableLayout) findViewById(R.id.store);

        Bundle b = this.getIntent().getBundleExtra("b1");
        nums = b.getIntArray("array");
        Intent intent = getIntent();
        size = intent.getIntExtra("size", 0);
        total_iterations = intent.getIntExtra("max_digit", 0);
        tv = (TextView) findViewById(R.id.heading_radix_sort_iteration);
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
        singleRadixSort(arr, size, iteration);
    }

    public void nextClicked(View view) {
        int[] arr = nums.clone();
        iteration++;
        if(iteration == total_iterations){
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
        else if(iteration == total_iterations+1){
            finish();
        }
        else {
            singleRadixSort(arr, size, iteration);
            tv.setText("Iteration no. "+Integer.toString(iteration+1));
        }
    }


    void singleRadixSort(int[] arr, int size, int iteration){
        storage.removeAllViews();
        int temp = 0;
        try {
            for (int i = 0; i < total_iterations; i++) {
                System.out.println(iteration);
                if (i == iteration) {
                    for (int j = 0; j < size-1; j++) {
                        int div = (int) Math.pow(10,(i+1));
                        int temp1 = (((arr[j]) % div)*10)/div;
                        int temp2 = (((arr[j+1]) % div)*10)/div;
                        if (temp1 > temp2) {

                            TableRow tr = new TableRow(this);
                            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                            lp.topMargin=50;
                            tr.setLayoutParams(lp);

                            for (int k = 0; k < (size); k++) {
                                Button b = new Button(this);
                                b.setText(Integer.toString(arr[k]));
                                if (k == j+1 || k == j) {
                                    b.setBackgroundColor(Color.GREEN);
                                    b.setTextColor(Color.BLACK);
                                }
                                tr.addView(b);
                            }
                            storage.addView(tr);

                            TextView tvv = new TextView(this);
                            tvv.setText("As you can see, In the "+Integer.toString(i)+"th iteration, the Radix sort algo " +
                                    "\ntraversed the array from beginning to end " +
                                    "\nand whenever we encounter adjacent elements of " + Integer.toString(i+1) +"th\n significant bit in decreasing order, " +
                                    "we swap them and keep traversing. All such swaps are shown via Green colour.");
                            tvv.setTextSize(21.0F);
                            tvv.setTextColor(Color.BLACK);
                            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                            tvv.setTypeface(typeface);
                            storage.addView(tvv);
//                            storage.addView(tr1);
                            //swap elements
                            temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                            if(j>0) j-=2;
                            else j=-1;
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
                    for (int j = 0; j < size-1; j++) {
                        int div = (int) Math.pow(10,(i+1));
                        int temp1 = (((arr[j]) % div)*10)/div;
                        int temp2 = (((arr[j+1]) % div)*10)/div;
                        if (temp1 > temp2) {
                            //swap elements
                            temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                            if(j>0) j-=2;
                            else j=-1;
                        }
//                        if (arr[j - 1] > arr[j]) {
//                            //swap elements
//                            temp = arr[j - 1];
//                            arr[j - 1] = arr[j];
//                            arr[j] = temp;
//                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}