package dao;

import java.util.List;

import entity.Originaldata;

public interface OriginaldataMapper {
	/**
	 * 添加信息到DB
	 * @param list	信息集合
	 */
	int insertOrginalData(List<Originaldata>list);
	List<Originaldata> DecodingXlsx();
    int deleteByPrimaryKey(Integer id);
    int insert(Originaldata record);
    int insertSelective(Originaldata record);
    Originaldata selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Originaldata record);
    int updateByPrimaryKeyWithBLOBs(Originaldata record);
    int updateByPrimaryKey(Originaldata record);
    /**
     * 获取原始数据用于处理
     * @author ss
     * @date 2018-3-25
     */
    List<Originaldata> getDataForProcessing();
}