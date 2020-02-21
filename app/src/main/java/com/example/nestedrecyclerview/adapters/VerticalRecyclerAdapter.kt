package com.example.nestedrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.model.HorizantalModel
import com.example.nestedrecyclerview.model.VerticalModel
import kotlinx.android.synthetic.main.item_vertical.view.*

/**
 * Created by ahmad Mansour on 21,February,2020
 */

class VerticalRecyclerAdapter():
    RecyclerView.Adapter<VerticalRecyclerAdapter.VerticalRecyclerViewHolder>() {

    private lateinit var context: Context
    private lateinit var arrayList: ArrayList<VerticalModel>

    constructor(context: Context, arrayList: ArrayList<VerticalModel>) : this() {
        this.context = context
        this.arrayList = arrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalRecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_vertical,
            parent, false
        )
        return VerticalRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList?.size
    }

    override fun onBindViewHolder(holder: VerticalRecyclerViewHolder, position: Int) {
        val verticalModel = arrayList[position]
        val title: String = verticalModel.title
        val singleItem: ArrayList<HorizantalModel> = verticalModel.arrayList

        holder.titleTxt.text = title
        val horizantalRecyclerAdapter = HorizentalRecyclerAdapter(context, singleItem)
        holder.recyclerView.setHasFixedSize(true)
        holder.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
        holder.recyclerView.adapter = horizantalRecyclerAdapter

    }


    // Inner Class to create the view holder for the
    // recycler view Row
    inner class VerticalRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.recyclerview1
        val titleTxt: TextView = itemView.title_tv
        val btnMore: Button = itemView.btnMore
    }


}