package com.project.studysmarter.studysmarter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_layout);
   }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        PreferenceKeys preferenceKeys = new PreferenceKeys(getResources());
        if(key.equals(preferenceKeys.no_disturb_mode_pref_key)){
            SharedPreferences themePreferences = getActivity().getSharedPreferences(MainActivity.THEME_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor themeEditor = themePreferences.edit();
            themeEditor.putBoolean(MainActivity.RECREATE_ACTIVITY, true);

            CheckBoxPreference checkBoxPreference = (CheckBoxPreference)findPreference(preferenceKeys.no_disturb_mode_pref_key);
            if(checkBoxPreference.isChecked()){

                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                myIntent.putExtra(preferenceKeys.no_disturb_mode_pref_key, true); //Optional parameters
                getActivity().startActivity(myIntent);
            }
            else{
                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                myIntent.putExtra(preferenceKeys.no_disturb_mode_pref_key, false); //Optional parameters
                getActivity().startActivity(myIntent);
            }

            getActivity().recreate();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
