package cc.xpedia.tv;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class test {

    public static void main(String[] args){
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet req = new HttpGet("http://www.bilibili.com/index/rank/all-3-0.json");
        req.addHeader("Accept","application/json, text/javascript, */*; q=0.01");
        req.addHeader("Referer","http://www.bilibili.com/ranking");
        req.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        req.addHeader("X-Requested-With","XMLHttpRequest");

        HttpResponse rep = null;
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
//            String test = unicodeToUtf8(content);

//            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        }

    };



}

