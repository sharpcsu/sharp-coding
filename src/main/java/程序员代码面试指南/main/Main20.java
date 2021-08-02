package 程序员代码面试指南.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by 杨威 on 9/29 0029 - 10:24
 */
public class Main20 {
    public static void main(String[] args) {

    }

public void copyFile(String fromPath, String toPath) {
    try {
        int sum = 0;
        int read = 0;
        File fromFile = new File(fromPath);
        if (fromFile.exists()) {                  //文件存在时
            InputStream inStream = new FileInputStream(fromPath);      //读入原文件
            FileOutputStream fs = new FileOutputStream(toPath);
            byte[] buffer = new byte[1444];
            while ( (read = inStream.read(buffer)) != -1) {
                sum += read;            //字节数 文件大小
                System.out.println(sum);
                fs.write(buffer, 0, read);
            }
            inStream.close();
        }
    }  catch (Exception e) {
        System.out.println("复制文件操作出错");
        e.printStackTrace();
    }
}

}
