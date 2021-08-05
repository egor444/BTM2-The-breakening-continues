package com.example.elisapp20.framgments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elisapp20.R;
import com.example.elisapp20.functions.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Confirmation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Confirmation extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Confirmation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Confirmation.
     */
    // TODO: Rename and change types and number of parameters
    public static Confirmation newInstance(String param1, String param2) {
        Confirmation fragment = new Confirmation();
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
        View view =  inflater.inflate(R.layout.fragment_confirmation, container, false);
        TextView tv_name = view.findViewById(R.id.tv_confirmation_ticketname);
        TextView tv_price = view.findViewById(R.id.tv_confirmation_ticketprice);
        Ticket ticket = FragmentFunctions.tickets[getArguments().getInt("ticketId")];
        int ticketCount = getArguments().getInt("ticketCount");

        if(ticketCount > 1){
            tv_name.setText(ticket.name + " x" + ticketCount);
        }else {
            tv_name.setText(ticket.name);
        }
        tv_price.setText((ticket.price*ticketCount) + "€");
        Bundle b1 = new Bundle();
        b1.putInt("ticketId",ticket.id);
        FragmentFunctions.createFrameSwitchButton(view,R.id.btn_confirmation_cancel,R.id.confirmation_canceled,b1);

        return view;
    }
}