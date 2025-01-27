package com.example.appalpin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewFruit:RecyclerView
    private val list = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewFruit = findViewById(R.id.view_fruit)
        viewFruit.setHasFixedSize(true)

        list.addAll(getListFruits())
        showRecyleList()

        supportActionBar?.title = ""
    }

    private fun getListFruits():ArrayList<Fruit>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhotoFruit = resources.obtainTypedArray(R.array.data_photo)
        val listFruit = ArrayList<Fruit>()

        for(i in dataName.indices){
            val fruit = Fruit(dataName[i], dataDescription[i], dataPhotoFruit.getResourceId(i, -1))
            listFruit.add(fruit)
        }

        return listFruit

    }

    private fun showSelectedFruit(fruit:Fruit){
        val intentFruitDetail = Intent(this, DetailFruit::class.java)
        intentFruitDetail.putExtra(DetailFruit.DATA_FRUIT, fruit)
        startActivity(intentFruitDetail)
    }

    private fun showRecyleList(){
        viewFruit.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        viewFruit.adapter = listFruitAdapter

        listFruitAdapter.setOnItemClickCallback(object : ListFruitAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Fruit) {
                showSelectedFruit(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.about_page) {
            val intentProfile = Intent(this, AboutMePage::class.java)
            startActivity(intentProfile)
        }
        return super.onOptionsItemSelected(item)
    }
}



