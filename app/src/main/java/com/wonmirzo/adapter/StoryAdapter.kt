package com.wonmirzo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wonmirzo.R
import com.wonmirzo.model.Story

class StoryAdapter(
    private var context: Context,
    private var items: ArrayList<Story>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_CREATE = 0
    private val TYPE_ITEM_VIEW = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return TYPE_ITEM_CREATE
        return TYPE_ITEM_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_CREATE) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_story_create, parent, false)
            return StoryCreateHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            val ivBackground = holder.ivBackground
            val ivProfile = holder.ivProfile
            val tvFullName = holder.tvFullName

            Glide.with(holder.itemView.context)
                .load(story.profile)
                .into(ivBackground)
            Glide.with(holder.itemView.context)
                .load(story.profile)
                .into(ivProfile)
            tvFullName.text = story.fullName
        }

        if (holder is StoryCreateHolder) {
            val ivBackground = holder.ivBackground

            Glide.with(holder.itemView.context)
                .load(story.profile)
                .into(ivBackground)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBackground: ShapeableImageView = view.findViewById(R.id.ivBackground)
        val ivProfile: ShapeableImageView = view.findViewById(R.id.ivProfile)
        val tvFullName: TextView = view.findViewById(R.id.tvFullName)
    }

    class StoryCreateHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBackground: ShapeableImageView = view.findViewById(R.id.ivBackground)
    }
}