package dao;

import entity.Originaldata;

public interface OriginaldataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int insert(Originaldata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int insertSelective(Originaldata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    Originaldata selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int updateByPrimaryKeySelective(Originaldata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Originaldata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table originaldata
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int updateByPrimaryKey(Originaldata record);
}