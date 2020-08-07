package com.mayumi.listajson.ui.act003


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mayumi.listajson.R
import com.mayumi.listajson.model.Repos
import kotlinx.android.synthetic.main.celula_repos.view.*


class ReposAdapter(
    private var listaRepos: List<Repos>
) : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.celula_repos, parent, false)
        return ReposViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaRepos.count()
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bindView(listaRepos[position])
    }

    class ReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nome_repos = itemView.cel_nome_repos
        private val repos_stars = itemView.cel_stars
        private val repos_description = itemView.cel_descr_repos

        fun bindView(repositorio: Repos) {
            nome_repos.text = repositorio.name
            repos_stars.text = repositorio.stargazers_count.toString()
            repos_description.text = repositorio.description
        }
    }
}