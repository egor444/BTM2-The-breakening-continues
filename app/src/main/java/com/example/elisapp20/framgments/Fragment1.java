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
        int[] buttonids = {
                R.id.btn_fr1_1,
                R.id.btn_fr1_2,
                R.id.btn_fr1_3,
                R.id.btn_fr1_4,
                R.id.btn_fr1_5,
                R.id.btn_fr1_6,
                R.id.btn_fr1_7,
                R.id.btn_fr1_8,
        };
        Button[] btns = new Button[buttonids.length];
        int typeId = getArguments().getInt("typeId");
        int[] ticketIdFromTo=FragmentFunctions.getFromToTicketIndexes(typeId);

        for (int i = 0; i < buttonids.length; i++) {
            if(i >= ticketIdFromTo[1] - ticketIdFromTo[0] + 1){
                btns[i] = view.findViewById(buttonids[i]);
                btns[i].setEnabled(false);
                btns[i].setVisibility(View.INVISIBLE);
            }else{
                Bundle b1 = new Bundle();
                b1.putInt("ticketId",i+ticketIdFromTo[0]);
                FragmentFunctions.createFrameSwitchButton(view,buttonids[i],R.id.to_buyPage,b1);
            }
        }

        FragmentFunctions.createTransitionButton(view,R.id.btn_fr1_to_types,R.id.fr1_to_types,"Zurück zum Anfang",null);

        return view;
    }

}