package com.eleganzit.vkcvendor.model.plan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PNumber {

    @SerializedName("pur_doc_num")
    @Expose
    private String purDocNum;
    @SerializedName("articledata")
    @Expose
    private List<Article> articledata = null;

    public String getPurDocNum() {
        return purDocNum;
    }

    public void setPurDocNum(String purDocNum) {
        this.purDocNum = purDocNum;
    }

    public List<Article> getArticledata() {
        return articledata;
    }

    public void setArticledata(List<Article> articledata) {
        this.articledata = articledata;
    }

}
