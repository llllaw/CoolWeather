package com.example.lenovo.coolweather.util;

import android.text.TextUtils;

import com.example.lenovo.coolweather.db.City;
import com.example.lenovo.coolweather.db.County;
import com.example.lenovo.coolweather.db.Province;
import com.example.lenovo.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by lenovo on 2017/7/28.
 */

public class Utility {
    //处理省级数据
    public static boolean handleProvinceResponce(String responce){
        if(!TextUtils.isEmpty(responce)){
            try{
                JSONArray allProvinces=new JSONArray(responce);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityResponse(String responce,int provinceId){
        if(!TextUtils.isEmpty(responce)) {
            try {
                JSONArray allCities = new JSONArray(responce);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCountyResponse( String response,int CityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(CityId);
                    county.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;

    }
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String WeatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(WeatherContent,Weather.class);
        }catch(Exception e){

        }
        return null;
    }

}
