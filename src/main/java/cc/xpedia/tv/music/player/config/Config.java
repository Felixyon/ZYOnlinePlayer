package cc.xpedia.tv.music.player.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通用config信息
 *
 * @author Xpedia
 */
@Configuration
public class Config {

    @Bean
    CloseableHttpClient httpClient() {
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000).setSocketTimeout(20000).build();
        return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
    }
}
