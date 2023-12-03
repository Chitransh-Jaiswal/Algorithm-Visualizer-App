package com.example.algorithmvisualier.radix_sort;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.algorithmvisualier.R;
import com.example.algorithmvisualier.radix_sort.RadixSortIterations;

public class RadixSortVisualise extends AppCompatActivity {

    int n;
    EditText size;
    EditText array;
    TableLayout store;
    int[] numsCopy;
    static int max_digits = 0;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radix_sort_visualise);
        getSupportActionBar().hide();

        store = findViewById(R.id.store_radix_sort);
    }

//
//    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onGenArrPressed(View view) {
        //Getting values into Structure...
        size = (EditText) findViewById(R.id.inputSize_radix_sort);
        s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_radix_sort);
        s = array.getText().toString();
        if (!s.isEmpty()) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ',' && s.charAt(i) != ' ') {
                    String temp = "";
                    temp += s.charAt(i);
                    while (i < s.length() - 1 && s.charAt(i + 1) != ',' && s.charAt(i + 1) != ' ') {
                        i++;
                        temp += s.charAt(i);
                    }
                    nums[j++] = Integer.parseInt(temp);
                }
            }
        }

        numsCopy = nums.clone();
        int[][] storage = new int[n][n];
        max_digits=0;
        radixSort(nums, storage);

        store.removeAllViews();
        for (int i = 0; i < max_digits; i++) {
            TableRow tr0 = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin = 32;
            tr0.setLayoutParams(lp);
            for (int j = 0; j < n; j++) {
                Button b = new Button(this);
                b.setElevation(10);
                b.setText(Integer.toString(storage[i][j]));
                //if (j == n - 1 - i) b.setBackgroundColor(Color.rgb(28,159, 143));;
                tr0.addView(b);
            }
            store.addView(tr0);
            TableRow tr1 = new TableRow(this);
            tr0.setLayoutParams(lp);
            TextView tvv = new TextView(this);
            tvv.setText("Here, we see in this array, in the " + Integer.toString(i + 1) + "th iteration \nthe " + Integer.toString(i + 1) + "th significant position is considered to sort.");
            tvv.setTextSize(21.0F);
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            store.addView(tvv);
        }

    }

    public void seeIterationsPress(View view) {

        Intent i = new Intent(this, RadixSortIterations.class);
        i.putExtra("size", n);
        Bundle b = new Bundle();
        i.putExtra("max_digit", max_digits);
        b.putIntArray("array", numsCopy);
        i.putExtra("b1", b);
        startActivity(i);
    }

    static void radixSort(int[] arr, int[][] storage) {
        int n = arr.length;
        //System.out.print(n+" ");
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int div = (int) Math.pow(10, (i + 1));
                int temp1 = (((arr[j]) % div) * 10) / div;
                int temp2 = (((arr[j + 1]) % div) * 10) / div;
                if (temp1 > temp2) {
                    //swap elements
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    if (j > 0) j -= 2;
                    else j = -1;
                }
            }
            for (int j = 0; j < n; j++) {
                storage[i][j] = arr[j];
            }
        }
        int max_ele = storage[n - 1][n - 1];

        while (max_ele > 0) {
            max_ele /= 10;
            max_digits++;
        }
    }

}