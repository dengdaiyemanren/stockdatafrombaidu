package org.com.onetopic.stockdata.bddomain;

import java.math.BigDecimal;

public class MarketInfo
{
    String marketName;
    String name;
    BigDecimal curdot;
    BigDecimal curprice;
    BigDecimal rate;
    BigDecimal dealnumber;
    BigDecimal turnover;
    
    public String getMarketName()
    {
        return marketName;
    }
    public void setMarketName(String marketName)
    {
        this.marketName = marketName;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public BigDecimal getCurdot()
    {
        return curdot;
    }
    public void setCurdot(BigDecimal curdot)
    {
        this.curdot = curdot;
    }
    public BigDecimal getCurprice()
    {
        return curprice;
    }
    public void setCurprice(BigDecimal curprice)
    {
        this.curprice = curprice;
    }
    public BigDecimal getRate()
    {
        return rate;
    }
    public void setRate(BigDecimal rate)
    {
        this.rate = rate;
    }
    public BigDecimal getDealnumber()
    {
        return dealnumber;
    }
    public void setDealnumber(BigDecimal dealnumber)
    {
        this.dealnumber = dealnumber;
    }
    public BigDecimal getTurnover()
    {
        return turnover;
    }
    public void setTurnover(BigDecimal turnover)
    {
        this.turnover = turnover;
    }

}
