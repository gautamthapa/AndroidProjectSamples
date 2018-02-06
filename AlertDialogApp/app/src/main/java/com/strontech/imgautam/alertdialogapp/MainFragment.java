package com.strontech.imgautam.alertdialogapp;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    RadioButton rb1, rb2;
    TextInputEditText edt1, edt2, edt3;
    Spinner spn;
    Button btn;
    String[] data;
    String name, email, number, courseName, gender;
    AlertDialog.Builder alertDialog;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        spn = v.findViewById(R.id.spinner1);
        rb1 = v.findViewById(R.id.radioButton1);
        rb2 = v.findViewById(R.id.radioButton2);
        btn = v.findViewById(R.id.button1);
        edt1 = v.findViewById(R.id.editText1);
        edt2 = v.findViewById(R.id.editText2);
        edt3 = v.findViewById(R.id.editText3);

        data = getResources().getStringArray(R.array.course_data);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        spn.setAdapter(adapter);


        final FirstFragment firstFragment = new FirstFragment();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = edt1.getText().toString().trim();
                email = edt2.getText().toString().trim();
                number = edt3.getText().toString().trim();
                courseName = spn.getSelectedItem().toString();

                if (rb1.isChecked()) {
                    gender = "Mr.";
                } else if (rb2.isChecked()) {
                    gender = "Miss";
                }

                if (name.equals("")) {
                    edt1.setError("Enter name");
                } else if (email.equals("")) {
                    edt2.setError("Enter email");
                } else if (number.equals("")) {
                    edt3.setError("Enter number");
                } else if (spn.getSelectedItemPosition() == 0) {
                    Toast.makeText(getActivity(), "Please select course", Toast.LENGTH_SHORT).show();
                } else if (!(rb1.isChecked()) && !(rb2.isChecked())) {
                    Toast.makeText(getActivity(), "Please select gender", Toast.LENGTH_SHORT).show();
                } else {
                    alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setTitle("Confirmation");
                    alertDialog.setMessage("Are you want to submit !");

                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Bundle b = new Bundle();
                            b.putString("key_name", name);
                            b.putString("key_email", email);
                            b.putString("key_number", number);
                            b.putString("key_course", courseName);
                            b.putString("key_gender", gender);
                            firstFragment.setArguments(b);

                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.main_layout, firstFragment);
                            ft.addToBackStack("MainFragment");
                            ft.commit();

                            Toast.makeText(getActivity(), "info successfully submitted", Toast.LENGTH_SHORT).show();

                            edt1.setText("");
                            edt2.setText("");
                            edt3.setText("");
                            spn.setSelection(0);
                            if (rb1.isChecked() || rb2.isChecked()) {
                                rb1.setChecked(false);
                                rb2.setChecked(false);
                            }


                        }
                    });

                    alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            edt1.setText("");
                            edt2.setText("");
                            edt3.setText("");
                            spn.setSelection(0);
                            if (rb1.isChecked() || rb2.isChecked()) {
                                rb1.setChecked(false);
                                rb2.setChecked(false);
                            }
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            }
        });

        return v;
    }

}
