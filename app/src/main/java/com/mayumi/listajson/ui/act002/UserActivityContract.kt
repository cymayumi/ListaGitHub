package com.mayumi.listajson.ui.act002

import com.mayumi.listajson.model.Users

interface UserActivityContract {
    interface I_View {
        fun showListaUsers(lista: List<Users>)
        fun showErrorMsg(message: String)
    }

    interface I_Presenter {
        fun carregarAPI()
    }
}