package 遇到的面试题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * n个升序的数组，返回第k大的数
 * 要求 时间复杂度 O(nlogn)
 * Create by @author 杨威 on 2021/8/1 0001 - 22:35
 */
public class 微软_多个有序数组第k大的值 {

    @Test
    public void main(String[] args) {
        ArrayList<List<Integer>> arrs = new ArrayList<List<Integer>>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(2);
        arr2.add(7);
        arr2.add(8);
        arr2.add(10);
        arr2.add(12);
        arr2.add(22);
        arr2.add(32);
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        arr3.add(0);
        arrs.add(arr1);
        arrs.add(arr2);
        arrs.add(arr3);

        int k = 7;
        int result = method(k, arrs);
        System.out.println(result);
    }


    private int method(int k, List<List<Integer>> arrs) {
        //参数检查
        if (k <= 0) {
            return 0;
        }

        if (arrs == null || arrs.size() == 0) {
            return 0;
        }

        int[] tempArr = new int[k];
        //对应的数组
        int index;
        for (int i = 0; i < k; i++) {
            tempArr[i] = arrs.get(0).get(0);
            index = 0;

            for (int j = 1; j < arrs.size(); j++) {
                if (tempArr[i] > arrs.get(j).get(0)) {
                    tempArr[i] = arrs.get(j).get(0);
                    index = j;
                }
            }

            arrs.get(index).remove(0);
            if (arrs.get(index).size() == 0) {
                arrs.remove(index);
            }
        }

        return tempArr[k - 1];
    }

}
