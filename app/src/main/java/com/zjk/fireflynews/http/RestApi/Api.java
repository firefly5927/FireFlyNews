package com.zjk.fireflynews.http.RestApi;

/**
 * Created by FireFly on 2016/9/23.
 */

public class Api {
    // 头条
    public static final String HEADLINE_TYPE = "headline";
    //头条id
    public static final String HEADLINE_ID = "T1348647909107";

    // 房产
    public static final String HOUSE_TYPE = "house";
    // 房产id
    public static final String HOUSE_ID = "5YyX5Lqs";

    public static final String OTHER_TYPE = "list";

    /**
     * 新闻类别获取类型
     */
    public static String getType(String id) {
        switch (id) {
            case HEADLINE_ID:
                return HEADLINE_TYPE;
            case HOUSE_ID:
                return HOUSE_TYPE;
            default:
                break;
        }
        return OTHER_TYPE;
    }

    public static final String FIREFLY_NEWS_HOST = "https://c.m.163.com/";

    /**
     * 获取对应的host
     */
    public static String getHost(int hostType){
        switch (hostType){
            case HostType.FIREFLY_NEWS_HOST:
                return FIREFLY_NEWS_HOST;
            default:
                break;
        }
        return "";
    }

}
