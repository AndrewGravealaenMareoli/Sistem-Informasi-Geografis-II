package com.example.mymaps;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(-0.946799, 119.891251);
        LatLng bandara = new LatLng(-0.918597, 119.906450);
        mMap.addMarker(new MarkerOptions().position(home).title("My Home").
                snippet("Andrew Mareoli").icon(BitmapFromVector(getApplicationContext(),R.drawable.start)));
        mMap.addMarker(new MarkerOptions().position(bandara).title("Bandar Udara Mutiara SIS Al-Jufrie").
                snippet("Andrew Mareoli").icon(BitmapFromVector(getApplicationContext(),R.drawable.finish)));
        mMap.addPolyline(new PolylineOptions().add(
                home,
                /** BTN **/
                new LatLng(-0.946799, 119.891251),
                new LatLng(-0.946498, 119.891258),
                new LatLng(-0.946193, 119.891285),
                new LatLng(-0.945519, 119.891339),
                new LatLng(-0.942895, 119.891543),
                /** Jl. tara**/
                new LatLng(-0.942467, 119.891544),
                new LatLng(-0.942470, 119.891622),
                new LatLng(-0.942545, 119.892346),
                new LatLng(-0.942564, 119.892630),
                new LatLng(-0.942577, 119.893641),
                new LatLng(-0.942577, 119.893719),
                /** Jl. jalan kelapa gading **/
                new LatLng(-0.942581, 119.894673),
                new LatLng(-0.942085, 119.894711),
                new LatLng(-0.941091, 119.894722),
                new LatLng(-0.940946, 119.894730),
                new LatLng(-0.940115, 119.894727),
                new LatLng(-0.939119, 119.894759),
                /** jalan karanjalemba **/
                new LatLng(-0.938379, 119.894907),
                new LatLng(-0.938661, 119.895376),
                new LatLng(-0.939020, 119.896036),
                new LatLng(-0.939391, 119.896666),
                new LatLng(-0.939669, 119.897172),
                new LatLng(-0.940970, 119.899485),
                new LatLng(-0.941926, 119.901173),
                /** jalan DewoSartika **/
                new LatLng(-0.942162, 119.901618),
                new LatLng(-0.941943, 119.901658),
                new LatLng(-0.940208, 119.901317),
                new LatLng(-0.937784, 119.900382),
                new LatLng(-0.936406, 119.899719),
                new LatLng(-0.933161, 119.898442),
                new LatLng(-0.929980, 119.897079),
                new LatLng(-0.927368, 119.896058),
                new LatLng(-0.924800, 119.895169),
                new LatLng(-0.924286, 119.895085),
                new LatLng(-0.924203, 119.895176),
                new LatLng(-0.921430, 119.893886),
                new LatLng(-0.920017, 119.893281),
                new LatLng(-0.918791, 119.892640),
                /** jalan Dr.Abdurahman saleh **/
                new LatLng(-0.918630, 119.893828),
                new LatLng(-0.918846, 119.894632),
                new LatLng(-0.919114, 119.895609),
                new LatLng(-0.919152, 119.897685),
                new LatLng(-0.919063, 119.901748),
                new LatLng(-0.918977, 119.903349),
                new LatLng(-0.918969, 119.903668),
                new LatLng(-0.918473, 119.904687),
                new LatLng(-0.917899, 119.905995),
                new LatLng(-0.918649, 119.906338),
                bandara
                ).width(20)
                        .color(Color.rgb(0, 129, 227))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.5f));
    }

    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());

        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        vectorDrawable.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
