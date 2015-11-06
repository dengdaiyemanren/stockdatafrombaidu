package org.com.onetopic.stockdata;

import java.io.IOException;

import org.com.onetopic.stockdata.bdget.ApiUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetStockOrignData
{
    public Document getDataFromUrl(String url)
    {
        Document doc = null;
        try
        {
            doc = Jsoup.connect(url).get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            
        }
        return doc;
    }
    public static void main(String[] args)
    {
       String url = "http://search.10jqka.com.cn/stockpick/search";
       String httparg ="typed=0&preParams=&ts=1&f=1&qs=1&selfsectsn=&querytype=&searchfilter=&tid=stockpick&w=000001"; 
       
       //String url = "http://cjhq.baidu.com/suggest?code5=000005";
       String jsonResult = new ApiUtils().request(url, httparg, null);
       System.out.println(jsonResult);
       
      //  Document doc = new GetStockOrignData().getDataFromUrl(url);
       // System.out.println(doc);
    }
    
    
}
