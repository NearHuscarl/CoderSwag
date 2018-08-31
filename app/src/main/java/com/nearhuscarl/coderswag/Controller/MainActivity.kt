package com.nearhuscarl.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.nearhuscarl.coderswag.Adapter.CategoryAdapter
import com.nearhuscarl.coderswag.Adapter.CategoryRecycleAdapter
import com.nearhuscarl.coderswag.Model.Category
import com.nearhuscarl.coderswag.R
import com.nearhuscarl.coderswag.Services.DataService
import com.nearhuscarl.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductActivity::class.java)

            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }

        val layoutManager = LinearLayoutManager(this)

        categoryListView.layoutManager = layoutManager
        categoryListView.adapter = adapter
        categoryListView.hasFixedSize()
    }
}
