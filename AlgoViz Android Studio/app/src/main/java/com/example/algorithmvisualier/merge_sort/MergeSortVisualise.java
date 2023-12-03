package com.example.algorithmvisualier.merge_sort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.algorithmvisualier.R;

import java.util.Vector;

public class MergeSortVisualise extends AppCompatActivity {

    int n;
    EditText size;
    EditText array;
    TableLayout store;
    int[] numsCopy;
    Vector<Vector<Integer>> v0 = new Vector<>();
    Vector<Vector<Integer>> v1 = new Vector<>();
    Vector<Vector<Integer>> v2 = new Vector<>();
    Vector<Vector<Integer>> v3 = new Vector<>();
    Vector<Vector<Integer>> v4 = new Vector<>();
    Vector<Vector<Integer>> v5 = new Vector<>();
    Vector<Vector<Integer>> w0 = new Vector<>();
    Vector<Vector<Integer>> w1 = new Vector<>();
    Vector<Vector<Integer>> w2 = new Vector<>();
    Vector<Vector<Integer>> w3 = new Vector<>();
    Vector<Vector<Integer>> w4 = new Vector<>();
    Vector<Vector<Integer>> w5 = new Vector<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_sort_visualise);
        getSupportActionBar().hide();

        store = (TableLayout) findViewById(R.id.store_merge_sort);
    }

    @SuppressLint("SetTextI18n")
    public void onGenArrPressed(View view) {
        v1.clear(); v2.clear(); v3.clear(); v4.clear(); v5.clear();
        w1.clear(); w2.clear(); w3.clear(); w4.clear(); w5.clear();
        //Getting Values into Structure
        size = (EditText) findViewById(R.id.inputSize_merge_sort);
        String s = size.getText().toString();
        n = s.isEmpty() ? 0 : Integer.parseInt(s);
        int[] nums = new int[n];
        array = (EditText) findViewById(R.id.inputArray_merge_sort);
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
        mergeSort(nums, 0, n-1, 1);


        store.removeAllViews();
        {
            for (int i = 0; i < v1.size(); i++) {
                for (int j = 0; j < v1.get(i).size(); j++) {
                    System.out.println(v1.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
            for (int i = 0; i < v2.size(); i++) {
                for (int j = 0; j < v2.get(i).size(); j++) {
                    System.out.println(v2.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
            for (int i = 0; i < v3.size(); i++) {
                for (int j = 0; j < v3.get(i).size(); j++) {
                    System.out.println(v3.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
            for (int i = 0; i < v4.size(); i++) {
                for (int j = 0; j < v4.get(i).size(); j++) {
                    System.out.println(v4.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");

            System.out.println("\n\n\n");

            for (int i = 0; i < w4.size(); i++) {
                for (int j = 0; j < w4.get(i).size(); j++) {
                    System.out.println(w4.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
            for (int i = 0; i < w3.size(); i++) {
                for (int j = 0; j < w3.get(i).size(); j++) {
                    System.out.println(w3.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
            for (int i = 0; i < w2.size(); i++) {
                for (int j = 0; j < w2.get(i).size(); j++) {
                    System.out.println(w2.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
            for (int i = 0; i < w1.size(); i++) {
                for (int j = 0; j < w1.get(i).size(); j++) {
                    System.out.println(w1.get(i).get(j));
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
        } //printing the intermediate values...


        TextView tvvv = new TextView(this);
        tvvv.setText("Division phase");
        Typeface tf = ResourcesCompat.getFont(this, R.font.autour_one);
        tvvv.setTextColor(Color.BLACK);
        tvvv.setTypeface(tf, Typeface.BOLD);
        tvvv.setTextSize(32.0f);
        store.addView(tvvv);
        TextView tvvv2 = new TextView(this);
        tvvv2.setText("In this phase ,the array gets divided into 2 parts,\n left and right until it becomes atomic and cannot \nbe further divided. \n");
        tvvv2.setTextSize(20.0f);
        tvvv2.setTextColor(Color.BLACK);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.bitter);
        tvvv2.setTypeface(typeface2);
        store.addView(tvvv2);

        if(!v1.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(28, 159, 143));

            TextView tvv = new TextView(this);
            tvv.setText("Step 1 : ");
            tvv.setTextSize(16.0f);
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            store.addView(tvv);

            for(int k=0; k<5; k++) {
                Button b3 = new Button(this);
                b3.setVisibility(View.INVISIBLE);
                tr.addView(b3);
            }

            for(int i=0; i<v1.size(); i++) {
                Button b = new Button(this);
                String temp = "" ;
                for(int j=0; j<v1.get(i).size(); j++) {
                    temp += Integer.toString(v1.get(i).get(j));
                    temp += " " ;
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);
            }
            store.addView(tr);
        }

        if(!v2.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(63, 190, 198));

            TextView tvv = new TextView(this);
            tvv.setText("Step 2 : ");
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            tvv.setTextSize(16.0f);
            store.addView(tvv);

            for(int i=0; i<v2.size(); i++) {
                if(i==0) {
                    for(int j=0; j<2; j++) {
                        Button b2 = new Button(this);
                        b2.setVisibility(View.INVISIBLE);
                        tr.addView(b2);
                    }
                }
                if(i==2) {
                    for(int j=0; j<4; j++) {
                        Button b2 = new Button(this);
                        b2.setVisibility(View.INVISIBLE);
                        tr.addView(b2);
                    }
                }

                Button b = new Button(this);
                String temp = "";
                for(int j=0; j<v2.get(i).size(); j++) {
                    temp += Integer.toString(v2.get(i).get(j));
                    temp += " ";
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);
            }
            store.addView(tr);
        }

        if(!v3.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(65, 154, 174));

            TextView tvv = new TextView(this);
            tvv.setText("Step 3 : ");
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            tvv.setTextSize(16.0f);
            store.addView(tvv);

            Button b3 = new Button(this);
            b3.setVisibility(View.INVISIBLE);
            tr.addView(b3);

            for(int i=0; i<v3.size(); i++) {
                Button b = new Button(this);
                String temp = "";
                for(int j=0; j<v3.get(i).size(); j++) {
                    temp += Integer.toString(v3.get(i).get(j));
                    temp += " ";
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
//                b.setLayoutParams (new ViewGroup.LayoutParams(500, ViewGroup.LayoutParams.WRAP_CONTENT));
                tr.addView(b);

                if(i%2==1) {
                    Button b2 = new Button(this);
                    b2.setVisibility(View.INVISIBLE);
                    tr.addView(b2);
                }
            }
            store.addView(tr);
        }

        if(!v4.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(129, 148, 196));

            TextView tvv = new TextView(this);
            tvv.setText("Step 4 : ");
            tvv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tvv.setTypeface(typeface);
            tvv.setTextSize(16.0f);
            store.addView(tvv);

            for(int i=0; i<v4.size(); i++) {
                Button b = new Button(this);
                String temp = "";
                for(int j=0; j<v4.get(i).size(); j++) {
                    temp += Integer.toString(v4.get(i).get(j));
                    temp += " ";
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);
                if(i==1){
                    for(int k =0 ; k<4; k++){
                        Button b2 = new Button(this);
                        b2.setVisibility(View.INVISIBLE);
                        tr.addView(b2);
                    }
                }
            }
            store.addView(tr);
        }

        TextView tvv = new TextView(this);
        tvv.setText(" \n Now merging phase");
        tvv.setTypeface(tf, Typeface.BOLD);
        tvv.setTextColor(Color.BLACK);
        tvv.setTextSize(32.0f);
        store.addView(tvv);

        if(!w4.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(129, 148, 196));

            TextView tv = new TextView(this);
            tv.setText("Merging Step 4 : ");
            tv.setTextSize(20.0f);
            tv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tv.setTypeface(typeface);
            store.addView(tv);
            TextView tvvv3 = new TextView(this);
            tvvv3.setText("In this step, we will merge the partitions made in step 4 and unite them such that they arrange in a sorted manner.");
            tvvv3.setTextSize(16.0f);
            tvvv3.setTextColor(Color.BLACK);
            tvvv3.setTypeface(typeface);
            store.addView(tvvv3);
//            Button b3 = new Button(this);
//            b3.setVisibility(View.INVISIBLE);
//            tr.addView(b3);

            for(int i=0; i<w4.size(); i++) {
                Button b = new Button(this);
                String temp = "" ;
                for(int j=0; j<w4.get(i).size(); j++) {
                    temp += Integer.toString(w4.get(i).get(j));
                    temp += " " ;
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);

                for(int k =0 ; k<5; k++){
                    Button b2 = new Button(this);
                    b2.setVisibility(View.INVISIBLE);
                    tr.addView(b2);
                }

            }
            store.addView(tr);
        }

        if(!w3.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(65, 154, 174));

            TextView tv = new TextView(this);
            tv.setText("Merging Step 3 : ");
            tv.setTextSize(20.0f);
            tv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tv.setTypeface(typeface);
            store.addView(tv);
            TextView tvvv3 = new TextView(this);
            tvvv3.setText("In this step, we will merge the partitions made in step 3 and unite them such that they arrange in a sorted manner.");
            tvvv3.setTextSize(16.0f);
            tvvv3.setTextColor(Color.BLACK);
            tvvv3.setTypeface(typeface);
            store.addView(tvvv3);

            Button b3 = new Button(this);
            b3.setVisibility(View.INVISIBLE);
            tr.addView(b3);

            for(int i=0; i<w3.size(); i++) {
                Button b = new Button(this);
                String temp = "";
                for(int j=0; j<w3.get(i).size(); j++) {
                    temp += Integer.toString(w3.get(i).get(j));
                    temp += " ";
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);

                for(int k=0; k<2; k++) {
                    Button b2 = new Button(this);
                    b2.setVisibility(View.INVISIBLE);
                    tr.addView(b2);
                }
            }
            store.addView(tr);
        }

        if(!w2.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(63, 190, 198));

            TextView tv = new TextView(this);
            tv.setText("Merging Step 2 : ");
            tv.setTextSize(20.0f);
            tv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tv.setTypeface(typeface);
            store.addView(tv);
            TextView tvvv3 = new TextView(this);
            tvvv3.setText("In this step, we will merge the partitions made in step 2 and unite them such that they arrange in a sorted manner.");
            tvvv3.setTextSize(16.0f);
            tvvv3.setTextColor(Color.BLACK);
            tvvv3.setTypeface(typeface);
            store.addView(tvvv3);

            for(int k=0; k<2; k++) {
                Button b3 = new Button(this);
                b3.setVisibility(View.INVISIBLE);
                tr.addView(b3);
            }

            for(int i=0; i<w2.size(); i++) {
                Button b = new Button(this);
                String temp = "";
                for(int j=0; j<w2.get(i).size(); j++) {
                    temp += Integer.toString(w2.get(i).get(j));
                    temp += " ";
                }
                b.setText(temp);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);

                for(int k=0; k<5; k++) {
                    Button b2 = new Button(this);
                    b2.setVisibility(View.INVISIBLE);
                    tr.addView(b2);
                }
            }
            store.addView(tr);
        }

        if(!w1.isEmpty()) {
            TableRow tr = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.topMargin=32;
            tr.setLayoutParams(lp);
            tr.setBackgroundColor(Color.rgb(28, 159, 143));

            TextView tv = new TextView(this);
            tv.setText("Merging Step 1 : ");
            tv.setTextColor(Color.BLACK);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bitter);
            tv.setTypeface(typeface);
            tv.setTextSize(20.0f);
            store.addView(tv);
            TextView tvvv3 = new TextView(this);
            tvvv3.setText("In this step, we will merge the partitions made in 1st step and unite them such that they arrange in a sorted manner.");
            tvvv3.setTextSize(16.0f);
            tvvv3.setTextColor(Color.BLACK);
            tvvv3.setTypeface(typeface);
            store.addView(tvvv3);

            for(int k=0; k<5; k++) {
                Button b3 = new Button(this);
                b3.setVisibility(View.INVISIBLE);
                tr.addView(b3);
            }

            for(int i=0; i<w1.size(); i++) {
                Button b = new Button(this);
                String temp = "";
                for(int j=0; j<w1.get(i).size(); j++) {
                    temp += Integer.toString(w1.get(i).get(j));
                    temp += " ";
                }
                b.setText(temp);
//                b.setTextColor(Color.BLACK);
//                if(i%2==0)  b.setBackgroundColor(Color.CYAN);
//                else        b.setBackgroundColor(Color.LTGRAY);
                if(i%2 == 0){    b.setBackgroundColor(Color.WHITE);     b.setTextColor(Color.BLACK);}
                else         {   b.setBackgroundColor(Color.BLACK);     b.setTextColor(Color.WHITE);}
                tr.addView(b);

            }
            store.addView(tr);
        }

    }


    void mergeSort(int arr[], int l, int r, int depth) {
        if (l < r) {
            int m = (l + r) / 2;

            switch (depth) {
                case 1: {
                    Vector<Integer> temp = new Vector<>() ;
                    for(int i=l; i<=m; i++) {
                        temp.add(arr[i]);
                    }
                    v1.add(temp);

                    Vector<Integer> temp2 = new Vector<>() ;
                    for(int i=m+1; i<=r; i++){
                        temp2.add(arr[i]);
                    }
                    v1.add(temp2);
                } break;

                case 2: {
                    Vector<Integer> temp = new Vector<>() ;
                    for(int i=l; i<=m; i++) {
                        temp.add(arr[i]);
                    }
                    v2.add(temp);

                    Vector<Integer> temp2 = new Vector<>() ;
                    for(int i=m+1; i<=r; i++){
                        temp2.add(arr[i]);
                    }
                    v2.add(temp2);
                } break;

                case 3: {
                    Vector<Integer> temp = new Vector<>() ;
                    for(int i=l; i<=m; i++) {
                        temp.add(arr[i]);
                    }
                    v3.add(temp);

                    Vector<Integer> temp2 = new Vector<>() ;
                    for(int i=m+1; i<=r; i++){
                        temp2.add(arr[i]);
                    }
                    v3.add(temp2);
                } break;

                case 4: {
                    Vector<Integer> temp = new Vector<>() ;
                    for(int i=l; i<=m; i++) {
                        temp.add(arr[i]);
                    }
                    v4.add(temp);

                    Vector<Integer> temp2 = new Vector<>() ;
                    for(int i=m+1; i<=r; i++){
                        temp2.add(arr[i]);
                    }
                    v4.add(temp2);
                } break;

                case 5: {
                    Vector<Integer> temp = new Vector<>() ;
                    for(int i=l; i<=m; i++) {
                        temp.add(arr[i]);
                    }
                    v5.add(temp);

                    Vector<Integer> temp2 = new Vector<>() ;
                    for(int i=m+1; i<=r; i++){
                        temp2.add(arr[i]);
                    }
                    v5.add(temp2);
                } break;

            }
            mergeSort(arr, l, m, depth+1);
            mergeSort(arr, m + 1, r, depth+1);
            merge(arr, l, m, r);
            switch (depth) {
                case 1: {
                    Vector<Integer> temp = new Vector<>();
                    for(int i=l; i<=r; i++) {
                        temp.add(arr[i]);
                    }
                    w1.add(temp);
                } break;

                case 2: {
                    Vector<Integer> temp = new Vector<>();
                    for(int i=l; i<=r; i++) {
                        temp.add(arr[i]);
                    }
                    w2.add(temp);
                } break;

                case 3: {
                    Vector<Integer> temp = new Vector<>();
                    for(int i=l; i<=r; i++) {
                        temp.add(arr[i]);
                    }
                    w3.add(temp);
                } break;

                case 4: {
                    Vector<Integer> temp = new Vector<>();
                    for(int i=l; i<=r; i++) {
                        temp.add(arr[i]);
                    }
                    w4.add(temp);
                } break;

                case 5: {
                    Vector<Integer> temp = new Vector<>();
                    for(int i=l; i<=r; i++) {
                        temp.add(arr[i]);
                    }
                    w5.add(temp);
                } break;
            }
        }
    }


    void merge(int arr[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];
        int i, j, k;
        i = 0;
        j = 0;
        k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }


//    public void nextButtonPress(View view) {
//        Intent i = new Intent(this, iterations.class);
//        i.putExtra("size", n);
//        Bundle b = new Bundle();
//        b.putIntArray("array", numsCopy);
//        i.putExtra("b1",b);
//        startActivity(i);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}