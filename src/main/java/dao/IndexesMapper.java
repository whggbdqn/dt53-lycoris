package dao;

import java.util.List;

import entity.Indexes;

public interface IndexesMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Indexes record);
    int insertSelective(Indexes record);
    Indexes selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Indexes record);
    int updateByPrimaryKey(Indexes record);
    /**
     * 获取一级检索索引,indexclass=1
     * @author ss
     * @date 2018-3-25
     */
    List<Indexes> getFirstClassIndex();
    /**
     * 获取二级检索索引,indexclass=2
     * @author lk
     * @date 2018-3-25
     */
    List<Indexes> getSecondClassIndex();
}