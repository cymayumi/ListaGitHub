package com.mayumi.listajson.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.listajson.R
import com.mayumi.listajson.Utils.Constantes
import com.mayumi.listajson.list.MeuAdapter
import com.mayumi.listajson.list.ReposAdapter
import com.mayumi.listajson.model.Repos
import com.mayumi.listajson.model.Users
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_repos.*
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var reposAdapter: ReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@ReposActivity
        recuperarParametros()
    }

    private fun initActions() {
        btn_perfil.setOnClickListener {
            val mIntent = Intent(context, UserActivity::class.java)
            mIntent.putExtra(Constantes.USER, recuperarParametros())

            startActivity(mIntent)
            finish()
        }
    }

    private fun recuperarParametros() : String{
        var username = intent.getStringExtra(Constantes.USER)

        carregarLista(username)
        return username
    }

    private fun carregarLista(username: String) {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getListRepos(username)

        requestCall.enqueue(object : Callback<List<Repos>> {

            override fun onResponse(call: Call<List<Repos>>, response: Response<List<Repos>>) {
                if (response.isSuccessful) {
                    var listaRepositorios = response.body()!!

                    reposAdapter = ReposAdapter(
                        context,
                        R.layout.celula_repos,
                        listaRepositorios
                    )

                    list_repos.adapter = reposAdapter
                }
            }

            override fun onFailure(call: Call<List<Repos>>, t: Throwable) {
                Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
            }
        })
    }
}
