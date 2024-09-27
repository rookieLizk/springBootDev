package com.mould.boot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mould.boot.dao.NewsRepository;
import com.mould.boot.dataobject.News;
import com.mould.boot.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.mould.boot.controller.base.BaseController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizk
 * @since 2019-11-09
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsRepository newsRepository;

    @ApiOperation(value="初始化",notes="将mysql数据库数据同步到es")
    @PostMapping("init")
    @Transactional
    public Map<String, Object> init(){
        Map<String, Object> map=new HashMap<>();
        map.put("code", 1);
        int pageNum=1,pageSize=100;
        //先删除news
        newsRepository.deleteAll();
//		循环插入数据
        IPage<News> page=newsService.page(new Page<>(pageNum,pageSize),new QueryWrapper<News>().orderByAsc("id"));
        while (page.getRecords().size()>0){
            newsRepository.saveAll(page.getRecords());
            page=newsService.page(new Page<>(++pageNum,pageSize),new QueryWrapper<News>().orderByAsc("id"));
        }
        map.put("code", 0);
        map.put("msg", "初始化完成");
        return map;
    }


    @ApiOperation(value="搜索(带分页)",notes="根据输入文本搜索，searchText为空时查询所有,检索内容`title`,`origin`,`info`,`publish_Date`,`type_Name`")
    @GetMapping("search")
    public Map<String, Object> search(
            @RequestParam(value="pageNum",required=true,defaultValue="1")Integer pageNum,
            @RequestParam(value="pageSize",required=true,defaultValue="10")Integer pageSize,
            String searchText){
        Map<String, Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        Pageable pageable = PageRequest.of(pageNum-1, pageSize, Sort.by("createTime").descending());
        if(searchText==null||searchText.length()==0) {
            map.put("page", newsRepository.findAll(pageable));
        }else {
            map.put("page", newsRepository.search(new QueryStringQueryBuilder(searchText), pageable));
        }
        return map;
    }
}
