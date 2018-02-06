package com.strontech.imgautam.webview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ArrayAdapter<String> adapter;
    AutoCompleteTextView act;
    Button btn;
    String data;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        act=v.findViewById(R.id.autoCompleteTextView1);
        btn=v.findViewById(R.id.button1);

        adapter=new ArrayAdapter<String>(getActivity(), R.layout.my_history_layout);
        act.setAdapter(adapter);
        act.setThreshold(1);

        adapter.add(""+act.getText().toString());
        data=act.getText().toString();
      /* Bundle b = getArguments();
        //string = b.getString("dt");
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.setWebViewClient(new MyWebViewClient());
        if (b!=null){
            web.loadUrl(""+b.getString("dt"));
        }*/
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              adapter.add(""+act.getText().toString());
              data=act.getText().toString();
              if (data.equals("")){
                  act.setError("Enter URL");
              }else {

                  Bundle b=new Bundle();
                  SeondFragment seondFragment=new SeondFragment();
                  b.putString("dt",data);
                  seondFragment.setArguments(b);
                  FragmentManager fm=getFragmentManager();
                  FragmentTransaction ft=fm.beginTransaction();
                  ft.replace(R.id.main_layout, seondFragment);
                  ft.addToBackStack("");
                  ft.commit();
              }
          }
      });
        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        act.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
