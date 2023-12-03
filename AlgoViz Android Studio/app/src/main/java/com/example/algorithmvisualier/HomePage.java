package com.example.algorithmvisualier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithmvisualier.binary_search.BinarySearchPage;
import com.example.algorithmvisualier.bubble_sort.BubbleSortPage;
import com.example.algorithmvisualier.insertion_sort.InsertionSortPage;
import com.example.algorithmvisualier.linear_search.LinearSearchPage;
import com.example.algorithmvisualier.merge_sort.MergeSortPage;
import com.example.algorithmvisualier.quick_sort.QuickSortPage;
import com.example.algorithmvisualier.radix_sort.RadixSortPage;
import com.example.algorithmvisualier.selection_sort.SelectionSortPage;
import com.example.algorithmvisualier.shell_sort.ShellSortPage;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();

        Spinner spin1 = (Spinner) findViewById(R.id.searchSpinner);
        Spinner spin2 = (Spinner) findViewById(R.id.sortSpinner);

        ArrayAdapter<CharSequence> aa1 = ArrayAdapter.createFromResource(this, R.array.searches, R.layout.spinner_list);
        aa1.setDropDownViewResource(R.layout.spinner_list);
        spin1.setAdapter(aa1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 1:
                        Intent Intent1 = new Intent(getApplicationContext(), LinearSearchPage.class);
                        startActivity(Intent1);
                        break;
                    case 2:
                        Intent Intent2 = new Intent(getApplicationContext(), BinarySearchPage.class);
                        startActivity(Intent2);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        ArrayAdapter<CharSequence> aa2 = ArrayAdapter.createFromResource(this, R.array.sorts, R.layout.spinner_list);
        aa2.setDropDownViewResource(R.layout.spinner_list);
        spin2.setAdapter(aa2);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String selection = (String) adapterView.getItemAtPosition(i);
//                if(selection.equalsIgnoreCase("Bubble Sort"))
//                {
//                    Intent intent = new Intent(getBaseContext(), SplashScreen.class);
//                    startActivity(intent);
//                }

                switch(i){
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), BubbleSortPage.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), InsertionSortPage.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), SelectionSortPage.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), MergeSortPage.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getApplicationContext(), QuickSortPage.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getApplicationContext(), RadixSortPage.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getApplicationContext(), ShellSortPage.class);
                        startActivity(intent7);
                        break;
                    default :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}