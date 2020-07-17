package org.sang.hanzy.designPatterns.创建型模式.原型模式;

import javax.swing.*;
import java.awt.*;
/**
 * 原型模式定义
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 */

/**
 * 原型模式结构
 * 1.抽象原型类：规定了具体原型对象必须实现的接口。
 * 2.具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 3.访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 */

/**
 * 原型模式应用场景
 * 1.对象之间相同或相似，即只是个别的几个属性不同的时候。
 * 2.对象的创建过程比较麻烦，但复制比较简单的时候。
 */

/**
 * 原型模式的克隆分为浅克隆和深克隆，
 * Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
 * 这里的 Cloneable 接口就是抽象原型类
 */

class SunWukong extends JPanel implements Cloneable {
    private static final long serialVersionUID = 5543049531872119328L;

    public SunWukong() {
        JLabel l1 = new JLabel(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Wukong.jpg"));
        this.add(l1);
    }

    public Object clone() {
        SunWukong w = null;
        try {
            w = (SunWukong) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败!");
        }
        return w;
    }
}

public class ProtoTypeWukong {
    public static void main(String[] args) {
        JFrame jf = new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        SunWukong obj1 = new SunWukong();
        contentPane.add(obj1);
        SunWukong obj2 = (SunWukong) obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}