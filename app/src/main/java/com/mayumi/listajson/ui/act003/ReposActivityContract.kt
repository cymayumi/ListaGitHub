package com.mayumi.listajson.ui.act003

import com.mayumi.listajson.model.Repos

interface ReposActivityContract {
    interface I_View{
        fun showListaRepos(lista: List<Repos>)
        fun showErrorMsg(message: String)
    }
    interface I_Presenter{
        fun carregarlistaAPI(username: String)
    }
}