package com.android.priyanka.googlemapandroid;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity4 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    boolean mapReady=false;

    MarkerOptions rentonMarker;
    LatLng renton = new LatLng(47.489805, -122.120502);

    MarkerOptions kirklandMarker;
    LatLng kirkland = new LatLng(47.7301986, -122.1768858);

    MarkerOptions everettMarker;
    LatLng everett = new LatLng(47.978748,-122.202001);



    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);

        Toolbar toolbar  = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rentonMarker = new MarkerOptions()
                .position(renton)
                .title("Renton")
                .icon ( bitmapDescriptorFromVector ( this, R.drawable.ic_marker ));

        kirklandMarker = new MarkerOptions()
                .position(kirkland)
                .title("Kirkland")
                .icon ( bitmapDescriptorFromVector ( this, R.drawable.ic_marker ));

        everettMarker = new MarkerOptions()
                .position(everett)
                .title("Everett")
                .icon ( bitmapDescriptorFromVector ( this, R.drawable.ic_marker ));


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
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
        //MapsInitializer.initialize(getApplicationContext());
        mapReady=true;
        mMap = googleMap;

        mMap.addMarker(rentonMarker);
        mMap.addMarker(kirklandMarker);
        mMap.addMarker(everettMarker);

        flyTo(SEATTLE);

        mMap.addPolyline (
                new PolylineOptions().geodesic ( true )
                        .add ( renton )
                        .add ( kirkland )
                        .add ( everett ));


    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {

        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        vectorDrawable.setBounds(10, 5, vectorDrawable.getIntrinsicWidth() + 10,
                vectorDrawable.getIntrinsicHeight() + 5);
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getMinimumWidth (), vectorDrawable.getMinimumHeight (),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    private void flyTo(CameraPosition target)
    {
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public Resources getResources() {
        return super.getResources();
    }
}
