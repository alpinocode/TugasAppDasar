package com.example.appalpin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailFruit : AppCompatActivity() {
    companion object{
        const val DATA_FRUIT = "data_fruit"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_fruit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fruit = intent.getParcelableExtra<Fruit>(DATA_FRUIT)
        if(fruit != null) {
            val imageFruit:ImageView = findViewById(R.id.imageView_detail)
            val nameFruit:TextView = findViewById(R.id.fruit_name_detail)
            val descriptionFruit:TextView = findViewById(R.id.description_fruit_detail)

            imageFruit.setImageResource(fruit.photoFruit)
            nameFruit.text = fruit.nameFruit
            descriptionFruit.text = fruit.deskripsiFruit

        }
    }
}