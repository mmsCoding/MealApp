package com.mealapp.networking

import com.mealapp.model.MealResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    //Interface that grabs the API data. Here, searching for all recipes that start with R
    @GET("search.php")
    fun getMeal(
        @Query("f") filter: String = "r"
    ): Call<MealResponse>
}