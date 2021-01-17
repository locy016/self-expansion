package online.selfexpansion.commitment.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import online.selfexpansion.commitment.model.ToxicList;
import online.selfexpansion.commitment.service.ToxicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/toxic")
public class ToxicController {
    @Autowired
    private ToxicService toxicService;

    //随机获取一条记录
    @RequestMapping(value = "/get")
    public JSON get() {
        ToxicList toxicList = toxicService.selectByRandom();
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("data", JSON.toJSONString(toxicList));
        json.put("message", "获取数据成功。");
        return json;
    }

    //获取列表
    @RequestMapping(value = "/getlist")
    public JSON getlist() {
        List<ToxicList> lists = toxicService.selectList();
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("data", JSON.toJSONString(lists));
        json.put("message", "成功获取数据列表。");
        return json;
    }

    //插入一条记录
    @PostMapping(value = "/setinfo")
    public JSON setinfo(@RequestBody ToxicList toxicList) {
        JSONObject json = new JSONObject();
        try {
            int result = toxicService.insertInfo(toxicList);
            json.put("code", 200);
            json.put("data", result);
            json.put("message", "新记录已保存完成。");
        } catch (Exception e) {
            json.put("code", e.hashCode());
            json.put("message", e.getMessage());
        } finally {
            return json;
        }
    }
}
