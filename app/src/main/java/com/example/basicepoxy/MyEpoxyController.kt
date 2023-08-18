package com.example.basicepoxy

import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.constraintlayout.motion.utils.ViewState
import com.airbnb.epoxy.TypedEpoxyController

 class MyEpoxyController:TypedEpoxyController<ArrayList<ItemModel>>() {
     override fun buildModels(data: ArrayList<ItemModel>?) {
         data?.forEach { item ->
             if (item != null) {
                 ItemEpoxymodel(item)
                     .id(item.id) // Each model requires a unique ID
                     .addTo(this)
             }
         }
     }
}