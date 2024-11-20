package com.liem.primeraappandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorRecycle (private val alumnes: List<AlumneModel>) : RecyclerView.Adapter<AdaptadorRecycle.AlumneViewHolder>(){

    // ViewHolder que representa cada ítem de la lista
    class AlumneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNom: TextView = itemView.findViewById(R.id.textView)
        val textEdat: TextView = itemView.findViewById(R.id.textView2)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumneViewHolder {
        // Infla el layout del ítem
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return AlumneViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumneViewHolder, position: Int) {

        val alumne = alumnes[position]
        holder.textNom.text = alumne.nom
        holder.textEdat.text = alumne.edat.toString() + " anys"

        holder.imageView.setImageResource(R.drawable.baseline_co_present_24)
    }

    override fun getItemCount(): Int {
        return alumnes.size
    }
}