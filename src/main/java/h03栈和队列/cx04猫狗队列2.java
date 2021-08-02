package h03栈和队列;

/**
 * Created by sharp on 2017/7/13 - 13:16
 */

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 书中参考答案
 * Created by yw on 7/6 0006.
 */
// TODO: 7/6 0006 测试不通过, 需要查看
public class cx04猫狗队列2 {
    public static void main(String[] args) {
        PetQueue petQueue = new PetQueue();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        
        //创建队列
        for (String s1 : split) {
            Pet pet = new Pet(s1);
            petQueue.add(pet);
        }
        
        System.out.println("isEmpty: " + petQueue.isEmpty());
        System.out.println("isCatEmpty" + petQueue.isCatEmpty());
        System.out.println("isDogEmpty: " + petQueue.isDogEmpty());
        
        System.out.println("全部输出");
        while (!petQueue.isEmpty()) {
            PetQueueEntry pet = petQueue.pollAll();
            System.out.print(pet.getPetType() + ", " + pet.getCount() + "\t");
        }
        System.out.println();
        
        System.out.println("isEmpty: " + petQueue.isEmpty());
        System.out.println("isCatEmpty" + petQueue.isCatEmpty());
        System.out.println("isDogEmpty: " + petQueue.isDogEmpty());
        
    }
}

class PetQueue {
    LinkedList<PetQueueEntry> catQ;
    LinkedList<PetQueueEntry> dogQ;
    public int count = 0;
    
    public PetQueue() {
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
    }
    
    //添加宠物
    public void add(Pet pet) {
        PetQueueEntry petQueueEntry = new PetQueueEntry(pet, count++);
        if (pet.getPet().equals("cat")) {
            catQ.push(petQueueEntry);
        } else {
            dogQ.push(petQueueEntry);
        }
    }
    
    //宠物出列
    public PetQueueEntry pollAll() {
        if (!isCatEmpty() && !isDogEmpty()) {
            System.out.print("all");
            if (catQ.peek().getCount() < dogQ.peek().getCount()) {
                PetQueueEntry poll = catQ.poll();
                System.out.println(" , count-" + poll.getCount() + ", ");
                return poll;
            } else if (catQ.peek().getCount() > dogQ.peek().getCount()) {
                PetQueueEntry poll = dogQ.poll();
                System.out.println(" ,count-" + poll.getCount() + ", ");
                return poll;
            } else {
                throw new RuntimeException("count 顺序标记异常");
            }
        } else if (!isCatEmpty() && isDogEmpty()) {
            System.out.print("cat");
            return catQ.poll();
        } else if (isCatEmpty() && !isDogEmpty()) {
            System.out.print("dog");
            return dogQ.poll();
        } else {
            throw new RuntimeException("错误, 队列为空");
        }
    }
    
    //cat出列
    public PetQueueEntry pollCat() {
        if (!catQ.isEmpty()) {
            return catQ.poll();
        } else {
            throw new RuntimeException("错误, cat队列为空");
        }
    }
    
    //dog出列
    public PetQueueEntry pollDog() {
        if (!dogQ.isEmpty()) {
            return dogQ.poll();
        } else {
            throw new RuntimeException("错误, dog队列为空");
        }
    }
    
    //宠物为空
    public boolean isEmpty() {
        return catQ.isEmpty() && dogQ.isEmpty();
    }
    
    //cat为空
    public boolean isCatEmpty() {
        return catQ.isEmpty();
    }
    
    //dog为空
    public boolean isDogEmpty() {
        return dogQ.isEmpty();
    }
}

class PetQueueEntry {
    private Pet pet;
    private long count;
    
    public PetQueueEntry(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }
    
    public Pet getPet() {
        return pet;
    }
    
    public long getCount() {
        return count;
    }
    
    public String getPetType() {
        return pet.getPet();
    }
}

class CatQueueEntry extends PetQueueEntry {
    public CatQueueEntry(Pet pet, int count) {
        super(pet, count);
    }
}

class DogQueueEntry extends PetQueueEntry {
    public DogQueueEntry(Pet pet, int count) {
        super(pet, count);
    }
}