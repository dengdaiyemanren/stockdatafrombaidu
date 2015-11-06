package org.com.onetopic.stockdata.bddomain;

import java.util.ArrayList;
import java.util.List;

public class Stock
{
  
    StockInfo StockInfo ;
    List<MarketInfo> marketInfos = new ArrayList();
    

    public StockInfo getStockInfo()
    {
        return StockInfo;
    }
    public void setStockInfo(StockInfo stockInfo)
    {
        StockInfo = stockInfo;
    }
    
    public List<MarketInfo> getMarketInfos()
    {
        return marketInfos;
    }
    public void setMarketInfos(List<MarketInfo> marketInfos)
    {
        this.marketInfos = marketInfos;
    }

}
