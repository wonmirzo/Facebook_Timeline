package com.wonmirzo.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.R
import com.wonmirzo.adapter.FeedAdapter
import com.wonmirzo.model.Feed
import com.wonmirzo.model.Link
import com.wonmirzo.model.Post
import com.wonmirzo.model.Story

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList()
        stories.add(Story("https://images.unsplash.com/photo-1617870952348-7524edfb61b7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=802"))
        stories.add(Story("https://media-exp1.licdn.com/dms/image/C5603AQFWW4T5_qMk_A/profile-displayphoto-shrink_800_800/0/1632716993952?e=1651104000&v=beta&t=BLzb63BmAjGMEyyfEHGPwV8KVpbtkQu9cuvN63mAv_E",
            "Xurshidbek Kurbanov"))
        stories.add(Story("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
            "Ayo Ogunseinde"))

        val feeds: ArrayList<Feed> = ArrayList()
        // head
        feeds.add(Feed())
        //story
        feeds.add(Feed(stories))
        //post
        feeds.add(
            Feed(
                Link(
                    "https://media-exp1.licdn.com/dms/image/C5603AQFWW4T5_qMk_A/profile-displayphoto-shrink_800_800/0/1632716993952?e=1651104000&v=beta&t=BLzb63BmAjGMEyyfEHGPwV8KVpbtkQu9cuvN63mAv_E",
                    "Xurshidbek Qurbanov",
                    "https://miro.medium.com/max/875/1*hPT8Tgn3oTLLUYKu3URr7Q.png",
                    "Do'stlar davrasida",
                    "Something there",
                    "https://kurbanovxurshid.medium.com/android-java-kotlin-course-plan-68d8d97f75e5"
                )
            )
        )
        feeds.add(Feed(Post("https://images.unsplash.com/photo-1617870952348-7524edfb61b7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=802",
            "Malte Helmhold",
        "https://images.unsplash.com/photo-1645363710095-a58f4828720b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=411&q=80")))
        feeds.add(Feed(Post("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
            "Ayo Ogunseinde",
            "https://images.unsplash.com/photo-1644963300407-02c7644d9963?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80")))
        feeds.add(Feed(Post("https://images.unsplash.com/photo-1581382575275-97901c2635b7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
            "Mitchell Luo",
            "https://images.unsplash.com/photo-1488161628813-04466f872be2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80")))
        feeds.add(Feed(Post("https://images.unsplash.com/photo-1510832198440-a52376950479?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1167&q=80",
            "Pietra Schwarzlez",
            "https://images.unsplash.com/photo-1495395226200-8fbf6b720b8c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=397&q=80")))
        feeds.add(Feed(Post("https://images.unsplash.com/photo-1554126807-6b10f6f6692a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
            "JD Chow",
            "https://images.unsplash.com/photo-1462926703708-44ab9e271d97?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80")))

        return feeds
    }

    fun openCreatePost() {
        Intent(this, CreatePostActivity::class.java).also {
            startActivity(it)
        }
    }
}