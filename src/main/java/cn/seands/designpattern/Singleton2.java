package cn.seands.designpattern;

/**
 * Created by Seands on 2016/6/29.
 * 懒汉式
 */
public class Singleton2 {

    private Singleton2(){

    }

    private static Singleton2 singleton2;

    //需要时才创建实例。获取实例比饿汉式慢一点
    public static Singleton2 getInstance(){
        if(singleton2==null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    //保证线程安全
    public static Singleton2 getInstance2(){
        if(singleton2==null){
            synchronized (Singleton2.class){
                if(singleton2==null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }

}
