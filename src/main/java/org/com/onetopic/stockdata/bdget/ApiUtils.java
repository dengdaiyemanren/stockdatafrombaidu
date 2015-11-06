package org.com.onetopic.stockdata.bdget;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUtils
{
    /**
     * @param urlAll
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg, String apiKey)
    {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        
        if(null != httpArg)
        {
            httpUrl = httpUrl + "?" + httpArg;
        }
        
        try
        {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            if (null != apiKey)
            {
                connection.setRequestProperty("apikey", apiKey);
            }
            
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "GBK"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null)
            {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
}
