package com.example.sensormap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            LatLng mrtbk_kamila = new LatLng( -7.749413558773544, 110.39878906934368);
            mMap.addMarker(new MarkerOptions().position(mrtbk_kamila).title("Marker di Martabak Kamila"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mrtbk_kamila, 15));

            LatLng mrtbk_mrbs = new LatLng( -7.751585309757499, 110.40033053625677);
            mMap.addMarker(new MarkerOptions().position(mrtbk_mrbs).title("Marker di Martabak Marabasa"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrtbk_mrbs));

            LatLng mrtbk_btg = new LatLng( -7.754496870417889, 110.39693449196383);
            mMap.addMarker(new MarkerOptions().position(mrtbk_btg).title("Marker di Martabak Bintang"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrtbk_btg));

            LatLng mrtbk_lbs = new LatLng( -7.75602423844568, 110.39611558766624);
            mMap.addMarker(new MarkerOptions().position(mrtbk_lbs).title("Marker di Martabak LBS Tegal Bang Roni"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrtbk_lbs));

            LatLng mrtbk_csbl = new LatLng( -7.7472206877445196, 110.38688008959456);
            mMap.addMarker(new MarkerOptions().position(mrtbk_csbl).title("Marker di Martabak Casablanca Jalan Kaliurang"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrtbk_csbl));

            LatLng mrtbk_arndr = new LatLng( -7.7471636159663895, 110.38766747327428);
            mMap.addMarker(new MarkerOptions().position(mrtbk_arndr).title("Marker di Martabak Arindra Kaliurang 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrtbk_arndr));

            // My location
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
            else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            mMap.setMyLocationEnabled(true);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}