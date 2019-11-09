package com.mould.boot.dao;

import com.mould.boot.dataobject.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Demo class
 *
 * @author lizk
 * @date 2019/11/09
 */
public interface NewsRepository extends ElasticsearchRepository<News, Integer> {
}
