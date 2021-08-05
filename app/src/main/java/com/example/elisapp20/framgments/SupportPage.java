package com.example.elisapp20.framgments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.elisapp20.R;
import com.example.elisapp20.functions.*;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SupportPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SupportPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextToSpeech t1;

    public SupportPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SupportPage.
     */
    // TODO: Rename and change types and number of parameters
    public static SupportPage newInstance(String param1, String param2) {
        SupportPage fragment = new SupportPage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_support_page, container, false);
        int speakstate = 0;

        Button btn_backhome = view.findViewById(R.id.btn_support_backhome);
        Button btn_speak_1 = view.findViewById(R.id.btn_support_1);
        Button btn_speak_2 = view.findViewById(R.id.btn_support_2);
        Button btn_speak_3 = view.findViewById(R.id.btn_support_3);
        Button btn_speak_4 = view.findViewById(R.id.btn_support_4);

        t1=new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.GERMANY);
                }
            }
        });

        createSpeechButton(btn_speak_1,"Bitte besorgen sie sich einen richtigen Job.");
        createSpeechButton(btn_speak_2,"Bitte versuchen sie eine andere Fahrkarte.");
        createSpeechButton(btn_speak_3,"Haben sie versucht den Automaten aus und wieder anzuschalten?");
        createSpeechButton(btn_speak_4,"Ich komm gleich durch den Bildschirm und schlag dich alter");

        FragmentFunctions.overrideFrameSwitchButton(view,btn_backhome,R.id.support_to_types,-1,0);

        return view;
    }

    private Button createSpeechButton(Button btn, String toSpeak){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        return btn;
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}