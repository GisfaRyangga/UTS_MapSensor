package com.example.sensormap;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;

public class SettingFragment extends Fragment {

    private GoogleMap mMap;
    private MapsFragment mapsFragment = new MapsFragment();

    Button actionlang;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        actionlang = view.findViewById(R.id.action_language);

        // Button untuk mengganti bahasa
        actionlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(languageIntent);
            }
        });

        // Inflate the layout for this fragment
        return view;

    }


}