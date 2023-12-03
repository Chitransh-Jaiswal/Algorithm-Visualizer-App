package com.example.algorithmvisualier.binary_search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algorithmvisualier.R;

public class BinarySearchPage extends AppCompatActivity {
    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_binary_search);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_binary_search);
        cpp = (Button) findViewById(R.id.btn2_binary_search);
        java = (Button) findViewById(R.id.btn3_binary_search);
        python = (Button) findViewById(R.id.btn4_binary_search);
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
        Intent i = new Intent(this, BinarySearchVisualise.class);
        startActivity(i);
    }


    {c_code="// C program to implement iterative Binary Search\n" +
            "#include <stdio.h>\n" +
            "\n" +
            "// A iterative binary search function. It returns\n" +
            "// location of x in given array arr[l..r] if present,\n" +
            "// otherwise -1\n" +
            "int binarySearch(int arr[], int l, int r, int x)\n" +
            "{\n" +
            "\twhile (l <= r) {\n" +
            "\t\tint m = l + (r - l) / 2;\n" +
            "\n" +
            "\t\t// Check if x is present at mid\n" +
            "\t\tif (arr[m] == x)\n" +
            "\t\t\treturn m;\n" +
            "\n" +
            "\t\t// If x greater, ignore left half\n" +
            "\t\tif (arr[m] < x)\n" +
            "\t\t\tl = m + 1;\n" +
            "\n" +
            "\t\t// If x is smaller, ignore right half\n" +
            "\t\telse\n" +
            "\t\t\tr = m - 1;\n" +
            "\t}\n" +
            "\n" +
            "\t// if we reach here, then element was\n" +
            "\t// not present\n" +
            "\treturn -1;\n" +
            "}\n" +
            "\n" +
            "int main(void)\n" +
            "{\n" +
            "\tint arr[] = { 2, 3, 4, 10, 40 };\n" +
            "\tint n = sizeof(arr) / sizeof(arr[0]);\n" +
            "\tint x = 10;\n" +
            "\tint result = binarySearch(arr, 0, n - 1, x);\n" +
            "\t(result == -1) ? printf(\"Element is not present\"\n" +
            "\t\t\t\t\t\t\t\" in array\")\n" +
            "\t\t\t\t: printf(\"Element is present at \"\n" +
            "\t\t\t\t\t\t\t\"index %d\",\n" +
            "\t\t\t\t\t\t\tresult);\n" +
            "\treturn 0;\n" +
            "}\n";} // c-code

    {
        cpp_code = "// C++ program to implement iterative Binary Search\n" +
                "#include <bits/stdc++.h>\n" +
                "using namespace std;\n" +
                "\n" +
                "// A iterative binary search function. It returns\n" +
                "// location of x in given array arr[l..r] if present,\n" +
                "// otherwise -1\n" +
                "int binarySearch(int arr[], int l, int r, int x)\n" +
                "{\n" +
                "\twhile (l <= r) {\n" +
                "\t\tint m = l + (r - l) / 2;\n" +
                "\n" +
                "\t\t// Check if x is present at mid\n" +
                "\t\tif (arr[m] == x)\n" +
                "\t\t\treturn m;\n" +
                "\n" +
                "\t\t// If x greater, ignore left half\n" +
                "\t\tif (arr[m] < x)\n" +
                "\t\t\tl = m + 1;\n" +
                "\n" +
                "\t\t// If x is smaller, ignore right half\n" +
                "\t\telse\n" +
                "\t\t\tr = m - 1;\n" +
                "\t}\n" +
                "\n" +
                "\t// if we reach here, then element was\n" +
                "\t// not present\n" +
                "\treturn -1;\n" +
                "}\n" +
                "\n" +
                "int main(void)\n" +
                "{\n" +
                "\tint arr[] = { 2, 3, 4, 10, 40 };\n" +
                "\tint x = 10;\n" +
                "\tint n = sizeof(arr) / sizeof(arr[0]);\n" +
                "\tint result = binarySearch(arr, 0, n - 1, x);\n" +
                "\t(result == -1)\n" +
                "\t\t? cout << \"Element is not present in array\"\n" +
                "\t\t: cout << \"Element is present at index \" << result;\n" +
                "\treturn 0;\n" +
                "}\n";} // c++ code

    {
        java_code = "// Java implementation of iterative Binary Search\n" +
                "class BinarySearch {\n" +
                "\t// Returns index of x if it is present in arr[],\n" +
                "\t// else return -1\n" +
                "\tint binarySearch(int arr[], int x)\n" +
                "\t{\n" +
                "\t\tint l = 0, r = arr.length - 1;\n" +
                "\t\twhile (l <= r) {\n" +
                "\t\t\tint m = l + (r - l) / 2;\n" +
                "\n" +
                "\t\t\t// Check if x is present at mid\n" +
                "\t\t\tif (arr[m] == x)\n" +
                "\t\t\t\treturn m;\n" +
                "\n" +
                "\t\t\t// If x greater, ignore left half\n" +
                "\t\t\tif (arr[m] < x)\n" +
                "\t\t\t\tl = m + 1;\n" +
                "\n" +
                "\t\t\t// If x is smaller, ignore right half\n" +
                "\t\t\telse\n" +
                "\t\t\t\tr = m - 1;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t// if we reach here, then element was\n" +
                "\t\t// not present\n" +
                "\t\treturn -1;\n" +
                "\t}\n" +
                "\n" +
                "\t// Driver method to test above\n" +
                "\tpublic static void main(String args[])\n" +
                "\t{\n" +
                "\t\tBinarySearch ob = new BinarySearch();\n" +
                "\t\tint arr[] = { 2, 3, 4, 10, 40 };\n" +
                "\t\tint n = arr.length;\n" +
                "\t\tint x = 10;\n" +
                "\t\tint result = ob.binarySearch(arr, x);\n" +
                "\t\tif (result == -1)\n" +
                "\t\t\tSystem.out.println(\"Element not present\");\n" +
                "\t\telse\n" +
                "\t\t\tSystem.out.println(\"Element found at \"\n" +
                "\t\t\t\t\t\t\t+ \"index \" + result);\n" +
                "\t}\n" +
                "}\n"
        ;} // java code

    {
        python_code = "# Python3 code to implement iterative Binary\n" +
                "# Search.\n" +
                "\n" +
                "# It returns location of x in given array arr\n" +
                "# if present, else returns -1\n" +
                "\n" +
                "\n" +
                "def binarySearch(arr, l, r, x):\n" +
                "\n" +
                "\twhile l <= r:\n" +
                "\n" +
                "\t\tmid = l + (r - l) // 2\n" +
                "\n" +
                "\t\t# Check if x is present at mid\n" +
                "\t\tif arr[mid] == x:\n" +
                "\t\t\treturn mid\n" +
                "\n" +
                "\t\t# If x is greater, ignore left half\n" +
                "\t\telif arr[mid] < x:\n" +
                "\t\t\tl = mid + 1\n" +
                "\n" +
                "\t\t# If x is smaller, ignore right half\n" +
                "\t\telse:\n" +
                "\t\t\tr = mid - 1\n" +
                "\n" +
                "\t# If we reach here, then the element\n" +
                "\t# was not present\n" +
                "\treturn -1\n" +
                "\n" +
                "\n" +
                "# Driver Code\n" +
                "arr = [2, 3, 4, 10, 40]\n" +
                "x = 10\n" +
                "\n" +
                "# Function call\n" +
                "result = binarySearch(arr, 0, len(arr)-1, x)\n" +
                "\n" +
                "if result != -1:\n" +
                "\tprint(\"Element is present at index % d\" % result)\n" +
                "else:\n" +
                "\tprint(\"Element is not present in array\")\n"
        ;} // python code
}