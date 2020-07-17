package org.sang.hanzy.designPatterns.创建型模式.单例模式;

/**
 * 单例模式
 * 1.单例类只有一个实例对象
 * 2.该单例对象必须由单例自行创建
 * 3.单例类对外提供一个访问该单例的全局访问点
 */

/**
 * 应用场景
 * 1.在应用场景中，某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
 * 2.当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
 * 3.当某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。
 */

/**
 * 懒汉式单例
 * 类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例
 * 如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
 * 如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
 */
public class LazySingleton {
    public static void main(String[] args) {
        President zt1 = President.getInstance();
        zt1.getName();    //输出总统的名字
        President zt2 = President.getInstance();
        zt2.getName();    //输出总统的名字
        if (zt1 == zt2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }
}

class President {

    //保证instance在所有线程中同步
    private static volatile President instance = null;

    //private避免类在外部被实例化
    private President() {
        System.out.println("产生一个总统！");
    }

    public static synchronized President getInstance() {
        //在getInstance方法上加同步
        if (instance == null) {
            instance = new President();
        } else {
            System.out.println("已经有一个总统，不能产生新总统！");
        }
        return instance;
    }

    public void getName() {
        System.out.println("我是美国总统：特朗普。");
    }
}