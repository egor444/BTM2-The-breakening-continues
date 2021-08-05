package com.example.elisapp20.framgments;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.elisapp20.R;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import com.example.elisapp20.functions.FragmentFunctions;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextToSpeech t1;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        Button btn1 = FragmentFunctions.createFrameSwitchButton(view,R.id.btnFr1,R.id.fr2_to_types,null);
        Button btn_supp = view.findViewById(R.id.btn_fr2_support);
        t1=new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.GERMANY);
                }
            }
        });

        btn_supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak = "Hallo, willkommen bei der Automat hilfe. "
                        + "Bitte drücken Sie den Knopf, der ihr Problem wiederspiegelt.";
                Toast.makeText(view.getContext(), toSpeak, Toast.LENGTH_SHORT).show();
                NavController navctrlr = Navigation.findNavController(view);
                NavOptions no = new NavOptions.Builder()
                        .setEnterAnim(R.anim.from_left)
                        .setExitAnim(R.anim.to_right)
                        .build();
                FragmentFunctions.playStartup(view.getContext());
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);

                navctrlr.navigate(R.id.fr2_to_support,null,no);
            }
        });
        return view;
    }


}