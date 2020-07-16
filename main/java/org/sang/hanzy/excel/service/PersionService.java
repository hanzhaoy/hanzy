package org.sang.hanzy.excel.service;

import org.sang.hanzy.excel.dao.PersionMapper;
import org.sang.hanzy.excel.entity.PersonExportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersionService {
//    @Autowired
//    BookDao bookDao;
//    public int addBook(Book book){
//        return bookDao.addBook(book);
//    }
//    public List<Book> getAllBook(){
//        return bookDao.getAllBook();
//    }

    @Autowired
    PersionMapper persionMapper;
    public int addPersion(PersonExportVo persion){
        return persionMapper.addPersion(persion);
    }
    public List<PersonExportVo> getAllPersion(){
        return persionMapper.getAllPersion();
    }
}
