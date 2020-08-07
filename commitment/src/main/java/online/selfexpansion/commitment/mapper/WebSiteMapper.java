package online.selfexpansion.commitment.mapper;

import online.selfexpansion.commitment.model.WebSiteInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebSiteMapper {
    public List<WebSiteInfo> selectList();
}
