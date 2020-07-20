package org.sang.hanzy.designPatterns.结构性模式.外观模式;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 * 外观模式定义：
 * 是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式。
 * 该模式对外有一个统一接口，外部应用程序不用关心内部子系统的具体的细节，这样会大大降低应用程序的复杂度，提高了程序的可维护性。
 * 优点：
 * 1.降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
 * 2.对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。
 * 3.降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。
 * 缺点：
 * 1.不能很好地限制客户使用子系统类。
 * 2.增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”。
 */

/**
 * 外观模式格式：
 * 1.外观（Facade）角色：为多个子系统对外提供一个共同的接口。
 * 2.子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
 * 3.客户（Client）角色：通过一个外观角色访问各个子系统的功能。
 * 外观观模式应用场景：
 * 1.对分层结构系统构建时，使用外观模式定义子系统中每层的入口点可以简化子系统之间的依赖关系。
 * 2.当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问。
 * 3.当客户端与多个子系统之间存在很大的联系时，引入外观模式可将它们分离，从而提高子系统的独立性和可移植性。
 */

public class WySpecialtyFacade {
    public static void main(String[] args) {
        JFrame f = new JFrame("外观模式: 婺源特产选择测试");
        Container cp = f.getContentPane();
        WySpecialty wys = new WySpecialty();
        JScrollPane treeView = new JScrollPane(wys.tree);
        JScrollPane scrollpane = new JScrollPane(wys.label);
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, treeView, scrollpane); //分割面版
        splitpane.setDividerLocation(230);     //设置splitpane的分隔线位置
        splitpane.setOneTouchExpandable(true); //设置splitpane可以展开或收起
        cp.add(splitpane);
        f.setSize(650, 350);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class WySpecialty extends JPanel implements TreeSelectionListener {
    private static final long serialVersionUID = 1L;
    final JTree tree;
    JLabel label;
    private Specialty1 s1 = new Specialty1();
    private Specialty2 s2 = new Specialty2();
    private Specialty3 s3 = new Specialty3();
    private Specialty4 s4 = new Specialty4();
    private Specialty5 s5 = new Specialty5();
    private Specialty6 s6 = new Specialty6();
    private Specialty7 s7 = new Specialty7();
    private Specialty8 s8 = new Specialty8();

    WySpecialty() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("婺源特产");
        DefaultMutableTreeNode node1 = null, node2 = null, tempNode = null;
        node1 = new DefaultMutableTreeNode("婺源四大特产（红、绿、黑、白）");
        tempNode = new DefaultMutableTreeNode("婺源荷包红鲤鱼");
        node1.add(tempNode);
        tempNode = new DefaultMutableTreeNode("婺源绿茶");
        node1.add(tempNode);
        tempNode = new DefaultMutableTreeNode("婺源龙尾砚");
        node1.add(tempNode);
        tempNode = new DefaultMutableTreeNode("婺源江湾雪梨");
        node1.add(tempNode);
        top.add(node1);
        node2 = new DefaultMutableTreeNode("婺源其它土特产");
        tempNode = new DefaultMutableTreeNode("婺源酒糟鱼");
        node2.add(tempNode);
        tempNode = new DefaultMutableTreeNode("婺源糟米子糕");
        node2.add(tempNode);
        tempNode = new DefaultMutableTreeNode("婺源清明果");
        node2.add(tempNode);
        tempNode = new DefaultMutableTreeNode("婺源油煎灯");
        node2.add(tempNode);
        top.add(node2);
        tree = new JTree(top);
        tree.addTreeSelectionListener(this);
        label = new JLabel();
    }

    public void valueChanged(TreeSelectionEvent e) {
        if (e.getSource() == tree) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node == null) return;
            if (node.isLeaf()) {
                Object object = node.getUserObject();
                String sele = object.toString();
                label.setText(sele);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.BOTTOM);
                sele = sele.substring(2, 4);
                if (sele.equalsIgnoreCase("荷包")) label.setIcon(s1);
                else if (sele.equalsIgnoreCase("绿茶")) label.setIcon(s2);
                else if (sele.equalsIgnoreCase("龙尾")) label.setIcon(s3);
                else if (sele.equalsIgnoreCase("江湾")) label.setIcon(s4);
                else if (sele.equalsIgnoreCase("酒糟")) label.setIcon(s5);
                else if (sele.equalsIgnoreCase("糟米")) label.setIcon(s6);
                else if (sele.equalsIgnoreCase("清明")) label.setIcon(s7);
                else if (sele.equalsIgnoreCase("油煎")) label.setIcon(s8);
                label.setHorizontalAlignment(JLabel.CENTER);
            }
        }
    }
}

class Specialty1 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty1() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty11.jpg");
    }
}

class Specialty2 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty2() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty12.jpg");
    }
}

class Specialty3 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty3() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty13.jpg");
    }
}

class Specialty4 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty4() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty14.jpg");
    }
}

class Specialty5 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty5() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty21.jpg");
    }
}

class Specialty6 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty6() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty22.jpg");
    }
}

class Specialty7 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty7() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty23.jpg");
    }
}

class Specialty8 extends ImageIcon {
    private static final long serialVersionUID = 1L;

    Specialty8() {
        super("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/Specialty24.jpg");
    }
}
