package org.sang.hanzy.excel.service;

import org.sang.hanzy.excel.entity.PersonExportVo;
import org.sang.hanzy.excel.dao.PersionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersionService {

    @Autowired
    PersionDao persionDao;
    public int addPersion(PersonExportVo persion){
        return persionDao.addPersion(persion);
    }
    public List<PersonExportVo> getAllPersion(){
        return persionDao.getAllPersion();
    }
}
