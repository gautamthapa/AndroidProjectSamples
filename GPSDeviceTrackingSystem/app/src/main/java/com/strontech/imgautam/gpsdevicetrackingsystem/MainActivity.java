package com.strontech.imgautam.gpsdevicetrackingsystem;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  TextView textView1;
  LocationManager locationManager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView1 = findViewById(R.id.textView);

    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

    //runtime permission
    if (ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION) !=
        PackageManager.PERMISSION_GRANTED) {

      ActivityCompat.requestPermissions(this,
          new String[]{permission.ACCESS_COARSE_LOCATION, permission.ACCESS_FINE_LOCATION}, 0);

      return;
    }

    //Runtime permission
    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling

      ActivityCompat
          .requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
      return;
    }

    //Runtime permission
    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling

      ActivityCompat
          .requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
      return;
    }

    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
        0,//take time
        0, // how many distance cover
        new LocationListener() {
          @Override
          public void onLocationChanged(Location location) {

            double lat = location.getLatitude();
            double lon = location.getLongitude();
            textView1.setText("Latitude  " + lat + "\n Longitude  " + lon);

            Geocoder geocoder = new Geocoder(MainActivity.this);

            try {

              List<Address> adr=geocoder.getFromLocation(lat,lon,1);
              String country=adr.get(0).getCountryName();
              String locality=adr.get(0).getLocality();
              String postalCode=adr.get(0).getPostalCode();
              String addressLine =adr.get(0).getAddressLine(0);

              textView1.append("\n\n "+country+" , "+locality+" , "+
              postalCode+" , "+addressLine);
            } catch (Exception e) {

            }
          }

          @Override
          public void onStatusChanged(String provider, int status, Bundle extras) {

          }

          @Override
          public void onProviderEnabled(String provider) {

          }

          @Override
          public void onProviderDisabled(String provider) {

          }
        });
  }
}
