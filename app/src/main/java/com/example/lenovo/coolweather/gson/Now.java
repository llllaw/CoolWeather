package com.example.lenovo.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 2017/7/29.
 */

public class Now {
    @SerializedName("tmp")
    public String tempture;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }

}
