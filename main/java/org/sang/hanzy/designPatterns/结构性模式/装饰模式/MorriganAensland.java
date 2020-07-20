package org.sang.hanzy.designPatterns.结构性模式.装饰模式;

import java.awt.*;
import javax.swing.*;
/**
 * 装饰模式定义：
 * 指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。
 * 优点：
 * 1.采用装饰模式扩展对象的功能比采用继承方式更加灵活。
 * 2.可以设计出多个不同的具体装饰类，创造出多个不同行为的组合。
 * 缺点：
 * 1.装饰模式增加了许多子类，如果过度使用会使程序变得很复杂
 */

/**
 * 装饰模式格式：
 * 1.抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 2.具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 3.抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 4.具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
/**
 * 装饰模式应用场景：
 * 1.当需要给一个现有类添加附加职责，而又不能采用生成子类的方法进行扩充时。例如，该类被隐藏或者该类是终极类或者采用继承方式会产生大量的子类。
 * 2.当需要通过对现有的一组基本功能进行排列组合而产生非常多的功能时，采用继承关系很难实现，而采用装饰模式却很好实现。
 * 3.当对象的功能要求可以动态地添加，也可以再动态地撤销时。
 */

public class MorriganAensland {
    public static void main(String[] args) {
        Morrigan m0 = new original();
        m0.display();
        Morrigan m1 = new Succubus(m0);
        m1.display();
        Morrigan m2 = new Girl(m0);
        m2.display();
    }
}

//抽象构件角色：莫莉卡
interface Morrigan {
    public void display();
}

//具体构件角色：原身
class original extends JFrame implements Morrigan {
    private static final long serialVersionUID = 1L;
    private String t = "Morrigan0.jpg";

    public original() {
        super("《恶魔战士》中的莫莉卡·安斯兰");
    }

    public void setImage(String t) {
        this.t = t;
    }

    public void display() {
        this.setLayout(new FlowLayout());
        JLabel l1 = new JLabel(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/" + t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//抽象装饰角色：变形
class Changer implements Morrigan {
    Morrigan m;

    public Changer(Morrigan m) {
        this.m = m;
    }

    public void display() {
        m.display();
    }
}

//具体装饰角色：女妖
class Succubus extends Changer {
    public Succubus(Morrigan m) {
        super(m);
    }

    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((original) super.m).setImage("Morrigan1.jpg");
    }
}

//具体装饰角色：少女
class Girl extends Changer {
    public Girl(Morrigan m) {
        super(m);
    }

    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((original) super.m).setImage("Morrigan2.jpg");
    }
}
