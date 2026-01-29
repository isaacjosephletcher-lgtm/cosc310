package chapter6;

import java.util.ArrayList;

public class ListInsert extends Target{

    public ListInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indicesOrnums) {
        int result = 0;
        for (int i = 0; i < indicesOrnums.length; i++) {
            list.add(i, indicesOrnums[i]);
            result++;
        }
        return result;
    }
}

