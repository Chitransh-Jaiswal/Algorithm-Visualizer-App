package com.example.algorithmvisualier.bubble_sort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algorithmvisualier.R;

public class BubbleSortPage extends AppCompatActivity {

    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_bubble_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_bubble_sort);
        cpp = (Button) findViewById(R.id.btn2_bubble_sort);
        java = (Button) findViewById(R.id.btn3_bubble_sort);
        python = (Button) findViewById(R.id.btn4_bubble_sort);
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
        Intent i = new Intent(this, BubbleSortVisualise.class);
        startActivity(i);
    }

    {c_code = "// C program for implementation of Bubble sort\n" +
            "#include <stdio.h>\n" +
            "\n" +
            "void swap(int* xp, int* yp)\n" +
            "{\n" +
            "\tint temp = *xp;\n" +
            "\t*xp = *yp;\n" +
            "\t*yp = temp;\n" +
            "}\n" +
            "\n" +
            "// A function to implement bubble sort\n" +
            "void bubbleSort(int arr[], int n)\n" +
            "{\n" +
            "\tint i, j;\n" +
            "\tfor (i = 0; i < n - 1; i++)\n" +
            "\n" +
            "\t\t// Last i elements are already in place\n" +
            "\t\tfor (j = 0; j < n - i - 1; j++)\n" +
            "\t\t\tif (arr[j] > arr[j + 1])\n" +
            "\t\t\t\tswap(&arr[j], &arr[j + 1]);\n" +
            "}\n" +
            "\n" +
            "/* Function to print an array */\n" +
            "void printArray(int arr[], int size)\n" +
            "{\n" +
            "\tint i;\n" +
            "\tfor (i = 0; i < size; i++)\n" +
            "\t\tprintf(\"%d \", arr[i]);\n" +
            "\tprintf(\"\\n\");\n" +
            "}\n" +
            "\n" +
            "// Driver program to test above functions\n" +
            "int main()\n" +
            "{\n" +
            "\tint arr[] = { 5, 1, 4, 2, 8 };\n" +
            "\tint n = sizeof(arr) / sizeof(arr[0]);\n" +
            "\tbubbleSort(arr, n);\n" +
            "\tprintf(\"Sorted array: \\n\");\n" +
            "\tprintArray(arr, n);\n" +
            "\treturn 0;\n" +
            "}\n";} //c-code

    {
        cpp_code = "// C++ program for implementation\n" +
                "// of Bubble sort\n" +
                "#include <bits/stdc++.h>\n" +
                "using namespace std;\n" +
                "\n" +
                "// A function to implement bubble sort\n" +
                "void bubbleSort(int arr[], int n)\n" +
                "{\n" +
                "\tint i, j;\n" +
                "\tfor (i = 0; i < n - 1; i++)\n" +
                "\n" +
                "\t\t// Last i elements are already\n" +
                "\t\t// in place\n" +
                "\t\tfor (j = 0; j < n - i - 1; j++)\n" +
                "\t\t\tif (arr[j] > arr[j + 1])\n" +
                "\t\t\t\tswap(arr[j], arr[j + 1]);\n" +
                "}\n" +
                "\n" +
                "// Function to print an array\n" +
                "void printArray(int arr[], int size)\n" +
                "{\n" +
                "\tint i;\n" +
                "\tfor (i = 0; i < size; i++)\n" +
                "\t\tcout << arr[i] << \" \";\n" +
                "\tcout << endl;\n" +
                "}\n" +
                "\n" +
                "// Driver code\n" +
                "int main()\n" +
                "{\n" +
                "\tint arr[] = { 5, 1, 4, 2, 8};\n" +
                "\tint N = sizeof(arr) / sizeof(arr[0]);\n" +
                "\tbubbleSort(arr, N);\n" +
                "\tcout << \"Sorted array: \\n\";\n" +
                "\tprintArray(arr, N);\n" +
                "\treturn 0;\n" +
                "}\n" +
                "// This code is contributed by rathbhupendra\n";
    } // c++ code

    {
        java_code = "// Java program for implementation of Bubble Sort\n" +
                "import java.util.*;\n" +
                "\n" +
                "class BubbleSort {\n" +
                "\tvoid bubbleSort(int arr[])\n" +
                "\t{\n" +
                "\t\tint n = arr.length;\n" +
                "\t\tfor (int i = 0; i < n - 1; i++)\n" +
                "\t\t\tfor (int j = 0; j < n - i - 1; j++)\n" +
                "\t\t\t\tif (arr[j] > arr[j + 1]) {\n" +
                "\t\t\t\t\t// swap arr[j+1] and arr[j]\n" +
                "\t\t\t\t\tint temp = arr[j];\n" +
                "\t\t\t\t\tarr[j] = arr[j + 1];\n" +
                "\t\t\t\t\tarr[j + 1] = temp;\n" +
                "\t\t\t\t}\n" +
                "\t}\n" +
                "\n" +
                "\t/* Prints the array */\n" +
                "\tvoid printArray(int arr[])\n" +
                "\t{\n" +
                "\t\tint n = arr.length;\n" +
                "\t\tfor (int i = 0; i < n; ++i)\n" +
                "\t\t\tSystem.out.print(arr[i] + \" \");\n" +
                "\t\tSystem.out.println();\n" +
                "\t}\n" +
                "\n" +
                "\t// Driver method to test above\n" +
                "\tpublic static void main(String args[])\n" +
                "\t{\n" +
                "\t\tBubbleSort ob = new BubbleSort();\n" +
                "\t\tint arr[] = { 5, 1, 4, 2, 8 };\n" +
                "\t\tob.bubbleSort(arr);\n" +
                "\t\tSystem.out.println(\"Sorted array\");\n" +
                "\t\tob.printArray(arr);\n" +
                "\t}\n" +
                "}\n" +
                "/* This code is contributed by Rajat Mishra */\n";
    } // java code

    {
        python_code = "# Python program for implementation of Bubble Sort\n" +
                "\n" +
                "\n" +
                "def bubbleSort(arr):\n" +
                "\tn = len(arr)\n" +
                "\n" +
                "\t# Traverse through all array elements\n" +
                "\tfor i in range(n):\n" +
                "\n" +
                "\t\t# Last i elements are already in place\n" +
                "\t\tfor j in range(0, n-i-1):\n" +
                "\n" +
                "\t\t\t# traverse the array from 0 to n-i-1\n" +
                "\t\t\t# Swap if the element found is greater\n" +
                "\t\t\t# than the next element\n" +
                "\t\t\tif arr[j] > arr[j+1]:\n" +
                "\t\t\t\tarr[j], arr[j+1] = arr[j+1], arr[j]\n" +
                "\n" +
                "\n" +
                "# Driver code to test above\n" +
                "if __name__ == \"__main__\":\n" +
                "arr = [5, 1, 4, 2, 8]\n" +
                "\n" +
                "bubbleSort(arr)\n" +
                "\n" +
                "print(\"Sorted array is:\")\n" +
                "for i in range(len(arr)):\n" +
                "\tprint(\"%d\" % arr[i], end=\" \")\n";
    } //Python code

}