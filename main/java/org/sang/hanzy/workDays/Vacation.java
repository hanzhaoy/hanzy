package org.sang.hanzy.workDays;
import java.io.Serializable;
import java.util.Date;
//利用面向对象的思想把假期进行封装成实体类！
public class Vacation implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Date date;
    private int days;
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public int getDays()
    {
        return days;
    }
    public void setDays(int days)
    {
        this.days = days;
    }
}
