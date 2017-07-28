package com.example.lenovo.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by lenovo on 2017/7/28.
 */

public class County extends DataSupport {
    public int id;
    public String countyName;
    public String weatherId;
    public int cityId;
}
