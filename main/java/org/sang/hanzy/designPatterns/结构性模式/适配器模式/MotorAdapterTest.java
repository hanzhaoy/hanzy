package org.sang.hanzy.designPatterns.结构性模式.适配器模式;

/**
 * 适配器模式定义：
 * 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 * 适配器模式分为类结构型模式和对象结构型模式两种
 * 类结构型模式类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些
 * 优点：
 * 1.客户端通过适配器可以透明地调用目标接口。
 * 2.复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 * 3.将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 * 缺点：
 * 1.对类适配器来说，更换适配器的实现过程比较复杂。
 */

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * 适配器模式格式：
 * 1.目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 * 2.适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * 3.适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 * 适配器模式场景：
 * 1.以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。
 * 2.使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。
 */

//目标：发动机
interface Motor {
    public void drive();
}

//适配者1：电能发动机
class ElectricMotor {
    public void electricDrive() {
        System.out.println("电能发动机驱动汽车！");
    }
}

//适配者2：光能发动机
class OpticalMotor {
    public void opticalDrive() {
        System.out.println("光能发动机驱动汽车！");
    }
}

//电能适配器
class ElectricAdapter implements Motor {
    private ElectricMotor emotor;

    public ElectricAdapter() {
        emotor = new ElectricMotor();
    }

    public void drive() {
        emotor.electricDrive();
    }
}

//光能适配器
class OpticalAdapter implements Motor {
    private OpticalMotor omotor;

    public OpticalAdapter() {
        omotor = new OpticalMotor();
    }

    public void drive() {
        omotor.opticalDrive();
    }
}

//客户端代码
public class MotorAdapterTest {
    public static void main(String[] args) {
        System.out.println("适配器模式测试：");
        Motor motor = (Motor) ReadXML.getObject();
        motor.drive();
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:/project/hanzy/src/main/java/org/sang/hanzy/designPatterns/src/config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(3).getFirstChild();
            String cName = "org.sang.hanzy.designPatterns.结构性模式.适配器模式." + classNode.getNodeValue();
            System.out.println("新类名：" + cName);
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}