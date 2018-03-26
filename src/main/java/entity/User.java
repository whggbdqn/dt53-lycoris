package entity;

public class User {
    private Integer id;
    private String userid;
    private String username;
    private String password;
    private String email;
    private String tel;
    private Integer userlevel;
    private String picture;
    private Integer idarea;
    private Integer idgrade;
    private Company company;
    public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
    public Integer getUserlevel() {
        return userlevel;
    }
    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
    public Integer getIdarea() {
        return idarea;
    }
    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }
    public Integer getIdgrade() {
        return idgrade;
    }
    public void setIdgrade(Integer idgrade) {
        this.idgrade = idgrade;
    }
}