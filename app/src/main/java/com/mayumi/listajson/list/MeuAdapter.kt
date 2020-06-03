package com.mayumi.listajson.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Star

class MeuAdapter (
    private val context: Context,
    private var resource: Int,
    private var listaPosts: List<Star>):BaseAdapter(){

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(resource, parent, false)
        }

        var tv_nome = mView?.findViewById<TextView>(R.id.celula_tv_nome)

        val item = listaPosts[position]

        tv_nome?.text = item.name

        return mView!!
    }

    override fun getItem(position: Int): Any {
        return listaPosts[position]
    }

    override fun getItemId(position: Int): Long {
        return listaPosts[position].id.toLong()
    }

    override fun getCount(): Int {
        return listaPosts.size
    }

}