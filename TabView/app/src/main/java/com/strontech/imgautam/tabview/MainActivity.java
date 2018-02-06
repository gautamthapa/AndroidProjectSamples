package com.strontech.imgautam.tabview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.myTab);
        tb.setup();

        TabHost.TabSpec tabSpec=tb.newTabSpec("tab 1");// string just indication
        //for your first tab reference
        tabSpec.setIndicator("One tab");
        tabSpec.setContent(R.id.tab1);
        tb.addTab(tabSpec);

        tabSpec=tb.newTabSpec("tab 2");
        tabSpec.setIndicator("Tab two");
        tabSpec.setContent(R.id.tab2);
        tb.addTab(tabSpec);

        tabSpec=tb.newTabSpec("tab 3");
        tabSpec.setIndicator("Tab Three");
        tabSpec.setContent(R.id.tab3);
        tb.addTab(tabSpec);

        tabSpec=tb.newTabSpec("tab 4");
        tabSpec.setIndicator("Tab Four");
        tabSpec.setContent(R.id.tab4);
        tb.addTab(tabSpec);
    }
}
