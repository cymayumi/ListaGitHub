package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.Utils.Constantes
import kotlinx.android.synthetic.main.activity_user.*

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
        recuperarParametros()
    }

    private fun initActions() {
    }

    private fun recuperarParametros() {
        var nome = intent.getStringExtra(Constantes.USER)
        tv_user.text = nome
    }


    override fun onBackPressed() {
        val mIntent = Intent(context, HomeActivity::class.java)
        startActivity(mIntent)

        finish()
    }
}