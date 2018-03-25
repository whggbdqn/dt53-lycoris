package entity;

public class Indexes {
    private Integer id;
    private String indexinfo;
    private Integer taglevel;
    private Integer indexclass;
    private Integer parent;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIndexinfo() {
        return indexinfo;
    }
    public void setIndexinfo(String indexinfo) {
        this.indexinfo = indexinfo == null ? null : indexinfo.trim();
    }
    public Integer getTaglevel() {
        return taglevel;
    }
    public void setTaglevel(Integer taglevel) {
        this.taglevel = taglevel;
    }
    public Integer getIndexclass() {
        return indexclass;
    }
    public void setIndexclass(Integer indexclass) {
        this.indexclass = indexclass;
    }
    public Integer getParent() {
        return parent;
    }
    public void setParent(Integer parent) {
        this.parent = parent;
    }
}