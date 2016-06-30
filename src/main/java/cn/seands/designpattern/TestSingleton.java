package cn.seands.designpattern;

/**
 * Created by Seands on 2016/6/29.
 */
public class TestSingleton {

    public static void main(String[] args){
        System.out.println("Main方法...");
        System.out.println("Singleton的TEST变量：\t"+Singleton.TEST);
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s+"\n"+s2);

    }
}
