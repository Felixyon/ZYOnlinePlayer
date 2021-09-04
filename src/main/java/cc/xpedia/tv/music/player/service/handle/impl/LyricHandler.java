package cc.xpedia.tv.music.player.service.handle.impl;

import cc.xpedia.tv.music.player.service.handle.TypeHandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 歌词处理器
 *
 * @author Xpedia
 */
@Service
public class LyricHandler implements TypeHandler {
    @Autowired
    private CloseableHttpClient httpClient;

    @Override
    public String handle(String data) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost req = new HttpPost("http://music.163.com/api/song/lyric?id=" + data + "&os=linux&lv=-1&kv=-1&tv=-1");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("decode", "netease_lyric");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            resultlist = EntityUtils.toString(repEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultlist;
    }

    @Override
    public String getType() {
        return TYPE_LYRIC;
    }
}
