package entity;

public class Originaldata {
    private Integer id;
    private String companyname;
    private Integer idarea;
    private String companyemail;
    private String otherinfo;
    private String companyinfo;
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
    public Integer getIdarea() {
        return idarea;
    }
    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }
    public String getCompanyemail() {
        return companyemail;
    }
    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail == null ? null : companyemail.trim();
    }
    public String getOtherinfo() {
        return otherinfo;
    }
    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo == null ? null : otherinfo.trim();
    }
    public String getCompanyinfo() {
        return companyinfo;
    }
    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo == null ? null : companyinfo.trim();
    }
}