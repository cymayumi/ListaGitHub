package com.mayumi.listajson.ui.act002

import com.mayumi.listajson.model.Users

interface HomeActivityContract {
    interface I_View{
        fun showListaUsers(lista: List<Users>)
        fun showErrorMsg()
    }
    interface I_Presenter{
    fun carregarListaUsers()
    }
}