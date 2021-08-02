package 程序员代码面试指南.第1章栈和队列;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 */
public class _4猫狗队列 {
    public static void main(String[] args) {
        CatDogQueue queue = new CatDogQueue();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("请输入宠物队列");
        String s = scanner.nextLine();
        String[] pets = s.split(" ");
        
        for (String pet : pets) {
            if ("cat".equals(pet)) {
                Pet cat = new Cat();
                queue.add(cat);
            } else {
                Pet dog = new Dog();
                queue.add(dog);
            }
        }
        
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("isCatEmpty: " + queue.isCatEmpty());
        System.out.println("isDogEmpty: " + queue.isDogEmpty());
        System.out.println("猫出列");
        //        queue.pollCat();
        System.out.println("全部出列");
        LinkedList<Pet> pollAll = queue.pollAll();
        while (!pollAll.isEmpty()) {
            System.out.print(pollAll.pop().getPet() + "\t");
        }
        System.out.println();
        
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("isCatEmpty: " + queue.isCatEmpty());
        System.out.println("isDogEmpty: " + queue.isDogEmpty());
        System.out.println("狗出列");
        //        queue.pollDog();
        
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("isCatEmpty: " + queue.isCatEmpty());
        System.out.println("isDogEmpty: " + queue.isDogEmpty());
        
    }
}

class CatDogQueue {
    private LinkedList<Pet> catQueue;
    private LinkedList<Pet> dogQueue;
    
    public CatDogQueue() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
    }
    
    //添加宠物
    public void add(Pet pet) {
        if (pet.getPet().equals("cat")) {
            catQueue.push(pet);
            dogQueue.push(null);
        } else if ("dog".equals(pet.getPet())) {
            catQueue.push(null);
            dogQueue.push(pet);
        } else {
            throw new RuntimeException("不认识的宠物");
        }
    }
    
    //宠物出列
    public LinkedList<Pet> pollAll() {
        LinkedList<Pet> pets = new LinkedList<>();
        
        while (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            if (catQueue.peek() != null) {
                pets.push(catQueue.pop());
                dogQueue.pop();
            } else {
                catQueue.pop();
                pets.push(dogQueue.pop());
            }
        }
        
        pollCat();
        pollDog();
        
        return pets;
    }
    
    //猫出列
    public LinkedList<Pet> pollCat() {
        LinkedList<Pet> pets = new LinkedList<>();
        while (!catQueue.isEmpty()) {
            if (catQueue.peek() != null) {
                pets.push(catQueue.pop());
            } else {
                catQueue.pop();
            }
        }
        
        return pets;
    }
    
    //狗出列
    public LinkedList<Pet> pollDog() {
        LinkedList<Pet> pets = new LinkedList<>();
        while (!dogQueue.isEmpty()) {
            if (dogQueue != null) {
                pets.push(dogQueue.pop());
            } else {
                dogQueue.pop();
            }
        }
        
        return pets;
    }
    
    //宠物为空
    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }
    
    //猫为空
    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }
    
    //狗为空
    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }
}
