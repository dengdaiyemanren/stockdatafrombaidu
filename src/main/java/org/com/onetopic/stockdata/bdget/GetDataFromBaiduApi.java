package org.com.onetopic.stockdata.bdget;

import java.util.ArrayList;
import java.util.List;

import org.com.onetopic.stockdata.bddomain.CodeInfo;
import org.com.onetopic.stockdata.bddomain.MarketInfo;
import org.com.onetopic.stockdata.bddomain.Stock;
import org.com.onetopic.stockdata.bddomain.StockInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class GetDataFromBaiduApi
{
    
    public void getKLine(String kLineURl)
    {
        //String httpUrl = "http://apis.baidu.com/apistore/stockservice/stock";
        String apiKey = "f0b7ff5ff57a4e350ad0212c199dce02";
        
        String jsonResult = new ApiUtils().request(kLineURl, null, apiKey);
        System.out.println(jsonResult);
    }
    public Stock getDataByCode(String id)
    {
        String httpUrl = "http://apis.baidu.com/apistore/stockservice/stock";
        // String httpArg = "stockid=sz002230&list=1";
        String httpArg = "stockid=" + id + "&list=1";
        String apiKey = "f0b7ff5ff57a4e350ad0212c199dce02";
        String jsonResult = new ApiUtils().request(httpUrl, httpArg, apiKey);
        
        Stock stock = new Stock();
        
        JSONObject object = JSONObject.parseObject(jsonResult);
        String retCode = (String) object.getString("errNum");
        
        if (retCode.equals("0"))
        {
            
            JSONObject retDataJson = object.getJSONObject("retData");
            
            JSONArray stockInfoArray = retDataJson.getJSONArray("stockinfo");
            
            List<MarketInfo> marketInfos = new ArrayList<MarketInfo>();
            //System.out.println("\r\n" + stockInfoArray.getJSONObject(0));
            
            StockInfo stockInfo = JSON.parseObject(stockInfoArray.getJSONObject(0).toString(), StockInfo.class);
            stock.setStockInfo(stockInfo);
            
            MarketInfo marketSHInfo = JSON.parseObject(retDataJson.getJSONObject("market").getString("shanghai"), MarketInfo.class);
            marketSHInfo.setMarketName("SH");
            marketInfos.add(marketSHInfo);
            
            MarketInfo marketSZInfo = JSON.parseObject(retDataJson.getJSONObject("market").getString("shenzhen"), MarketInfo.class);
            marketSZInfo.setMarketName("SZ");
            marketInfos.add(marketSZInfo);
            
            stock.setMarketInfos(marketInfos);
            
        }
        return stock;
    }
    
    public List<CodeInfo> getCodeInfoByName(String name)
    {
        String httpUrl = "http://cjhq.baidu.com/suggest";
        String httpArg = "code5=" + name;
        String jsonResult = new ApiUtils().request(httpUrl, httpArg, null);
        
        JSONObject object = JSONObject.parseObject(jsonResult);
        List<JSONObject> arrayList = (List<JSONObject>) object.get("Result");
        List<CodeInfo> codeInfos = new ArrayList();
        
        if (null != arrayList && arrayList.size() > 0)
        {
            codeInfos = JSON.parseArray(arrayList.toString(), CodeInfo.class);
        }
        return codeInfos;
    }
    
    public static void main(String[] args)
    {
        // String url =
        // "http://search.10jqka.com.cn/stockpick/search?typed=1&preParams=&ts=1&f=1&qs=1&selfsectsn=&querytype=&searchfilter=&tid=stockpick&w=000001";
        String url = "http://cjhq.baidu.com/suggest?code5=000005";
        
        List<CodeInfo> codeInfos = new GetDataFromBaiduApi().getCodeInfoByName("dly");
        
        Stock stock = new GetDataFromBaiduApi().getDataByCode(codeInfos.get(0).getCode());
        
        new GetDataFromBaiduApi().getKLine(stock.getStockInfo().getMinurl());
        //System.out.println();
        
    }
    
    // http://cjhq.baidu.com/suggest?code5=000005
    
}
