package com.example.nestedrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.model.HorizantalModel
import kotlinx.android.synthetic.main.item_horizantal.view.*

/**
 * Created by ahmad Mansour on 21,February,2020
 */

class HorizentalRecyclerAdapter() :
    RecyclerView.Adapter<HorizentalRecyclerAdapter.HorizantalRecyclerViewHolder>() {

    lateinit var context: Context
    lateinit var arrayList: ArrayList<HorizantalModel>

    constructor(context: Context, arrayList: ArrayList<HorizantalModel>) : this() {
        this.context = context
        this.arrayList = arrayList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorizantalRecyclerViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_horizantal, parent, false)
        return HorizantalRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: HorizantalRecyclerViewHolder, position: Int) {
        val horizantalModel: HorizantalModel = arrayList[position]
        holder.decriptionTv.text = horizantalModel.name
        holder.itemView.setOnClickListener { v: View? ->
            Toast.makeText(context, "item # $position", Toast.LENGTH_LONG).show()
        }
    }

    /*
    * inner Class for Horizental recycler view ViewHolder
    */

    inner class HorizantalRecyclerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val decriptionTv: TextView = itemview.description_txt
        val imageThumb: ImageView = itemview.iv_thumb

    }


}