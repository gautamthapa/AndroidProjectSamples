package com.strontech.imgautam.patanjalistor;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MerchSignupFragment extends Fragment {


    TextInputEditText edt1_mer_sid,edt2_mer_name,edt3_mer_mob,edt4_mer_em,edt5_mer_add;
    Button btn_sub_mer;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    String mUsername, mPas;
    public String FILE="myFile";

    String mShop_id, mName, mMob, mEmail, mAdd;
    public MerchSignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_merch_signup, container, false);

        edt1_mer_sid=v.findViewById(R.id.edt_shopid_mer);
        edt2_mer_name=v.findViewById(R.id.edt_username_mer);
        edt3_mer_mob=   v.findViewById(R.id.edt_mob_mer);
        edt4_mer_em=v.findViewById(R.id.edt_email_mer);
        edt5_mer_add=v.findViewById(R.id.edt_address_mer);
        btn_sub_mer=v.findViewById(R.id.btn_sum_mer);

        pref=this.getActivity().getSharedPreferences(FILE, Context.MODE_PRIVATE);
        editor=pref.edit();

        btn_sub_mer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShop_id=edt1_mer_sid.getText().toString().trim();
                mName=edt2_mer_name.getText().toString().trim();
                mMob=edt3_mer_mob.getText().toString().trim();
                mEmail=edt4_mer_em.getText().toString().trim();
                mAdd=edt5_mer_add.getText().toString().trim();

                if (mShop_id.equals("")){
                    edt1_mer_sid.setError("Enter shop id");
                }else if(mName.equals("")){
                    edt2_mer_name.setError("Enter name");
                }else if(mMob.equals("")){
                    edt3_mer_mob.setError("Enter Mobile number");
                }else if(mEmail.equals("")){
                    edt4_mer_em.setError("Enter email address");
                }else if(mAdd.equals("")){
                    edt5_mer_add.setError("enter Shop address");
                }else{
                    editor.putString("key_mUsername",mEmail);
                    editor.putString("key_mPass",mMob);
                    editor.commit();

                    Toast.makeText(getActivity(), "Successfully registered", Toast.LENGTH_SHORT).show();

                }
            }
        });


        return v;

    }

}
