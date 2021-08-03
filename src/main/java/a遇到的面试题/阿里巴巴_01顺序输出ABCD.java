package a遇到的面试题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有A、B、C、D四个线程，A线程输出A，B线程输出B，C线程输出C，D线程输出D，要求：同时启动四个线程，按顺序输出ABCD
 * Create by @author 杨威 on 2021/8/1 0001 - 22:14
 */
public class 阿里巴巴_01顺序输出ABCD {

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
        new ThreadD().start();
    }
    
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static Condition D = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();

                for (int i = 0; i < 1; i++) {
                    while (count % 4 != 0){//注意这里是不等于0，也就是说没轮到该线程执行，之前一直等待状态
                        A.await(); //该线程A将会释放lock锁，构造成节点加入等待队列并进入等待状态
                    }
                    System.out.print("A");
                    count++;
                    B.signal(); // A执行完唤醒B线程
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 1; i++) {
                    while (count % 4 != 1) {
                        B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                    }
                    System.out.print("B");
                    count++;
                    C.signal();// B执行完唤醒C线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 1; i++) {
                    while (count % 4 != 2)
                        C.await();// C释放lock锁
                    System.out.print("C");
                    count++;
                    D.signal();// C执行完唤醒A线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadD extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 1; i++) {
                    while (count % 4 != 3)
                        D.await();// C释放lock锁
                    System.out.print("D");
                    count++;
                    A.signal();// C执行完唤醒A线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    
}