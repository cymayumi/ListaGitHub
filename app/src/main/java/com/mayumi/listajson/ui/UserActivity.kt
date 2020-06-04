package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import kotlinx.android.synthetic.main.activity_main.*

class UserActivity : AppCompatActivity() {
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@UserActivity
    }

    private fun initActions() {

    }

    override fun onBackPressed() {
        val mIntent = Intent(context, HomeActivity::class.java)
        startActivity(mIntent)

        finish()
    }
}