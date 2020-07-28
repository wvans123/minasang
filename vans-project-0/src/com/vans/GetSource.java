package com.vans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetSource {
    public static String getSource(String url){
        BufferedReader reader=null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
//			打开和url之间的连接
            URLConnection conn = realUrl.openConnection();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while((line=reader.readLine())!=null){
                result.append(line);
            }
            //System.out.println(result);
            if(reader!=null) reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
