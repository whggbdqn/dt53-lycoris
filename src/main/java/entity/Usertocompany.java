package entity;

public class Usertocompany {
    private Integer id;
    private Integer iduser;
    private Integer idcompany;
    private String updatetime;
  
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
    public Integer getIduser() {
        return iduser;
    }
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    public Integer getIdcompany() {
        return idcompany;
    }
    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }
}