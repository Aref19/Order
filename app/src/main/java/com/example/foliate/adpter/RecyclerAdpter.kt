package com.example.foliate.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foliate.R

class RecyclerAdpter(list:ArrayList<String>) : RecyclerView.Adapter<RecyclerAdpter.ViewHolder>() {
    var name1=list
    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        var image=view.findViewById<ImageView>(R.id.iconad)
        var name=view.findViewById<TextView>(R.id.namead)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdpter.ViewHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.adpterforrecycler,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdpter.ViewHolder, position: Int) {
        holder.image.setImageResource(R.drawable.ic_baseline_home_repair_service_24)
        holder.name.text=name1.get(position)
    }

    override fun getItemCount(): Int {
       return name1.size
    }
}