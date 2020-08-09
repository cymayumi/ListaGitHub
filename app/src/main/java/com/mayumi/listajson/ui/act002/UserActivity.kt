package com.mayumi.listajson.ui.act002

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Users
import com.mayumi.listajson.ui.act001.MainActivity
import com.mayumi.listajson.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.include_toolbar.*

class UserActivity : BaseActivity(), UserActivityContract.I_View {
    private lateinit var context: Context
    private lateinit var mPresenter: UserActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setUpToolbar(toolbarMain, R.string.title_activity_users)
        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@UserActivity
        mPresenter = UserActivityPresenter(this)
        mPresenter.carregarAPI()
    }

    private fun initActions() {

    }

    override fun onBackPressed() {
        val mIntent = Intent(context, MainActivity::class.java)
        startActivity(mIntent)

        finish()
    }

    override fun showListaUsers(lista: List<Users>) {
        recycler_home.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = UserAdapter(lista)
        }
    }

    override fun showErrorMsg(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}