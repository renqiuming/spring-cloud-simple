package com.rqm.tool.http;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class HttpUtils {

    private final static int ERROR_CODE=200;
    public static void doHttp(String path, String cookie, String requestMethod, String param) {
        try {
            URL url = new URL(path);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.104 Safari/537.36");
            con.setRequestProperty("Cookie", cookie);
            con.setRequestProperty("Content-Length", "100000");
            con.setConnectTimeout(2000);
            con.setReadTimeout(2000);
            con.setDoOutput(true);
            con.connect();
            if(!StringUtils.isEmpty(param)) {
                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out,"UTF-8");
                outputStreamWriter.write(param);
                outputStreamWriter.flush();
                outputStreamWriter.close();
                out.close();
            }
            if (con.getResponseCode() == ERROR_CODE) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                System.out.println("出参："+sb);
            } else {
                System.out.println("错误码："+con.getResponseCode());
            }
            con.disconnect();
        } catch (Exception e) {
            System.out.println("异常"+e);
        }
    }
    public static void doHttp(String path, String cookie) {
        doHttp(path,cookie,"GET",null);
    }
}
