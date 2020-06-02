package com.mayumi.listajson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter (
    private val context: Context,
    private var resource: Int,
    private var dados: ArrayList<HMAux>):BaseAdapter(){

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(resource, parent, false)
        }

        var tv_nome = mView?.findViewById<TextView>(R.id.celula_tv_nome)

        val item = dados[position]

        tv_nome?.setText(item[HMAux.NOME])

        return mView!!
    }

    override fun getItem(position: Int): Any {
        return dados[position]
    }

    override fun getItemId(position: Int): Long {
        return dados[position][HMAux.ID]?.toLong() ?: 0L
    }

    override fun getCount(): Int {
        return dados.size
    }

}