package com.strontech.imgautam.useofsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

  TextView textView;

  SensorManager sensorManager;
  Sensor sensor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = findViewById(R.id.textView);

    sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);


   /*

   //it is used to get sensor list...

    List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);

    for (Sensor sen:list)
    {
      textView.append("\n"+sen.getName());
    }*/

  }

  @Override
  public void onSensorChanged(SensorEvent event) {

    textView.setText("X:- "+event.values[0]+
    "Y:- "+ event.values[1]+
    "Z:- "+ event.values[2]);
  }


  //to calculate the sensor height
  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {

  }
}
