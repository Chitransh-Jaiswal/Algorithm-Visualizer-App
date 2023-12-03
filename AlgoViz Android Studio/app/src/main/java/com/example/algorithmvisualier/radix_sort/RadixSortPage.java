package com.example.algorithmvisualier.radix_sort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algorithmvisualier.R;
import com.example.algorithmvisualier.radix_sort.RadixSortVisualise;

public class RadixSortPage extends AppCompatActivity {

    String c_code, cpp_code, java_code, python_code;
    Button c, cpp, java, python;
    TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radix_sort_page);
        getSupportActionBar().hide();

        tvv = (TextView) findViewById(R.id.code_area_radix_sort);
        tvv.setText(c_code);

        c = (Button) findViewById(R.id.btn1_radix_sort);
        cpp = (Button) findViewById(R.id.btn2_radix_sort);
        java = (Button) findViewById(R.id.btn3_radix_sort);
        python = (Button) findViewById(R.id.btn4_radix_sort);
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
        Intent i = new Intent(this, RadixSortVisualise.class);
        startActivity(i);
    }

    {c_code = "// Radix Sort in C Programming\n" +
            "#include <stdio.h>\n// Function to get the largest element from an array\n" +
            "\n" +
            "int getMax(int array[], int n) {\n" +
            "\tint max = array[0];\n" +
            "\tfor (int i = 1; i < n; i++)\n" +
            "\t\tif (array[i] > max)\n" +
            "\t\t\tmax = array[i];\n" +
            "\t\treturn max;\n" +
            "}\n" +
            "\n" +
            "// Using counting sort to sort the elements in the basis of significant places\n" +
            "void countingSort(int array[], int size, int place) \n" +
            "{\n" +
            "\tint output[size + 1];\n" +
            "\tint max = (array[0] / place) % 10;\n" +
            "\n" +
            "\tfor (int i = 1; i < size; i++) {\n" +
            "\t\tif (((array[i] / place) % 10) > max)\n" +
            "\t}\n" +
            "\tint count[max + 1];\n" +
            "\tfor (int i = 0; i < max; ++i)" +
            "\tcount[i] = 0;\n" +
            "\n" +
            "\t// Calculate count of elements\n" +
            "\tfor (int i = 0; i < size; i++)\n" +
            "\t\tcount[(array[i] / place) % 10]++;\n" +
            "\n" +
            "\t//Calculate cumulative count\n" +
            "\tfor (int i = 0; i < 10; i++)\n" +
            "\t\tcount[i] += count[i - 1];\n" +
            "\n" +
            "\t// Place the elements in sorted order\n" +
            "\tfor (int i = size - 1; i >= 0; i--) {\n" +
            "\t\toutput[count[(array[i] / place) % 10] - 1] = array[i];\n" +
            "\t\tcount[(array[i] / place) % 10]--;\n" +
            "}\n" +
            "\n" +
            "\tfor (int i = 0; i < size; i++)\n" +
            "\t\tarray[i] = output[i];\n" +
            "\n" +
            "// Main function to implement radix sort\n\n" +
            "void radixsort(int array[], int size) {\n" +
            "\t// Get maximum element\n" +
            "\tint max = getMax(array, size);\n\n" +
            "\t// Apply counting sort to sort elements based on place value.\n" +
            "\tfor (int place = 1; max / place > 0; place *= 10)\n" +
            "\t\tcountingSort(array, size, place);\n" +
            "}\n" +
            "// Print an array\n\n" +
            "void printArray(int array[], int size) {\n" +
            "\tfor (int i = 0; i < size; ++i) {\n" +
            "\t\tprintf(\"%d  \", array[i]);\n" +
            "\t}\n" +
            "}\n" +
            "\n// Driver code\n\n" +
            "int main() {\n" +
            "\tint array[] = {121, 432, 564, 23, 1, 45, 788};\n" +
            "\tint n = sizeof(array) / sizeof(array[0]);\n" +
            "\tradixsort(array, n);\n"+
            "\tprintArray(array, n);\n"+
            "}\n";
    } //c-code

    {
        cpp_code = "// Radix Sort in C++ Programming\n\n" +
                "#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "// Function to get the largest element from an array\n" +
                "int getMax(int array[], int n) {\n" +
                "\tint max = array[0];\n" +
                "\tfor (int i = 1; i < n; i++)\n" +
                "\t\tif (array[i] > max)\n" +
                "\t\t\tmax = array[i];\n" +
                "\treturn max;\n" +
                "}\n" +
                "\n" +
                "// Using counting sort to sort the elements in the basis of significant places\n" +
                "void countingSort(int array[], int size, int place) {\n" +
                "\tconst int max = 10;\n" +
                "\tint output[size];\n" +
                "\tint count[max];\n" +
                "\t}\n\n" +
                "\tfor (int i = 0; i < max; ++i)\n" +
                "\t\tcount[i] = 0;\n\n" +
                "\t// Calculate count of elements\n" +
                "\tfor (int i = 0; i < size; i++)\n" +
                "\t\tcount[(array[i] / place) % 10]++;\n" +
                "\n" +
                "\t//Calculate cumulative count\n" +
                "\tfor (int i = 0; i < max; i++)\n" +
                "\t\tcount[i] += count[i - 1];\n" +
                "\n" +
                "\t// Place the elements in sorted order\n" +
                "\tfor (int i = size - 1; i >= 0; i--) {\n" +
                "\t\toutput[count[(array[i] / place) % 10] - 1] = array[i];\n" +
                "\t\tcount[(array[i] / place) % 10]--;\n" +
                "\t}\n" +
                "\n" +
                "\tfor (int i = 0; i < size; i++)\n" +
                "\t\tarray[i] = output[i];\n" +
                "\n" +
                "// Main function to implement radix sort\n\n" +
                "void radixsort(int array[], int size) {\n" +
                "\t// Get maximum element\n" +
                "\tint max = getMax(array, size);\n\n" +
                "\t// Apply counting sort to sort elements based on place value.\n" +
                "\tfor (int place = 1; max / place > 0; place *= 10)\n" +
                "\t\tcountingSort(array, size, place);\n" +
                "}\n" +
                "// Print an array\n\n" +
                "void printArray(int array[], int size) {\n" +
                "\tfor (int i = 0; i < size; ++i) \n" +
                "\t\tcout << array[i] << \" \";\n\tcout << endl;\n\t" +
                "}\n" +
                "\n// Driver code\n\n" +
                "int main() {\n" +
                "\tint array[] = {121, 432, 564, 23, 1, 45, 788};\n" +
                "\tint n = sizeof(array) / sizeof(array[0]);\n" +
                "\tradixsort(array, n);\n"+
                "\tprintArray(array, n);\n"+
                "}\n";
    } // c++ code

    {
        java_code = "// Radix Sort in Java Programming\n\n" +
                "import java.util.Arrays;\n\n" +
                "\n" +
                "class RadixSort {\n\t// Using counting sort to sort the elements in the basis of significant places\n" +
                "\tvoid countingSort(int array[], int size, int place) {\n" +
                "\t\tint[] output = new int[size + 1];\n" +
                "\t\tint max = array[0];\n" +
                "\t\tfor (int i = 1; i < size; i++) {\n" +
                "\t\t\tif (array[i] > max)\n" +
                "\t\t\t\tmax = array[i];\n" +
                "\t\t}\n" +
                "\t\tint[] count = new int[max + 1];\n" +
                "\t\tfor (int i = 0; i < max; ++i)\n" +
                "\t\t\tcount[i] = 0;\n" +
                "\n" +
                "\t\tfor (int i = 0; i < size; ++i)\n" +
                "\t\t\tcount[(array[i] / place) % 10]++;\n" +
                "\n" +
                "\t\tfor (int i = 1; i < 10; ++i)\n" +
                "\t\t\tcount[i] += count[i - 1];\n\n" +
                "\n" +
                "\t\tfor (int i = size - 1; i >= 0; i--) {\n" +
                "\t\t\toutput[count[(array[i] / place) % 10] - 1] = array[i];\n\n" +
                "\t\t\tcount[(array[i] / place) % 10]--;\n\t\t}\n" +
                "\n" +
                "\t\tfor (int i = 0; i < size; i++)\n" +
                "\t\t\tarray[i] = output[i];\n\t}\n" +
                "\n" +
                "\t// Main function to implement radix sort\n\tvoid radixSort(int array[], int size) {\n\t\t// Get maximum element\n\t\tint max = getMax(array, size);\n\n\t\t// Apply counting sort to sort elements based on place value.\n\t\tfor (int place = 1; max / place > 0; place *= 10)\n\t\t\tcountingSort(array, size, place);\n"+
                "\t// Driver Code\n" +
                "\tpublic static void main(String args[])\n" +
                "\t{\n" +
                "\t\tint[] data = { 121, 432, 564, 23, 1, 45, 788 };\n" +
                "\t\tint size = data.length;\n" +
                "\t\tRadixSort rs = new RadixSort();\n" +
                "\t\trs.radixSort(data, size);\n" +
                "\t\tSystem.out.println(\"Sorted Array in Ascending Order: \");\n" +
                "\t\tSystem.out.println(Arrays.toString(data));\n" +
                "\t}\n" +
                "}\n";
    } // java code

    {
        python_code = "# Radix sort in Python\n" +
                "\n" +
                "\n# Using counting sort to sort the elements in the basis of significant places\n" +
                "def countingSort(array, place):\n" +
                "\tsize = len(array)\n" +
                "\toutput = [0] * size\n" +
                "\tcount = [0] * 10\n" +
                "\n" +
                "\t# Calculate count of elements\n" +
                "\tfor i in range(0, size):\n" +
                "\t\tindex = array[i] // place\n" +
                "\t\tcount[index % 10] += 1\n" +
                "\n" +
                "\t\t# Calculate cumulative count\n" +
                "\t\tfor i in range(1, 10):\n\t\t\tcount[i] += count[i - 1]\n" +
                "\n" +
                "\t\t# Place the elements in sorted order\n" +
                "\t\ti = size - 1\n" +
                "\t\twhile i >= 0:\n" +
                "\t\t\tindex = array[i] // place\n" +
                "\t\t\toutput[count[index % 10] - 1] = array[i]\n" +
                "\t\t\tcount[index % 10] -= 1\n" +
                "\t\t\ti -= 1\n" +
                "\n" +
                "\t\tfor i in range(0, size):\n" +
                "\t\t\tarray[i] = output[i]\n" +
                "\n"+
                "# Main function to implement radix sort\n" +
                "def radixSort(array):\n" +
                "\t# Get maximum element\n" +
                "\tmax_element = max(array)\n\n" +
                "\t# Apply counting sort to sort elements based on place value.\n" +
                "\tplace = 1\n" +
                "\twhile max_element // place > 0:\n\t\tcountingSort(array, place)\n\t\tplace *= 10\n\n" +
                "data = [121, 432, 564, 23, 1, 45, 788]\nradixSort(data)\n" +
                "print(data)\n\n";
    } //Python code

}