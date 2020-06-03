package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.list.MeuAdapter
import com.mayumi.listajson.model.Star
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
    }

    private fun initActions() {
        carregarLista()
    }

    private fun carregarLista() {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getList()

        requestCall.enqueue(object : Callback<List<Star>> {

            override fun onResponse(call: Call<List<Star>>, response: Response<List<Star>>) {
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

            override fun onFailure(call: Call<List<Star>>, t: Throwable) {
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