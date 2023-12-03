package com.example.algorithmvisualier.insertion_sort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithmvisualier.R;

public class InsertionSortPage extends AppCompatActivity {
    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_insertion_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_insertion_sort);
        cpp = (Button) findViewById(R.id.btn2_insertion_sort);
        java = (Button) findViewById(R.id.btn3_insertion_sort);
        python = (Button) findViewById(R.id.btn4_insertion_sort);
    }

    public void onButtonClick(View view) {
        if(view==c){
            tvv.setText(c_code);
        }
        else if(view==cpp){
            tvv.setText(cpp_code);
        }
        else if(view==java){
            tvv.setText(java_code);
        }
        else if(view==python){
            tvv.setText(python_code);
        }
    }

    public void onVisualiseClick(View view) {
        Intent i = new Intent(this,InsertionSortVisualise.class);
        startActivity(i);
    }

    {c_code = "//C program for insertion sort\n"+
            "\n#include <math.h>\n"+
            "#include <stdio.h>\n"+
            "\n/* Function to sort an array using insertion sort*/\n"+
            "void insertionSort(int arr[], int n)\n"+
            "\t{\n"+
            "\t\tint i, key, j;\n"+
            "\t\tfor (i = 1; i < n; i++) {\n"+
            "\t\tkey = arr[i];\n"+
            "\t\tj = i - 1;\n"+
            "\n\t// Move elements of arr[0..i-1], that are\n"+
            "\t//greater than key, to one position ahead\n"+
            "\t//of their current position \n\n"+
            "\t\twhile (j >= 0 && arr[j] > key) {\n"+
            "\t\t\t\tarr[j + 1] = arr[jj = j - 1;\n"+
            "\t\t\t}\n"+
            "\t\t\tarr[j + 1] = key;\n"+
            "\t\t}\n"+
            "\t}\n"+
            "\n//A utility function to print an array of size n\n"+
            "void printArray(int arr[], int n)\n"+
            "\t{\n"+
            "\t\tint i;\n"+
            "\t\tfor (i = 0; i < n; i++)\n"+
            "\t\tprintf(\"%d\", arr[i]);\n"+
            "\t\tprintf(\"\\n\");\n"+
            "\t}\n"+
            "\n/* Driver program to test insertion sort */\n"+
            "int main()\n"+
            "\t{\n"+
            "\t\tint arr[] = { 12, 11, 13, 5, 6 };\n"+
            "\t\tint n = sizeof(arr) / sizeof(arr[0]);\n"+
            "\t\tinsertionSort(arr, n);\n"+
            "\t\tprintArray(arr, n);\n"+
            "\t\treturn 0;\n"+
            "\t}\n";
    } //c-code

    {
        cpp_code = "// C++ program for insertion sort\n"+

                "\n#include <bits/stdc++.h>\n"+
                "using namespace std;\n"+

                "\n// Function to sort an array using\n"+
                "// insertion sort\n"+
                "\nvoid insertionSort(int arr[], int n)\n"+
                "\t{\n"+
                "\t\t int i, key, j;\n"+
                "\t\t for (i = 1; i < n; i++)\n"+
                "\t\t\t\t{\n"+
                "\t\t\t\t\tkey = arr[i];\n"+
                "\t\t\t\t\tj = i - 1;\n"+

                "\n\t// Move elements of arr[0..i-1], \n"+
                "\t// that are greater than key, to one\n"+
                "\t// position ahead of their\n"+
                "\t// current position\n\n"+
                "\t\twhile (j >= 0 && arr[j] > key)\n"+
                "\t\t\t{\n"+
                "\t\t\t\tarr[j + 1] = arr[j];\n"+
                "\t\t\t\tj = j - 1;\n"+
                "\t\t\t}\n"+
                "\t\t\tarr[j + 1] = key;\n"+
                "\t\t}\n"+
                "\t}\n"+
                "\n\t// A utility function to print an array\n"+
                "\t// of size n\n\n"+
                "void printArray(int arr[], int n)\n"+
                "\t{\n"+
                "\t\tint i;\n"+
                "\t\tfor (i = 0; i < n; i++)\n"+
                "\t\tcout << arr[i] << \" \";\n"+
                "\t\tcout << endl;\n"+
                "\t}\n"+

                "\n// Driver code\n"+
                "int main()\n"+
                "\t{\n"+
                "\t\tint arr[] = { 12, 11, 13, 5, 6 };\n"+
                "\t\tint N = sizeof(arr) / sizeof(arr[0]);\n"+

                "\t\tinsertionSort(arr, N);\n"+
                "\t\tprintArray(arr, N);\n"+

                "\t\treturn 0;\n"+
                "\t}\n";

    } // c++ code

    {
        java_code = "//Java program for implementation of Insertion Sort\n"+
                "\npublic class InsertionSort {\n"+
                "\n/*Function to sort array using insertion sort*/\n"+
                "void sort(int arr[])\n"+
                "\t{\n"+
                "\t\tint n = arr.length;\n"+
                "\t\tfor (int i = 1; i < n; ++i) {\n"+
                "\t\t\t\tint key = arr[i];\n"+
                "\t\t\t\tint j = i - 1;\n"+
                "\n/* Move elements of arr[0..i-1], that are\n"+
                "\t\t\t\t\tgreater than key, to one position ahead\n"+
                "\t\t\t\t\tof their current position */\n\n"+
                "\t\t\t\twhile (j >= 0 && arr[j] > key) {\n"+
                "\t\t\t\t\tarr[j + 1] = arr[j];\n"+
                "\t\t\t\t\t\tj = j - 1;\n"+
                "\t\t\t}\n"+
                "\t\t\tarr[j + 1] = key;\n"+
                "\t\t}\n"+
                "\t}\n"+
                "\n\n/* A utility function to print array of size n*/\n"+
                "static void printArray(int arr[])\n"+
                "{\n"+
                "\t\tint n = arr.length;\n"+
                "\t\tfor (int i = 0; i < n; ++i)\n"+
                "\t\t\t\tSystem.out.print(arr[i] + \" \");\n"+
                "\t\t\t\tSystem.out.println();\n"+
                "\t\t}\n"+
                "\nDriver method\n"+
                "public static void main(String args[])\n"+
                "{\n"+
                "\t\tint arr[] = { 12, 11, 13, 5, 6 };\n"+
                "\t\tInsertionSort ob = new InsertionSort();\n"+
                "\t\tob.sort(arr);\n"+
                "\t\tprintArray(arr);\n"+
                "\t}\n"+
                "};\n";
    } // java code

    {
        python_code = "# Python program for implementation of Insertion Sort\n"+

                "\n\n# Function to do insertion sort\n"+
                "def insertionSort(arr):\n"+

                "\n# Traverse through 1 to len(arr)\n"+
                "\t\tfor i in range(1, len(arr)):\n"+

                "\t\tkey = arr[i]\n"+

                "\n# Move elements of arr[0..i-1], that are\n"+
                "# greater than key, to one position ahead\n"+
                "# of their current position\n"+
                "\n\t\tj = i-1\n"+
                "\t\twhile j >= 0 and key < arr[j] :\n"+
                "\t\tarr[j + 1] = arr[j]\n"+
                "\t\tj -= 1\n"+
                "\t\tarr[j + 1] = key\n"+


                "\n# Driver code to test above\n"+
                "\t\tarr = [12, 11, 13, 5, 6]\n"+
                "\t\tinsertionSort(arr)\n"+
                "\t\tfor i in range(len(arr)):\n"+
                "\t\tprint (\"%d\"  %arr[i])";
    } //Python code

}