package com.mayumi.listajson.ui.act002

import com.mayumi.listajson.model.Users
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivityPresenter(
    private var mView: UserActivityContract.I_View?
) : UserActivityContract.I_Presenter {

    override fun carregarAPI() {
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
                mView?.showErrorMsg("Ocorreu um erro!")
            }
        })
    }
}