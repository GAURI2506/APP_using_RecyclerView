package com.example.day26

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class Myadapter (val context:Activity,val productArrayList: List<Product>):
RecyclerView.Adapter<Myadapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title:TextView
        var image:ShapeableImageView
        init{
            title=itemView.findViewById(R.id.producttitle)
            image=itemView.findViewById(R.id.productimage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem=productArrayList[position]
        holder.title.text=currentItem.title
        //image view,HOW TO SHOW IMAGE IN OMAGE VIEW IF GIVEN IN URL,3rd party libraray
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

}