package org.sang.hanzy.excel.entity;
import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersonImportVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @Excel(name = "姓名", orderNum = "0", width = 15)
    private String name;

    @Excel(name = "性别", orderNum = "0", width = 15)
    private String sex;

    @Excel(name = "身高", orderNum = "0", width = 15)
    private Integer height;

    @Excel(name = "体重", orderNum = "0", width = 15)
    private Integer weight;


}