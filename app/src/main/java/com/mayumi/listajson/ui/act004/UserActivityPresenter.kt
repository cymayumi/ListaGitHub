package com.mayumi.listajson.ui.act004

import android.net.Uri
import com.mayumi.listajson.model.Data
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivityPresenter(private var mView: UserActivityContract.I_View?):UserActivityContract.I_Presenter {

    override fun carregarDadosAPI(username: String) {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getData(username)

        requestCall.enqueue(object : Callback<Data> {

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    var dataUser = response.body()!!
                    mView?.showDados(dataUser)
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                mView?.showErrorMsg("Ocorreu um erro!")
            }
        })
    }
}