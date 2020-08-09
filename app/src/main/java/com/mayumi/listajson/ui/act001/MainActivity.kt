package com.mayumi.listajson.ui.act001

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mayumi.listajson.R
import com.mayumi.listajson.ui.act002.UserActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.I_View {

    private lateinit var context: Context
    private lateinit var mPresenter : MainActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@MainActivity
        mPresenter = MainActivityPresenter(this)
    }

    private fun initActions() {
        btn_start.setOnClickListener {
            executaNavegacao()
        }
    }

    override fun executaNavegacao() {
        val mIntent = Intent(context, UserActivity::class.java)
        startActivity(mIntent)
        finish()
    }

}
