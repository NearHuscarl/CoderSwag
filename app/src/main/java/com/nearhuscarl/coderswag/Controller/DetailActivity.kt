package com.nearhuscarl.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nearhuscarl.coderswag.Model.Product
import com.nearhuscarl.coderswag.R
import com.nearhuscarl.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)

        productImage.setImageResource(resourceId)
        productName.text = product.title
        productPrice.text = product.price
        productRate.numStars = product.rate
    }
}
