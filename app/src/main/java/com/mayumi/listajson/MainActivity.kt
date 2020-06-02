package com.mayumi.listajson

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@MainActivity
        lv_list.adapter = Adapter(
            context,
            R.layout.celula,
            gerarClientes(1000)
        )
    }

    private fun initActions() {

    }

    private fun gerarClientes(quantidade: Int): ArrayList<HMAux> {
        var clientes = ArrayList<HMAux>()

        for (i in 1..quantidade) {
            var aux = HMAux() // ??? chaves 0
            aux[HMAux.ID] = i.toString()
            aux[HMAux.NOME] = "Nome $i"

            clientes.add(aux)
        }

        return clientes
    }
}
