package com.example.elisapp20.framgments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.elisapp20.R;
import com.example.elisapp20.functions.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicketTypePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TicketTypePage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TicketTypePage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TicketTypePage.
     */
    // TODO: Rename and change types and number of parameters
    public static TicketTypePage newInstance(String param1, String param2) {
        TicketTypePage fragment = new TicketTypePage();
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
        View view = inflater.inflate(R.layout.fragment_ticket_type_page, container, false);
        int[] btnIds = {R.id.btn_types_1,R.id.btn_types_2,R.id.btn_types_3,R.id.btn_types_4,R.id.btn_types_5,R.id.btn_types_6};
        Button[] btns = new Button[btnIds.length];

        for (int i = 0; i < btnIds.length; i++) {
            if(i>=FragmentFunctions.TicketTypes.length){
                btns[i] = view.findViewById(btnIds[i]);
                btns[i].setEnabled(false);
                btns[i].setVisibility(View.INVISIBLE);
            }else{
                Bundle b1 = new Bundle();
                b1.putInt("typeId",i);
                btns[i] = FragmentFunctions.createTransitionButton(view,btnIds[i],R.id.types_to_fr1,FragmentFunctions.TicketTypes[i],b1);
            }
        }

        Button btnToFrag2 = FragmentFunctions.createFrameSwitchButton(view,R.id.btnFr2,R.id.types_to_fr2,null);
        
        return view;
    }
}