package com.mintic.ticapp

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class FragmentosPreferencias: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, clave: String?) {
        setPreferencesFromResource(R.xml.preferencias_app, clave)
    }
}