package entity;

public class Area {
    private Integer id;
    private String areainfo;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAreainfo() {
        return areainfo;
    }
    public void setAreainfo(String areainfo) {
        this.areainfo = areainfo == null ? null : areainfo.trim();
    }
}