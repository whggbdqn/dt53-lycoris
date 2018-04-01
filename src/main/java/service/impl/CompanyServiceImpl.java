package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CompanyMapper;
import entity.Company;
import entity.Indexes;
import pojo.AreatoCompany;
import pojo.IndexPojo;
import service.CompanyService;
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
@Autowired
private CompanyMapper companyMapper;
	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return companyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional
	@Override
	public int insertSelective(Company record) {
		return companyMapper.insertSelective(record);
	}

	@Override
	public Company selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(Company record) {
		return companyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkCompanyName(String companyName) {
		companyName="%"+companyName+"%";
		return companyMapper.checkCompanyName(companyName);
	}
	@Override
	public List<AreatoCompany> getAllAreabyCompany() {
		return companyMapper.getAllAreabyCompany();
	}

	@Override
	public void setTime(String time) {
		companyMapper.setTime(time);
	}
	 /**
     * 按地区查询公司
     * @author Asuna
     * @date 2018/3/30
     */
	@Override//测试成功 By ss
	public List<Company> getCompanyByArea() {
		return companyMapper.getCompanyByArea();
	}
	 /**
     * 查询公司详情
     * @author Asuna
     * @date 2018/3/30
     */
	@Override
	public Company getCompanyDetil(Integer id) {
		return companyMapper.getCompanyDetil(id);
	}

	 /**
     * 查询公司标签
     * @author Asuna
     * @date 2018/3/30
     */
	public List<IndexPojo> getCompanyIndexes(Integer id){
		return companyMapper.getCompanyIndexes(id);
	}
	 /**
	 * 查询所有公司 与标签数量
	 * @return
	 * 2018.4.1
	 * @author ss
	 */
	public List<Company> getAllCompany(){
		return companyMapper.getAllCompany();
	};
	 /**
	 * id多选删除
	 * @param 传数组
	 * @return 影响行数
	 * @author ywz
	 */
	@Transactional
	public int delmanyckey(Integer[] chk_value) {
		// TODO Auto-generated method stub
		return companyMapper.delmanyckey(chk_value);
	}

	 /**
	 * 删除公司和标签
	 * @param 传公司id
	 * @return 影响行数
	 * @author 
	 */
	@Transactional
public int delCompanyAndIndexes(int idcompany) {
	int count=-1;
    count=companyMapper.deleteByPrimaryKey(idcompany);
    if(count>0){
    	int temp=companyMapper.delCompanytoIndexes(idcompany);
    	count=count+temp;
    }
	return count;
}
}
