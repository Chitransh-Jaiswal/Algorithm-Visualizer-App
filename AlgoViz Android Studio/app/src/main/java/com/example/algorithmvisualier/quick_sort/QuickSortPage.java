package com.example.algorithmvisualier.quick_sort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithmvisualier.R;

public class QuickSortPage extends AppCompatActivity {
    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_quick_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_quick_sort);
        cpp = (Button) findViewById(R.id.btn2_quick_sort);
        java = (Button) findViewById(R.id.btn3_quick_sort);
        python = (Button) findViewById(R.id.btn4_quick_sort);
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
        Intent i = new Intent(this,QuickSortVisualise.class);
        startActivity(i);
    }

    {c_code = "// Quick sort in C\n"+

            "\n#include <stdio.h>\n"+

            "\n// function to swap elements\n"+
            "void swap(int *a, int *b) {\n"+
            "  int t = *a;\n"+
            "  *a = *b;\n"+
            "  *b = t;\n"+
            "}\n"+

            "\n// function to find the partition position\n"+
            "int partition(int array[], int low, int high) {\n"+

            "\n// select the rightmost element as pivot\n"+
            "\t\tint pivot = array[high];\n"+

            "\n\t\t// pointer for greater element\n"+
            "\t\tint i = (low - 1);\n"+

            "\n\t\t// traverse each element of the array\n"+
            "\t\t// compare them with the pivot\n"+
            "\t\tfor (int j = low; j < high; j++) {\n"+
            "\t\tif (array[j] <= pivot) {\n"+

            "\n\t\t// if element smaller than pivot is found\n"+
            "\t\t// swap it with the greater element pointed by i\n"+
            "\t\ti++;\n"+

            "\n// swap element at i with element at j\n"+
            "\t\tswap(&array[i], &array[j]);\n"+
            "\t}\n"+
            "}\n"+

            "\n\t\t// swap the pivot element with the greater element at i\n"+
            "\t\tswap(&array[i + 1], &array[high]);\n"+

            "\t\t// return the partition point\n"+
            "\t\treturn (i + 1);\n"+
            "\t}\n"+

            "\nvoid quickSort(int array[], int low, int high) {\n"+
            "\n\t\tif (low < high) {\n"+
            "\t\t// find the pivot element such that\n"+
            "\t\t// elements smaller than pivot are on left of pivot\n"+
            "\t\t// elements greater than pivot are on right of pivot\n"+
            "\t\tint pi = partition(array, low, high);\n"+

            "\n\t\t// recursive call on the left of pivot\n"+
            "\t\tquickSort(array, low, pi - 1);\n"+

            "\n\t\t// recursive call on the right of pivot\n"+
            "\t\tquickSort(array, pi + 1, high);\n"+
            "\t}\n"+
            "}\n"+

            "\n// function to print array elements\n"+
            "void printArray(int array[], int size) {\n"+
            "\t\tfor (int i = 0; i < size; ++i) {\n"+
            "\t\tprintf(\"%d\", array[i]);\n"+
            "\t}\n"+
            "\t\tprintf(\"\\n\");\n"+
            "}\n"+

            "\n\n// main function\n"+
            "int main() {\n"+
            "\t\tint data[] = {8, 7, 2, 1, 0, 9, 6};\n"+
            "\t\tint n = sizeof(data) / sizeof(data[0]);\n"+
            "\t\tprintf(\"Unsorted Array\\n\");\n"+
            "\t\tprintArray(data, n);\n"+
            "\n\t\t// perform quicksort on data\n"+
            "\t\tquickSort(data, 0, n - 1);\n"+

            "\t\tprintf(\"Sorted array in ascending order: \\n\");\n"+
            "\t\tprintArray(data, n);\n"+
            "}\n";
    } //c-code

    {
        cpp_code = "/* C++ implementation of QuickSort */\n"+
                "\n#include <bits/stdc++.h>\n"+
                "using namespace std;\n"+

                "\n//A utility function to swap two elements\n"+
                "void swap(int* a, int* b)\n"+
                "{\n"+
                "    int t = *a;\n"+
                "    *a = *b;\n"+
                "    *b = t;\n"+
                "}\n"+

                "\n/* This function takes last element as pivot, places\n"+
                "the pivot element at its correct position in sorted\n"+
                "array, and places all smaller (smaller than pivot)\n"+
                "to left of pivot and all greater elements to right\n"+
                "of pivot */\n"+
                "int partition(int arr[], int low, int high)\n"+
                "{\n"+
                "    int pivot = arr[high]; // pivot\n"+
                "    int i =(low+1) // Index of smaller element and indicates\n"+
                "                 // the right position of pivot found so far\n"+

                "    for (int j = low; j <= high - 1; j++) {\n"+
                "        // If current element is smaller than the pivot\n"+
                "        if (arr[j] < pivot) {\n"+
                "            i++; // increment index of smaller element\n"+
                "            swap(&arr[i], &arr[j]);\n"+
                "        }\n"+
                "    }\n"+
                "    swap(&arr[i + 1], &arr[high]);\n"+
                "    return (i + 1);\n"+
                "}\n"+

                "\n\n/* The main function that implements QuickSort\n"+
                "arr[] --> Array to be sorted,\n"+
                "low --> Starting index,\n"+
                "high --> Ending index */\n"+
                "void quickSort(int arr[], int low, int high)\n"+
                "{\n"+
                "    if (low < high) {\n"+
                "        /* pi is partitioning index, arr[p] is now\n"+
                "        at right place */\n"+
                "        int pi = partition(arr, low, high);\n"+

                "        // Separately sort elements before\n"+
                "        // partition and after partition\n"+
                "        quickSort(arr, low, pi - 1);\n"+
                "        quickSort(arr, pi + 1, high);\n"+
                "    }\n"+
                "}\n"+

                "\n/* Function to print an array */\n"+
                "void printArray(int arr[], int size)\n"+
                "{\n"+
                "    int i;\n"+
                "    for (i = 0; i < size; i++)\n"+
                "        cout << arr[i] << \" \";\n"+
                "    cout << endl;\n"+
                "}\n"+

                "// Driver Code\n"+
                "int main()\n"+
                "{\n"+
                "    int arr[] = { 10, 7, 8, 9, 1, 5 };\n"+
                "    int n = sizeof(arr) / sizeof(arr[0]);\n"+
                "    quickSort(arr, 0, n - 1);\n"+
                "    cout << \"Sorted array: \\n\";\n"+
                "    printArray(arr, n);\n"+
                "    return 0;\n"+
                "}";

    } // c++ code

    {
        java_code = "// Java implementation of QuickSort\n"+
                "import java.io.*;\n"+

                "class GFG {\n"+

                "    // A utility function to swap two elements\n"+
                "    static void swap(int[] arr, int i, int j)\n"+
                "    {\n"+
                "        int temp = arr[i];\n"+
                "        arr[i] = arr[j];\n"+
                "        arr[j] = temp;\n"+
                "    }\n"+

                "    /* This function takes last element as pivot, places\n"+
                "       the pivot element at its correct position in sorted\n"+
                "       array, and places all smaller (smaller than pivot)\n"+
                "       to left of pivot and all greater elements to right\n"+
                "       of pivot */\n"+
                "    static int partition(int[] arr, int low, int high)\n"+
                "    {\n"+

                "        // pivot\n"+
                "        int pivot = arr[high];\n"+

                "        // Index of smaller element and\n"+
                "        // indicates the right position\n"+
                "        // of pivot found so far\n"+
                "        int i = (low - 1);\n"+

                "        for (int j = low; j <= high - 1; j++) {\n"+

                "            // If current element is smaller\n"+
                "            // than the pivot\n"+
                "            if (arr[j] < pivot) {\n"+

                "                // Increment index of\n"+
                "                // smaller element\n"+
                "                i++;\n"+
                "                swap(arr, i, j);\n"+
                "            }\n"+
                "        }\n"+
                "        swap(arr, i + 1, high);\n"+
                "        return (i + 1);\n"+
                "    }\n"+

                "    /* The main function that implements QuickSort\n"+
                "              arr[] --> Array to be sorted,\n"+
                "              low --> Starting index,\n"+
                "              high --> Ending index\n"+
                "     */\n"+
                "    static void quickSort(int[] arr, int low, int high)\n"+
                "    {\n"+
                "        if (low < high) {\n"+

                "            // pi is partitioning index, arr[p]\n"+
                "            // is now at right place\n"+
                "            int pi = partition(arr, low, high);\n"+

                "            // Separately sort elements before\n"+
                "            // partition and after partition\n"+
                "            quickSort(arr, low, pi - 1);\n"+
                "            quickSort(arr, pi + 1, high);\n"+
                "        }\n"+
                "    }\n"+

                "    // Function to print an array\n"+
                "    static void printArray(int[] arr, int size)\n"+
                "    {\n"+
                "        for (int i = 0; i < size; i++)\n"+
                "            System.out.print(arr[i] + \" \");\n"+

                "        System.out.println();\n"+
                "    }\n"+

                "    // Driver Code\n"+
                "    public static void main(String[] args)\n"+
                "    {\n"+
                "        int[] arr = { 10, 7, 8, 9, 1, 5 };\n"+
                "        int n = arr.length;\n"+

                "        quickSort(arr, 0, n - 1);\n"+
                "        System.out.println(\"Sorted array: \");\n"+
                "        printArray(arr, n);\n"+
                "    }\n"+
                "}\n";
    } // java code

    {
        python_code = "# Python3 implementation of QuickSort\n"+


                "\n# Function to find the partition position\n"+
                "def partition(array, low, high):\n"+

                "    \n# Choose the rightmost element as pivot\n"+
                "    pivot = array[high]\n"+

                "    \n# Pointer for greater element\n"+
                "    i = low - 1\n"+

                "    \n# Traverse through all elements\n"+
                "    # compare each element with pivot\n"+
                "    for j in range(low, high):\n"+
                "        if array[j] <= pivot:"+
                "            \n# If element smaller than pivot is found\n"+
                "            # swap it with the greater element pointed by i\n"+
                "            i = i + 1\n"+

                "            \n# Swapping element at i with element at j\n"+
                "            (array[i], array[j]) = (array[j], array[i])\n"+

                "    \n# Swap the pivot element with \n"+
                "    # e greater element specified by i\n"+
                "    (array[i + 1], array[high]) = (array[high], array[i + 1])\n"+

                "    \n# Return the position from where partition is done\n"+
                "    return i + 1\n"+

                "\n# Function to perform quicksort\n"+


                "def quick_sort(array, low, high):\n"+
                "    if low < high:\n"+

                "        \n# Find pivot element such that\n"+
                "        # element smaller than pivot are on the left\n"+
                "        # element greater than pivot are on the right\n"+
                "        pi = partition(array, low, high)\n"+

                "        \n# Recursive call on the left of pivot\n"+
                "        quick_sort(array, low, pi - 1)\n"+

                "        \n# Recursive call on the right of pivot\n"+
                "        quick_sort(array, pi + 1, high)\n"+


                "\n# Driver code\n"+
                "array = [10, 7, 8, 9, 1, 5]\n"+
                "quick_sort(array, 0, len(array) - 1)\n"+

                "print(f'Sorted array: {array}')\n";
    } //Python code

}