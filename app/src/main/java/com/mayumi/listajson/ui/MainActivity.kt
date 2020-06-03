package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mayumi.listajson.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@MainActivity
    }

    private fun initActions() {
        btn_start.setOnClickListener {
            val mIntent = Intent(context, HomeActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }

}
