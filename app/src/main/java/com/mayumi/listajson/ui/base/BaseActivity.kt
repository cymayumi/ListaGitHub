package com.mayumi.listajson.ui.base

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mayumi.listajson.R


open class BaseActivity : AppCompatActivity() {

    protected fun setUpToolbar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false) {
        val titleTool = findViewById<TextView>(R.id.title_toolbar)
        titleTool.text = getString(titleIdRes)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (showBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}