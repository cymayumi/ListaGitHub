package com.mayumi.listajson.ui.act004

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.utils.Constantes
import com.mayumi.listajson.model.Data
import com.mayumi.listajson.ui.act003.ReposActivity
import com.mayumi.listajson.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.include_toolbar.*

class UserActivity : BaseActivity(),UserActivityContract.I_View {
    private lateinit var context: Context
    private lateinit var mPresenter: UserActivityContract.I_Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setUpToolbar(toolbarMain, R.string.title_activity_profile, true)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@UserActivity
        mPresenter = UserActivityPresenter(this)
        recuperarParametros()
    }

    private fun initActions() {

    }

    private fun recuperarParametros() : String {
        var username = intent.getStringExtra(Constantes.USER)
        tv_user.text = username!!

        mPresenter.carregarDadosAPI(username)
        return username
    }


    override fun onBackPressed() {
        val mIntent = Intent(context, ReposActivity::class.java)
        mIntent.putExtra(Constantes.USER, recuperarParametros())
        startActivity(mIntent)
        finish()
    }

    override fun showDados(dados : Data) {
        tv_name.text = dados.name
        tv_location.text = dados.location
        tv_followers.text = dados.followers.toString()
        tv_following.text = dados.following.toString()
        tv_repositories.text = dados.public_repos.toString()

        var myUri = Uri.parse(dados.avatar_url)
        Picasso.with(context).load(myUri).into(iv_photo_user)
    }

    override fun showErrorMsg(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}