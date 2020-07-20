package org.sang.hanzy.designPatterns.行为型模式.命令模式;

/**
 * 命令模式定义：
 * 将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
 * 这样两者之间通过命令对象进行沟通，这样方便将命令对象进行储存、传递、调用、增加与管理。
 * 优点：
 * 1.降低系统的耦合度。命令模式能将调用操作的对象与实现该操作的对象解耦。
 * 2.增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，它满足“开闭原则”，对扩展比较灵活。
 * 3.可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令。
 * 4.方便实现 Undo 和 Redo 操作。命令模式可以与后面介绍的备忘录模式结合，实现命令的撤销与恢复。
 * 缺点：
 * 1.可能产生大量具体命令类。因为计对每一个具体操作都需要设计一个具体命令类，这将增加系统的复杂性。
 * <p>
 * 命令模式结构：
 * 1.抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
 * 2.具体命令角色（Concrete    Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
 * 实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 * 3.调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。
 */

/**
 * 命令模式结构：
 * 1.抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
 * 2.具体命令角色（Concrete    Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
 * 实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 * 3.调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。
 * 命令模式应用场景：
 * 1.当系统需要将请求调用者与请求接收者解耦时，命令模式使得调用者和接收者不直接交互。
 * 2.当系统需要随机请求命令或经常增加或删除命令时，命令模式比较方便实现这些功能。
 * 3.当系统需要执行一组操作时，命令模式可以定义宏命令来实现该功能。
 * 4.当系统需要支持命令的撤销（Undo）操作和恢复（Redo）操作时，可以将命令对象存储起来，采用备忘录模式来实现。
 */

import javax.swing.*;

public class CookingCommand {
    public static void main(String[] args) {
        Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunTun();
        Breakfast food3 = new HeFen();
        Waiter fwy = new Waiter();
        fwy.setChangFen(food1);//设置肠粉菜单
        fwy.setHunTun(food2);  //设置河粉菜单
        fwy.setHeFen(food3);   //设置馄饨菜单
        fwy.chooseChangFen();  //选择肠粉
        fwy.chooseHeFen();     //选择河粉
        fwy.chooseHunTun();    //选择馄饨
    }
}

//调用者：服务员
class Waiter {
    private Breakfast changFen, hunTun, heFen;

    public void setChangFen(Breakfast f) {
        changFen = f;
    }

    public void setHunTun(Breakfast f) {
        hunTun = f;
    }

    public void setHeFen(Breakfast f) {
        heFen = f;
    }

    public void chooseChangFen() {
        changFen.cooking();
    }

    public void chooseHunTun() {
        hunTun.cooking();
    }

    public void chooseHeFen() {
        heFen.cooking();
    }
}

//抽象命令：早餐
interface Breakfast {
    public abstract void cooking();
}

//具体命令：肠粉
class ChangFen implements Breakfast {
    private ChangFenChef receiver;

    ChangFen() {
        receiver = new ChangFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//具体命令：馄饨
class HunTun implements Breakfast {
    private HunTunChef receiver;

    HunTun() {
        receiver = new HunTunChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//具体命令：河粉
class HeFen implements Breakfast {
    private HeFenChef receiver;

    HeFen() {
        receiver = new HeFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//接收者：肠粉厨师
class ChangFenChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    ChangFenChef() {
        super("煮肠粉");
        l.setIcon(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/ChangFen.jpg"));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}

//接收者：馄饨厨师
class HunTunChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    HunTunChef() {
        super("煮馄饨");
        l.setIcon(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/HunTun.jpg"));
        this.add(l);
        this.setLocation(350, 50);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}

//接收者：河粉厨师
class HeFenChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    HeFenChef() {
        super("煮河粉");
        l.setIcon(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/HeFen.jpg"));
        this.add(l);
        this.setLocation(200, 280);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}
