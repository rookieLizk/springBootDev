package com.mould.boot.service.impl;

import com.mould.boot.dataobject.News;
import com.mould.boot.mapper.NewsMapper;
import com.mould.boot.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizk
 * @since 2019-11-09
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
