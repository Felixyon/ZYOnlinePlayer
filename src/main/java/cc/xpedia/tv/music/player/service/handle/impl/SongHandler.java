package cc.xpedia.tv.music.player.service.handle.impl;

import cc.xpedia.tv.music.player.service.handle.TypeHandler;
import cc.xpedia.tv.music.player.util.UrlUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 歌曲处理器
 *
 * @author Xpedia
 */
@Service
public class SongHandler implements TypeHandler {
    @Autowired
    CloseableHttpClient httpClient;

    @Override
    public String handle(String data) {
        HttpPost req = new HttpPost("http://music.163.com/api/v3/song/detail/?c=[%7B%22id%22:" + data + ",%22v%22:0%7D]");
        req.addHeader("encode", "netease_AESCBC");
        req.addHeader("format", "songs");
        req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        HttpResponse rep = null;
        String resultlist = "";
        try {
            rep = httpClient.execute(req);
            HttpEntity repEntity = rep.getEntity();
            String content = EntityUtils.toString(repEntity);
            resultlist = UrlUtil.unicodeToUtf8(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultlist;
    }

    @Override
    public String getType() {
        return TYPE_SONG;
    }
}
