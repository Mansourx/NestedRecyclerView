package com.example.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.adapters.VerticalRecyclerAdapter
import com.example.nestedrecyclerview.model.HorizantalModel
import com.example.nestedrecyclerview.model.VerticalModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var verticalAdapter: VerticalRecyclerAdapter
    private lateinit var arrayListVertical: ArrayList<VerticalModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDate()


        val recyclerView = vertical_recycler_view
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        // here we setup the adapter for the recycler-view
        verticalAdapter = VerticalRecyclerAdapter(context = this, arrayList = arrayListVertical)
        recyclerView.adapter = verticalAdapter
        verticalAdapter.notifyDataSetChanged()

    }

    private fun setDate() {

        arrayListVertical = ArrayList()
        for(i in 1..5) {

            var arrayListHorizantal: ArrayList<HorizantalModel> = ArrayList()
            var verticalModel = VerticalModel("Title $i", arrayListHorizantal)


            for (j in 0..5) {
                var horizantalModel = HorizantalModel( "name $j",
                    "description $j")
                arrayListHorizantal.add(horizantalModel)
            }
            verticalModel.arrayList = arrayListHorizantal

            arrayListVertical.add(verticalModel)
        }


    }
}
