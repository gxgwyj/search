package com.xinguoren.coolpen.cloud.web.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http_json 请求工具
 * Created by Administrator on 2016/6/23.
 */
public class HttpJsonUtils {
    public static String sendPost(String urlStr, Object param) {
        DataOutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(param);
            System.out.println(jsonStr);
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 设置通用的请求属性
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8;");

            // 获取URLConnection对象对应的输出流
            httpURLConnection.connect();
            out = new DataOutputStream(httpURLConnection.getOutputStream());
            // 发送请求参数
            out.write(jsonStr.getBytes("UTF-8"));
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static String sendPost(String urlStr, String jsonStr) {
        DataOutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            System.out.println(jsonStr);
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 设置通用的请求属性
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8;");

            // 获取URLConnection对象对应的输出流
            httpURLConnection.connect();
            out = new DataOutputStream(httpURLConnection.getOutputStream());
            // 发送请求参数
            out.write(jsonStr.getBytes("UTF-8"));
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String url = "http://top-api.teshehui.com/service";
        String jsonStr = "{\"action\":\"getProductList\",\"app_key\":\"36ff80808157d185a801582939c68e0004\",\"data\":{\"pageNo\":1,\"pageSize\":100},\"dist_code\":\"wangxinqianbao\",\"format\":\"json\",\"platform\":\"\",\"sign\":\"A035859D4907C053A7F647704ED620A9\",\"sign_method\":\"md5\",\"typeId\":1,\"version\":\"1.0\"}\n";
        String result = sendPost(url, jsonStr);
        System.out.println(result);
    }


}
