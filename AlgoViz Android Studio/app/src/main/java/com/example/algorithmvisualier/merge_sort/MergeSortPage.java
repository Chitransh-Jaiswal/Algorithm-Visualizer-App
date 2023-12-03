package com.example.algorithmvisualier.merge_sort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algorithmvisualier.R;
import com.example.algorithmvisualier.bubble_sort.BubbleSortVisualise;

public class MergeSortPage extends AppCompatActivity {

    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_merge_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_merge_sort);
        cpp = (Button) findViewById(R.id.btn2_merge_sort);
        java = (Button) findViewById(R.id.btn3_merge_sort);
        python = (Button) findViewById(R.id.btn4_merge_sort);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
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
        Intent i = new Intent(this, MergeSortVisualise.class);
        startActivity(i);
    }


    {c_code = " /* C program for Merge Sort */\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// Merges two subarrays of arr[].\n" +
            "// First subarray is arr[l..m]\n" +
            "// Second subarray is arr[m+1..r]\n" +
            "void merge(int arr[], int l, int m, int r)\n" +
            "{\n" +
            "\tint i, j, k;\n" +
            "\tint n1 = m - l + 1;\n" +
            "\tint n2 = r - m;\n" +
            "\n" +
            "\t/* create temp arrays */\n" +
            "\tint L[n1], R[n2];\n" +
            "\n" +
            "\t/* Copy data to temp arrays L[] and R[] */\n" +
            "\tfor (i = 0; i < n1; i++)\n" +
            "\t\tL[i] = arr[l + i];\n" +
            "\tfor (j = 0; j < n2; j++)\n" +
            "\t\tR[j] = arr[m + 1 + j];\n" +
            "\n" +
            "\t/* Merge the temp arrays back into arr[l..r]*/\n" +
            "\ti = 0; // Initial index of first subarray\n" +
            "\tj = 0; // Initial index of second subarray\n" +
            "\tk = l; // Initial index of merged subarray\n" +
            "\twhile (i < n1 && j < n2) {\n" +
            "\t\tif (L[i] <= R[j]) {\n" +
            "\t\t\tarr[k] = L[i];\n" +
            "\t\t\ti++;\n" +
            "\t\t}\n" +
            "\t\telse {\n" +
            "\t\t\tarr[k] = R[j];\n" +
            "\t\t\tj++;\n" +
            "\t\t}\n" +
            "\t\tk++;\n" +
            "\t}\n" +
            "\n" +
            "\t/* Copy the remaining elements of L[], if there\n" +
            "\tare any */\n" +
            "\twhile (i < n1) {\n" +
            "\t\tarr[k] = L[i];\n" +
            "\t\ti++;\n" +
            "\t\tk++;\n" +
            "\t}\n" +
            "\n" +
            "\t/* Copy the remaining elements of R[], if there\n" +
            "\tare any */\n" +
            "\twhile (j < n2) {\n" +
            "\t\tarr[k] = R[j];\n" +
            "\t\tj++;\n" +
            "\t\tk++;\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "/* l is for left index and r is right index of the\n" +
            "sub-array of arr to be sorted */\n" +
            "void mergeSort(int arr[], int l, int r)\n" +
            "{\n" +
            "\tif (l < r) {\n" +
            "\t\t// Same as (l+r)/2, but avoids overflow for\n" +
            "\t\t// large l and h\n" +
            "\t\tint m = l + (r - l) / 2;\n" +
            "\n" +
            "\t\t// Sort first and second halves\n" +
            "\t\tmergeSort(arr, l, m);\n" +
            "\t\tmergeSort(arr, m + 1, r);\n" +
            "\n" +
            "\t\tmerge(arr, l, m, r);\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "/* UTILITY FUNCTIONS */\n" +
            "/* Function to print an array */\n" +
            "void printArray(int A[], int size)\n" +
            "{\n" +
            "\tint i;\n" +
            "\tfor (i = 0; i < size; i++)\n" +
            "\t\tprintf(\"%d \", A[i]);\n" +
            "\tprintf(\"\\n\");\n" +
            "}\n" +
            "\n" +
            "/* Driver code */\n" +
            "int main()\n" +
            "{\n" +
            "\tint arr[] = { 12, 11, 13, 5, 6, 7 };\n" +
            "\tint arr_size = sizeof(arr) / sizeof(arr[0]);\n" +
            "\n" +
            "\tprintf(\"Given array is \\n\");\n" +
            "\tprintArray(arr, arr_size);\n" +
            "\n" +
            "\tmergeSort(arr, 0, arr_size - 1);\n" +
            "\n" +
            "\tprintf(\"\\nSorted array is \\n\");\n" +
            "\tprintArray(arr, arr_size);\n" +
            "\treturn 0;\n" +
            "}\n";} //c-code

    {
        cpp_code = "// C++ program for Merge Sort\n" +
                "#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "// Merges two subarrays of array[].\n" +
                "// First subarray is arr[begin..mid]\n" +
                "// Second subarray is arr[mid+1..end]\n" +
                "void merge(int array[], int const left, int const mid,\n" +
                "\t\tint const right)\n" +
                "{\n" +
                "\tauto const subArrayOne = mid - left + 1;\n" +
                "\tauto const subArrayTwo = right - mid;\n" +
                "\n" +
                "\t// Create temp arrays\n" +
                "\tauto *leftArray = new int[subArrayOne],\n" +
                "\t\t*rightArray = new int[subArrayTwo];\n" +
                "\n" +
                "\t// Copy data to temp arrays leftArray[] and rightArray[]\n" +
                "\tfor (auto i = 0; i < subArrayOne; i++)\n" +
                "\t\tleftArray[i] = array[left + i];\n" +
                "\tfor (auto j = 0; j < subArrayTwo; j++)\n" +
                "\t\trightArray[j] = array[mid + 1 + j];\n" +
                "\n" +
                "\tauto indexOfSubArrayOne\n" +
                "\t\t= 0, // Initial index of first sub-array\n" +
                "\t\tindexOfSubArrayTwo\n" +
                "\t\t= 0; // Initial index of second sub-array\n" +
                "\tint indexOfMergedArray\n" +
                "\t\t= left; // Initial index of merged array\n" +
                "\n" +
                "\t// Merge the temp arrays back into array[left..right]\n" +
                "\twhile (indexOfSubArrayOne < subArrayOne\n" +
                "\t\t&& indexOfSubArrayTwo < subArrayTwo) {\n" +
                "\t\tif (leftArray[indexOfSubArrayOne]\n" +
                "\t\t\t<= rightArray[indexOfSubArrayTwo]) {\n" +
                "\t\t\tarray[indexOfMergedArray]\n" +
                "\t\t\t\t= leftArray[indexOfSubArrayOne];\n" +
                "\t\t\tindexOfSubArrayOne++;\n" +
                "\t\t}\n" +
                "\t\telse {\n" +
                "\t\t\tarray[indexOfMergedArray]\n" +
                "\t\t\t\t= rightArray[indexOfSubArrayTwo];\n" +
                "\t\t\tindexOfSubArrayTwo++;\n" +
                "\t\t}\n" +
                "\t\tindexOfMergedArray++;\n" +
                "\t}\n" +
                "\t// Copy the remaining elements of\n" +
                "\t// left[], if there are any\n" +
                "\twhile (indexOfSubArrayOne < subArrayOne) {\n" +
                "\t\tarray[indexOfMergedArray]\n" +
                "\t\t\t= leftArray[indexOfSubArrayOne];\n" +
                "\t\tindexOfSubArrayOne++;\n" +
                "\t\tindexOfMergedArray++;\n" +
                "\t}\n" +
                "\t// Copy the remaining elements of\n" +
                "\t// right[], if there are any\n" +
                "\twhile (indexOfSubArrayTwo < subArrayTwo) {\n" +
                "\t\tarray[indexOfMergedArray]\n" +
                "\t\t\t= rightArray[indexOfSubArrayTwo];\n" +
                "\t\tindexOfSubArrayTwo++;\n" +
                "\t\tindexOfMergedArray++;\n" +
                "\t}\n" +
                "\tdelete[] leftArray;\n" +
                "\tdelete[] rightArray;\n" +
                "}\n" +
                "\n" +
                "// begin is for left index and end is\n" +
                "// right index of the sub-array\n" +
                "// of arr to be sorted */\n" +
                "void mergeSort(int array[], int const begin, int const end)\n" +
                "{\n" +
                "\tif (begin >= end)\n" +
                "\t\treturn; // Returns recursively\n" +
                "\n" +
                "\tauto mid = begin + (end - begin) / 2;\n" +
                "\tmergeSort(array, begin, mid);\n" +
                "\tmergeSort(array, mid + 1, end);\n" +
                "\tmerge(array, begin, mid, end);\n" +
                "}\n" +
                "\n" +
                "// UTILITY FUNCTIONS\n" +
                "// Function to print an array\n" +
                "void printArray(int A[], int size)\n" +
                "{\n" +
                "\tfor (auto i = 0; i < size; i++)\n" +
                "\t\tcout << A[i] << \" \";\n" +
                "}\n" +
                "\n" +
                "// Driver code\n" +
                "int main()\n" +
                "{\n" +
                "\tint arr[] = { 12, 11, 13, 5, 6, 7 };\n" +
                "\tauto arr_size = sizeof(arr) / sizeof(arr[0]);\n" +
                "\n" +
                "\tcout << \"Given array is \\n\";\n" +
                "\tprintArray(arr, arr_size);\n" +
                "\n" +
                "\tmergeSort(arr, 0, arr_size - 1);\n" +
                "\n" +
                "\tcout << \"\\nSorted array is \\n\";\n" +
                "\tprintArray(arr, arr_size);\n" +
                "\treturn 0;\n" +
                "}\n" +
                "\n" +
                "// This code is contributed by Mayank Tyagi\n" +
                "// This code was revised by Joshua Estes\n";
    } // c++ code

    {
        java_code = "/* Java program for Merge Sort */\n" +
                "class MergeSort {\n" +
                "\t// Merges two subarrays of arr[].\n" +
                "\t// First subarray is arr[l..m]\n" +
                "\t// Second subarray is arr[m+1..r]\n" +
                "\tvoid merge(int arr[], int l, int m, int r)\n" +
                "\t{\n" +
                "\t\t// Find sizes of two subarrays to be merged\n" +
                "\t\tint n1 = m - l + 1;\n" +
                "\t\tint n2 = r - m;\n" +
                "\n" +
                "\t\t/* Create temp arrays */\n" +
                "\t\tint L[] = new int[n1];\n" +
                "\t\tint R[] = new int[n2];\n" +
                "\n" +
                "\t\t/*Copy data to temp arrays*/\n" +
                "\t\tfor (int i = 0; i < n1; ++i)\n" +
                "\t\t\tL[i] = arr[l + i];\n" +
                "\t\tfor (int j = 0; j < n2; ++j)\n" +
                "\t\t\tR[j] = arr[m + 1 + j];\n" +
                "\n" +
                "\t\t/* Merge the temp arrays */\n" +
                "\n" +
                "\t\t// Initial indexes of first and second subarrays\n" +
                "\t\tint i = 0, j = 0;\n" +
                "\n" +
                "\t\t// Initial index of merged subarray array\n" +
                "\t\tint k = l;\n" +
                "\t\twhile (i < n1 && j < n2) {\n" +
                "\t\t\tif (L[i] <= R[j]) {\n" +
                "\t\t\t\tarr[k] = L[i];\n" +
                "\t\t\t\ti++;\n" +
                "\t\t\t}\n" +
                "\t\t\telse {\n" +
                "\t\t\t\tarr[k] = R[j];\n" +
                "\t\t\t\tj++;\n" +
                "\t\t\t}\n" +
                "\t\t\tk++;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* Copy remaining elements of L[] if any */\n" +
                "\t\twhile (i < n1) {\n" +
                "\t\t\tarr[k] = L[i];\n" +
                "\t\t\ti++;\n" +
                "\t\t\tk++;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* Copy remaining elements of R[] if any */\n" +
                "\t\twhile (j < n2) {\n" +
                "\t\t\tarr[k] = R[j];\n" +
                "\t\t\tj++;\n" +
                "\t\t\tk++;\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\n" +
                "\t// Main function that sorts arr[l..r] using\n" +
                "\t// merge()\n" +
                "\tvoid sort(int arr[], int l, int r)\n" +
                "\t{\n" +
                "\t\tif (l < r) {\n" +
                "\t\t\t// Find the middle point\n" +
                "\t\t\tint m = l + (r - l) / 2;\n" +
                "\n" +
                "\t\t\t// Sort first and second halves\n" +
                "\t\t\tsort(arr, l, m);\n" +
                "\t\t\tsort(arr, m + 1, r);\n" +
                "\n" +
                "\t\t\t// Merge the sorted halves\n" +
                "\t\t\tmerge(arr, l, m, r);\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\n" +
                "\t/* A utility function to print array of size n */\n" +
                "\tstatic void printArray(int arr[])\n" +
                "\t{\n" +
                "\t\tint n = arr.length;\n" +
                "\t\tfor (int i = 0; i < n; ++i)\n" +
                "\t\t\tSystem.out.print(arr[i] + \" \");\n" +
                "\t\tSystem.out.println();\n" +
                "\t}\n" +
                "\n" +
                "\t// Driver code\n" +
                "\tpublic static void main(String args[])\n" +
                "\t{\n" +
                "\t\tint arr[] = { 12, 11, 13, 5, 6, 7 };\n" +
                "\n" +
                "\t\tSystem.out.println(\"Given Array\");\n" +
                "\t\tprintArray(arr);\n" +
                "\n" +
                "\t\tMergeSort ob = new MergeSort();\n" +
                "\t\tob.sort(arr, 0, arr.length - 1);\n" +
                "\n" +
                "\t\tSystem.out.println(\"\\nSorted array\");\n" +
                "\t\tprintArray(arr);\n" +
                "\t}\n" +
                "}\n" +
                "/* This code is contributed by Rajat Mishra */\n";
    } // java code

    {
        python_code = "# Python program for implementation of MergeSort\n" +
                "def mergeSort(arr):\n" +
                "\tif len(arr) > 1:\n" +
                "\n" +
                "\t\t# Finding the mid of the array\n" +
                "\t\tmid = len(arr)//2\n" +
                "\n" +
                "\t\t# Dividing the array elements\n" +
                "\t\tL = arr[:mid]\n" +
                "\n" +
                "\t\t# into 2 halves\n" +
                "\t\tR = arr[mid:]\n" +
                "\n" +
                "\t\t# Sorting the first half\n" +
                "\t\tmergeSort(L)\n" +
                "\n" +
                "\t\t# Sorting the second half\n" +
                "\t\tmergeSort(R)\n" +
                "\n" +
                "\t\ti = j = k = 0\n" +
                "\n" +
                "\t\t# Copy data to temp arrays L[] and R[]\n" +
                "\t\twhile i < len(L) and j < len(R):\n" +
                "\t\t\tif L[i] <= R[j]:\n" +
                "\t\t\t\tarr[k] = L[i]\n" +
                "\t\t\t\ti += 1\n" +
                "\t\t\telse:\n" +
                "\t\t\t\tarr[k] = R[j]\n" +
                "\t\t\t\tj += 1\n" +
                "\t\t\tk += 1\n" +
                "\n" +
                "\t\t# Checking if any element was left\n" +
                "\t\twhile i < len(L):\n" +
                "\t\t\tarr[k] = L[i]\n" +
                "\t\t\ti += 1\n" +
                "\t\t\tk += 1\n" +
                "\n" +
                "\t\twhile j < len(R):\n" +
                "\t\t\tarr[k] = R[j]\n" +
                "\t\t\tj += 1\n" +
                "\t\t\tk += 1\n" +
                "\n" +
                "# Code to print the list\n" +
                "\n" +
                "\n" +
                "def printList(arr):\n" +
                "\tfor i in range(len(arr)):\n" +
                "\t\tprint(arr[i], end=\" \")\n" +
                "\tprint()\n" +
                "\n" +
                "\n" +
                "# Driver Code\n" +
                "if __name__ == '__main__':\n" +
                "\tarr = [12, 11, 13, 5, 6, 7]\n" +
                "\tprint(\"Given array is\", end=\"\\n\")\n" +
                "\tprintList(arr)\n" +
                "\tmergeSort(arr)\n" +
                "\tprint(\"Sorted array is: \", end=\"\\n\")\n" +
                "\tprintList(arr)\n" +
                "\n" +
                "# This code is contributed by Mayank Khanna\n";
    } //Python code

}