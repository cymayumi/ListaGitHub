package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var meuAdapter: MeuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@HomeActivity
        carregarLista()
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

    private fun carregarLista() {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getList()

        requestCall.enqueue(object : Callback<List<Users>> {

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    var listaPosts = response.body()!!

                    meuAdapter = MeuAdapter(
                        context,
                        R.layout.celula,
                        listaPosts
                    )

                    list.adapter = meuAdapter
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onBackPressed() {
        val mIntent = Intent(context, MainActivity::class.java)
        startActivity(mIntent)

        finish()
    }

}