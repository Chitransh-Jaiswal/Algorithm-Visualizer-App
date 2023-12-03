package com.example.algorithmvisualier.bubble_sort;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

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

import com.example.algorithmvisualier.R;
import com.example.algorithmvisualier.bubble_sort.BubbleSortIterations;

public class BubbleSortVisualise extends AppCompatActivity {

    int n;
    EditText size;
    EditText array;
    TableLayout store;
    int[] numsCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort_visualise);
        getSupportActionBar().hide();

        store = findViewById(R.id.store_bubble_sort);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onGenArrPressed(View view) {
        //Getting values into Structure...
        size = (EditText) findViewById(R.id.inputSize_bubble_sort);
        String s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_bubble_sort);
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
        bubbleSort(nums, storage);

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
                if (j == n - 1 - i) b.setBackgroundColor(Color.rgb(28,159, 143));;
                tr0.addView(b);
            }
            store.addView(tr0);
            TableRow tr1 = new TableRow(this);
            tr0.setLayoutParams(lp);
            TextView tvv = new TextView(this);
            tvv.setText("Here, we see in this array, in the "+Integer.toString(i+1)+"th iteration \nthe "+Integer.toString(i+1)+"th largest element in the array gets attached to \nits position i.e "+Integer.toString(n-1-i)+"th spot which \nis fixed for it.");
            tvv.setTextSize(21.0F);
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            store.addView(tvv);
        }

    }

    public void seeIterationsPress(View view) {

        Intent i = new Intent(this, BubbleSortIterations.class);
        i.putExtra("size", n);
        Bundle b = new Bundle();
        b.putIntArray("array", numsCopy);
        i.putExtra("b1",b);
        startActivity(i);
    }

    static void bubbleSort(int[] arr, int[][] storage) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            for(int j=0; j<n; j++){
                storage[i][j] = arr[j];
            }
        }
    }

}