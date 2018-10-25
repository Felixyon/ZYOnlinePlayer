package cc.xpedia.tv.Service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class MusicService {
    //MusicService，用于提供网易云音乐等音乐类接口

    //整个MusicService的接入点
    public String ifselector(String types,String data){
//        System.out.println(types);
        if (types.equals("playlist")){
            return playlist(data);
        }else if (types.equals("song")){
            return song(data);
        }else if (types.equals("lyric")) {
            return lyric(data);
        }else if (types.equals("url")) {
            return url(data);
        }else if (types.equals("search")) {
            return search(data);
        }else if (types.equals("pic")) {
            return pic(data);
        }else if (types.equals("userlist")) {
            return userlist(data);
        }else {
                return "请求数据失败";
        }
    }

    //各种方法对应。功能已从方法名称中标出
    public String playlist(String id){//获取音乐歌单
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/v3/playlist/detail?s=0&id="+id+"&n=1000&t=0");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("format", "playlist.tracks");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
//            resultlist = unicodeToUtf8(content);
            resultlist=content;

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }

    public String song(String id){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/v3/song/detail/?c=[%7B%22id%22:"+id+",%22v%22:0%7D]");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("format", "songs");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist = unicodeToUtf8(content);

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }

    public String lyric(String id){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/song/lyric?id="+id+"&os=linux&lv=-1&kv=-1&tv=-1");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("decode", "netease_lyric");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist = content;

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }

    public String url(String id){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/song/enhance/player/url?ids=["+id+"]&br=320000");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("decode", "netease_url");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist = unicodeToUtf8(content);

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }

    public String search(String data){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/cloudsearch/pc?s="+data+"&type=1&limit=30&total=true&offset=0");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("format", "result.songs");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist =content;

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }

    public String pic(String data){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("https://p3.music.126.net/"+data+"/"+data+".jpg?param=300y300");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist =content;

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }

    public String userlist(String data){
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/user/playlist/?offset=0&limit=1001&uid="+data);
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist =content;

//            System.out.println(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultlist;
    }


    //将get到的response的unicode编码转化为utf-8格式，可以进行输出和存储
    public static String unicodeToUtf8(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
