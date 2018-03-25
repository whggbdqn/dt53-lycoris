package entity;

public class Grade {
    private Integer id;
    private String gradeinfo;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGradeinfo() {
        return gradeinfo;
    }
    public void setGradeinfo(String gradeinfo) {
        this.gradeinfo = gradeinfo == null ? null : gradeinfo.trim();
    }
}