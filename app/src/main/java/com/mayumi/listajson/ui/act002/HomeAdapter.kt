package com.mayumi.listajson.ui.act002


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Users
import com.mayumi.listajson.ui.act003.ReposActivity
import com.mayumi.listajson.utils.Constantes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.celula_users.view.*


class HomeAdapter(
    private var listaUsers: List<Users>
) : RecyclerView.Adapter<HomeAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.celula_users, parent, false)
        return UsersViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaUsers.count()
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindView(listaUsers[position])
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nome_user = itemView.cel_tv_user
        private val photo_user = itemView.cel_photo

        fun bindView(users: Users) {
            nome_user.text = users.login
            var myUri = Uri.parse(users.avatar_url)
            Picasso.with(itemView.context).load(myUri).resize(70, 70).centerCrop().into(photo_user)

            itemView.setOnClickListener {
                val mIntent = Intent(itemView.context, ReposActivity::class.java)
                mIntent.putExtra(Constantes.USER, nome_user.text.toString())
                itemView.context.startActivity(mIntent)
            }
        }
    }
}