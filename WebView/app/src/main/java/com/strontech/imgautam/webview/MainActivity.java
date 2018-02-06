package com.strontech.imgautam.webview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_layout, new BlankFragment());
        ft.commit();

        /*txt = findViewById(R.id.autoCompleteTextView);
        btn = findViewById(R.id.button);
        editText=findViewById(R.id.editText1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString().trim();
                if (s.equals("")) {
                    editText.setError("enter url");
                } else {
                    Bundle b = new Bundle();
                    b.putString("dt", s);
                    BlankFragment blankFragment = new BlankFragment();
                    blankFragment.setArguments(b);
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_layout, new BlankFragment());
                    ft.addToBackStack("jj");
                    ft.commit();
                }
            }
        });

        // web = findViewById(R.id.webView1);

      /*  WebSettings ws=web.getSettings();
        ws.setJavaScriptEnabled(true);
web.setWebViewClient(new MyWebViewClient());
        web.loadUrl("http://www.ducatindia.com");

    }
    public class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;
        }*/
    }
}
