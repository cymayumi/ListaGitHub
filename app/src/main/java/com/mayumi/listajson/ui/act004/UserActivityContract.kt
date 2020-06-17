package com.mayumi.listajson.ui.act004

import com.mayumi.listajson.model.Data
import com.mayumi.listajson.model.Repos

interface UserActivityContract {
    interface I_View{
        fun showDados(dados : Data)
        fun showErrorMsg(message: String)
    }
    interface I_Presenter{
        fun carregarDadosAPI(username: String)
    }
}