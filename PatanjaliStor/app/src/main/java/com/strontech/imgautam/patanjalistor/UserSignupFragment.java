package com.strontech.imgautam.patanjalistor;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserSignupFragment extends Fragment {


    TextInputEditText edt1_user, edt2_user,edt3_user,edt4_user;
    Button btn_user_sub;

    UserInfoDatabase database;

    public UserSignupFragment() {
        // Required empty public constructor
    }

    UserInfo userInfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_user_signup, container, false);

        edt1_user=v.findViewById(R.id.edt_username_user);
        edt2_user=v.findViewById(R.id.edt_mobile_user);
        edt3_user=v.findViewById(R.id.edt_email_user);
        edt4_user=v.findViewById(R.id.edt_address_user);
        btn_user_sub=v.findViewById(R.id.btn_user_sub);

        database=new UserInfoDatabase(getActivity());


        btn_user_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, mob_no, email, address;
                name=edt1_user.getText().toString().trim();
                mob_no=edt2_user.getText().toString().trim();
                email=edt3_user.getText().toString().trim();
                address=edt4_user.getText().toString().trim();

                if (name.equals("")){
                    edt1_user.setError("Enter name");
                }else if (mob_no.equals("")){
                    edt2_user.setError("Enter mobile number");
                }else if (email.equals("")){
                    edt3_user.setError("Enter email");
                }else if (address.equals("")){
                    edt4_user.setError("Enter address");
                }else{

                    userInfo=new UserInfo();
                    userInfo.setUserName(name);
                    userInfo.setMob_number(mob_no);
                    userInfo.setEmail(email);
                    userInfo.setAddress(address);

                   long id=database.addUser(userInfo);

                   if (id>0)
                   {
                       TestMessage.message(getActivity(),"Successfully saved");

                   }else {
                       TestMessage.message(getActivity(),"Not saved");

                   }

                }

            }
        });



        return v;
    }

}
