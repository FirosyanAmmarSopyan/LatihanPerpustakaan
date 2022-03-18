package com.codenesia.latihanperpustakaan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseLogin> login(@Field("username") String username,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST("post_book.php")
    Call<ResponseInsertBook> insertBook(@Field("title") String title,
                                        @Field("publisher") String publisher,
                                        @Field("author") String author,
                                        @Field("stock") String stock,
                                        @Field("year") String year);

    @GET("get_book.php")
    Call<ResponseGetBook> getBook();
}
