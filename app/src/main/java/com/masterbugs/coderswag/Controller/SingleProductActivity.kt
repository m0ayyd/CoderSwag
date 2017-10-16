package com.masterbugs.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.masterbugs.coderswag.Model.Product
import com.masterbugs.coderswag.R
import com.masterbugs.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_single_product.*
import kotlinx.android.synthetic.main.product_list_item.*

class SingleProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_product)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        productNameTxt.text = product.title
        productPriceTxt.text = product.price

        val resourceId = resources.getIdentifier(product.image, "drawable", this.packageName)
        productImg.setImageResource(resourceId)

        buyBtn.setOnClickListener {
            Toast.makeText(this, "You bought ${product.title} successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
