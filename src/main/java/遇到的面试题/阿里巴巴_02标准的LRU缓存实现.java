package 遇到的面试题;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Java基础类库（仅JDK中包含的类库）编写一个标准的LRU缓存实现
 * Create by @author 杨威 on 2021/8/1 0001 - 22:14
 */
public class 阿里巴巴_02标准的LRU缓存实现 {

    @Test
    public void testLRUCacheLinkedHashMap() {
        LRUCacheLinkedHashMap lruCacheLinkedHashMap = new LRUCacheLinkedHashMap(3,0.75f);

        lruCacheLinkedHashMap.put("1",1);
        lruCacheLinkedHashMap.put("2",2);
        lruCacheLinkedHashMap.put("3",3);
        System.out.println(lruCacheLinkedHashMap);
        lruCacheLinkedHashMap.put("4",4);
        System.out.println(lruCacheLinkedHashMap);
    }

    @Test
    public void testLRUCacheHashMap() {
        LRUCacheHashMap<Integer, Integer> lruCacheHashMap = new LRUCacheHashMap<>(2);

        lruCacheHashMap.put(1, 1);
        lruCacheHashMap.put(2, 2);
        System.out.println(lruCacheHashMap.get(1));
        lruCacheHashMap.put(3, 3);
        System.out.println(lruCacheHashMap.get(2));
        lruCacheHashMap.put(4, 4);
        System.out.println(lruCacheHashMap.get(1));
        System.out.println(lruCacheHashMap.get(3));
        System.out.println(lruCacheHashMap.get(4));
    }
}

/**
 * LRU算法
 * 思路：重写LinkedHashMap
 */
class LRUCacheLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private float initialCapacity;
    private volatile int maxCapacity;
    private final Lock lock = new ReentrantLock();

    public LRUCacheLinkedHashMap(int maxCapacity, float initialCapacity) {
        super(maxCapacity, initialCapacity);
        this.maxCapacity = maxCapacity;
        this.initialCapacity = initialCapacity;
    }

    @Override
    public boolean containsKey(Object k) {
        try {
            lock.lock();
            return super.containsKey(k);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object k) {
        try {
            lock.lock();
            return super.get(k);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K k, V v) {
        try {
            lock.lock();
            return super.put(k, v);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        try {
            lock.lock();
            return super.remove(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }
}

/**
 * 使用HashMap和双向链表实现LRUCache
 * 思路：
 *
 */
class LRUCacheHashMap<K, V> {

    private final int capacity;
    private final Map<K, Entry<K, V>> map;
    private Entry<K, V> head;
    private Entry<K, V> tail;

    public LRUCacheHashMap(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>((int)(capacity / 0.75 + 1), 0.75f);
        head = new Entry<>(null, null);
        tail = new Entry<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Entry<K, V> entry = map.get(key);
            popToTail(entry);
            return entry.val;
        }
        return null;
    }

    public V put(K key, V val) {
        if (map.containsKey(key)) {
            Entry<K, V> entry = map.get(key);
            V oldVal = entry.val;
            entry.val = val;
            popToTail(entry);
            return oldVal;
        }
        Entry<K, V> entry = new Entry<>(key, val);
        if (map.size() >= capacity) {
            Entry<K, V> first = removeFirst();
            map.remove(first.key);
        }
        map.put(key, entry);
        addToTail(entry);
        return null;
    }

    private void addToTail(Entry<K, V> entry) {
        Entry<K, V> prev = tail.prev;
        prev.next = entry;
        tail.prev = entry;
        entry.next = tail;
        entry.prev = prev;
    }

    private Entry<K, V> removeFirst() {
        Entry<K, V> entry = head.next;
        Entry<K, V> next = entry.next;
        head.next = next;
        next.prev = head;
        return entry;
    }

    private void popToTail(Entry<K, V> entry) {
        Entry<K, V> next = entry.next;
        Entry<K, V> prev = entry.prev;
        next.prev = prev;
        prev.next = next;
        Entry<K, V> last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    class Entry<K, V> {
        /**
         * 键
         */
        K key;

        /**
         * 值
         */
        V val;

        /**
         * 前驱节点
         */
        Entry<K, V> next;

        /**
         * 后继节点
         */
        Entry<K, V> prev;

        Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

}
