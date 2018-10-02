package com.coen.mad_w3_student_portal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coen.mad_w3_student_portal.model.Portal
import kotlinx.android.synthetic.main.portal_list_item.view.*

class PortalAdapter(val items : ArrayList<Portal>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.portal_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvItem?.text = "" + items.get(position).title
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvItem = view.tv_portal_item
}