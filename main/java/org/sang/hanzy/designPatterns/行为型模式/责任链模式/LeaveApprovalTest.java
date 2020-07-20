package org.sang.hanzy.designPatterns.行为型模式.责任链模式;

/**
 * 责任链模式定义：
 * 为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 * 优点：
 * 1.降低了对象之间的耦合度。该模式使得一个对象无须知道到底是哪一个对象处理其请求以及链的结构，发送者和接收者也无须拥有对方的明确信息。
 * 2.增强了系统的可扩展性。可以根据需要增加新的请求处理类，满足开闭原则。
 * 3.增强了给对象指派职责的灵活性。当工作流程发生变化，可以动态地改变链内的成员或者调动它们的次序，也可动态地新增或者删除责任。
 * 4.责任链简化了对象之间的连接。每个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的 if 或者 if···else 语句。
 * 5.责任分担。每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。
 * 缺点：
 * 1.不能保证每个请求一定被处理。由于一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直传到链的末端都得不到处理。
 * 2.对比较长的职责链，请求的处理可能涉及多个处理对象，系统性能将受到一定影响。
 * 3.职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错，如可能会造成循环调用。
 */

/**
 * 责任链模式结构：
 * 1.抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * 2.具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 * 3.客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
 * 责任链应用场景:
 * 1.有多个对象可以处理一个请求，哪个对象处理该请求由运行时刻自动确定。
 * 2.可动态指定一组对象处理请求，或添加新的处理者。
 * 3.在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求。
 */
public class LeaveApprovalTest
{
    public static void main(String[] args)
    {
        //组装责任链
        Leader teacher1=new ClassAdviser();
        Leader teacher2=new DepartmentHead();
        Leader teacher3=new Dean();
        Leader teacher4=new DeanOfStudies();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);
        teacher3.setNext(teacher4);
        //提交请求
        teacher1.handleRequest(20);
    }
}
//抽象处理者：领导类
abstract class Leader
{
    private Leader next;
    public void setNext(Leader next)
    {
        this.next=next;
    }
    public Leader getNext()
    {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(int LeaveDays);
}
//具体处理者1：班主任类
class ClassAdviser extends Leader
{
    public void handleRequest(int LeaveDays)
    {
        if(LeaveDays<=2)
        {
            System.out.println("班主任批准您请假" + LeaveDays + "天。");
        }
        else
        {
            if(getNext() != null)
            {
                getNext().handleRequest(LeaveDays);
            }
            else
            {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
//具体处理者2：系主任类
class DepartmentHead extends Leader
{
    public void handleRequest(int LeaveDays)
    {
        if(LeaveDays<=7)
        {
            System.out.println("系主任批准您请假" + LeaveDays + "天。");
        }
        else
        {
            if(getNext() != null)
            {
                getNext().handleRequest(LeaveDays);
            }
            else
            {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
//具体处理者3：院长类
class Dean extends Leader
{
    public void handleRequest(int LeaveDays)
    {
        if(LeaveDays<=10)
        {
            System.out.println("院长批准您请假" + LeaveDays + "天。");
        }
        else
        {
            if(getNext() != null)
            {
                getNext().handleRequest(LeaveDays);
            }
            else
            {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
//具体处理者4：教务处长类
class DeanOfStudies extends Leader
{
    public void handleRequest(int LeaveDays)
    {
        if(LeaveDays<=20)
        {
            System.out.println("教务处长批准您请假"+LeaveDays+"天。");
        }
        else
        {
            if(getNext()!=null)
            {
                getNext().handleRequest(LeaveDays);
            }
            else
            {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
