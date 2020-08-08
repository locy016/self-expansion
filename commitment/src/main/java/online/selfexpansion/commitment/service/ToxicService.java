package online.selfexpansion.commitment.service;

import online.selfexpansion.commitment.model.ToxicList;

import java.util.List;

public interface ToxicService {
    public List<ToxicList> selectList();

    public int installInfo(ToxicList toxicList);
}
