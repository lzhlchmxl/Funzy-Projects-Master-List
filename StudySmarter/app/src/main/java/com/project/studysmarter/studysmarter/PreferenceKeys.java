package com.project.studysmarter.studysmarter;

import android.content.res.Resources;

/**
 * Created by Bill on 3/30/18.
 */
public class PreferenceKeys {
    final String no_disturb_mode_pref_key;

    public PreferenceKeys(Resources resources){
        no_disturb_mode_pref_key = resources.getString(R.string.no_disturb_mode_pref_key);
    }
}
