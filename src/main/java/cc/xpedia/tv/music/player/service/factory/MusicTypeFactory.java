package cc.xpedia.tv.music.player.service.factory;

import cc.xpedia.tv.music.player.service.handle.TypeHandler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 音乐处理类工厂
 *
 * @author Xpedia
 */
@Service
public class MusicTypeFactory implements TypeFactory {
    /**
     * 方法处理器MAP
     */
    private Map<String,TypeHandler> typeHandlerMap;

    public MusicTypeFactory(List<TypeHandler> typeHandlers) {
        Map<String, TypeHandler> typeMap = new HashMap<>();
        try {
            typeHandlers.forEach(typeHandler -> {
                typeMap.put(typeHandler.getType(), typeHandler);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        typeHandlerMap = typeMap;
    }

    @Override
    public TypeHandler getHandler(String type) {
        return typeHandlerMap.get(type);
    }
}
