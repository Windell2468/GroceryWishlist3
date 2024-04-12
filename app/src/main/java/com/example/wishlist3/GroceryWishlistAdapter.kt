package com.example.wishlist3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist3.GroceryWishlist
import com.example.wishlist3.R

class GroceryWishlistAdapter(private val wishlist: List<GroceryWishlist>) :
    RecyclerView.Adapter<GroceryWishlistAdapter.WishlistViewHolder>() {

    inner class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textName)
        val priceTextView: TextView = itemView.findViewById(R.id.textPrice)
        val urlTextView: TextView = itemView.findViewById(R.id.textUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.grocerywishlist_items3, parent, false)
        return WishlistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        val currentItem = wishlist[position]

        // Set name
        holder.nameTextView.text = currentItem.Name

        // Set price, you can format it as currency if needed
        holder.priceTextView.text = String.format("%.2f", currentItem.Price)

        // Set URL
        holder.urlTextView.text = currentItem.Url
    }

    override fun getItemCount() = wishlist.size
}
