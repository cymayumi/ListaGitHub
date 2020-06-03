package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R

class HomeActivity : AppCompatActivity() {
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@HomeActivity
    }

    private fun initActions() {

    }

    override fun onBackPressed() {
        val mIntent = Intent(context, MainActivity::class.java)
        startActivity(mIntent)

        finish()
    }

}