package com.mintic.ticapp.ui.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.mintic.ticapp.R

class FragmentosPreferencias: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, clave: String?) {
        setPreferencesFromResource(R.xml.preferencias_app, clave)
    }
}