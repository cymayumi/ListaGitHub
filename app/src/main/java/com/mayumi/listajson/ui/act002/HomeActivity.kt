package com.mayumi.listajson.ui.act002

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.Utils.Constantes
import com.mayumi.listajson.list.MeuAdapter
import com.mayumi.listajson.model.Users
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import com.mayumi.listajson.ui.act003.ReposActivity
import com.mayumi.listajson.ui.act001.MainActivity
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), HomeActivityContract.I_View {
    private lateinit var context: Context
    private lateinit var meuAdapter: MeuAdapter
    private lateinit var mPresenter: HomeActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@HomeActivity
        mPresenter = HomeActivityPresenter(this)
        mPresenter.carregarListaUsers()
    }

    private fun initActions() {

        list.setOnItemClickListener { parent, view, position, id ->

            var user = view.findViewById<TextView>(R.id.cel_tv_user)
            val mIntent = Intent(context, ReposActivity::class.java)

            mIntent.putExtra(Constantes.USER, user.text.toString())
            startActivity(mIntent)
            finish()
        }

    }

    override fun onBackPressed() {
        val mIntent = Intent(context, MainActivity::class.java)
        startActivity(mIntent)

        finish()
    }

    override fun showListaUsers(lista: List<Users>) {
        meuAdapter = MeuAdapter(
            context,
            R.layout.celula,
            lista
        )

        list.adapter = meuAdapter
    }

    override fun showErrorMsg() {
        Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
    }

}