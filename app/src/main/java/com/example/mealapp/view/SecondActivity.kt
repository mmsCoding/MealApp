package com.example.mealapp.view

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mealapp.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.mealapp.viewmodel.MainViewModel
import android.content.Intent
import android.net.Uri
import com.example.mealapp.model.MealResponse
import com.example.mealapp.model.MealsItem
import kotlin.properties.Delegates
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.concurrent.Executors

class SecondActivity : AppCompatActivity() {

    private lateinit var rName: TextView
    private lateinit var rIng: TextView
    private lateinit var rInst: TextView
    private lateinit var ytBtn: Button
    private lateinit var backBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //initializing the views
        rName = findViewById(R.id.recipe_name)
        rIng = findViewById(R.id.ingredients)
        rInst = findViewById(R.id.instructions)
        ytBtn = findViewById(R.id.youtube)
        backBtn = findViewById(R.id.back)

        //getting the information passed from Main Activity
        val recipeName: String = intent.getStringExtra("recipeName").toString()

        val ing1: String = intent.getStringExtra("recipeIng1").orEmpty()
        val ing2: String = intent.getStringExtra("recipeIng2").orEmpty()
        val ing3: String = intent.getStringExtra("recipeIng3").orEmpty()
        val ing4: String = intent.getStringExtra("recipeIng4").orEmpty()
        val ing5: String = intent.getStringExtra("recipeIng5").orEmpty()
        val ing6: String = intent.getStringExtra("recipeIng6").orEmpty()
        val ing7: String = intent.getStringExtra("recipeIng7").orEmpty()
        val ing8: String = intent.getStringExtra("recipeIng8").orEmpty()
        val ing9: String = intent.getStringExtra("recipeIng9").orEmpty()
        val ing10: String = intent.getStringExtra("recipeIng10").orEmpty()
        val ing11: String = intent.getStringExtra("recipeIng11").orEmpty()
        val ing12: String = intent.getStringExtra("recipeIng12").orEmpty()
        val ing13: String = intent.getStringExtra("recipeIng13").orEmpty()
        val ing14: String = intent.getStringExtra("recipeIng14").orEmpty()
        val ing15: String = intent.getStringExtra("recipeIng15").orEmpty()
        val ing16: String = intent.getStringExtra("recipeIng16").orEmpty()
        val ing17: String = intent.getStringExtra("recipeIng17").orEmpty()
        val ing18: String = intent.getStringExtra("recipeIng18").orEmpty()
        val ing19: String = intent.getStringExtra("recipeIng19").orEmpty()
        val ing20: String = intent.getStringExtra("recipeIng20").orEmpty()

        val meas1: String = intent.getStringExtra("recipeMeas1").orEmpty()
        val meas2: String = intent.getStringExtra("recipeMeas2").orEmpty()
        val meas3: String = intent.getStringExtra("recipeMeas3").orEmpty()
        val meas4: String = intent.getStringExtra("recipeMeas4").orEmpty()
        val meas5: String = intent.getStringExtra("recipeMeas5").orEmpty()
        val meas6: String = intent.getStringExtra("recipeMeas6").orEmpty()
        val meas7: String = intent.getStringExtra("recipeMeas7").orEmpty()
        val meas8: String = intent.getStringExtra("recipeMeas8").orEmpty()
        val meas9: String = intent.getStringExtra("recipeMeas9").orEmpty()
        val meas10: String = intent.getStringExtra("recipeMeas10").orEmpty()
        val meas11: String = intent.getStringExtra("recipeMeas11").orEmpty()
        val meas12: String = intent.getStringExtra("recipeMeas12").orEmpty()
        val meas13: String = intent.getStringExtra("recipeMeas13").orEmpty()
        val meas14: String = intent.getStringExtra("recipeMeas14").orEmpty()
        val meas15: String = intent.getStringExtra("recipeMeas15").orEmpty()
        val meas16: String = intent.getStringExtra("recipeMeas16").orEmpty()
        val meas17: String = intent.getStringExtra("recipeMeas17").orEmpty()
        val meas18: String = intent.getStringExtra("recipeMeas18").orEmpty()
        val meas19: String = intent.getStringExtra("recipeMeas19").orEmpty()
        val meas20: String = intent.getStringExtra("recipeMeas20").orEmpty()

        val instructionText: String = intent.getStringExtra("recipeInstructions").toString()

        val rImage: String = intent.getStringExtra("recipeImage").toString()

        val rVideo: String = intent.getStringExtra("recipeVideo").toString()

        //setting the ingredient text
        val ingredient = "$meas1 $ing1\n" +
                "$meas2 $ing2\n" +
                "$meas3 $ing3\n" +
                "$meas4 $ing4\n" +
                "$meas5 $ing5\n" +
                "$meas6 $ing6\n" +
                "$meas7 $ing7\n" +
                "$meas8 $ing8\n" +
                "$meas9 $ing9\n" +
                "$meas10 $ing10\n" +
                "$meas11 $ing11\n" +
                "$meas12 $ing12\n" +
                "$meas13 $ing13\n" +
                "$meas14 $ing14\n" +
                "$meas15 $ing15\n" +
                "$meas16 $ing16\n" +
                "$meas17 $ing17\n" +
                "$meas18 $ing18\n" +
                "$meas19 $ing19\n" +
                "$meas20 $ing20\n"

        //setting the text on the UI
        rName.text = recipeName
        rIng.text = ingredient.trim()
        rInst.text = instructionText

        //setting the recipe image
        val imageView = findViewById<ImageView>(R.id.imageView)
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null

        executor.execute {
            val imageURL = rImage
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                handler.post {
                    imageView.setImageBitmap(image)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }

        //setting up the buttons on the recipe page
        ytBtn.setOnClickListener{
            try{
                val uri = Uri.parse(rVideo)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            catch(e : ActivityNotFoundException){
            }
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

}
