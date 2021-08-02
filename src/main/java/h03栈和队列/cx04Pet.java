package h03栈和队列;

/**
 * Created by sharp on 2017/7/13 - 13:15
 */
public class cx04Pet {
}

class Pet{
    private String type;
    
    public Pet(String type) {
        this.type = type;
    }
    
    public String getPet() {
        return type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}