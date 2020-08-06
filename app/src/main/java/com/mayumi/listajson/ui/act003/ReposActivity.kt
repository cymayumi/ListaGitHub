package com.mayumi.listajson.ui.act003

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.utils.Constantes
import com.mayumi.listajson.list.ReposAdapter
import com.mayumi.listajson.model.Repos
import com.mayumi.listajson.ui.act004.UserActivity
import com.mayumi.listajson.ui.act002.HomeActivity
import kotlinx.android.synthetic.main.activity_repos.*
import kotlinx.android.synthetic.main.activity_repos.btn_perfil
import kotlinx.android.synthetic.main.activity_repos.btn_voltar_repos
import kotlinx.android.synthetic.main.activity_repos.list_repos

class ReposActivity : AppCompatActivity(), ReposActivityContract.I_View {
    private lateinit var context: Context
    private lateinit var reposAdapter: ReposAdapter
    private lateinit var mPresenter: ReposActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@ReposActivity
        mPresenter = ReposActivityPresenter(this)

        recuperarParametros()
    }

    private fun initActions() {
        btn_perfil.setOnClickListener {
            val mIntent = Intent(context, UserActivity::class.java)
            mIntent.putExtra(Constantes.USER, recuperarParametros())

            startActivity(mIntent)
            finish()
        }

        btn_voltar_repos.setOnClickListener {
            val mIntent = Intent(context, HomeActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }

    private fun recuperarParametros() : String{
        var username = intent.getStringExtra(Constantes.USER)
        tv_nome_user.text = username
        mPresenter.carregarlistaAPI(username)
        return username
    }

    override fun onBackPressed() {
        val mIntent = Intent(context, HomeActivity::class.java)
        startActivity(mIntent)
        finish()
    }

    override fun showListaRepos(lista: List<Repos>) {
        reposAdapter = ReposAdapter(
            context,
            R.layout.celula_repos,
            lista
        )

        list_repos.adapter = reposAdapter
    }

    override fun showErrorMsg(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
