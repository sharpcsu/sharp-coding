package 剑指offer.h1公共类;

/**
 * Created by sharp on 2017/7/7 - 14:01
 */
public class Tree {
    public int value; //public是为了在其它包中可以被访问到
    public Tree left; //左指针
    public Tree right; //右指针
    
    public Tree(int value) {
        this.value = value;
    }
}