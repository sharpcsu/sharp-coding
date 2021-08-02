package 程序员代码面试指南.main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main17 {
    private static int state = 0;

    public static void main(String[] args) {
        final Lock l = new ReentrantLock();
        int n = 40;
        Thread A = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=n) {
                    l.lock();
                    if(state%4==0){
                        System.out.print("A");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        Thread B = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=n) {
                    l.lock();
                    if(state%4==1){
                        System.out.print("B");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        Thread C = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=n) {
                    l.lock();
                    if(state%4==2){
                        System.out.print("C");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        Thread D = new Thread(new Runnable(){
            @Override
            public void run() {
                while (state<=n) {
                    l.lock();
                    if(state%4==3){
                        System.out.print("D");
                        state ++;
                    }
                    l.unlock();
                }
            }
        });
        A.start();
        B.start();
        C.start();
        D.start();
    }

}

