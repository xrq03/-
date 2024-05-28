package com.utils;



import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 智能回复机器人工具类
 * @author Hai
 * @date 2020/6/25 - 17:53
 */
public class TuLingUtil {

  private static ObjectMapper MAPPER=new ObjectMapper();

  /**
   * 发送消息，获得图灵机器人回复消息
   * @param message
   * @return
   * @throws IOException
   */
  public static String replyMessage(String message) throws IOException {
    //String APIKEY = "40445cf23e2144828218d7fc95d6f05a";
    String APIKEY = "2980260c9bb5f9256aa5e86a788f80a8";
    String INFO = URLEncoder.encode(message, "utf-8");
    //String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
    String getURL = "https://api.ownthink.com/bot?appid="+APIKEY+"&userid=admin&spoken="+INFO;
    String json = HttpUtil.get(getURL);
    ResData resData = JSONObject.parseObject(json, ResData.class);
    //URL getUrl = new URL(getURL);
    //HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
    //connection.connect();
    // 取得输入流，并使用Reader读取
    //BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
    //StringBuffer sb = new StringBuffer();
    //String line = "";
    //while ((line = reader.readLine()) != null) {
      //sb.append(line);
    //}
    //reader.close();
    // 断开连接
    //connection.disconnect();

    //return parseMess(resData.getData().getInfo().getText());
    return resData.getData().getInfo().getText();
  }
  /**
   * 解析返回的JSON字符串，获取回复字符串
   * @param jsonStr
   * @return
   * @throws JsonProcessingException
   */
  @SneakyThrows
  public static String parseMess(String jsonStr) throws JsonProcessingException {
    HashMap resultMap = MAPPER.readValue(jsonStr, HashMap.class);
    String result = ((String) resultMap.get("text"));
    return result;
  }
  public static void main(String[] args) throws IOException {
    String jsonStr = replyMessage("http://39.108.169.57/group1/M00/00/00/J2ypOV7wP0-AEZHOAAILbcn5GEM095.jpg");
    HashMap resultMap = MAPPER.readValue(jsonStr, HashMap.class);
    System.out.println(resultMap.get("text"));
  }

  @lombok.Data
  static class ResData{
    private String message;
    private Data data;
  }
  @lombok.Data
  static class Data{
    private String type;
    private Info info;
  }
  @lombok.Data
  static class Info{
    private String text;
  }
}
