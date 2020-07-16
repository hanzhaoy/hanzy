package org.sang.hanzy.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DowloadExcelUtil {

    public static void dowloadTemplate(HttpServletResponse response, HttpServletRequest request, String templateName, String downLoadName){
        OutputStream outp = null;
        FileInputStream in = null;
        try {
            String fileName = templateName;
            if(templateName!=null){
                if(!templateName.endsWith(".xlsx")){
                    fileName = templateName+".xlsx";
                }
            }

            String fileDir = "doc";
            //获取文件路径
            String osname = System.getProperty("os.name").toLowerCase();
            String rootPath = "";
            if (osname.indexOf("windows") >= 0) {
                rootPath = new org.sang.hanzy.utils.DowloadExcelUtil().getClass().getResource("/").getFile().substring(1);
            } else {
                rootPath = new org.sang.hanzy.utils.DowloadExcelUtil().getClass().getResource("/").getPath();
            }
            String path = rootPath + fileDir + File.separator;
            String filedowload = path + fileName;

            String fileNameStr = URLEncoder.encode(downLoadName, "UTF-8");
            fileNameStr = fileNameStr+".xlsx";
            //要下载的模板所在的绝对路径
            response.reset();
            response.addHeader("Access-Control-Allow-Origin","*");
            response.addHeader("Content-Disposition","attachment; filename="+fileNameStr);
            response.setContentType("application/octet-stream;charset=UTF-8");
            outp = response.getOutputStream();
            in = new FileInputStream(filedowload);
            byte[] b = new byte[1024];
            int i=0;
            while ((i=in.read(b))>0){
                outp.write(b,0,i);
            }
            outp.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(in!=null){
                    in.close();
                    in = null;
                }
                if(outp!=null){
                    outp.close();
                    outp=null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
