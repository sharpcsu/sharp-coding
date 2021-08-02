package 程序员代码面试指南.main; /**
 * Created by 杨威 on 9/29 0029 - 10:34
 */

/**
 * 设计 4 个 ( 可以是 n 个 ) 线程，其中两个线程每次对 j 增加 1 ，另外两个线程对 j 每次减少 1
 */


public class Main21 {
    // 采用 Runnable 接口方式创建的多条线程可以共享实例属性
    private int i;
    // 同步增加方法

    private synchronized void inc() {
        i++;
        System.out.println(Thread.currentThread().getName() + "--inc--" + i);
    }

    // 同步减算方法
    private synchronized void dec() {
        i--;
        System.out.println(Thread.currentThread().getName() + "--dec--" + i);
    }

    // 增加线程

    class Inc implements Runnable {
        public void run() {
            inc();
        }

    }


    // 减算线程
    class Dec implements Runnable {
        public void run() {
            dec();
        }
    }


    public static void main(String[] args) {


        Main21 t = new Main21();


        // 内部类的实例化

        Inc inc = t.new Inc();

        Dec dec = t.new Dec();


        // 创建 2*n 个线程 此处 n=2

        for (int i = 0; i < 2; i++) {

            new Thread(inc).start();

            new Thread(dec).start();

        }

    }

}