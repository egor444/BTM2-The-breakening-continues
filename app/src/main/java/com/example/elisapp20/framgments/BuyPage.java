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

    // Tickets
    private static final Ticket[] tickets = {
            new Ticket(1,"Streifenkarte",15),
            new Ticket(2,"Tageskarte",10),
            new Ticket(3,"Pepekarte",420),
            new Ticket(4,"Jahreskarte",400),

    };

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
        Ticket ticket = getTicketById(getArguments().getInt("ticketId"));
        if(ticket != null){
            tvTicketName.setText(ticket.name);
            tvTicketPrice.setText(ticket.price + "€");
        }
        else
            tvTicketName.setText("Oof ouch Fehler :(");

        createFrameSwitchButton(view,R.id.btn_bp_to_fr1,R.id.bp_to_fr1,-1);

        return view;
    }

    private Button createFrameSwitchButton(@NonNull View view, int btnID, int resId, int ticketId){
        Button btn = (Button) view.findViewById(btnID);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navctrlr = Navigation.findNavController(view);
                if(resId == R.id.to_buyPage) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("ticketId", ticketId);
                    navctrlr.navigate(resId,bundle);
                }
                else
                    Navigation.findNavController(view).navigate(resId);
            }
        });
        return btn;
    }

    /**
     * Find the Ticket by its id.
     *
     + @param id The id of the searched ticket.
     * @return The ticket searched with the input id.
     */
    private final Ticket getTicketById(int id){
        for (Ticket ticket: tickets){
            if(ticket.id == id) return ticket;
        }
        return null;
    }
}

final class Ticket{
    public final int id;
    public final String name;
    public final int price;
    public Ticket(int id, String name, int price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}