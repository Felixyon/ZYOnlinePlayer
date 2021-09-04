package cc.xpedia.tv.music.player.service.factory;

import cc.xpedia.tv.music.player.service.handle.TypeHandler;

/**
 * 方法工厂
 *
 * @author Xpedia
 */
public interface TypeFactory {
    /**
     * 根据类型获取handler
     *
     * @param type 类型
     * @return 方法处理器
     */
    TypeHandler getHandler(String type);
}
