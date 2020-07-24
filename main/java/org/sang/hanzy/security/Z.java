package org.sang.hanzy.security;

/**
 * 1.父类静态代码块 java虚拟机加载类时，就会执行该块代码，故只执行一次）
 * 2.子类静态代码块 java虚拟机加载类时，就会执行该块代码，故只执行一次）
 * 3.父类属性对象初始化
 * 4.父类普通代码块（每次new,每次执行）
 * 5.父类构造函数（每次new,每次执行）
 * 6.子类属性对象初始化
 * 7.子类普通代码块（每次new,每次执行）
 * 8.子类构造函数（每次new,每次执行）
 */
class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
public class Z extends X{
    Y y=new Y();
    public Z(){
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Z();
    }
}
