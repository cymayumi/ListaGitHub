package com.mayumi.listajson.list

import android.content.Context
import android.hardware.Camera
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Users
import com.squareup.picasso.Picasso


class MeuAdapter (
    private val context: Context,
    private var resource: Int,
    private var listaPosts: List<Users>):BaseAdapter(){

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView

        if (mView == null) {
            mView = mInflater.inflate(resource, parent, false)
        }

        var tv_nome = mView?.findViewById<TextView>(R.id.cel_tv_user)
        var iv_photo = mView?.findViewById<ImageView>(R.id.cel_photo)

        val item = listaPosts[position]

        tv_nome?.text = item.login

        var myUri = Uri.parse(item.avatar_url)
        Picasso.with(context).load(myUri).resize(100, 100).centerCrop().into(iv_photo)


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