package online.selfexpansion.commitment.service;

import online.selfexpansion.commitment.mapper.WebSiteMapper;
import online.selfexpansion.commitment.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteServiceImpl implements WebSiteService {
    @Autowired
    private WebSiteMapper webSiteMapper;

    @Override
    public List<WebSiteInfo> selectList(){
        return webSiteMapper.selectList();
    }

    @Override
    public  int updateInfo(WebSiteInfo webSiteInfo){ return webSiteMapper.updateInfo(webSiteInfo); }
}
