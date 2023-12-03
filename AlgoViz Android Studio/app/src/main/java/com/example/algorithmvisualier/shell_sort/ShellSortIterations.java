package com.example.algorithmvisualier.shell_sort;

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

public class ShellSortIterations extends AppCompatActivity {

    int[] nums;
    int size;
    int iteration = -1;
    TableLayout storage;
    TextView tv;
    int total_its = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell_sort_iterations);
        getSupportActionBar().hide();

        storage = (TableLayout) findViewById(R.id.store);

        Bundle b = this.getIntent().getBundleExtra("b1");
        nums = b.getIntArray("array");
        Intent intent = getIntent();
        size = intent.getIntExtra("size", 0);
//        total_its = intent.getIntExtra("kitni baar chalega",0);
        System.out.println(total_its);
        tv = (TextView) findViewById(R.id.heading_shell_sort_iteration);
//        tv.setText(Integer.toString(size));
        String temp = "";
        for(int i=0; i<size; i++){
            temp += Integer.toString(nums[i]);
            temp += " ";
        }

        findIterations();
        tv.setText(temp);
    }

    public void prevClicked(View view) {
        iteration--;
        int[] arr = nums.clone();
        if(iteration<0){
            finish();
        }
        tv.setText("Iteration no. "+Integer.toString(iteration+1));
        singleShellSort(arr, size, iteration);
    }

    public void nextClicked(View view) {
        int[] arr = nums.clone();
        iteration++;
        if(iteration == total_its){
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
        else if(iteration == total_its+1){
            finish();
        }
        else {
            singleShellSort(arr, size, iteration);
            tv.setText("Iteration no. "+Integer.toString(iteration+1));
        }
    }


    void singleShellSort(int[] arr, int size, int iteration){
        storage.removeAllViews();
        int gap,iter=0;                          // i=gap ,j=i
        try {
            for (gap = size/2; gap > 0; gap /= 2) {
                System.out.println(iteration);
                if (iter == iteration) {
                    for (int i = gap; i < size; i += 1) {
//                        if (arr[i+1] < arr[i]) {
                        int temp = arr[i];
                        int j;
                        for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                            TableRow tr = new TableRow(this);
                            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                            lp.topMargin=50;
                            tr.setLayoutParams(lp);

                            for (int k = 0; k < (size); k++) {
                                Button b = new Button(this);
                                b.setText(Integer.toString(arr[k]));
                                if (k == j || k == j-gap) { b.setTextColor(Color.BLACK);    b.setBackgroundColor(Color.GREEN);}
                                tr.addView(b);
                            }
                            storage.addView(tr);

                            TextView tvv = new TextView(this);
                            tvv.setText("As you can see, In the "+Integer.toString(iter)+"th iteration, the shell sort algo " +
                                    "\ntraversed the array from beginning to end " +
                                    "\nand whenever swap the elements with a gap "+Integer.toString(gap)+" and swap them to make them in " +
                                    "\nascending order. All such swaps are shown via Green colour.");
                            tvv.setTextSize(21.0F);
                            tvv.setTextColor(Color.BLACK);
                            storage.addView(tvv);
                            arr[j] = arr[j - gap];
                        }
                        arr[j] = temp;
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

                        for (int i = gap; i < size; i += 1)
                        {
                            int temp = arr[i];
                            int j;
                            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                                arr[j] = arr[j - gap];
                            arr[j] = temp;
                        }

                }
                iter++;
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void findIterations(){
        int mnmn = size/2;
        while(mnmn > 0) {
            mnmn /= 2;
            total_its++;
        }
    }
}