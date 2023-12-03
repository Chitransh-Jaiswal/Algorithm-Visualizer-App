package com.example.algorithmvisualier.selection_sort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algorithmvisualier.R;

public class SelectionSortPage extends AppCompatActivity {
    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_selection_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_selection_sort);
        cpp = (Button) findViewById(R.id.btn2_selection_sort);
        java = (Button) findViewById(R.id.btn3_selection_sort);
        python = (Button) findViewById(R.id.btn4_selection_sort);
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
        Intent i = new Intent(this, SelectionSortVisualise.class);
        startActivity(i);
    }


    {c_code="// C program for implementation of selection sort\n"+
            "#include <stdio.h>\n"+
            "\n"+
            "void swap(int *xp, int *yp)"+
            "{\n"+
            "\tint temp = *xp;\n"+
            "\t*xp = *yp;\n"+
            "\t*yp = temp;\n"+
            "}\n"+
            "\n"+
            "// A function to implement selection sort\n"+
            "void selectionSort(int arr[], int n)\n"+
            "{\n"+
            "\tint i, j, min_idx;\n"+
            "// One by one move boundary of unsorted subarray\n"+
            "\tfor (i = 0; i < n-1; i++)\n"+
            "{\n"+
            "\t\t// Find the minimum element in unsorted array\n"+
            "\t\tmin_idx = i;\n"+
            "\t\tfor (j = i+1; j < n; j++)\n"+
            "\t\t\tif (arr[j] < arr[min_idx])\n"+
            "\t\t\t\tmin_idx = j;\n"+
            "\t\t// Swap the found minimum element with the first element\n"+
            "\t\t\tif(min_idx != i)\n"+
            "\t\t\t\tswap(&arr[min_idx], &arr[i]);\n"+
            "}\n"+
            "}\n"+
            "/* Function to print an array */\n"+
            "void printArray(int arr[], int size)\n"+
            "{\n"+
            "\tint i;\n"+
            "\tfor (i=0; i < size; i++)\n"+
            "\t\tprintf(\"%d \", arr[i]);\n"+
            "\tprintf(\"\\n\");\n"+
            "}\n"+
            "Driver program to test above functions\n"+
            "int main()\n"+
            "{\n"+
            "\tint arr[] = {64, 25, 12, 22, 11};\n"+
            "\tint n = sizeof(arr)/sizeof(arr[0]);\n"+
            "\tselectionSort(arr, n);\n"+
            "\tprintf(\"Sorted array: \\n\");\n"+
            "\tprintArray(arr, n);\n"+
            "\treturn 0;\n"+
            "}\n";} // c-code

    {
        cpp_code = "// C++ program for implementation of\n"+
                "// selection sort\n"+
                "#include <bits/stdc++.h>\n"+
                "using namespace std;\n"+
                "\n"+
                "//Swap function\n"+
                "void swap(int *xp, int *yp)\n"+
                "{\n"+
                "int temp = *xp;\n"+
                "*xp = *yp;\n"+
                "*yp = temp;\n"+
                "}\n"+
                "void selectionSort(int arr[], int n)\n"+
                "{\n"+
                "\tint i, j, min_idx;\n"+
                "\n"+
                "\t\t// One by one move boundary of\n"+
                "\t\t// unsorted subarray\n"+
                "\t\tfor (i = 0; i < n-1; i++)\n"+
                "{\n"+
                "\n"+
                "\t\t// Find the minimum element in\n"+
                "\t\t// unsorted array\n"+
                "\t\tmin_idx = i;\n"+
                "\t\tfor (j = i+1; j < n; j++)\n"+
                "\t\t\tif (arr[j] < arr[min_idx])\n"+
                "\t\t\t\tmin_idx = j;\n"+
                "\t\t// Swap the found minimum element\n"+
                "\t\t// with the first element\n"+
                "\t\tif(min_idx!=i)\n"+
                "\t\t\tswap(&arr[min_idx], &arr[i]);\n"+
                "}\n"+
                "}\n"+
                "//Function to print an array\n"+
                "void printArray(int arr[], int size)\n"+
                "{\n"+
                "\tint i;\n"+
                "\tfor (i=0; i < size; i++)\n"+
                "\t\tcout << arr[i] << \"\";\n"+
                "\tcout << endl;\n"+
                "}\n"+
                "\n"+
                "// Driver program to test above functions\n"+
                "int main()\n"+
                "{\n"+
                "\tint arr[] = {64, 25, 12, 22, 11};\n"+
                "\tint n = sizeof(arr)/sizeof(arr[0]);\n"+
                "\tselectionSort(arr, n);\n"+
                "\tcout << \"Sorted array: \\n\";\n"+
                "\tprintArray(arr, n);\n"+
                "\treturn 0;\n"+
                "}\n";} // c++ code

    {
        java_code = "// Java program for implementation of Selection Sort\n"+
                "class SelectionSort\n"+
                "{\n"+
                "\tvoid sort(int arr[])\n"+
                "{\n"+
                "\tint n = arr.length;\n"+
                "\n"+
                "// One by one move boundary of unsorted subarray\n"+
                "\tfor (int i = 0; i < n-1; i++)\n"+
                "{\n"+
                "// Find the minimum element in unsorted array\n"+
                "\t\tint min_idx = i;\n"+
                "\t\tfor (int j = i+1; j < n; j++)\n"+
                "\t\t\tif (arr[j] < arr[min_idx])\n"+
                "\t\t\t\tmin_idx = j;\n"+
                "\n"+
                "// Swap the found minimum element with the first\n"+
                "// element\n"+
                "\t\tint temp = arr[min_idx];\n"+
                "\t\tarr[min_idx] = arr[i];\n"+
                "\t\tarr[i] = temp;\n"+
                "}\n"+
                "}\n"+
                "\n"+
                "// Prints the array\n"+
                "void printArray(int arr[])\n"+
                "{\n"+
                "\tint n = arr.length;\n"+
                "\tfor (int i=0; i<n; ++i)\n"+
                "\t\tSystem.out.print(arr[i]+\" \");\n"+
                "\tSystem.out.println();\n"+
                "}\n"+
                "\n"+
                "// Driver code to test above\n"+
                "public static void main(String args[])\n"+
                "\t{\n"+
                "\t\tBubbleSortPage.SelectionSort ob = new BubbleSortPage.SelectionSort();\n"+
                "\t\tint arr[] = {64,25,12,22,11};\n"+
                "\t\tob.sort(arr);\n"+
                "\t\tSystem.out.println(\"Sorted array\");\n"+
                "\t\tob.printArray(arr);\n"+
                "\t}\n"+
                "}\n"
        ;} // java code

    {
        python_code = "# Python program for implementation of Selection\n"+
                "# Sort\n"+
                "import sys\n"+
                "A = [64, 25, 12, 22, 11]\n"+
                "\n"+
                "# Traverse through all array elements\n"+
                "for i in range(len(A)):\n"+
                "\n"+
                "# Find the minimum element in remaining\n"+
                "# unsorted array\n"+
                "min_idx = i\n"+
                "for j in range(i+1, len(A)):\n"+
                "if A[min_idx] > A[j]:\n"+
                "min_idx = j\n"+
                "\n"+
                "# Swap the found minimum element with\n"+
                "# the first element\n"+
                "A[i], A[min_idx] = A[min_idx], A[i]\n"+
                "\n"+
                "# Driver code to test above\n"+
                "print (\"Sorted array\")\n"+
                "for i in range(len(A)):"+
                "print(\"%d\" %A[i],end=\" \")"
        ;} // python code
}