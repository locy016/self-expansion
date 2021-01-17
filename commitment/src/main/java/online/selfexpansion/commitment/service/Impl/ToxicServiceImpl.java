package online.selfexpansion.commitment.service.Impl;

import online.selfexpansion.commitment.mapper.ToxicMapper;
import online.selfexpansion.commitment.model.ToxicList;
import online.selfexpansion.commitment.service.ToxicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToxicServiceImpl implements ToxicService {
    @Autowired
    private ToxicMapper toxicMapper;

    @Override
    public List<ToxicList> selectList() {
        return toxicMapper.selectList();
    }

    @Override
    public ToxicList selectByRandom() {
        return toxicMapper.selectByRandom();
    }

    @Override
    public int insertInfo(ToxicList toxicList) {
        return toxicMapper.insertInfo(toxicList);
    }
}
