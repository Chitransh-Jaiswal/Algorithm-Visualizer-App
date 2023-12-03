package com.example.algorithmvisualier.binary_search;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.algorithmvisualier.R;

public class BinarySearchVisualise extends AppCompatActivity {

    int n;
    EditText size;
    EditText array;
    TableLayout store;
    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search_visualise);
        getSupportActionBar().hide();

        store = (TableLayout) findViewById(R.id.store_binary_search);
    }

    public void binary_search_btn_pressed(View view) {
        size = (EditText) findViewById(R.id.inputSize_binary_search);
        String s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_binary_search);
        s = array.getText().toString();

        EditText et = (EditText) findViewById(R.id.target_element_binary_search);
        String sTextFromET = et.getText().toString();
        key = sTextFromET.isEmpty() ? 0 :  Integer.parseInt(sTextFromET);

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
        binarySearch(nums, 0, n-1);

    }


    public void binarySearch(int[] arr, int low, int high) {
        int mid =  (high - low) / 2;
        boolean found = false;

        while(low<=high) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin = 32;
            tr.setLayoutParams(lp);

            for(int i=low; i<=high; i++) {
                Button b = new Button(this);
                b.setText(Integer.toString(arr[i]));

                if(key<arr[mid] && i<mid){

                    b.setBackgroundColor(Color.rgb(28,159, 143));

                }

                if(key>arr[mid] && i<mid){

                    b.setBackgroundColor(Color.rgb(24, 217, 172));

                }

                else if(key!=arr[mid] && i==mid){
                    b.setBackgroundColor(Color.rgb(129, 148, 196));

                }

                else if(key == arr[mid] && i==mid ){
                    b.setBackgroundColor(Color.rgb(129, 148, 196));

                }

                else if(key>arr[mid] && i>mid) {

                    b.setBackgroundColor(Color.rgb(28,159, 143));

                }

                else if(key<arr[mid] && i>mid){

                    b.setBackgroundColor(Color.rgb(24, 217, 172));

                }

                tr.addView(b);

            }

            store.addView(tr);


            if (key == arr[mid]){

                TextView tvv = new TextView(this);
                tvv.setText("Here, Element " + Integer.toString(key) + " is equal to the element at mid position " + Integer.toString(arr[mid]) + " .So\n the element is present at index " + Integer.toString(mid)+ "\n");
                tvv.setTextSize(21.0F);
                tvv.setTextColor(Color.BLACK);
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                tvv.setTypeface(typeface);
                store.addView(tvv);

            }


            else if (key > arr[mid]) {
                TextView tvv = new TextView(this);
                tvv.setText("Here, Element " + Integer.toString(key) + " is greater than the element at mid position " + Integer.toString(arr[mid]) + " .So\n left half of array will not be considered\n");
                tvv.setTextSize(21.0F);
                tvv.setTextColor(Color.BLACK);
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                tvv.setTypeface(typeface);
                store.addView(tvv);
            }
            else if (key < arr[mid]) {
                TextView tvv = new TextView(this);
                tvv.setText("Here, Element " + Integer.toString(key) + " is less than the element at mid position " + Integer.toString(arr[mid]) + " .So\n right half of array will not be considered\n");
                tvv.setTextSize(21.0F);
                tvv.setTextColor(Color.BLACK);
                Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
                tvv.setTypeface(typeface);
                store.addView(tvv);

            }


            if(key == arr[mid]){
                found = true;
                break;
            }
            else if (key > arr[mid]) {

                low = mid + 1;
                mid = low + (high - low) / 2;
            }
            else {
                high = mid - 1;
                mid = low + (high - low) / 2;
            }


        }

        if(found){
            return;
        }

        else{
            TextView tvv = new TextView(this);
            tvv.setText("\n \n HENCE The Element " + Integer.toString(key) + " is not present in the array\n");
            tvv.setTextSize(21.0F);
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface, Typeface.BOLD_ITALIC);
            store.addView(tvv);
        }

    }

}