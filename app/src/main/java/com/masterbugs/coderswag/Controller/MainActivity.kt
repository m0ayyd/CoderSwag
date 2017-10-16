package com.masterbugs.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.masterbugs.coderswag.Adapters.CategoryRecycleAdapter
import com.masterbugs.coderswag.R
import com.masterbugs.coderswag.Services.DataService
import com.masterbugs.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productActivity = Intent(this, ProductsActivity::class.java)
            productActivity.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productActivity)
        }

        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
