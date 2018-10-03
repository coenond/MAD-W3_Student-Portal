package com.coen.mad_w3_student_portal

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coen.mad_w3_student_portal.model.Portal
import kotlinx.android.synthetic.main.item_portal.view.*
import kotlinx.android.synthetic.main.portal_list_item.view.*

class PortalAdapter(
        val onClickCallback: (Portal) -> Unit,
        var items : ArrayList<Portal>,
        val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_portal, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvPortal?.text = "" + items.get(position).title
        holder?.clItemPortal.setOnClickListener { onClickCallback(items[position]) }
    }

    fun update(items : ArrayList<Portal>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Portal {
        return items[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvPortal = view.tv_portal
    val clItemPortal = view.cl_item_portal
}