package org.sang.hanzy.designPatterns.行为型模式.备忘录模式;

/**
 * 备忘录模式定义：
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后当需要时能将该对象恢复到原先保存的状态。该模式又叫快照模式
 * 优点：
 * 1.提供了一种可以恢复状态的机制。当用户需要时能够比较方便地将数据恢复到某个历史的状态。
 * 2.实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。
 * 3.简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则。
 * 缺点：
 * 1.资源消耗大。如果要保存的内部状态信息过多或者特别频繁，将会占用比较大的内存资源。
 * <p>
 * 备忘录模式格式：
 * 1.发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息。
 * 2.备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 3.管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 */

/**
 * 备忘录模式格式：
 * 1.发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息。
 * 2.备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 3.管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 * 备忘录模式应用场景：
 * 1.需要保存与恢复数据的场景，如玩游戏时的中间结果的存档功能。
 * 2.需要提供一个可回滚操作的场景，如 Word、记事本、Photoshop，Eclipse 等软件在编辑时按 Ctrl+Z 组合键，还有数据库中事务操作
 */

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class DatingGame {
    public static void main(String[] args) {
        new DatingGameWin();
    }
}

//客户窗体类
class DatingGameWin extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JPanel CenterJP, EastJP;
    JRadioButton girl1, girl2, girl3, girl4;
    JButton button1, button2;
    String FileName;
    JLabel g;
    You you;
    GirlStack girls;

    DatingGameWin() {
        super("利用备忘录模式设计相亲游戏");
        you = new You();
        girls = new GirlStack();
        this.setBounds(0, 0, 900, 380);
        this.setResizable(false);
        FileName = "D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/四大美女.jpg";
        g = new JLabel(new ImageIcon(FileName), JLabel.CENTER);
        CenterJP = new JPanel();
        CenterJP.setLayout(new GridLayout(1, 4));
        CenterJP.setBorder(BorderFactory.createTitledBorder("四大美女如下："));
        CenterJP.add(g);
        this.add("Center", CenterJP);
        EastJP = new JPanel();
        EastJP.setLayout(new GridLayout(1, 1));
        EastJP.setBorder(BorderFactory.createTitledBorder("您选择的爱人是："));
        this.add("East", EastJP);
        JPanel SouthJP = new JPanel();
        JLabel info = new JLabel("四大美女有“沉鱼落雁之容、闭月羞花之貌”，您选择谁？");
        girl1 = new JRadioButton("西施", true);
        girl2 = new JRadioButton("貂蝉");
        girl3 = new JRadioButton("王昭君");
        girl4 = new JRadioButton("杨玉环");
        button1 = new JButton("确定");
        button2 = new JButton("返回");
        ButtonGroup group = new ButtonGroup();
        group.add(girl1);
        group.add(girl2);
        group.add(girl3);
        group.add(girl4);
        SouthJP.add(info);
        SouthJP.add(girl1);
        SouthJP.add(girl2);
        SouthJP.add(girl3);
        SouthJP.add(girl4);
        SouthJP.add(button1);
        SouthJP.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        this.add("South", SouthJP);
        showPicture("空白");
        you.setWife("空白");
        girls.push(you.createMemento());    //保存状态
    }

    //显示图片
    void showPicture(String name) {
        EastJP.removeAll(); //清除面板内容
        EastJP.repaint(); //刷新屏幕
        you.setWife(name);
        FileName = "D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/" + name + ".jpg";
        g = new JLabel(new ImageIcon(FileName), JLabel.CENTER);
        EastJP.add(g);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean ok = false;
        if (e.getSource() == button1) {
            ok = girls.push(you.createMemento());    //保存状态
            if (ok && girl1.isSelected()) {
                showPicture("西施");
            } else if (ok && girl2.isSelected()) {
                showPicture("貂蝉");
            } else if (ok && girl3.isSelected()) {
                showPicture("王昭君");
            } else if (ok && girl4.isSelected()) {
                showPicture("杨玉环");
            }
        } else if (e.getSource() == button2) {
            you.restoreMemento(girls.pop()); //恢复状态
            showPicture(you.getWife());
        }
    }
}

//备忘录：美女
class Girl {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//发起人：您
class You {
    private String wifeName;    //妻子

    public void setWife(String name) {
        wifeName = name;
    }

    public String getWife() {
        return wifeName;
    }

    public Girl createMemento() {
        return new Girl(wifeName);
    }

    public void restoreMemento(Girl p) {
        setWife(p.getName());
    }
}

//管理者：美女栈
class GirlStack {
    private Girl girl[];
    private int top;

    GirlStack() {
        girl = new Girl[5];
        top = -1;
    }

    public boolean push(Girl p) {
        if (top >= 4) {
            System.out.println("你太花心了，变来变去的！");
            return false;
        } else {
            girl[++top] = p;
            return true;
        }
    }

    public Girl pop() {
        if (top <= 0) {
            System.out.println("美女栈空了！");
            return girl[0];
        } else return girl[top--];
    }
}
