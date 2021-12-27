package com.example.tablayoutandviewpagerexample

import android.app.Application
import android.content.Context
import com.example.tablayoutandviewpagerexample.ButtonView.Locale.LocaleUtil
import com.example.tablayoutandviewpagerexample.ButtonView.Locale.Storage

class MyApp: Application() {
    val storage : Storage by lazy {
        Storage(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(
            LocaleUtil.getLocalizedContext(
                base,
                Storage(base).getPreferredLocale()
            )
        )
    }
}