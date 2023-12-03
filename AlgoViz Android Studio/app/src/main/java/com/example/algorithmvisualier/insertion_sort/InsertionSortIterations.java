package com.example.algorithmvisualier.insertion_sort;

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

public class InsertionSortIterations extends AppCompatActivity {
    int[] nums;
    int size,count=0;
    int iteration = -1;
    TableLayout storage;
    TextView tv;
    int track=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort_iterations);
        getSupportActionBar().hide();

        storage = (TableLayout) findViewById(R.id.store);

        Bundle b = this.getIntent().getBundleExtra("b1");
        nums = b.getIntArray("array");
        Intent intent = getIntent();
        size = intent.getIntExtra("size", 0);
        tv = (TextView) findViewById(R.id.heading_insertion_sort_iteration);
//        tv.setText(Integer.toString(size));
        String temp = "";
        for (int i = 0; i < size; i++) {
            temp += Integer.toString(nums[i]);
            temp += " ";
        }

        tv.setText(temp);
    }

    public void prevClicked(View view) {
        iteration--;
        int[] arr = nums.clone();
        if (iteration < 0) {
            finish();
        }
        tv.setText("Iteration no. " + Integer.toString(iteration + 1));
        singleinsertionSort(arr, size, iteration);
    }

    public void nextClicked(View view) {
        int[] arr = nums.clone();
        iteration++;
        if (iteration == size ) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You have reached the end of all iterations...").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog alert = builder.create();
            alert.setTitle("THE END!");
            alert.show();
        } else if (iteration == size+1) {
            finish();
        } else {
            singleinsertionSort(arr, size, iteration);
            if(iteration!=0)
                tv.setText("Iteration no. " + Integer.toString(iteration));
            else
                tv.setText("Algorithm's Working");
        }
    }


    void singleinsertionSort(int[] arr, int size, int iteration) {
        storage.removeAllViews();
        int t,emp = 0;
        try {
            for (int i = 0; i <= size; i++) {
                System.out.println(iteration);

                if (i == iteration) {
                    for (int j = 0; j < size; j++) {
                        if(track==0) {
                            TextView tvv = new TextView(this);
                            tvv.setText("First element of the array is always considered sorted. \nWith Respect to it, " +
                                    "the remaining unsorted array is sorted. \n" +
                                    "The Repetitive Process of \nExtract --> Compare --> Place --> Replace \n" +
                                    "is followed in this sorting algorithm. \nThe same has been applied here.");
                            Typeface typeface = ResourcesCompat.getFont(this, R.font.concert_one);
                            tvv.setTypeface(typeface);
                            tvv.setTextSize(21.0F);
                            tvv.setTextColor(Color.WHITE);
                            track = 1;

//                            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
//                            tvv.setTypeface(typeface);
                            storage.addView(tvv);
                        }


                        int key = arr[i];
                        int u = i - 1;
                        while (u >= 0 && arr[u] > key) {


                            TableRow tr = new TableRow(this);
                            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                            lp.topMargin = 50;
                            tr.setLayoutParams(lp);

                            for (int k = 0; k < (size); k++) {
                                Button b = new Button(this);
                                b.setText(Integer.toString(arr[k]));
                                if(k==i)    b.setBackgroundColor(Color.rgb(129,148,196));
                                if(k<i)     b.setBackgroundColor(Color.rgb(24,217,172));
                                if(k>i)     b.setBackgroundColor(Color.rgb(28,159,143));
                                if (k == u) b.setBackgroundColor(Color.GREEN); //highlight the element accordingly
                                tr.addView(b);
                            }
                            storage.addView(tr);

//                            storage.addView(tr1);
                            //swap elements
                            arr[u + 1] = arr[u];
                            u = u - 1;

                        }
                        arr[u + 1] = key;
                    }
                    if(iteration!=0) {
                        for (int xy = 0; xy < 1; xy++) {
                            TextView tvv = new TextView(this);
                            tvv.setText("Color Code - " +
                                    "\n\t\tDark Green - Unsorted Array" +
                                    "\n\t\tPurple - Key" +
                                    "\n\t\tBright Green - Comparing Element" + "( if greater, shifted to right)"+
                                    "\n\t\tTeal - Sorted Array"+
                                    "\n\tAfter all shifts, the key element is put at the pointer's position");
                            Typeface typeface = ResourcesCompat.getFont(this, R.font.concert_one);
                            tvv.setTypeface(typeface);
                            tvv.setTextSize(21.0F);
                            tvv.setTextColor(Color.rgb(00,80,80));


//                            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
//                            tvv.setTypeface(typeface);
                            storage.addView(tvv);
                        }
                    }
                    TextView tvv = new TextView(this);
                    tvv.setText("\n\n\nTHE FINAL ARRAY AFTER THIS ITERATION...");
                    Typeface typeface = ResourcesCompat.getFont(this, R.font.concert_one);
                    tvv.setTypeface(typeface);
                    tvv.setTextSize(21.0F);
                    tvv.setTextColor(Color.BLACK);
//                    Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
//                    tvv.setTypeface(typeface);
                    storage.addView(tvv);

                    TableRow tr = new TableRow(this);
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    lp.topMargin = 50;
                    tr.setLayoutParams(lp);
                    for (int k = 0; k < (size); k++) {
                        Button b = new Button(this);
                        b.setText(Integer.toString(arr[k]));
                        tr.addView(b);
                    }
                    storage.addView(tr);
                    return;
                }

                else
                {
                    //itinerant the loop one time only for single iteration

                    int key = arr[i];
                    int j = i - 1;

                    /* Move elements of arr[0..i-1], that are
                    greater than key, to one position ahead
                    of their current position */
                    while (j >= 0 && arr[j] > key)
                    {
                        arr[j + 1] = arr[j];
                        j = j - 1;
                    }
                    arr[j + 1] = key;

                }


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


//            for (int i = 0; i < size; i++) {
//        System.out.println(iteration);
//        if (i == iteration) {
//        for (int j = 0; j < size; j++) {
//        int key = arr[j];
//        int u = j - 1;
//        while (u >= 0 && arr[u] > key) {
//        if(track==0) {
//        TextView tvv = new TextView(this);
//        tvv.setText("First element of the array is always considered sorted. \nWith Respect to it, " +
//        "the remaining unsorted array is sorted. \n" +
//        "The Repetitive Process of \nExtract --> Compare --> Place --> Replace \n" +
//        "is followed in this sorting algorithm. \nThe same has been applied here.");
//        tvv.setTextSize(21.0F);
//        tvv.setTextColor(Color.WHITE);
//        track = 1;
//
////                            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
////                            tvv.setTypeface(typeface);
//        storage.addView(tvv);
//        }
//
//        TableRow tr = new TableRow(this);
//        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
//        lp.topMargin = 50;
//        tr.setLayoutParams(lp);
//
//        for (int k = 0; k < (size); k++) {
//        Button b = new Button(this);
//        b.setText(Integer.toString(arr[k]));
//        if (k == j || k == j - 1) b.setBackgroundColor(Color.GREEN); //highlight the element accordingly
//        tr.addView(b);
//        }
//        storage.addView(tr);
//
//
//
////                            storage.addView(tr1);
//        //swap elements
//        arr[u + 1] = arr[u];
//        u = u - 1;
//
//        }
//        arr[u + 1] = key;
//        }
//
//        TextView tvv = new TextView(this);
//        tvv.setText("\n\n No swaps left in this iteration...\n\n\nTHE FINAL ARRAY AFTER THIS ITERATION...");
//        tvv.setTextSize(21.0F);
//        tvv.setTextColor(Color.BLACK);
////                    Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
////                    tvv.setTypeface(typeface);
//        storage.addView(tvv);
//
//        TableRow tr = new TableRow(this);
//        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
//        lp.topMargin = 50;
//        tr.setLayoutParams(lp);
//        for (int k = 0; k < (size); k++) {
//        Button b = new Button(this);
//        b.setText(Integer.toString(arr[k]));
//        tr.addView(b);
//        }
//        storage.addView(tr);
//        return;
//        }
//        else
//        {
//        //itinerant the loop one time only for single iteration
//        for (i = 0; i < size; ++i)
//        {
//        int key = arr[i];
//        int j = i - 1;
//
//                    /* Move elements of arr[0..i-1], that are
//                    greater than key, to one position ahead
//                    of their current position */
//        while (j >= 0 && arr[j] > key)
//        {
//        arr[j + 1] = arr[j];
//        j = j - 1;
//        }
//        arr[j + 1] = key;
//
//        }
//        }

//        }