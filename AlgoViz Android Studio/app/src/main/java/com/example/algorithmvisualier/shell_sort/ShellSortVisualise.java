package com.example.algorithmvisualier.shell_sort;

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

public class ShellSortVisualise extends AppCompatActivity {

    int n;
    EditText size;
    EditText array;
    TableLayout store;
    int[] numsCopy;
    static int total_its = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell_sort_visualise);
        getSupportActionBar().hide();

        store = findViewById(R.id.store_shell_sort);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onGenArrPressed(View view) {
        //Getting values into Structure...
        size = (EditText) findViewById(R.id.inputSize_shell_sort);
        String s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_shell_sort);
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
        shellSort(nums, storage);

        store.removeAllViews();
        int gap;
        int rows=0,i=0;
        for (gap = n/2; gap > 0; gap /= 2) {

            TableRow tr0 = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin = 32;
            tr0.setLayoutParams(lp);
            for (int j = 0; j < n; j++) {
                Button b = new Button(this);
                b.setElevation(10);
                b.setText(Integer.toString(storage[rows][j]));
                tr0.addView(b);
            }
            rows++;
            store.addView(tr0);
            TableRow tr1 = new TableRow(this);
            tr0.setLayoutParams(lp);
            TextView tvv = new TextView(this);
            tvv.setText("Here, we see in this array, in the " + Integer.toString(i + 1) + "th iteration \nthe, the elements with gap " + Integer.toString(gap) + "are swapped ");
            i++;
            tvv.setTextSize(21.0F);
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            store.addView(tvv);
        }

    }

    public void seeIterationsPress(View view) {

        Intent i = new Intent(this, ShellSortIterations.class);
        i.putExtra("size", n);
        i.putExtra("kitni baar chalega", total_its);
        Bundle b = new Bundle();
        b.putIntArray("array", numsCopy);
        i.putExtra("b1", b);
        startActivity(i);
    }

    static void shellSort(int[] arr, int[][] storage) {
        int n = arr.length;
        int rows = 0;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            total_its++;
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
            for (int j = 0; j < n; j++) {
                storage[rows][j] = arr[j];
            }
            rows++;
        }
    }
}