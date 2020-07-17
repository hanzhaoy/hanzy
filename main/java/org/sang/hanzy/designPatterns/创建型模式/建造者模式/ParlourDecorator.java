package org.sang.hanzy.designPatterns.创建型模式.建造者模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;

/**
 * 建造者模式：
 * 指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 * 它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。
 * 它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 *
 *优点：
 * 1.各个具体的建造者相互独立，有利于系统的扩展。
 * 2.客户端不必知道产品内部组成的细节，便于控制细节风险。
 * 缺点：
 * 产品的组成部分必须相同，这限制了其使用范围。
 * 如果产品的内部变化复杂，该模式会增加很多的建造者类。
 */

/**
 * 建造者模式格式：
 * 1.产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
 * 2.抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 3.具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 4.指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 * 应用场景：
 * 1.创建的对象较复杂，由多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的。
 * 2.创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的。
 */
public class ParlourDecorator {
    public static void main(String[] args)
    {
        try
        {
            Decorator d;
            d=(Decorator) ReadXML.getObject();
            ProjectManager m=new ProjectManager(d);
            Parlour p=m.decorate();
            p.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

//产品：客厅
class Parlour
{
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发
    public void setWall(String wall)
    {
        this.wall=wall;
    }
    public void setTV(String TV)
    {
        this.TV=TV;
    }
    public void setSofa(String sofa)
    {
        this.sofa=sofa;
    }
    public void show()
    {
        JFrame jf=new JFrame("建造者模式测试");
        Container contentPane=jf.getContentPane();
        JPanel p=new JPanel();
        JScrollPane sp=new JScrollPane(p);
        String parlour=wall+TV+sofa;
        JLabel l=new JLabel(new ImageIcon("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/"+parlour+".jpg"));
        p.setLayout(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder("客厅"));
        p.add(l);
        contentPane.add(sp,BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//抽象建造者：装修工人
abstract class Decorator
{
    //创建产品对象
    protected Parlour product=new Parlour();
    public  abstract void buildWall();
    public  abstract void buildTV();
    public  abstract void buildSofa();
    //返回产品对象
    public Parlour getResult()
    {
        return  product;
    }
}

//具体建造者：具体装修工人1
class ConcreteDecorator1  extends Decorator
{
    public void buildWall()
    {
        product.setWall("w1");
    }
    public void buildTV()
    {
        product.setTV("TV1");
    }
    public void buildSofa()
    {
        product.setSofa("sf1");
    }
}

//具体建造者：具体装修工人2
class ConcreteDecorator2 extends Decorator
{
    public void buildWall()
    {
        product.setWall("w2");
    }
    public void buildTV()
    {
        product.setTV("TV2");
    }
    public void buildSofa()
    {
        product.setSofa("sf2");
    }
}

//指挥者：项目经理
class ProjectManager
{
    private Decorator builder;
    public ProjectManager(Decorator builder)
    {
        this.builder=builder;
    }
    //产品构建与组装方法
    public Parlour decorate()
    {
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }
}

class ReadXML
{
    public static Object getObject()
    {
        try
        {
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/config.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(2).getFirstChild();
            String cName="org.sang.hanzy.designPatterns.创建型模式.建造者模式."+classNode.getNodeValue();
            System.out.println("新类名："+cName);
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
