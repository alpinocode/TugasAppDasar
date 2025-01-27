package com.example.appalpin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListFruitAdapter(private val listFruit:ArrayList<Fruit>): RecyclerView.Adapter<ListFruitAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoFruit:ImageView = itemView.findViewById(R.id.img_item_fruit)
        val nameFruit:TextView = itemView.findViewById(R.id.text_view_fruit)
        val descriptionFruit:TextView = itemView.findViewById(R.id.item_text_description)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_fruit, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description, imgFruit) = listFruit[position]
        Glide.with(holder.itemView.context).load(imgFruit).into(holder.photoFruit)
        holder.nameFruit.text = name
        holder.descriptionFruit.text = description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFruit[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listFruit.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback{
        fun onItemClicked(data:Fruit)
    }
}