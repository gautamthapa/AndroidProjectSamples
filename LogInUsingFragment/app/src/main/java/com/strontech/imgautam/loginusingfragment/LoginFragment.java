package com.strontech.imgautam.loginusingfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    EditText edt1, edt2, edt3;
    Button btn1, btn2;
    Spinner spn;
    RadioButton rb1, rb2;
    String name, email, number, gender, course_name;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        edt1=v.findViewById(R.id.editText1);
        edt2=v.findViewById(R.id.editText2);
        edt3=v.findViewById(R.id.editText3);
        btn1=v.findViewById(R.id.button1);
       // btn2=v.findViewById(R.id.button2);
        spn=v.findViewById(R.id.spinner1);
        rb1=v.findViewById(R.id.radioBtn1);
        rb2=v.findViewById(R.id.radioBtn2);

        String[] data = getResources().getStringArray(R.array.course_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        spn.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=edt1.getText().toString();
                email=edt2.getText().toString();
                number=edt3.getText().toString();
                course_name= spn.getSelectedItem().toString();

                if (name.equals("")){
                    edt1.setError("Enter name");
                }else if (email.equals("")){
                    edt2.setError("Enter email");
                }else if(number.equals("")){
                    edt3.setError("Enter number");
                }else if (!(rb1.isChecked()) && !(rb2.isChecked())){
                    Toast.makeText(getActivity(), "Please select gender", Toast.LENGTH_SHORT).show();
                }else if (spn.getSelectedItemPosition()==0){
                    Toast.makeText(getActivity(), "Please select course", Toast.LENGTH_SHORT).show();
                }else{

                    if (rb1.isChecked()){
                        gender="Mr.";
                    }else{
                        gender="Mis.";
                    }

                    // Transfer data
                    SecondFragment sf=new SecondFragment();
                    Bundle bundle=new Bundle();             // Store data on bundle object
                    bundle.putString("user_name",name);
                    bundle.putString("email_id",email);
                    bundle.putString("mob_number",number);
                    bundle.putString("selected_gender",gender);
                    bundle.putString("course",course_name);
                    sf.setArguments(bundle);

                    // Start new fragment
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout, sf);
                    ft.addToBackStack("Login Fragment");
                    ft.commit();

                }
            }
        });

        return v;
    }
    @Override
    public void onStop() {
        super.onStop();
       edt1.setText("");
       edt2.setText("");
       edt3.setText("");
        if (spn.getSelectedItemPosition() !=0){
            spn.setSelection(0);
        }
        if (rb1.isChecked() || rb2.isChecked()){
            rb1.setChecked(false);
            rb2.setChecked(false);
        }

    }

}
