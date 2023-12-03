package com.example.algorithmvisualier.insertion_sort;

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

public class InsertionSortVisualise extends AppCompatActivity {


    int n;
    EditText size;
    EditText array;
    TableLayout store;
    int[] numsCopy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort_visualise);
        getSupportActionBar().hide();

        store = findViewById(R.id.store_insertion_sort);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onGenArrPressed(View view) {
        //Getting values into Structure...
        size = (EditText) findViewById(R.id.inputSize_insertion_sort);
        String s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_insertion_sort);
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
        insertionSort(nums, storage);

        store.removeAllViews();
        for(int i=0; i<n; i++) {
            TableRow tr0 = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr0.setLayoutParams(lp);
            for (int j = 0; j < n; j++) {
                Button b = new Button(this);
                b.setElevation(10);
                b.setText(Integer.toString(storage[i][j]));
                if (j == i+1) b.setBackgroundColor(Color.rgb(28,159, 143));;
                tr0.addView(b);
            }
            store.addView(tr0);
            TableRow tr1 = new TableRow(this);
            tr0.setLayoutParams(lp);
            TextView tvv = new TextView(this);
            if(i<n-1) tvv.setText("Here, in this array, in the "+Integer.toString(i+1)+"th iteration \nthe "+Integer.toString(i+1)+"th element in the unsorted array is \nplaced to its correct position");
            tvv.setTextSize(21.0F);
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            store.addView(tvv);
        }

    }

    public void seeIterationsPress(View view) {

        Intent i = new Intent(this, InsertionSortIterations.class);
        i.putExtra("size", n);
        Bundle b = new Bundle();
        b.putIntArray("array", numsCopy);
        i.putExtra("b1",b);
        startActivity(i);
    }

    void insertionSort(int[] arr, int[][] storage) {

        int temp = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            for(int k=0; k<n; k++){
                storage[i][k] = arr[k];

            }
        }
    }

}