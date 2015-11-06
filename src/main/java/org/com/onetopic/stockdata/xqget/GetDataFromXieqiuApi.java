package org.com.onetopic.stockdata.xqget;

import java.io.IOException;











import java.net.URL;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.com.onetopic.stockdata.bdget.ApiUtils;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetDataFromXieqiuApi
{
    String cookValue = null;
    
    long getCount()
    {
        String httpUrl = "http://xueqiu.com/stock/cata/stocklist.json";
        String httpArg = "page=1&size=0&order=desc&orderby=percent&type=11%2C12&_=1";
        
        httpUrl = httpUrl+"?"+httpArg;
        Document result = null;
        try
        {
           // Jsoup.connect(httpUrl).header(name, value);
            Connection con = Jsoup.connect(httpUrl);
           // {'Accept': 'application/json, text/javascript, */*; q=0.01', 'X-Requested-With': 'XMLHttpRequest'}
            con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.header("X-Requested-With", "XMLHttpRequest");
            con.header("Mimetype", "application/json");
            con.header("Accept-Language","zh-CN,zh;q=0.8");
            
            con.cookie("xq_a_token", "138a2f04de6b9d0bafb7cf63b0e45cf14e9c28e4");
           

            result = con.get();
            
             //result = Jsoup.connect(httpUrl).cookie("xq_a_token", "138a2f04de6b9d0bafb7cf63b0e45cf14e9c28e4").get();
        
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //String result = new ApiUtils().request(httpUrl, httpArg, null);
        
        System.out.println(result.toString());
        
        return 0;
    }
    
    public void visit()
    {
        String httpUrl = "http://xueqiu.com/hq";
        //String result = new ApiUtils().request(httpUrl, null, null);
        //System.out.println(result);
        try
        {
           //Document doc = Jsoup.connect(httpUrl).get();
          // System.out.println(doc);
           // Elements element = doc.getElementsByTag("script");
       
            HtmlCleaner cleaner = new HtmlCleaner(); 
            TagNode root = cleaner.clean(new URL(httpUrl));
         
            try
            {
                Object[] nameArray=  root.evaluateXPath("//script");
                
                for(Object obj :nameArray)
                {
                    TagNode tagNode = (TagNode) obj;
                    Object[] names = tagNode.evaluateXPath("SNB.data.access_token");
                    if(names.length>0)
                    {
                        System.out.println("11");
                    }
                   // System.out.println(tagNode.getText());
                }
                //System.out.println(nameArray);
                
            }
            catch (XPatherException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            
            
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            try
            {
                XPathExpression expr = xpath.compile("//script");
                
               
                //Object result11 = expr.evaluate(result.toString(),XPathConstants.STRING);
                
            }
            catch (XPathExpressionException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
           // System.out.println(element);
            
            Jsoup.connect(httpUrl).cookie("xq_a_token", "138a2f04de6b9d0bafb7cf63b0e45cf14e9c28e4").get();
            
            
            
            // doc.getElementsMatchingText("SNB.data.access_token.*\|\| '(.*)';");
            
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // System.out.println(result);
        
        // String result = new ApiUtils().request(httpUrl, httpArg, null);
        
    }
    
    public static void main(String[] args)
    {
        new GetDataFromXieqiuApi().getCount();
        //new GetDataFromXieqiuApi().visit();
    }
}
