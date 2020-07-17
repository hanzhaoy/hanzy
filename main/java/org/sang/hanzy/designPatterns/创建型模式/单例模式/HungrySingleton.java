package org.sang.hanzy.designPatterns.创建型模式.单例模式;

import javax.swing.*;
import java.awt.*;
/**
 * 单例模式： 指一个类只有一个实例，且该类能自行创建这个实例的一种模式。
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
 * 饿汉式单例
 * 类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了
 * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 */

public class HungrySingleton {
    public static void main(String[] args) {
        JFrame jf = new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        Bajie obj1 = Bajie.getInstance();
        contentPane.add(obj1);
        Bajie obj2 = Bajie.getInstance();
        contentPane.add(obj2);
        if (obj1 == obj2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Bajie extends JPanel {
    private static Bajie instance = new Bajie();

    private Bajie() {
        JLabel l1 = new JLabel(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Bajie.jpg"));
        this.add(l1);
    }

    public static Bajie getInstance() {
        return instance;
    }
}