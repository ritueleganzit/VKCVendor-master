package com.eleganzit.vkcvendor.model.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleData {

    @SerializedName("article")
    @Expose
    private String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }


}
