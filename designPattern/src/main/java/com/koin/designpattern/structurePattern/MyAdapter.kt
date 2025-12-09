package com.koin.designpattern.structurePattern

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * `Adapter Pattern` — “Convert one interface to another”
 *
 *` Android Example → RecyclerView.Adapter`
 *
 * RecyclerView needs data + layout, but your data model doesn't match that format.
 * So you create an Adapter that converts your data into RecyclerView items.
 *
 * Converts data model → UI binding
 *
 * Room Entity ↔ Domain Model mapping
 *
 * Retrofit response ↔ UI Model conversion
 *
 * Firebase object ↔ Kotlin data class
 * */

class MyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}