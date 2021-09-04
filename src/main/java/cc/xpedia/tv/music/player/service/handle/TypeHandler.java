package cc.xpedia.tv.music.player.service.handle;

/**
 * 类型处理器
 *
 * @author Xpedia
 */
public interface TypeHandler {
    /**
     * 接口定义类型枚举
     */
    String TYPE_PLAYLIST = "playlist";
    String TYPE_SONG = "song";
    String TYPE_LYRIC = "lyric";
    String TYPE_URL = "url";
    String TYPE_SEARCH = "search";
    String TYPE_PIC = "pic";
    String TYPE_USER_LIST = "userlist";

    /**
     * 方法处理器
     *
     * @param data 参数
     * @return 处理结果
     */
    String handle(String data);

    /**
     * 获取接口类型
     *
     * @return 接口定义类型
     */
    String getType();
}
