package com.example.macbookair.gps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnGetloc;
    TextView textView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetloc= (Button)findViewById(R.id.btnGetLoc);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        btnGetloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null) {
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(),"Lat: " + lat + "\n Lon: " + lon + textView, Toast.LENGTH_LONG).show();

                }

            }
        });

    }

}
