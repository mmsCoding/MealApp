package com.mealapp.view

import android.widget.Button
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mealapp.R
import com.mealapp.model.Meal
import com.mealapp.model.MealResponse
import com.mealapp.view.MainActivity
import com.mealapp.viewmodel.MainViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

class MainActivityTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
    @Test
    fun setButtonText() {
        //Given
        val sut = MainActivity() //system under test

        val meal = mockk<Meal>()
        every { meal.strMeal } returns "Button Text"
        val mealData = MealResponse(listOf<Meal>(meal))
        val index = 0


        //When
        val result = sut.setButtonText(mealData, index)

        //Then
        assertEquals("Button Text", result, "Button text was not built properly")
    }

    @Test
    fun setMeal() {
    }

//    @Test
//    fun sendMeal() {
//        //Given
//        val sut = MainActivity()
//        sut.mainViewModel = mockk<MainViewModel>()
//
//        //When
//
//        //Then
//
//
//    }

}