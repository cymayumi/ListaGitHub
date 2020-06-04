package com.mayumi.listajson.list

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Repos
import com.squareup.picasso.Picasso

class ReposAdapter (
    private val context: Context,
    private var resource: Int,
    private var listaRepos: List<Repos>): BaseAdapter(){

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(resource, parent, false)
        }

        var tv_name_repos = mView?.findViewById<TextView>(R.id.cel_nome_repos)
        var tv_stars = mView?.findViewById<TextView>(R.id.cel_stars)
        var tv_descrip = mView?.findViewById<TextView>(R.id.cel_descr_repos)

        val item = listaRepos[position]

        tv_name_repos?.text = item.name
        tv_stars?.text = item.stargazers_count.toString()
        tv_descrip?.text = item.description

        return mView!!
    }

    override fun getItem(position: Int): Any {
        return listaRepos[position]
    }

    override fun getItemId(position: Int): Long {
        return listaRepos[position].id.toLong()
    }

    override fun getCount(): Int {
        return listaRepos.size
    }
}