package com.bottomless.letsdoit

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.chat_element.view.*

class ChatElement(var ctx: Context, var ava: String, var message: String ):LinearLayout(ctx){
    val conteiner = LinearLayout(ctx)
    init {
       conteiner.orientation = LinearLayout.HORIZONTAL
        val avatar = TextView(ctx)
        avatar.text = ava
        val text = TextView(ctx)
        text.text = message

        conteiner.addView(avatar)
        conteiner.addView(text)
    }
}