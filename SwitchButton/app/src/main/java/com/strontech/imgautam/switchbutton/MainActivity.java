package com.strontech.imgautam.switchbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt, txt2;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.textView);
        txt2=findViewById(R.id.textView2);
        aSwitch=findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txt.setVisibility(View.INVISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                }else{
                    txt.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
