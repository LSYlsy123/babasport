package cn.itcast.core.controller;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌管理
 * 列表
 * 删除
 * 修改
 * 添加
 * 删除（单）
 */
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    //查询
    @RequestMapping(value = "/brand/list.do")
    public String list(String name, Integer isDisplay, Integer pageNo, Model model){

        Pagination pagination=brandService.selectPaginationByQuery(name,isDisplay,pageNo);
        model.addAttribute("pagination",pagination);
        model.addAttribute("name",name);
        if (null != isDisplay) {
            model.addAttribute("isDisplay", isDisplay);
        }else {
            model.addAttribute("isDisplay",1);
        }
        return "brand/list";
    }
}