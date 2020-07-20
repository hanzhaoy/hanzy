package org.sang.hanzy.designPatterns.行为型模式.策略模式;

/**
 * 策略模式定义：
 * 该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。
 * 策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。
 * 优点：
 * 1.多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句。
 * 2.策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。
 * 3.策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。
 * 4.策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。
 * 5.策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离。
 * 缺点：
 * 1.客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类。
 * 2.策略模式造成很多的策略类。
 * <p>
 * 策略模式结构：
 * 1.抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 * 2.具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
 * 3.环境（Context）类：持有一个策略类的引用，最终给客户端调用。
 */

/**
 * 策略模式结构：
 * 1.抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 * 2.具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
 * 3.环境（Context）类：持有一个策略类的引用，最终给客户端调用。
 * 策略模式应用场景：
 * 1.一个系统需要动态地在几种算法中选择一种时，可将每个算法封装到策略类中。
 * 2.一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现，可将每个条件分支移入它们各自的策略类中以代替这些条件语句。
 * 3.系统中各算法彼此完全独立，且要求对客户隐藏具体算法的实现细节时。
 * 4.系统要求使用算法的客户不应该知道其操作的数据时，可使用策略模式来隐藏与算法相关的数据结构。
 * 5.多个类只区别在表现行为不同，可以使用策略模式，在运行时动态选择具体要执行的行为。
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrabCookingStrategy implements ItemListener {
    private JFrame f;
    private JRadioButton qz, hs;
    private JPanel CenterJP, SouthJP;
    private Kitchen cf;    //厨房
    private CrabCooking qzx, hsx;    //大闸蟹加工者

    CrabCookingStrategy() {
        f = new JFrame("策略模式在大闸蟹做菜中的应用");
        f.setBounds(100, 100, 500, 400);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SouthJP = new JPanel();
        CenterJP = new JPanel();
        f.add("South", SouthJP);
        f.add("Center", CenterJP);
        qz = new JRadioButton("清蒸大闸蟹");
        hs = new JRadioButton("红烧大闸蟹");
        qz.addItemListener(this);
        hs.addItemListener(this);
        ButtonGroup group = new ButtonGroup();
        group.add(qz);
        group.add(hs);
        SouthJP.add(qz);
        SouthJP.add(hs);
        //---------------------------------
        cf = new Kitchen();    //厨房
        qzx = new SteamedCrabs();    //清蒸大闸蟹类
        hsx = new BraisedCrabs();    //红烧大闸蟹类
    }

    public void itemStateChanged(ItemEvent e) {
        JRadioButton jc = (JRadioButton) e.getSource();
        if (jc == qz) {
            cf.setStrategy(qzx);
            cf.CookingMethod(); //清蒸
        } else if (jc == hs) {
            cf.setStrategy(hsx);
            cf.CookingMethod(); //红烧
        }
        CenterJP.removeAll();
        CenterJP.repaint();
        CenterJP.add((Component) cf.getStrategy());
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new CrabCookingStrategy();
    }
}

//抽象策略类：大闸蟹加工类
interface CrabCooking {
    public void CookingMethod();    //做菜方法
}

//具体策略类：清蒸大闸蟹
class SteamedCrabs extends JLabel implements CrabCooking {
    private static final long serialVersionUID = 1L;

    public void CookingMethod() {
        this.setIcon(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/SteamedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }
}

//具体策略类：红烧大闸蟹
class BraisedCrabs extends JLabel implements CrabCooking {
    private static final long serialVersionUID = 1L;

    public void CookingMethod() {
        this.setIcon(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/BraisedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }
}

//环境类：厨房
class Kitchen {
    private CrabCooking strategy;    //抽象策略

    public void setStrategy(CrabCooking strategy) {
        this.strategy = strategy;
    }

    public CrabCooking getStrategy() {
        return strategy;
    }

    public void CookingMethod() {
        strategy.CookingMethod();    //做菜
    }
}