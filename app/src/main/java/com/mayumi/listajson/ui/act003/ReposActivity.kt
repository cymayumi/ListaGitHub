package com.mayumi.listajson.ui.act003


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Repos
import com.mayumi.listajson.ui.act002.HomeActivity
import com.mayumi.listajson.ui.act004.UserActivity
import com.mayumi.listajson.ui.base.BaseActivity
import com.mayumi.listajson.utils.Constantes
import kotlinx.android.synthetic.main.activity_repos.*
import kotlinx.android.synthetic.main.include_toolbar.*


class ReposActivity : BaseActivity(), ReposActivityContract.I_View {
    private lateinit var context: Context
    private lateinit var mPresenter: ReposActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)

        setUpToolbar(toolbarMain, R.string.title_activity_repos, true)

        initVars()
        initActions()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val mIntent = Intent(context, HomeActivity::class.java)
                startActivity(mIntent)
                finish()
                true
            }
            R.id.miProfile -> {
                val mIntent = Intent(context, UserActivity::class.java)
                mIntent.putExtra(Constantes.USER, recuperarParametros())

                startActivity(mIntent)
                finish()
                true
            }
            else -> return true
        }
    }

    private fun initVars() {
        context = this@ReposActivity
        mPresenter = ReposActivityPresenter(this)

        recuperarParametros()
    }

    private fun initActions() {
    }

    private fun recuperarParametros(): String {
        val username = intent.getStringExtra(Constantes.USER)
        mPresenter.carregarlistaAPI(username!!)
        return username
    }


    override fun showListaRepos(lista: List<Repos>) {
        recycler_repos.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = ReposAdapter(lista)
        }
    }

    override fun showErrorMsg(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
