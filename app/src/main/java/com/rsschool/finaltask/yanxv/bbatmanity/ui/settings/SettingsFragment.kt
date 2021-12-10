package com.rsschool.finaltask.yanxv.bbatmanity.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.rsschool.finaltask.yanxv.bbatmanity.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}