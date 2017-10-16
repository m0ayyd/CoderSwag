package com.masterbugs.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.masterbugs.coderswag.Adapters.ProductsAdapter
import com.masterbugs.coderswag.R
import com.masterbugs.coderswag.Services.DataService
import com.masterbugs.coderswag.Utilities.EXTRA_CATEGORY
import com.masterbugs.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) { product ->
            val productActivity = Intent(this, SingleProductActivity::class.java)
            productActivity.putExtra(EXTRA_PRODUCT, product)
            startActivity(productActivity)
        }

        val orintation = resources.configuration.orientation

        var spanCount = 2
        if(orintation == Configuration.ORIENTATION_LANDSCAPE)
            spanCount = 3

        val screenSize = resources.configuration.screenWidthDp

        if(screenSize > 720)
            spanCount = 3

        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter
    }
}
