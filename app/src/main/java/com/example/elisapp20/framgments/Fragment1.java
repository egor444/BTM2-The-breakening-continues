package com.example.elisapp20.framgments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.elisapp20.R;
import com.example.elisapp20.functions.FragmentFunctions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
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
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        Button btnToFrag2 = FragmentFunctions.createFrameSwitchButton(view,R.id.btnFr2,R.id.onetotwo,-1,0);
        Button btnToBuyPage_Streifenkarte = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_fr1_1,R.id.to_buyPage,0,0);
        Button btnToBuyPage_Tageskarte = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_fr1_2,R.id.to_buyPage,1,0);
        Button btnToBuyPage_Pepekarte = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_fr1_3,R.id.to_buyPage,2,0);
        Button btnToBuyPage_Jahreskarte = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_fr1_4,R.id.to_buyPage,3,0);
        Button btnToBuyPage_Monatskarte = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_fr1_5,R.id.to_buyPage,4,0);
        Button btnToBuyPage_Kinderparadies = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_fr1_6,R.id.to_buyPage,5,0);

        return view;
    }

}