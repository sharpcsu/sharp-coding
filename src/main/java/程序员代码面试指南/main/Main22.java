package 程序员代码面试指南.main;

import java.util.HashMap;

/**
 * Created by 杨威 on 9/29 0029 - 16:00
 */
public class Main22 {
    public static void main(String[] args) {
        String[] arr = {"ww", "bb", "cc", "cc", "ww", "cc", "ww", "bb", "ww", "bb"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        System.out.println(map.toString());
    }
}
