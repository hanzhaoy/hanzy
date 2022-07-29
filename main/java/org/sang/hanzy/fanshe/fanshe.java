package org.sang.hanzy.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @description
 * @author: hanchaoyang
 * @createDate: 2022/5/23 10:19
 * @version: 1.0
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 */
public class fanshe {
    public static void main(String[] args) throws Exception {
        //第一种方式获取Class对象
        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("org.sang.hanzy.fanshe.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         /**
         * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
         *
         * 1.获取构造方法：
         * 		1).批量的方法：
         * 			public Constructor[] getConstructors()：所有"公有的"构造方法
                    public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

         * 		2).获取单个的方法，并调用：
         * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
         * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
         *
         * 			调用构造方法：
         * 			Constructor-->newInstance(Object... initargs)
         */

        //1.加载Class对象
        Class clazz = Class.forName("org.sang.hanzy.fanshe.Student");


        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }


        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();
        //	System.out.println("obj = " + obj);
        //	Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');

        /**
        * 获取成员变量并调用：
        *
        * 1.批量的
        * 		1).Field[] getFields():获取所有的"公有字段"
        * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
        * 2.获取单个的：
        * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
        * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
        *
        * 	 设置字段的值：
        * 		Field --> public void set(Object obj,Object value):
        * 					参数说明：
        * 					1.obj:要设置的字段所在的对象；
        * 					2.value:要为字段设置的值；
        *
        */

        //1.获取Class对象
        Class stuClass11 = Class.forName("fanshe.field.Student");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass11.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass11.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = stuClass11.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj11 = stuClass11.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj11, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student stu = (Student)obj11;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("**************获取私有字段****并调用********************************");
        f = stuClass11.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);

    }

}
