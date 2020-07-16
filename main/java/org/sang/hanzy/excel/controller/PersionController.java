package org.sang.hanzy.excel.controller;

import org.sang.hanzy.R;
import org.sang.hanzy.excel.entity.PersonExportVo;
import org.sang.hanzy.excel.entity.PersonImportVo;
import org.sang.hanzy.excel.service.PersionService;
import org.sang.hanzy.utils.DowloadExcelUtil;
import org.sang.hanzy.utils.ExcelUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/persion")
public class PersionController {

    @Autowired
    PersionService persionService;
    @RequestMapping(value = "/persionOps")
    public void persionOps(){
        PersonExportVo persion = new PersonExportVo();
        persion.setName("韩朝洋");
        persion.setSex("男");
        persion.setHeight(172);
        persion.setWeight(150);
        int i = persionService.addPersion(persion);
        System.out.println("addPserion"+i);
        List<PersonExportVo> allPersion = persionService.getAllPersion();
        System.out.println(allPersion.toString());

    }

    /**
     * 导出
     *
     * @param response
     */
    @GetMapping(value = "/export")
    public void exportExcel(HttpServletResponse response) {
        //long start = System.currentTimeMillis();
        List<PersonExportVo> personList = new ArrayList<>();
        List<PersonExportVo> allPersion = persionService.getAllPersion();
        for (int i = 0; i < allPersion.size(); i++) {
            personList.add(allPersion.get(i));
        }
        //log.debug("导出excel所花时间：" + (System.currentTimeMillis() - start));
        try {
            ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 下载模板
     *
     * @param response
     */
    @GetMapping(value = "/dowloadExcel")
    public void dowloadExcel(HttpServletResponse response, HttpServletRequest request) {

        DowloadExcelUtil.dowloadTemplate(response, request, "persion.xlsx", "员工信息导入模板");
    }

    @PostMapping(value ="/importExcel")
    public R importExcel(@RequestParam MultipartFile file){
        List<PersonImportVo> persiones;
        Map<String,String> retMap = new HashMap<>();
        try{
            persiones = ExcelUtils.importExcel(file, 0, 1, PersonImportVo.class);
            if(persiones==null || persiones.size()==0){
                return R.error("导入模板数据为空！");
            }
            for (int i = 0; i < persiones.size(); i++) {
                PersonImportVo vo = persiones.get(i);
                PersonExportVo personExportVo = new  PersonExportVo();
                BeanUtils.copyProperties(vo,personExportVo);
                int i1 = persionService.addPersion(personExportVo);
            }
        }catch(Exception e){
            e.printStackTrace();
            return R.error("导入失败!");
        }
        return R.ok("导入成功!");
    }
}
