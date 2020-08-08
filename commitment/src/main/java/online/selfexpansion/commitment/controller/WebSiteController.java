package online.selfexpansion.commitment.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import online.selfexpansion.commitment.model.WebSiteInfo;
import online.selfexpansion.commitment.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebSiteController {
    @Autowired
    private WebSiteService webSiteService;

    //测试网站索引页返回
    @RequestMapping("/")
    public String index() {
        return "hello ,welcome to website page.";
    }

    //查询网站信息
    @RequestMapping("/website")
    public JSON website() {
        JSONObject json = new JSONObject();
        try {
            List<WebSiteInfo> webSiteInfos = webSiteService.selectList();
            if (webSiteInfos.size() > 0) {
                json.put("code", 200);
                json.put("data", JSON.toJSONString(webSiteInfos.get(0)));
                json.put("message", "成功获取网站设置数据。");
            } else {
                json.put("code", 201);
                json.put("message", "网站没有设置数据。");
            }
            return json;
        } catch (Exception e) {
            json.put("code", e.hashCode());
            json.put("message", e.getMessage());
            return json;
        }
    }

    //设置网站参数
    @PutMapping(value = "/setting")
    public JSON setting(@RequestBody WebSiteInfo webSiteInfo, @RequestHeader HttpHeaders headers) {
        JSONObject json = new JSONObject();
        //数据检测
        if (webSiteInfo.getWs_name().length() > 100) {
            json.put("message", "站点名称文字长度超限。");
        } else if (webSiteInfo.getWs_desc().length() > 10000) {
            json.put("message", "网站设置项内容长度超限。");
        } else if (webSiteInfo.getWs_copyright().length() > 100) {
            json.put("message", "版权声明文字长度超限。");
        }
        if (json.get("message") != null) {
            json.put("code", 401);
            return json;
        }
        //执行操作并返回结果
        try {
            int result = webSiteService.updateInfo(webSiteInfo);
            json.put("code", 200);
            json.put("data", result);
            json.put("message", "已保存设置。");
            return json;
        } catch (Exception e) {
            json.put("code", e.hashCode());
            json.put("message", e.getMessage());
            return json;
        }
    }
}
