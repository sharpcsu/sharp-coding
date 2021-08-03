package h02链表;

import org.junit.Test;

/**
 * 维护一个有序单链表，越靠近链表尾部的结点是越早访问的，
 * 当有新的数据插入时，如果已经在缓存中，从原来的位置删除，插入到头部
 * 当有新的数据插入时，不在缓存中，如果缓存已满，将尾结点删除，新数据插入头部，否则直接插入头部
 * Create by @author 杨威 on 2021/8/1 0001 - 21:58
 */
public class wz07链表实现LRU算法 {


}


/////////////////////////

//public class Lock_Condition_ABC {
//    private static Lock lock = new ReentrantLock();
//    private static Condition A = lock.newCondition();
//    private static Condition B = lock.newCondition();
//    private static Condition C = lock.newCondition();
//    private static Condition D = lock.newCondition();
//
//    private static int count = 0;
//
//    static class ThreadA extends Thread {
//        @Override
//        public void run() {
//            try {
//                lock.lock();
//
//                for (int i = 0; i < 1; i++) {
//                    while (count % 4 != 0){//注意这里是不等于0，也就是说没轮到该线程执行，之前一直等待状态
//                        A.await(); //该线程A将会释放lock锁，构造成节点加入等待队列并进入等待状态
//                    }
//                    System.out.print("A");
//                    count++;
//                    B.signal(); // A执行完唤醒B线程
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    static class ThreadB extends Thread {
//        @Override
//        public void run() {
//            try {
//                lock.lock();
//                for (int i = 0; i < 1; i++) {
//                    while (count % 4 != 1)
//                        B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
//                    System.out.print("B");
//                    count++;
//                    C.signal();// B执行完唤醒C线程
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    static class ThreadC extends Thread {
//        @Override
//        public void run() {
//            try {
//                lock.lock();
//                for (int i = 0; i < 1; i++) {
//                    while (count % 4 != 2)
//                        C.await();// C释放lock锁
//                    System.out.print("C");
//                    count++;
//                    D.signal();// C执行完唤醒A线程
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    static class ThreadD extends Thread {
//        @Override
//        public void run() {
//            try {
//                lock.lock();
//                for (int i = 0; i < 1; i++) {
//                    while (count % 4 != 3)
//                        D.await();// C释放lock锁
//                    System.out.print("D");
//                    count++;
//                    A.signal();// C执行完唤醒A线程
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        new ThreadA().start();
//        new ThreadB().start();
//        new ThreadC().start();
//        new ThreadD().start();
//    }
//}