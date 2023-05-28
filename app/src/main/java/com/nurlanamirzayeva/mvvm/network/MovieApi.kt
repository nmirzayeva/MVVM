package com.nurlanamirzayeva.mvvm.network

import com.nurlanamirzayeva.mvvm.model.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitInstance {
    val api : MovieApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}



interface MovieApi {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>

}

