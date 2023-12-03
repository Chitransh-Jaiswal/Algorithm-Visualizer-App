package com.example.algorithmvisualier.shell_sort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithmvisualier.R;

public class ShellSortPage extends AppCompatActivity {

    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_shell_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_shell_sort);
        cpp = (Button) findViewById(R.id.btn2_shell_sort);
        java = (Button) findViewById(R.id.btn3_shell_sort);
        python = (Button) findViewById(R.id.btn4_shell_sort);
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
        Intent i = new Intent(this, ShellSortVisualise.class);
        startActivity(i);
    }

    {c_code="// C program for implementation of shell sort\n"+
            "#include <stdio.h>\n"+
            "#include <stdbool.h>\n"+
            "#define MAX 7\n"+
            "int intArray[MAX] = {4,6,3,2,1,9,7};\n"+
            "\n"+
            "void printline(int count) {\n"+
            "\tint i;\n"+
            "\tfor(i = 0;i < count-1;i++) {\n"+
            "\t\tprintf(\"=\");\n"+
            "\t}\n"+
            "printf(\"=\\n\");\n"+
            "}\n"+
            "void display() {\n"+
            "\tint i;\n"+
            "\tprintf(\"[\");\n"+
            "\t// navigate through all items\n"+
            "\tfor(i = 0;i < MAX;i++) {\n"+
            "\t\tprintf(\"%d \",intArray[i]);\n"+
            "\t}\n"+
            "\tprintf(\"]\\n\");\n"+
            "}\n"+
            "\n"+
            "void shellSort() {\n"+
            "\tint inner, outer;\n"+
            "\tint valueToInsert;\n"+
            "\tint interval = 1;\n"+
            "\tint elements = MAX;\n"+
            "\tint i = 0;\n"+
            "\twhile(interval <= elements/3) {\n"+
            "\t\tinterval = interval*3 +1;\n"+
            "\t}\n"+
            "\twhile(interval > 0) {\n"+
            "\t\tprintf(\"iteration %d#:\",i);\n"+
            "\t\tdisplay();\n"+
            "\t\tfor(outer = interval; outer < elements; outer++) {\n"+
            "\t\t\tvalueToInsert = intArray[outer];\n"+
            "\t\t\tinner = outer;\n"+
            "\t\t\twhile(inner > interval -1 && intArray[inner - interval]>= valueToInsert) {\n" +
            "\t\t\t\tintArray[inner] = intArray[inner - interval];\n"+
            "\t\t\t\tinner -=interval;\n"+
            "\t\t\t\tprintf(\" item moved :%d\\n\",intArray[inner]);\n"+
            "\t\t\t}\n"+
            "\t\t\tintArray[inner] = valueToInsert;\n"+
            "\t\t\tprintf(\" item inserted :%d, at position :%d\\n\",valueToInsert,inner);\n"+
            "\t\t}\n"+
            "\t\tinterval = (interval -1) /3;\n"+
            "\t\ti++;\n"+
            "\t}\n"+
            "}\n"+
            "\n"+
            "int main(){\n"+
            "\tprintf(\"Input Array: \");\n"+
            "\tdisplay();\n"+
            "\tprintline(50);\n"+
            "\tshellSort();\n"+
            "\tprintf(\"Output Array: \");\n"+
            "\tdisplay();\n"+
            "\tprintline(50);\n"+
            "\treturn 1;\n"+
            "}\n";} // c-code



    {
        cpp_code = "// C++ implementation of Shell Sort\n"+
                "#include  <iostream>\n"+
                "using namespace std;\n"+
                "\n"+
                "/* function to sort arr using shellSort */\n"+
                "int shellSort(int arr[], int n)\n"+
                "{\n"+
                "\t// Start with a big gap, then reduce the gap\n"+
                "\tfor (int gap = n/2; gap > 0; gap /= 2)\n"+
                "\t{\n"+
                "\t\t// Do a gapped insertion sort for this gap size.\n"+
                "\t\t// The first gap elements a[0..gap-1] are already in gapped order\n"+
                "\t\t// keep adding one more element until the entire array is\n"+
                "\t\t// gap sorted\n"+
                "\t\tfor (int i = gap; i < n; i += 1)\n"+
                "\t\t{\n"+
                "\t\t\t// add a[i] to the elements that have been gap sorted\n"+
                "\t\t\t// save a[i] in temp and make a hole at position i\n"+
                "\t\t\tint temp = arr[i];\n"+
                "\t\t\t\n"+
                "\t\t\t// shift earlier gap-sorted elements up until the correct\n"+
                "\t\t\t// location for a[i] is found\n"+
                "\t\t\tint j;\n"+
                "\t\t\tfor (j = i; j >= gap && arr[j - gap] > temp; j -= gap)\n"+
                "\t\t\t\tarr[j] = arr[j - gap];\n"+
                "\t\t\t\n"+
                "\t\t\t//  put temp (the original a[i]) in its correct location\n"+
                "\t\t\tarr[j] = temp;\n"+
                "\t\t}\n"+
                "\t}\n"+
                "\treturn 0;\n"+
                "}\n"+
                "\n" +
                "void printArray(int arr[], int n){\n"+
                "\tfor (int i=0; i<n; i++)\n"+
                "\t\tcout << arr[i] << \"\";\n"+
                "}\n"+
                "\n"+
                "int main(){\n"+
                "\tint arr[] = {12, 34, 54, 2, 3}, i;\n"+
                "\tint n = sizeof(arr)/sizeof(arr[0]);\n"+
                "\n"+
                "\tcout << \"Array before sorting:<<\"\";\n"+
                "\tprintArray(arr, n);\n"+
                "\n"+
                "\tshellSort(arr, n);\n"+
                "\n"+
                "\tcout << \"Array after sorting:<<\"\";\n"+
                "\tprintArray(arr, n);\n"+
                "\n"+
                "\treturn 0;\n"+
                "}\n";} // c++ code
    {
        java_code = "// Java implementation of ShellSort\n"+
                "class ShellSort\n"+
                "{\n"+
                "\t/* An utility function to print array of size n*/\n"+
                "\tstatic void printArray(int arr[])\n"+
                "\t{\n"+
                "\t\tint n = arr.length;\n"+
                "\t\tfor (int i=0; i<n; ++i)\n"+
                "\t\t\tSystem.out.print(arr[i] +\" \");\n"+
                "\t\tSystem.out.println();\n"+
                "\t}\n"+
                "\t\n"+
                "\t/* function to sort arr using shellSort */\n"+
                "\tint sort(int arr[])\n"+
                "\t{\n"+
                "\t\tint n = arr.length;\n"+
                "\t\t\n"+
                "\t\t// Start with a big gap, then reduce the gap\n"+
                "\t\tfor (int gap = n/2; gap > 0; gap /= 2)\n"+
                "\t\t{\n"+
                "\t\t\t// Do a gapped insertion sort for this gap size.\n"+
                "\t\t\t// The first gap elements a[0..gap-1] are already\n"+
                "\t\t\t// in gapped order keep adding one more element\n"+
                "\t\t\t// until the entire array is gap sorted\n"+
                "\t\t\tfor (int i = gap; i < n; i += 1)\n"+
                "\t\t\t{\n"+
                "\t\t\t\t// add a[i] to the elements that have been gap\n"+
                "\t\t\t\t// sorted save a[i] in temp and make a hole at\n"+
                "\t\t\t\t// position i\n"+
                "\t\t\t\tint temp = arr[i];\n"+
                "\t\t\t\t\n"+
                "\t\t\t\t// shift earlier gap-sorted elements up until\n"+
                "\t\t\t\t// the correct location for a[i] is found\n"+
                "\t\t\t\tint j;\n"+
                "\t\t\t\tfor (j = i; j >= gap && arr[j - gap] > temp; j -= gap)\n"+
                "\t\t\t\t\tarr[j] = arr[j - gap];\n"+
                "\t\t\t\t\t\n"+
                "\t\t\t\t// put temp (the original a[i]) in its correct\n"+
                "\t\t\t\t// location\n"+
                "\t\t\t\tarr[j] = temp;\n"+
                "\t\t\t}\n"+
                "\t\t}\n"+
                "\t\treturn 0;\n"+
                "\t}\n"+
                "\t// Driver method\n"+
                "\tpublic static void main(String args[])\n"+
                "\t{\n"+
                "\t\tint arr[] = {12, 34, 54, 2, 3};\n"+
                "\t\tSystem.out.println(\"Array before sorting\");\n"+
                "\t\tprintArray(arr);\n"+
                "\t\t\n"+
                "\t\tShellSort ob = new ShellSort();\n"+
                "\t\tob.sort(arr);\n"+
                "\t\t\n"+
                "\t\tSystem.out.println(\"Array after sorting\");\n"+
                "\t\tprintArray(arr);\n"+
                "\t}\n"+
                "}\n";} // java code

    {
        python_code = "# Python3 program for implementation of Shell Sort\n"+
                "# Python3 program for implementation of Shell Sort\n"+
                "\n"+
                "def shellSort(arr, n):\n"+
                "\t# code here\n"+
                "\tgap=n//2\n"+
                "\t\n"+
                "\twhile gap>0:\n"+
                "\t\tj=gap\n"+
                "\t\t# Check the array in from left to right\n"+
                "\t\t# Till the last possible index of j\n"+
                "\t\twhile j<n:\n"+
                "\t\t\ti=j-gap # This will keep help in maintain gap value\n"+
                "\t\t\t\n"+
                "\t\t\twhile i>=0:\n"+
                "\t\t\t\t# If value on right side is already greater than left side value\n"+
                "\t\t\t\t# We don't do swap else we swap\n"+
                "\t\t\t\tif arr[i+gap]>arr[i]:\n"+
                "\t\t\t\t\tbreak\n"+
                "\t\t\t\telse:\n"+
                "\t\t\t\t\tarr[i+gap],arr[i]=arr[i],arr[i+gap]\n"+
                "\t\t\t\t\t\n"+
                "\t\t\t\t# To check left side also\n"+
                "\t\t\t\ti=i-gap\n"+
                "\t\t\t\t# If the element present is greater than current element\n"+
                "\t\t\tj+=1\n"+
                "\t\tgap=gap//2\n"+
                "\n"+
                "\n"+
                "# driver to check the code\n"+
                "arr2 = [12, 34, 54, 2, 3]\n"+
                "print(\"input array:\",arr2)\n"+
                "\n"+
                "shellSort(arr2,len(arr2))\n"+
                "print(\"sorted array\",arr2)\n";} //Python code

}