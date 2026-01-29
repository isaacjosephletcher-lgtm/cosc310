package chapter6;

import java.util.ArrayList;

public class ArrayInsert extends Target{

    public ArrayInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    // Insert new items at beginning of arr
    @Override
    public int method(int[] indicesOrnums) {
        int result = 0; // This will overflow
        int largerarray[] = new int[arr.length + indicesOrnums.length];
        for (int i = 0; i < indicesOrnums.length; i++) {
            largerarray[i] = indicesOrnums[i];
            result += indicesOrnums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            largerarray[i + indicesOrnums.length] = arr[i];
            result++;
        }
        return result;
    }

}
