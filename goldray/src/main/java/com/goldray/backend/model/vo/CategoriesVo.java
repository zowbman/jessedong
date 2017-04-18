package com.goldray.backend.model.vo;

/**
 * Created by zwb on 2017/4/11.
 */
public class CategoriesVo {
    private int id;
    private String categoriesName;
    private String cAbbreviate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public String getcAbbreviate() {
        return cAbbreviate;
    }

    public void setcAbbreviate(String cAbbreviate) {
        this.cAbbreviate = cAbbreviate;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ",categoriesName:" + this.categoriesName + ",cAbbreviate:" + cAbbreviate;
    }
}
