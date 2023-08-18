package com.example.basicepoxy

import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
 class ItemEpoxymodel(private val item: ItemModel) : EpoxyModelWithHolder<ItemEpoxymodel.Holder>() {


    class Holder : EpoxyHolder(){
         lateinit var itemView: View

        override fun bindView(itemView: View) {
            this.itemView = itemView
        }
        fun bindData(item : ItemModel)
        {
            itemView.findViewById<TextView>(R.id.titleTextView).text = item.title
            itemView.findViewById<ImageView>(R.id.image_view).setImageResource(item.img)
            itemView.tag = item.id
        }
        val itemClickListener = View.OnClickListener {
            val itemId = itemView.tag as Int
            Toast.makeText(it.context, "Item Clicked: ${itemId}", Toast.LENGTH_SHORT).show()
        }
        val imageClickListener = View.OnClickListener {
            val itemId = itemView.tag as Int // Retrieve the ItemModel id from the tag
            // Handle the click event for the image
            // You can perform any action based on the clicked image here
            Toast.makeText(it.context, "Image Clicked: $itemId", Toast.LENGTH_SHORT).show()
        }
    }
     override fun bind(holder: Holder) {
         holder.bindData(item)
         holder.itemView.setOnClickListener(holder.itemClickListener)
         holder.itemView.findViewById<ImageView>(R.id.image_view).setOnClickListener(holder.imageClickListener)
     }
    override fun getDefaultLayout(): Int {
        return R.layout.item
    }

    override fun createNewHolder(parent: ViewParent): Holder {
       return Holder()
    }
}