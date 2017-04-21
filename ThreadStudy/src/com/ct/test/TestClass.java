package com.ct.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao on 2017/4/20.
 */
public class TestClass {
    public static void main(String[] arg){

        List<Object> payServices = new ArrayList<Object>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bankCode","asd19239124");
        jsonObject.put("city","5210");
        payServices.add(jsonObject);
        System.out.println(JSONObject.toJSONString(payServices).toString());
    }
}
