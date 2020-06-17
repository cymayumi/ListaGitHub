package com.mayumi.listajson.ui.act003

import com.mayumi.listajson.model.Repos
import com.mayumi.listajson.service.ServiceBuilder
import com.mayumi.listajson.service.WebAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposActivityPresenter(
    private var mView: ReposActivityContract.I_View?
) : ReposActivityContract.I_Presenter {

    override fun carregarlistaAPI(username: String) {
        val destinationService = ServiceBuilder.buildService(WebAPI::class.java)
        val requestCall = destinationService.getListRepos(username)

        requestCall.enqueue(object : Callback<List<Repos>> {

            override fun onResponse(call: Call<List<Repos>>, response: Response<List<Repos>>) {
                if (response.isSuccessful) {
                    var listaRepositorios = response.body()!!
                    mView?.showListaRepos(listaRepositorios)
                }
            }

            override fun onFailure(call: Call<List<Repos>>, t: Throwable) {
                mView?.showErrorMsg("Ocorreu um erro!")
            }
        })
    }
}