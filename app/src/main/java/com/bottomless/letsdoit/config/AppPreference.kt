package com.bottomless.letsdoit.config

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by someone on 04.03.17.
 */
class AppPreference(val context: Context) {

    private val USER_NAME = "user name"
    private val USERS_CHATS = "users chats"


    private val prefs: SharedPreferences
    init {
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }
    fun saveUserName(name: String) = prefs.edit().putString(USER_NAME, name).apply()
    fun getUserName() = prefs.getString(USER_NAME, null)






}