package com.example.emoji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import com.vanniktech.emoji.EmojiPopup
import com.vanniktech.emoji.EmojiTextView

class MainActivity : AppCompatActivity() {

    private lateinit var etMessage: EditText
    private lateinit var btnEmoji: ImageButton
    private lateinit var btnSend: ImageButton
    private lateinit var linearlayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMessage = findViewById(R.id.etMessage)
        btnEmoji = findViewById(R.id.btnEmoji)
        btnSend = findViewById(R.id.btnSend)
        linearlayout = findViewById(R.id.linearLayout)

        val view = findViewById<View>(R.id.root)
        val emoji = EmojiPopup.Builder.fromRootView(view)
            .build(etMessage)

        btnEmoji.setOnClickListener {
            emoji.toggle()
        }

        btnSend.setOnClickListener {
            inflateEmoji(it)
        }

    }

    private fun inflateEmoji(view: View){
        val emojiTextView = LayoutInflater.from(view.context)
            .inflate(R.layout.emoji_textview, linearlayout, false) as EmojiTextView

        emojiTextView.text = etMessage.text.toString()
        linearlayout.addView(emojiTextView)
        etMessage.text.clear()
    }

}
