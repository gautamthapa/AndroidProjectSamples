package com.strontech.imgautam.bluetoothwifi;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

  Switch s1, s2;

  BluetoothAdapter bluetoothAdapter;
  WifiManager wifiManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    s1 = findViewById(R.id.switch1);
    s2 = findViewById(R.id.switch2);

    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);


    s1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked==true){
          bluetoothAdapter.enable();

        }else {
          bluetoothAdapter.disable();
        }
      }
    });

    s2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked==true){
          wifiManager.setWifiEnabled(true);
        }else {
          wifiManager.setWifiEnabled(false);
        }
      }
    });
  }
}
