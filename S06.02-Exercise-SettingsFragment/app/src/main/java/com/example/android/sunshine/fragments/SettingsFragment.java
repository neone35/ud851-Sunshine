package com.example.android.sunshine.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;

import com.example.android.sunshine.R;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by aarta on 2018-01-13.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    int preferenceFragmentId = R.xml.pref_fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(preferenceFragmentId);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int preferenceCount = preferenceScreen.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference p = preferenceScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)) {
                setPreferenceSummary(p);
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference changedPreference = findPreference(key);
        setPreferenceSummary(changedPreference);
    }

    private void setPreferenceSummary(Preference p) {
        if (p instanceof ListPreference) {
            ListPreference lp = (ListPreference) p;
            setListPreferenceSummary(lp);
        } else if (p instanceof EditTextPreference) {
            EditTextPreference ep = (EditTextPreference) p;
            setEditTextPreferenceSummary(ep);
        }
    }

    private void setListPreferenceSummary(ListPreference lp) {
        String value = lp.getValue();
        int listEntryValueIndex = lp.findIndexOfValue(value);
        lp.setSummary(lp.getEntries()[listEntryValueIndex]);
    }

    private void setEditTextPreferenceSummary(EditTextPreference ep) {
        String value = ep.getText();
        ep.setSummary(value);
    }

    @Override
    public void onStop() {
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onStop();
    }
}
