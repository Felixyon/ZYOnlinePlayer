package cc.xpedia.tv.Controller;

import cc.xpedia.tv.Service.BilibiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.PAData;

@Controller
@RequestMapping(path = "api")
public class BilibiliController {
    @Autowired
    BilibiliService bilibiliService;


    @RequestMapping(path = "bilibili",method = RequestMethod.GET)
    @ResponseBody
    public String getbilibiliHotList(
    ){
        return bilibiliService.getRecentHot();
    }
}
