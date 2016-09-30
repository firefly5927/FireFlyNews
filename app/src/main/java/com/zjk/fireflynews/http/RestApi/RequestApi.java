package com.zjk.fireflynews.http.RestApi;

import com.zjk.fireflynews.data.NewsListData;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by FireFly on 2016/9/23.
 */

public interface RequestApi {
    /**
     * 请求新闻列表 例子：http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
     *
     * @param type      新闻类别：headline为头条,local为北京本地,fangchan为房产,list为其他
     * @param id        新闻类别id
     * @param startPage 开始的页码
     * @return 被观察对象
     */
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String,List<NewsListData>>> getNewList(
            @Header("Cache-Control")String cacheControl,
            @Path("type") String type, @Path("id") String id,
            @Path("startPage") int startPage);
}