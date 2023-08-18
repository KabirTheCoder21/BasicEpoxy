package com.example.basicepoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.EpoxyRecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var epoxyController: MyEpoxyController
    private lateinit var epoxyRecyclerView: EpoxyRecyclerView
    private var dataList : ArrayList<ItemModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        epoxyController = MyEpoxyController()
        epoxyRecyclerView = findViewById(R.id.epoxyRecyclerView) // Replace with your RecyclerView ID
        epoxyRecyclerView.setController(epoxyController)


        for(i in 1..20)
        {
            dataList.add(ItemModel(i,R.drawable.person_icon,"Item$i"))
        }

        epoxyController.setData(dataList)

    }
}