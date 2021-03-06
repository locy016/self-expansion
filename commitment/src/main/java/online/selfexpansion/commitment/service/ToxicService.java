package online.selfexpansion.commitment.service;

import online.selfexpansion.commitment.model.ToxicList;

import java.util.List;

public interface ToxicService {
    public List<ToxicList> selectList();

    public ToxicList selectByRandom();

    public int insertInfo(ToxicList toxicList);
}
