package com.example.lenovo.coolweather;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.coolweather.db.City;
import com.example.lenovo.coolweather.db.County;
import com.example.lenovo.coolweather.db.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/28.
 */

public class ChooseAreaFragment extends Fragment {
    public static final int LEVEL_PROVINCE=0;
    public static final int LEVEL_CITY=1;
    public static final int LEVEL_COUNTY=2;
    private ProgressDialog progressDialog;
    private TextView titleText;
    private Button button;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList=new ArrayList<String>();
    private List<Province> provinceList;
    private  List<City> cityList;
    private  List<County> countyList;
    private Province selectedProvince;
    private City selectedCity;
    private int currentLevel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.choose_area,container,false);
        titleText=(TextView)view.findViewById(R.id.title_text);
        button=(Button)view.findViewById(R.id.back_button);
        listView=(ListView)view.findViewById(R.id.list_view);
        adapter=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,dataList);
        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(currentLevel==LEVEL_PROVINCE){
                    selectedProvince=provinceList.get(i);
                    queryCities();
                }
            }
        });
    }
    public void queryProvinces(){

    }
    public void queryCities(){

    }
    public void queryCounties(){

    }
    public void queryFromServer(String adress,final String type){

    }
    public void showProgressDialog(){

    }
    public void closeProgressDialog(){

    }

}
