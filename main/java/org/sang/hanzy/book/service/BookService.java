package org.sang.hanzy.book.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import org.sang.hanzy.book.dao.BookMapper;
import org.sang.hanzy.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BookService {
//    @Autowired
//    BookDao bookDao;
//    public int addBook(Book book){
//        return bookDao.addBook(book);
//    }
//    public List<Book> getAllBook(){
//        return bookDao.getAllBook();
//    }

    @Autowired
    BookMapper bookMapper;

    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }

//    @Value("${ZBTel.templatePath:false}")
//    private String templatePath;


//    public void exportBook(HttpServletResponse response) {
//        try {
//            List<Book> allBook = bookMapper.getAllBook();
//            //组装表格列表数据
//            List<Map<String, Object>> bookList = new ArrayList<Map<String, Object>>();
//            for (int i = 0; i < allBook.size(); i++) {
//                Map<String, Object> bookMap = new HashMap<String, Object>();
//                //书名
//                bookMap.put("bookName", allBook.get(i).getName());
//                //作者名
//                bookMap.put("author", allBook.get(i).getAuthor());
//                //价格
//                bookMap.put("price", i*100);
//                bookList.add(bookMap);
//            }
//            //值班记录模板路径
//            String resource = templatePath;
//            //渲染表格
//            HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
//            Configure config = Configure.newBuilder().bind("bookList", policy).build();
//            XWPFTemplate template = XWPFTemplate.compile(resource, config).render(
//                    new HashMap<String, Object>() {{
//                        //时间
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
//                        put("toDay", simpleDateFormat.format(new Date()));
//                        //表格内容
//                        put("bookList", bookList);
//
//                    }}
//            );
//            // 生成的word格式
//            String formatSuffix = ".docx";
//            // 拼接后的文件名
//            String fileName = URLEncoder.encode("书本价格" + formatSuffix, "UTF-8");
//
//            FileOutputStream fos = new FileOutputStream(fileName);
//            template.write(fos);
//            //=================生成word到设置浏览默认下载地址=================
//            // 设置强制下载不打开
//            response.setContentType("application/force-download");
//            // 设置文件名
//            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
//            OutputStream out = response.getOutputStream();
//            template.write(out);
//            out.flush();
//            out.close();
//            template.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
