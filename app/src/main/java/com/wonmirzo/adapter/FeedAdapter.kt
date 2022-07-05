package com.wonmirzo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wonmirzo.R
import com.wonmirzo.activity.MainActivity
import com.wonmirzo.model.Feed
import com.wonmirzo.model.Story

class FeedAdapter(
    private var activity: MainActivity,
    private var items: ArrayList<Feed>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    private val TYPE_ITEM_LINK = 3

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        return when {
            feed.isHeader -> TYPE_ITEM_HEAD
            feed.stories.size > 0 -> TYPE_ITEM_STORY
            position == 2 -> TYPE_ITEM_LINK
            else -> TYPE_ITEM_POST
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_ITEM_HEAD -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_feed_head, parent, false)
                return HeadViewHolder(view)
            }
            TYPE_ITEM_STORY -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_feed_story, parent, false)
                return StoryViewHolder(view)
            }
            TYPE_ITEM_LINK -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_feed_link, parent, false)
                return LinkViewHolder(view)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_feed_post, parent, false)
                return PostViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeadViewHolder) {
            val tvMind = holder.tvMind

            tvMind.setOnClickListener {
                activity.openCreatePost()
            }
        }

        if (holder is StoryViewHolder) {
            val recyclerView = holder.recyclerView
            refreshAdapter(feed.stories, recyclerView)
        }

        if (holder is PostViewHolder) {
            val ivProfile = holder.ivProfile
            val ivPhoto = holder.ivPhoto
            val tvFullName = holder.tvFullName

            Glide.with(holder.itemView.context)
                .load(feed.post!!.profile)
                .into(ivProfile)

            Glide.with(holder.itemView.context)
                .load(feed.post!!.photo)
                .into(ivPhoto)
            tvFullName.text = feed.post!!.fullName
        }

        if (holder is LinkViewHolder) {
            val ivProfile = holder.ivProfile
            val ivPhoto = holder.ivPhoto
            val tvFullName = holder.tvFullName
            val tvLink = holder.tvLink
            val tvImageDescription = holder.tvImageDescription
            val tvImageTitle = holder.tvImageTitle

            Glide.with(holder.itemView.context)
                .load(feed.link!!.profile)
                .into(ivProfile)
            Glide.with(holder.itemView.context)
                .load(feed.link!!.photo)
                .into(ivPhoto)
            tvFullName.text = feed.link!!.fullName
            tvLink.text = feed.link!!.link
            tvImageDescription.text = feed.link!!.description
            tvImageTitle.text = feed.link!!.title
        }
    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(activity, stories)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // viewHolders

    class HeadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMind: TextView = view.findViewById(R.id.tvMind)
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        init {
            val manager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.ivProfile)
        val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
        val tvFullName: TextView = view.findViewById(R.id.tvFullName)
    }

    class LinkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.ivProfile)
        val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
        val tvFullName: TextView = view.findViewById(R.id.tvFullName)
        val tvLink: TextView = view.findViewById(R.id.tvLink)
        val tvImageDescription: TextView = view.findViewById(R.id.tvImageDescription)
        val tvImageTitle: TextView = view.findViewById(R.id.tvImageTitle)
    }
}