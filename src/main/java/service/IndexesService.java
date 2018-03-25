package service;

import java.util.List;

import entity.Indexes;

public interface IndexesService {
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
    
    /**
     * 获取父类标签，parent=0
     * @author lk
     * @date 2018-3-25
     */
    List<Indexes> getParentZeroLevelIndex();
    /**
     * 获取一级标签 
     * @author lk
     * @date 2018-3-25
     */
    List<Indexes> getParentOneLevelIndex();
    /**
     * 获取二级标签
     * 
     * @author lk
     * @date 2018-3-25
     */
    List<Indexes> getParentTwoLevelIndex();
    
    /**
     * 修改单个标签 
     * 传入实体，成功返回1，失败返回0
     * @author lk
     * @data 2018-3-25
     */
    int updateOneTag(Indexes indexes);
    
}
