package com.mayumi.listajson.ui.act002

import android.widget.Toast
import com.mayumi.listajson.R
import com.mayumi.listajson.list.MeuAdapter
import com.mayumi.listajson.model.Users
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivityPresenter(private var mView: HomeActivityContract.I_View?) : HomeActivityContract.I_Presenter{

    override fun carregarListaUsers() {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getList()

        requestCall.enqueue(object : Callback<List<Users>> {

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    var listaUsers = response.body()!!
                    mView?.showListaUsers(listaUsers)
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    mView?.showErrorMsg()
            }
        })
    }
}