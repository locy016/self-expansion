package online.selfexpansion.commitment.mapper;

import online.selfexpansion.commitment.model.ToxicList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToxicMapper {
    public List<ToxicList> selectList();

    public ToxicList selectByRandom();

    public int insertInfo(ToxicList toxicList);
}
