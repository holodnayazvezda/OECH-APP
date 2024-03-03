package com.example.oechappfinal.data

import android.content.Context

abstract class ApplicationContext {
    companion object {
        private lateinit var context: Context

        fun setContext(con: Context) {
            context = con
        }

        fun getContext(): Context {
            return context
        }
    }
}