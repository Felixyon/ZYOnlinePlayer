package cc.xpedia.tv.music.player.controller;


import cc.xpedia.tv.music.player.service.factory.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 音乐controller
 * @author Xpedia
 */
@Controller
@RequestMapping(path = "api")
public class MusicController {
    @Autowired
    TypeFactory typeFactory;

    @RequestMapping(path = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "测试成功";
    }

    //整个music的核心模块

    /**
     * 整个music的核心模块
     * @param types 类型
     * @param id id
     * @return 返回结果
     */
    @RequestMapping(path = "api.php", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String musicCore(
            @RequestParam String types,
            @RequestParam String id
    ) {
        return typeFactory.getHandler(types).handle(id);
    }


}
