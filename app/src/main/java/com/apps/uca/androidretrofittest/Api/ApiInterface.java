package com.apps.uca.androidretrofittest.Api;

import com.apps.uca.androidretrofittest.models.PostPage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/posts?access_token=EAACEdEose0cBANsWetUY5XSBDWRPT3BJTl1xyk5r4z3ycQWYu9mqnSHrFbern9FVRGOz1hnizZCBCZACFhSoKa4lSBEnT70GqnTKK8sCaZA5KZBXMomk5uoYF5sRefGi33uNEevaBd8jVH7IZAmXqPUiYLbUevjqAbw8cpyMy88NyqkpPQKJ2xJNE3ghKagZAbClVRHhvnRx1AvMLsFOzGsZAvpGa81uFEZD&debug=all&format=json&method=get&pretty=0&suppress_http_code=1")
    Call<PostPage> getPosts();
}