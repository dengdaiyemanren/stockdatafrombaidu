package org.com.onetopic.stockdata;

import org.com.onetopic.stockdata.bdget.ApiUtils;

import com.alibaba.fastjson.JSONObject;

public class Test
{
    public static void main(String[] args)
    {
        new Test().getDataBaseInfo();
    }
    
    public void getDataBaseInfo()
    {
        String httpUrl = "http://apis.baidu.com/apistore/stockservice/stock";
        String httpArg = "stockid=sz002230&list=1";
        String apiKey = "f0b7ff5ff57a4e350ad0212c199dce02";
        
        String jsonResult = new ApiUtils().request(httpUrl, httpArg, apiKey);
        System.out.println(jsonResult);
        JSONObject object = JSONObject.parseObject(jsonResult);
        System.out.println(object.get("errNum"));
    }
    
}
