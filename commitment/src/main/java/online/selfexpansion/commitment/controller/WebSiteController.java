package online.selfexpansion.commitment.controller;

import online.selfexpansion.commitment.model.WebSiteInfo;
import online.selfexpansion.commitment.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebSiteController {

    @Autowired
    private WebSiteService webSiteService;

    @RequestMapping("/")
    public String index(){
        return "hello ,welcome to website page.";
    }
    @RequestMapping("/website")
    public List<WebSiteInfo> website(){
        return webSiteService.selectList();
    }
}
