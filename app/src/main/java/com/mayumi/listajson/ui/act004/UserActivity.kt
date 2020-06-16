package com.mayumi.listajson.ui.act004

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.Utils.Constantes
import com.mayumi.listajson.model.Data
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import com.mayumi.listajson.ui.act003.ReposActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        btn_voltar.setOnClickListener {
            val mIntent = Intent(context, ReposActivity::class.java)
            mIntent.putExtra(Constantes.USER, recuperarParametros())
            startActivity(mIntent)
            finish()
        }
    }

    private fun recuperarParametros() : String {
        var username = intent.getStringExtra(Constantes.USER)
        tv_user.text = username!!

        carregarDados(username)
        return username
    }

    private fun carregarDados(username: String) {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getData(username)

        requestCall.enqueue(object : Callback<Data> {

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    var dataUser = response.body()!!

                    tv_name.text = dataUser.name
                    tv_location.text = dataUser.location
                    tv_followers.text = dataUser.followers.toString()
                    tv_following.text = dataUser.following.toString()
                    tv_repositories.text = dataUser.public_repos.toString()

                    var myUri = Uri.parse(dataUser.avatar_url)
                    Picasso.with(context).load(myUri).into(iv_photo_user)

                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onBackPressed() {
        val mIntent = Intent(context, ReposActivity::class.java)
        mIntent.putExtra(Constantes.USER, recuperarParametros())
        startActivity(mIntent)
        finish()
    }
}