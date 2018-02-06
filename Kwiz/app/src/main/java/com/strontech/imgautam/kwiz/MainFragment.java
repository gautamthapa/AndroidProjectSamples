package com.strontech.imgautam.kwiz;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    Bundle b;
    TextView timerTxt, quesTxt;
    MediaPlayer mp;
    Button btn1, btn2, btn3, btn4;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mp=MediaPlayer.create(getActivity(),R.raw.kbcbackground);
        mp.start();
    }

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_main, container, false);
        timerTxt=v.findViewById(R.id.timerTextView);
        quesTxt=v.findViewById(R.id.question_txt);




        btn1=v.findViewById(R.id.button1);
        btn2=v.findViewById(R.id.button2);
        btn3=v.findViewById(R.id.button3);
        btn4=v.findViewById(R.id.button4);

        quesTxt.setText("1. Which of the following is the official language in Argentina ?");
        btn1.setText("A. Portuguese");
        btn2.setText("B. French");
        btn3.setText("C. Spanish");
        btn4.setText("D. Dutch");

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s=btn1.getText().toString();
                 String b="C. Spanish";
                 if (s.equals(b))
                 {
                     btn1.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }else
                 {
                     btn1.setBackgroundColor(getResources().getColor(R.color.ans_wrong));
                     btn3.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }
             }
         });


         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s=btn2.getText().toString();
                 String b="C. Spanish";
                 if (s.equals(b))
                 {
                     btn2.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }else
                 {
                     btn2.setBackgroundColor(getResources().getColor(R.color.ans_wrong));
                     btn3.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }
             }

         });

         btn3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s=btn3.getText().toString();
                 String b="C. Spanish";
                 if (s.equals(b))
                 {
                     btn3.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }else
                 {
                     btn3.setBackgroundColor(getResources().getColor(R.color.ans_wrong));
                     btn3.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }
             }

         });


         btn4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s=btn4.getText().toString();
                 String b="C. Spanish";
                 if (s.equals(b))
                 {
                     btn4.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }else
                 {
                     btn4.setBackgroundColor(getResources().getColor(R.color.ans_wrong));
                     btn3.setBackgroundColor(getResources().getColor(R.color.ans_right));
                 }

             }
         });
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTxt.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTxt.setText("  ");

            }
        }.start();
    return v;
    }

}
