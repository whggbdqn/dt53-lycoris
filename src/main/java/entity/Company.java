package entity;

import java.util.List;

public class Company {
    private Integer id;
    private String companyname;
	private String companyemail;
    private Integer idarea;
    private String companyinfo;
    private String updatetime;
    private List<Indexes> indexes;
    private String areainfo;
    public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }
    public String getCompanyemail() {
        return companyemail;
    }
    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail == null ? null : companyemail.trim();
    }
    public Integer getIdarea() {
        return idarea;
    }
    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }
    public String getCompanyinfo() {
        return companyinfo;
    }
    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo == null ? null : companyinfo.trim();
    }
	public List<Indexes> getIndexes() {
		return indexes;
	}
	public void setIndexes(List<Indexes> indexes) {
		this.indexes = indexes;
	}
	public String getAreainfo() {
		return areainfo;
	}
	public void setAreainfo(String areainfo) {
		this.areainfo = areainfo;
	}
}