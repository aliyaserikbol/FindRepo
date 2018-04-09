package com.example.aliyaserikbol.findrepo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setTitle(R.string.title)
        setContentView(R.layout.activity_main)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        val userRepoEditText = findViewById<EditText>(R.id.userRepoEditText)

        val button = findViewById<Button>(R.id.searchButton)
        button.setOnClickListener {
            val intent = Intent(this, SearchResultActivity::class.java)
            intent.putExtra("searchTerm", searchEditText.text.toString())
            startActivity(intent)
        }

        val viewRepoButton = findViewById<Button>(R.id.userRepoButton)
        viewRepoButton.setOnClickListener {
            val intent = Intent(this, SearchResultActivity::class.java)
            intent.putExtra("username", userRepoEditText.text.toString())
            startActivity(intent)
        }
    }
}
