package com.zakaria.interviewans2.main.data.remote;


import com.zakaria.interviewans2.main.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("/photos")
    Call<List<Post>> getpost();

//    @FormUrlEncoded
//    @POST("/api/order")
//    Call<Post> savePost(@Body Post post);

//    @FormUrlEncoded
//    @POST("/api/order")
//    Call<Post> savePost(@Field("name") String name, @Field("email") String email, @Field("number") String number, @Field("cash") String cash,
//                        @Field("address") String address, @Field("state") String state, @Field("zip") String zip, @Field("role") String role);
//
//    @FormUrlEncoded
//    @PUT("/api/order/{id}")
//    Call<Post> putPost(
//            @Path("id") int id,
//            @Field("name") String name,
//            @Field("email") String email,
//            @Field("number") String number,
//            @Field("cash") String cash,
//            @Field("address") String address,
//            @Field("state") String state,
//            @Field("zip") String zip,
//            @Field("role") String role);
//
////    @PATCH("/api/order")
////    Call<Post> patchPost(@Path("id") int id, @Field("name") String name, @Field("email") String email, @Field("number") String number, @Field("cash") String cash,
////                         @Field("address") String address, @Field("state") String state, @Field("zip") String zip, @Field("role") String role);
//
//    @DELETE("/api/order/{id}")
//    Call<Void> deletePost(@Path("id") int id);

}
