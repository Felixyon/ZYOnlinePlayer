package cc.xpedia.tv.music.player.service.handle.impl;

import cc.xpedia.tv.music.player.service.handle.TypeHandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 封面处理器
 *
 * @author Xpedia
 */
@Service
public class PicHandler implements TypeHandler {
    @Autowired
    private CloseableHttpClient httpClient;

    @Override
    public String handle(String data) {
        HttpPost req = new HttpPost("https://p3.music.126.net/" + data + "/" + data + ".jpg?param=300y300");
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
        return TYPE_PIC;
    }
}
