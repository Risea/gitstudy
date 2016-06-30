package cn.seands.designpattern;

/**
 * Created by Seands on 2016/6/16.
 * 单例模式学习 了解
 */
public class Singleton {

    //私有化构造方法
    private Singleton(){
        //....
        System.out.println("Singleton构造函数...");
    }

    //创建私有单一对象  静态类属性 保证单一
    private static Singleton singleton = new Singleton();
    //加载类时 就初始化了singleton  饿汉式  线程安全

    public static String TEST = "TEST";

    //提供公有获取单利方法       获取实例比懒汉式快
    public static Singleton getInstance(){
        return singleton;
    }

}
