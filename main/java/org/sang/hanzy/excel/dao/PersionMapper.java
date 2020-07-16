package org.sang.hanzy.excel.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sang.hanzy.excel.entity.PersonExportVo;

import java.util.List;

@Mapper
public interface PersionMapper {
    int addPersion(PersonExportVo persion);
    List<PersonExportVo> getAllPersion();
}
