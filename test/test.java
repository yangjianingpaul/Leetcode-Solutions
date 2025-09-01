package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0,1);
        int[] arr1={1,2,3};
        int[] arr2=new int[3];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
    }
}