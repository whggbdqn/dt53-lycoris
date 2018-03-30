package dao;

import java.util.List;

import entity.Originaldata;

public interface OriginaldataMapper {
	/**
	 * 添加信息到DB
	 * @param list	信息集合
	 */
	int insertOrginalData(List<Originaldata>list);
	
	/**
	 * 生成并下载Excel模板到本地
	 * @return	影响行数
	 * @author zhangzhe
	 */
	int downExcelFile();
	
	/**
	 * 读取Excel文件到内存
	 * @return	数据集合
	 * @author zhangzhe
	 */
	List<Originaldata> DecodingXlsx(String Excelpath);
	
	/**
	 * 修改原始数据库其他字段
	 * @param 上传Excel绝对路径
	 * @return	影响行数
	 * @author zhangzhe
	 */
	int updateFlag();
	
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
    /**
     * 处理后对原数据增加已处理标识
     * @author s
     * @data 2018/3/27
     * 
     */
    void updateAfterProcessing();
    
}