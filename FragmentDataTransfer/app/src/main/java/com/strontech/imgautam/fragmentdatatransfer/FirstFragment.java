package com.strontech.imgautam.fragmentdatatransfer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    Button btn;
    EditText edt1;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_first, container, false);

         btn=v.findViewById(R.id.button);
        edt1=v.findViewById(R.id.editText1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nme=edt1.getText().toString();
                SecondFragment obj=new SecondFragment();
if (nme.equals("")){
    edt1.setError("enter name");
}else {

    Bundle b=new Bundle();
    b.putString("data",nme);
    obj.setArguments(b);

    FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.min_layout, obj);
    ft.commit();

}
        }
        });
        return v;
    }

}
