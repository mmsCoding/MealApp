package com.example.mealapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.mealapp.R
import com.example.mealapp.model.MealResponse
import com.example.mealapp.viewmodel.MainViewModel
import java.lang.StringBuilder
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.model.MealsItem
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn10: Button
    private lateinit var btn11: Button
    private lateinit var btn12: Button
    private lateinit var btn13: Button
    private lateinit var meal: MealsItem
    private lateinit var meals: LiveData<MealResponse>
    private var num by Delegates.notNull<Int>()
    private lateinit var btns: Array<Button>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel()

        //initializing the buttons for each recipe
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)
        btn5 = findViewById(R.id.btn_5)
        btn6 = findViewById(R.id.btn_6)
        btn7 = findViewById(R.id.btn_7)
        btn8 = findViewById(R.id.btn_8)
        btn9 = findViewById(R.id.btn_9)
        btn10 = findViewById(R.id.btn_10)
        btn11 = findViewById(R.id.btn_11)
        btn12 = findViewById(R.id.btn_12)
        btn13 = findViewById(R.id.btn_13)

        btns = arrayOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13)

        //getting the data from the API
        mainViewModel.getMealData()
        meals = mainViewModel.mealData
        num = 0

        //setting the text of the buttons to the recipe names
        mainViewModel.mealData.observe(this) { mealData ->
            val mList: List<MealsItem> = mealData.meals
            for (m: MealsItem in mList) {
                setButtonText(mealData, num, btns.elementAt(num))
                num++
            }
        }

        //setting the onClicks
        btn1.setOnClickListener {
            sendMeal(0)
        }

        btn2.setOnClickListener {
            sendMeal(1)
        }

        btn3.setOnClickListener {
            sendMeal(2)
        }

        btn4.setOnClickListener {
            sendMeal(3)
        }

        btn5.setOnClickListener {
            sendMeal(4)
        }
        btn6.setOnClickListener {
            sendMeal(5)
        }
        btn7.setOnClickListener {
            sendMeal(6)
        }

        btn8.setOnClickListener {
            sendMeal(7)
        }

        btn9.setOnClickListener {
            sendMeal(8)
        }

        btn10.setOnClickListener {
            sendMeal(9)
        }

        btn11.setOnClickListener {
            sendMeal(10)
        }

        btn12.setOnClickListener {
            sendMeal(11)
        }

        btn13.setOnClickListener {
            sendMeal(12)
        }
    }

    //sets the button text
    private fun setButtonText(mealData: MealResponse, index: Int, btn: Button) {
        val resultText = StringBuilder("")

        mealData.meals.let { meals ->
            meal = meals.elementAt(index)
            resultText.append("${meal.strMeal}")
            btn.text = resultText

        }

    }

    //indicates which meal has been selected, and prepares to pass it to the second activity
    private fun setMeal(mealData: MealResponse, index: Int): MealsItem {
        mealData.meals.let { meals ->
            meal = meals.elementAt(index)
        }
        return meal
    }

    //sends the pertinent information about the recipe to the second activity
    private fun sendMeal(number: Int){
        mainViewModel.mealData.observe(this) { mealData ->
            meal = setMeal(mealData, index = number)

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("recipeName", meal.strMeal)
            intent.putExtra("recipeIng1", meal.strIngredient1)
            intent.putExtra("recipeIng2", meal.strIngredient2)
            intent.putExtra("recipeIng3", meal.strIngredient3)
            intent.putExtra("recipeIng4", meal.strIngredient4)
            intent.putExtra("recipeIng5", meal.strIngredient5)
            intent.putExtra("recipeIng6", meal.strIngredient6)
            intent.putExtra("recipeIng7", meal.strIngredient7)
            intent.putExtra("recipeIng8", meal.strIngredient8)
            intent.putExtra("recipeIng9", meal.strIngredient9)
            intent.putExtra("recipeIng10", meal.strIngredient10)
            intent.putExtra("recipeIng11", meal.strIngredient11)
            intent.putExtra("recipeIng12", meal.strIngredient12)
            intent.putExtra("recipeIng13", meal.strIngredient13)
            intent.putExtra("recipeIng14", meal.strIngredient14)
            intent.putExtra("recipeIng14", meal.strIngredient15)

            intent.putExtra("recipeMeas1", meal.strMeasure1)
            intent.putExtra("recipeMeas2", meal.strMeasure2)
            intent.putExtra("recipeMeas3", meal.strMeasure3)
            intent.putExtra("recipeMeas4", meal.strMeasure4)
            intent.putExtra("recipeMeas5", meal.strMeasure5)
            intent.putExtra("recipeMeas6", meal.strMeasure6)
            intent.putExtra("recipeMeas7", meal.strMeasure7)
            intent.putExtra("recipeMeas8", meal.strMeasure8)
            intent.putExtra("recipeMeas9", meal.strMeasure9)
            intent.putExtra("recipeMeas10", meal.strMeasure10)
            intent.putExtra("recipeMeas11", meal.strMeasure11)
            intent.putExtra("recipeMeas12", meal.strMeasure12)
            intent.putExtra("recipeMeas13", meal.strMeasure13)
            intent.putExtra("recipeMeas14", meal.strMeasure14)
            intent.putExtra("recipeMeas15", meal.strMeasure15)

            intent.putExtra("recipeInstructions", meal.strInstructions)

            intent.putExtra("recipeImage", meal.strMealThumb)

            intent.putExtra("recipeVideo", meal.strYoutube)

            startActivity(intent)
        }
    }
}
