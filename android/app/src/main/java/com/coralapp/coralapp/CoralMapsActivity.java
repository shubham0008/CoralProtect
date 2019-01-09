package com.coralapp.coralapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CoralMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coral_maps);
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
        LatLng markerStarter = new LatLng(12.33, 92.66);
        LatLng markerWandur = new LatLng(11.48333, 92.58333);
        LatLng markerMayabandar = new LatLng(12.88333, 92.98333);
        LatLng markerNorthReef = new LatLng(13.11667, 92.71667);

        final Circle circle1 = mMap.addCircle(new CircleOptions()
                .center(new LatLng(11.48333, 92.58333))
                .radius(10000)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0))
                .clickable(true));

        Circle circle2 = mMap.addCircle(new CircleOptions()
                .center(new LatLng(12.88333, 92.98333))
                .radius(10000)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0))
                .clickable(true));

        Circle circle3 = mMap.addCircle(new CircleOptions()
                .center(new LatLng(13.11667, 92.71667))
                .radius(10000)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0))
                .clickable(true));

        mMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {
            @Override
            public void onCircleClick(Circle circle) {
                Double currLat = circle.getCenter().latitude;
                Double currLong = circle.getCenter().longitude;
                //Toast.makeText(CoralMapsActivity.this, "" + currLat + currLong, Toast.LENGTH_SHORT).show();
                openDialog(circle);
            }
        });
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                Toast.makeText(CoralMapsActivity.this, "IM working Bro", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        mMap.addMarker(new MarkerOptions().position(markerWandur).title("Marker in Wandur"));
        mMap.addMarker(new MarkerOptions().position(markerMayabandar).title("Marker in Mayabandar"));
        mMap.addMarker(new MarkerOptions().position(markerNorthReef).title("Marker in NorthReef"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(markerStarter));
        CameraPosition target = CameraPosition.builder().target(markerStarter).zoom((float) 7.5).bearing(82).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    public void openDialog(final Circle circle) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Set Custom Title
        TextView title = new TextView(this);
        // Title Properties
        title.setText("Do you want to select this area?");
        title.setPadding(10, 30, 10, 20);   // Set Position
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);
        alertDialog.setCustomTitle(title);

        // Set Message
        TextView msg = new TextView(this);
        // Message Properties
        msg.setText("Press OK to freeze this region to dive!");
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        alertDialog.setView(msg);

        // Set Button
        // you can more buttons
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
                Double currLat = circle.getCenter().latitude;
                Double currLong = circle.getCenter().longitude;
                circle.setFillColor(Color.argb(128, 0, 255, 0));
                Toast.makeText(CoralMapsActivity.this, "Co-ords:" + currLat + " and "+ currLong, Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
                Toast.makeText(CoralMapsActivity.this, "You rejected the job!", Toast.LENGTH_SHORT).show();
                circle.setFillColor(Color.argb(128, 255, 0, 0));
            }
        });

        new Dialog(getApplicationContext());
        alertDialog.show();

        // Set Properties for OK Button
        final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        neutralBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        okBT.setPadding(50, 10, 10, 10);   // Set Position
        okBT.setTextColor(Color.BLUE);
        okBT.setLayoutParams(neutralBtnLP);

        final Button cancelBT = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams negBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        negBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        cancelBT.setTextColor(Color.RED);
        cancelBT.setLayoutParams(negBtnLP);
    }

}


