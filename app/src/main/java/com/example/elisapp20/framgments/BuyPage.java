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
import android.widget.TextView;

import com.example.elisapp20.R;
import com.example.elisapp20.functions.FragmentFunctions;
import com.example.elisapp20.functions.*;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuyPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TicketCount
    private int ticketCount;


    public BuyPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyPage.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyPage newInstance(String param1, String param2) {
        BuyPage fragment = new BuyPage();
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
        View view = inflater.inflate(R.layout.fragment_buy_page, container, false);
        TextView tvTicketName = view.findViewById(R.id.tvBuyPage);
        TextView tvTicketPrice = view.findViewById(R.id.tvBuyPrice);
        Button btn_inc_ticket_count = view.findViewById(R.id.btn_incticketcount);
        Button btn_dec_ticket_count = view.findViewById(R.id.btn_decticketcount);
        Ticket ticket = getTicketById(getArguments().getInt("ticketId"));
        Button buy_button;
        ticketCount = 1;

        if(ticket == null){
            tvTicketName.setText("Oof ouch Fehler :(");
            buy_button = view.findViewById(R.id.btn_buy);
            buy_button.setActivated(false);
        }
        else{
            tvTicketName.setText(ticket.name);
            tvTicketPrice.setText(ticket.price + "€");
            buy_button = FragmentFunctions.createFrameSwitchButton(view,R.id.btn_buy,R.id.confirm_buy,ticket.id,ticketCount);

            btn_inc_ticket_count.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ticketCount+=1;
                    if(ticketCount > 100){
                        ticketCount-=1;
                        return;
                    }
                    if(ticketCount == 1){
                        tvTicketName.setText(ticket.name);
                    }
                    if(ticketCount > 1){
                        tvTicketName.setText(ticket.name + " x" + ticketCount);
                    }
                    tvTicketPrice.setText((ticketCount * ticket.price) + "€");
                    FragmentFunctions.overrideFrameSwitchButton(view,buy_button,R.id.confirm_buy,ticket.id,ticketCount);
                }
            });

            btn_dec_ticket_count.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ticketCount-=1;
                    if(ticketCount <= 0){
                        ticketCount+=1;
                        return;
                    }
                    if(ticketCount == 1){
                        tvTicketName.setText(ticket.name);
                    }
                    if(ticketCount > 1){
                        tvTicketName.setText(ticket.name + " x" + ticketCount);
                    }
                    tvTicketPrice.setText((ticketCount * ticket.price) + "€");
                    FragmentFunctions.overrideFrameSwitchButton(view,buy_button,R.id.confirm_buy,ticket.id,ticketCount);
                }
            });
        }

        FragmentFunctions.createFrameSwitchButton(view,R.id.btn_bp_to_fr1,R.id.bp_to_fr1,-1,0);

        return view;
    }

    /**
     * Find the Ticket by its id.
     *
     + @param id The id of the searched ticket.
     * @return The ticket searched with the input id.
     */
    private Ticket getTicketById(int id){
        if(id>=0 && id<FragmentFunctions.tickets.length) return FragmentFunctions.tickets[id];
        return null;
    }

}

