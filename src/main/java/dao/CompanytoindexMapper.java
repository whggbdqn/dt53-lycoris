package dao;

import entity.Companytoindex;

public interface CompanytoindexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companytoindex
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companytoindex
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int insert(Companytoindex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companytoindex
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int insertSelective(Companytoindex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companytoindex
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    Companytoindex selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companytoindex
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int updateByPrimaryKeySelective(Companytoindex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companytoindex
     *
     * @mbggenerated Sun Mar 25 09:09:51 CST 2018
     */
    int updateByPrimaryKey(Companytoindex record);
}