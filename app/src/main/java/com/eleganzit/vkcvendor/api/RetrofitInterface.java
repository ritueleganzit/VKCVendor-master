package com.eleganzit.vkcvendor.api;


import com.eleganzit.vkcvendor.model.LoginRespose;
import com.eleganzit.vkcvendor.model.article.ArticleResponse;
import com.eleganzit.vkcvendor.model.line.LineResponse;
import com.eleganzit.vkcvendor.model.plan.PlanResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by eleganz on 30/4/19.
 */

public interface RetrofitInterface {

    @FormUrlEncoded()
    @POST("/VKC-API/loginVendor")
    Call<LoginRespose> loginUser(
            @Field("email_id") String email_id,
            @Field("password") String password


    );

    @FormUrlEncoded()
    @POST("/VKC-API/getAllPoDetail")
    Call<PlanResponse> getAllPoDetail(
            @Field("vendor_id") String vendor_id


    );

    @FormUrlEncoded()
    @POST("/VKC-API/getVendorLine")
    Call<LineResponse> getVendorLine(
            @Field("vendor_id") String vendor_id


    );

    @FormUrlEncoded()
    @POST("/VKC-API/getArticleList")
    Call<ArticleResponse> getArticleList(
            @Field("vendor_id") String vendor_id


    );

    @FormUrlEncoded()
    @POST("/VKC-API/addFeedback")
    Call<LoginRespose> addFeedback(
            @Field("vendor_id") String vendor_id,
            @Field("message") String message,
            @Field("date_time") String date_time

    );


}
