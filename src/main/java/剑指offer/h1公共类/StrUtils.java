package 剑指offer.h1公共类;

/**
 * 一些字符串的公共操作
 * Created by sharp on 2017/7/7 - 14:11
 */
public class StrUtils {
    /**
     * 字符串转数组
     * @param str 字符串
     * @return 整型数组
     */
    public static int[] str2arrs(String str) {
        if (str == null || "".equals(str)) {
            throw new RuntimeException("数据不能为空");
        }
        
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        
        for(int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        
        return arr;
    }
}
