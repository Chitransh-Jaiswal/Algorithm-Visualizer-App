package com.example.algorithmvisualier.linear_search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.algorithmvisualier.R;

public class LinearSearchVisualise extends AppCompatActivity {


    int n;
    EditText size;
    EditText array;
    TableLayout store;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_search_visualise);
        getSupportActionBar().hide();

        store = (TableLayout) findViewById(R.id.store_linear_search);
    }


    public void linear_search_btn_pressed(View view){
        size = (EditText) findViewById(R.id.inputSize_linear_search);
        String s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_linear_search);
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

        store.removeAllViews();
        linearSearch(nums);

    }


    public void linearSearch(int[] arr){

        EditText et = (EditText)findViewById(R.id.target_element_linear_search);
        String sTextFromET = et.getText().toString();
        int key = new Integer(sTextFromET).intValue();
        Boolean found = false;

        for(int i=0;i<arr.length;i++){
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);

            for(int j=0; j<arr.length; j++) {
                Button b = new Button(this);
                b.setText(Integer.toString(arr[j]));
                if (j == i) {
                    if(arr[i] == key)
                    {
                        b.setBackgroundColor(Color.GREEN);

                    }

                    else {
                        b.setBackgroundColor(Color.rgb(28,159, 143));

                    }
                }
                tr.addView(b);
            }
            store.addView(tr);

            if(arr[i] == key) {
                found = true;
                TextView tvv = new TextView(this);
                tvv.setText("Here in the " + Integer.toString(i+1) + " th iteration, Element " + Integer.toString(key) + " is equal to the element at index "+ Integer.toString(i) + " so our searching will stop..\n");
                tvv.setTextSize(21.0F);
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                tvv.setTypeface(typeface);
                tvv.setTextColor(Color.BLACK);
                store.addView(tvv);
            }

            if(found) {
                return;
            } else{
                TextView tvv = new TextView(this);
                tvv.setText("Here in the " + Integer.toString(i+1) + " th iteration, Element " + Integer.toString(key) + " is not equal to the element at index "+ Integer.toString(i) + " so our\n algorithm will search the element in the next iteration.\n");
                tvv.setTextSize(21.0F);
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                tvv.setTypeface(typeface);
                tvv.setTextColor(Color.BLACK);
                store.addView(tvv);

                continue;
            }
        }

        TextView tvv = new TextView(this);
        tvv.setText("\n \n Hence This number is not present in the array");
        Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
        tvv.setTypeface(typeface, Typeface.BOLD_ITALIC);
        tvv.setTextSize(21.0F);
        store.addView(tvv);

        return;

    }

}