package com.wonmirzo.activity

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.wonmirzo.R

class CreatePostActivity : AppCompatActivity() {
    private lateinit var etMind: EditText
    private lateinit var llContent: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_create_post)
        initViews()
    }

    private fun initViews() {
        etMind = findViewById(R.id.etMind)
        llContent = findViewById(R.id.llContent)
        val ivEndTask: ImageView = findViewById(R.id.ivEndTask)


        ivEndTask.setOnClickListener {
            finish()
        }

    }

    @SuppressLint("StaticFieldLeak")
    inner class Content : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg p0: Unit?) {
            
        }
    }
}