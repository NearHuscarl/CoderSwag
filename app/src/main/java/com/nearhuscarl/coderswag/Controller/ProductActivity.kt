package com.nearhuscarl.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.nearhuscarl.coderswag.Adapter.ProductRecycleAdapter
import com.nearhuscarl.coderswag.R
import com.nearhuscarl.coderswag.Services.DataService
import com.nearhuscarl.coderswag.Utilities.EXTRA_CATEGORY
import com.nearhuscarl.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: ProductRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductRecycleAdapter(this, DataService.getProducts(categoryType)) { product ->
            val detailIntent = Intent(this, DetailActivity::class.java)

            detailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(detailIntent)
        }

        var spanCount: Int
        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp

        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            spanCount = 4
        else
            spanCount = 3

        if (screenSize > 720)
            spanCount = 3

        val layoutManager = GridLayoutManager(this, spanCount)

        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
