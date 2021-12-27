package com.example.tablayoutandviewpagerexample.ButtonView

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import androidx.core.os.ConfigurationCompat
import com.example.tablayoutandviewpagerexample.ButtonView.Locale.LocaleUtil
import com.example.tablayoutandviewpagerexample.ButtonView.Locale.Storage
import com.example.tablayoutandviewpagerexample.MyApp
import com.example.tablayoutandviewpagerexample.R
import kotlinx.android.synthetic.main.fragment_third.*
import java.util.*

class ThirdFragment : Fragment() {
    private lateinit var firstLocaleCode: String
    private lateinit var secondLocaleCode: String
    private lateinit var currentSystemLocaleCode: String
    val storage : Storage by lazy {
        (activity?.getApplication() as MyApp).storage
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentSystemLocaleCode = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0).language
        if(storage.getPreferredLocale() == LocaleUtil.OPTION_PHONE_LANGUAGE){
            if(currentSystemLocaleCode in LocaleUtil.supportedLocales){
                tvAppLocale.text = "English"
            } else {
                //current system language is neither English nor my second language (for me Bangla)
                tvAppLocale.text = "English"
            }
        } else {
            if(currentSystemLocaleCode == storage.getPreferredLocale()){
                tvAppLocale.text = "English"
            } else {
                tvAppLocale.text = Locale(storage.getPreferredLocale()).displayLanguage
            }
        }
        firstLocaleCode = if(currentSystemLocaleCode in LocaleUtil.supportedLocales){
            currentSystemLocaleCode
        } else {
            if(storage.getPreferredLocale() == LocaleUtil.OPTION_PHONE_LANGUAGE){
                //current system language is neither English nor my second language (for me Bangla)
                "en"
            } else {
                storage.getPreferredLocale()
            }
        }
        secondLocaleCode = getSecondLanguageCode()
        initRadioButtonUI()
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.op1 -> {
                    updateAppLocale(LocaleUtil.OPTION_PHONE_LANGUAGE)
                    activity?.let { recreate(it) }
                }
                R.id.op2 -> {
                    updateAppLocale(secondLocaleCode)
                    activity?.let { recreate(it) }
                }
            }
        }
    }

    private fun getSecondLanguageCode(): String {
        return if(firstLocaleCode == "en") "ar" else "en"
    }

    private fun initRadioButtonUI() {
        if(currentSystemLocaleCode in LocaleUtil.supportedLocales){
            op1.text = getLanguageNameByCode(firstLocaleCode)
        } else {
            op1.text = getLanguageNameByCode(firstLocaleCode)
        }
        op2.text = getLanguageNameByCode(secondLocaleCode)
        if(storage.getPreferredLocale() == secondLocaleCode) op2.isChecked = true
        else op1.isChecked = true
    }

    private fun getLanguageNameByCode(code: String) : String{
        val tempLocale = Locale(code)
        return tempLocale.getDisplayLanguage(tempLocale)
    }

    private fun updateAppLocale(locale: String) {
        storage.setPreferredLocale(locale)
        activity?.applicationContext?.let { LocaleUtil.applyLocalizedContext(it, locale) }
    }
}