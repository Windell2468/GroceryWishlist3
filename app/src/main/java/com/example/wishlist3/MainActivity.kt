package com.example.wishlist3
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist3.GroceryWishlist
import com.example.wishlist3.R

class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<GroceryWishlist>
    lateinit var groceryName: EditText
    lateinit var groceryPrice: EditText
    lateinit var groceryUrl: EditText
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = mutableListOf()

        // Initialize RecyclerView and its adapter
        val groceryWishlistRv = findViewById<RecyclerView>(R.id.groceryList)
        val groceryWishlistAdapter = GroceryWishlistAdapter(items)

        // Set the adapter and layout manager
        groceryWishlistRv.adapter = groceryWishlistAdapter
        groceryWishlistRv.layoutManager = LinearLayoutManager(this)

        // Initialize global variables
        groceryName = findViewById(R.id.groceryName)
        groceryPrice = findViewById(R.id.groceryPrice)
        groceryUrl = findViewById(R.id.groceryUrl)
        submitButton = findViewById(R.id.submitButton)

        // Set click listener for the submit button
        submitButton.setOnClickListener {
            val name = groceryName.text.toString()
            val url = groceryUrl.text.toString()

            // Error handling for price conversion
            val price = try {
                groceryPrice.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Invalid price. Please enter a valid number.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Create GroceryWishlist object and add to list
            val groceryItem = GroceryWishlist(name, url, price)
            items.add(groceryItem)
            groceryWishlistAdapter.notifyDataSetChanged()

            // Provide feedback to user
            Toast.makeText(this, "Grocery item added.", Toast.LENGTH_SHORT).show()

            // Clear inputs
            groceryName.text.clear()
            groceryPrice.text.clear()
            groceryUrl.text.clear()
        }
    }
}