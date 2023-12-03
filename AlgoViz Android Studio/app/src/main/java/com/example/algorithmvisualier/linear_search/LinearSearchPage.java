package com.example.algorithmvisualier.linear_search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algorithmvisualier.R;
import com.example.algorithmvisualier.selection_sort.SelectionSortVisualise;

public class LinearSearchPage extends AppCompatActivity {
    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_search_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_linear_search);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_linear_search);
        cpp = (Button) findViewById(R.id.btn2_linear_search);
        java = (Button) findViewById(R.id.btn3_linear_search);
        python = (Button) findViewById(R.id.btn4_linear_search);
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
        Intent i = new Intent(this, LinearSearchVisualise.class);
        startActivity(i);
    }


    {c_code="// C code to linearly search x in arr[]. If x\n" +
            "// is present then return its location, otherwise\n" +
            "// return -1\n" +
            "\n" +
            "#include <stdio.h>\n" +
            "\n" +
            "int search(int arr[], int N, int x)\n" +
            "{\n" +
            "\tint i;\n" +
            "\tfor (i = 0; i < N; i++)\n" +
            "\t\tif (arr[i] == x)\n" +
            "\t\t\treturn i;\n" +
            "\treturn -1;\n" +
            "}\n" +
            "\n" +
            "// Driver's code\n" +
            "int main(void)\n" +
            "{\n" +
            "\tint arr[] = { 2, 3, 4, 10, 40 };\n" +
            "\tint x = 10;\n" +
            "\tint N = sizeof(arr) / sizeof(arr[0]);\n" +
            "\n" +
            "\t// Function call\n" +
            "\tint result = search(arr, N, x);\n" +
            "\t(result == -1)\n" +
            "\t\t? printf(\"Element is not present in array\")\n" +
            "\t\t: printf(\"Element is present at index %d\", result);\n" +
            "\treturn 0;\n" +
            "}\n";} // c-code

    {
        cpp_code = "// C++ code to linearly search x in arr[]. If x\n" +
                "// is present then return its location, otherwise\n" +
                "// return -1\n" +
                "\n" +
                "#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int search(int arr[], int N, int x)\n" +
                "{\n" +
                "\tint i;\n" +
                "\tfor (i = 0; i < N; i++)\n" +
                "\t\tif (arr[i] == x)\n" +
                "\t\t\treturn i;\n" +
                "\treturn -1;\n" +
                "}\n" +
                "\n" +
                "// Driver's code\n" +
                "int main(void)\n" +
                "{\n" +
                "\tint arr[] = { 2, 3, 4, 10, 40 };\n" +
                "\tint x = 10;\n" +
                "\tint N = sizeof(arr) / sizeof(arr[0]);\n" +
                "\n" +
                "\t// Function call\n" +
                "\tint result = search(arr, N, x);\n" +
                "\t(result == -1)\n" +
                "\t\t? cout << \"Element is not present in array\"\n" +
                "\t\t: cout << \"Element is present at index \" << result;\n" +
                "\treturn 0;\n" +
                "}\n";} // c++ code

    {
        java_code = "// Java code for linearly searching x in arr[]. If x\n" +
                "// is present then return its location, otherwise\n" +
                "// return -1\n" +
                "\n" +
                "class GFG {\n" +
                "\tpublic static int search(int arr[], int x)\n" +
                "\t{\n" +
                "\t\tint N = arr.length;\n" +
                "\t\tfor (int i = 0; i < N; i++) {\n" +
                "\t\t\tif (arr[i] == x)\n" +
                "\t\t\t\treturn i;\n" +
                "\t\t}\n" +
                "\t\treturn -1;\n" +
                "\t}\n" +
                "\n" +
                "\t// Driver's code\n" +
                "\tpublic static void main(String args[])\n" +
                "\t{\n" +
                "\t\tint arr[] = { 2, 3, 4, 10, 40 };\n" +
                "\t\tint x = 10;\n" +
                "\n" +
                "\t\t// Function call\n" +
                "\t\tint result = search(arr, x);\n" +
                "\t\tif (result == -1)\n" +
                "\t\t\tSystem.out.print(\n" +
                "\t\t\t\t\"Element is not present in array\");\n" +
                "\t\telse\n" +
                "\t\t\tSystem.out.print(\"Element is present at index \"\n" +
                "\t\t\t\t\t\t\t+ result);\n" +
                "\t}\n" +
                "}\n"
        ;} // java code

    {
        python_code = "# Python3 code to linearly search x in arr[].\n" +
                "# If x is present then return its location,\n" +
                "# otherwise return -1\n" +
                "\n" +
                "\n" +
                "def search(arr, N, x):\n" +
                "\n" +
                "\tfor i in range(0, N):\n" +
                "\t\tif (arr[i] == x):\n" +
                "\t\t\treturn i\n" +
                "\treturn -1\n" +
                "\n" +
                "\n" +
                "# Driver Code\n" +
                "if __name__ == \"__main__\":\n" +
                "\tarr = [2, 3, 4, 10, 40]\n" +
                "\tx = 10\n" +
                "\tN = len(arr)\n" +
                "\n" +
                "\t# Function call\n" +
                "\tresult = search(arr, N, x)\n" +
                "\tif(result == -1):\n" +
                "\t\tprint(\"Element is not present in array\")\n" +
                "\telse:\n" +
                "\t\tprint(\"Element is present at index\", result)\n"
        ;} // python code
}