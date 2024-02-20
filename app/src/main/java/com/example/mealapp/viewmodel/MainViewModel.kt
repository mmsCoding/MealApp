package com.example.mealapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealapp.model.MealResponse
import com.example.mealapp.networking.ApiConfig
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainViewModel() : ViewModel() {

    private val _mealData = MutableLiveData<MealResponse>()
    val mealData: LiveData<MealResponse> get() = _mealData

    private var errorMessage: String = ""

    //function that gets the data from the API
    fun getMealData() {

        val client = ApiConfig.getApiService().getMeal()

        client.enqueue(object : Callback<MealResponse> {

            override fun onResponse(
                call: Call<MealResponse>,
                response: Response<MealResponse>
            ) {
                val responseBody = response.body()
                if (!response.isSuccessful || responseBody == null) {
                    onError("Data Processing Error")
                    return
                }

                _mealData.postValue(responseBody)
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                onError(t.message)
                t.printStackTrace()
            }

        })
    }

    private fun onError(inputMessage: String?) {

        val message = if (inputMessage.isNullOrBlank() or inputMessage.isNullOrEmpty()) "Unknown Error"
        else inputMessage

        errorMessage = "An error has occurred"
    }

}