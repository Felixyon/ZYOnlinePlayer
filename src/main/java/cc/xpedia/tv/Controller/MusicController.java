package cc.xpedia.tv.Controller;


import cc.xpedia.tv.Service.BilibiliService;
import cc.xpedia.tv.Service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "api")
public class MusicController {
    @Autowired
    MusicService musicService;



    //测试API成功，完成此步骤，该war已经可以到tomcat上面正常部署
    @RequestMapping(path = "test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "测试成功";
    }

    //整个music的核心模块
    @RequestMapping(path = "api.php",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String musiccore(
        @RequestParam String types,
        @RequestParam String id
    ){
        return musicService.ifselector(types,id);
    }



}
