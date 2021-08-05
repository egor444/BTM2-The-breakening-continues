package com.example.elisapp20.functions;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.elisapp20.R;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class FragmentFunctions {
    private static int tickedItIterator = 0;
    public static final Ticket[] tickets = {
            // Einzel- & Tageskarten
            new Ticket(tickedItIterator++,"Fahrkarte Einzeln",4),
            new Ticket(tickedItIterator++,"Kurzstrecke",2),
            new Ticket(tickedItIterator++,"Streifenkarte",15),
            new Ticket(tickedItIterator++,"Single Tageskarte",8),
            new Ticket(tickedItIterator++,"Gruppen Tageskarte",15),
            new Ticket(tickedItIterator++,"Kinder Tageskarte",3),
            // Vielfahrer
            new Ticket(tickedItIterator++,"IsarCard",60),
            new Ticket(tickedItIterator++,"IsarCard 9Uhr",50),
            new Ticket(tickedItIterator++,"IsarCard 65",45),
            new Ticket(tickedItIterator++,"IsarCard S",30),
            new Ticket(tickedItIterator++,"Tarif Ausbildung I",40),
            new Ticket(tickedItIterator++,"Tarif Ausbildung II",43),
            new Ticket(tickedItIterator++,"Tarif Ausbildung Plus",15),
            new Ticket(tickedItIterator++,"Ticket Semester",201),
            // München Besucher
            new Ticket(tickedItIterator++,"CityTourCard",20),
            new Ticket(tickedItIterator++,"Airport City Day Ticket",15),
            new Ticket(tickedItIterator++,"München Card",14),
            // Sonstige
            new Ticket(tickedItIterator++,"Pepeparadies Karte",420),
            new Ticket(tickedItIterator++,"Kintoticket",69),
            new Ticket(tickedItIterator++,"SEA LIFE Ticket",23),
            new Ticket(tickedItIterator++,"Oberland MVV Ticket",24),
            new Ticket(tickedItIterator++,"Bayern Ticket",25),

    };

    public static final String[] TicketTypes = {
            "Einzel & Tageskarten",
            "Vielfahrer",
            "München Besucher",
            "Sonstige"
    };

    public static Button createFrameSwitchButton(@NonNull View view, int btnID, int resId, int ticketId, int ticketCount){
        Button btn = (Button) view.findViewById(btnID);
        Context context = view.getContext();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navctrlr = Navigation.findNavController(view);

                NavOptions no = new NavOptions.Builder()
                            .setEnterAnim(R.anim.from_left)
                            .setExitAnim(R.anim.to_right)
                            .build();

                playStartup(context);

                Bundle bundle = null;

                if(ticketId >= 0 && ticketId < tickets.length || ticketCount > 0) {
                    bundle = new Bundle();
                    if (ticketId >= 0 && ticketId < tickets.length)
                        bundle.putInt("ticketId", ticketId);
                    if (ticketCount > 0)
                        bundle.putInt("ticketCount", ticketCount);
                }
                navctrlr.navigate(resId,bundle,no);
            }
        });
        if(resId == R.id.to_buyPage) {
            btn.setText(tickets[ticketId].name);
        }

        return btn;
    }

    public static Button overrideFrameSwitchButton(@NonNull View view, Button btn, int resId, int ticketId, int ticketCount){
        Context context = view.getContext();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navctrlr = Navigation.findNavController(view);

                NavOptions no = new NavOptions.Builder()
                        .setEnterAnim(R.anim.from_left)
                        .setExitAnim(R.anim.to_right)
                        .build();

                playStartup(context);

                Bundle bundle = null;

                if(ticketId >= 0 && ticketId < tickets.length || ticketCount > 0) {
                    bundle = new Bundle();
                    if (ticketId >= 0 && ticketId < tickets.length)
                        bundle.putInt("ticketId", ticketId);
                    if (ticketCount > 0)
                        bundle.putInt("ticketCount", ticketCount);
                }
                navctrlr.navigate(resId,bundle,no);
            }
        });
        if(resId == R.id.to_buyPage) {
            btn.setText(tickets[ticketId].name);
        }

        return btn;
    }

    public static Button createTransitionButton(View view, int btnID, int resId, String buttonText, int typeId){
        Button btn = view.findViewById(btnID);
        Context context = view.getContext();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                NavController navctrlr = Navigation.findNavController(view);
                NavOptions no = new NavOptions.Builder()
                        .setEnterAnim(R.anim.from_left)
                        .setExitAnim(R.anim.to_right)
                        .build();
                bundle.putInt("typeId", typeId);
                playStartup(context);

                navctrlr.navigate(resId,bundle,no);
            }
        });
        btn.setText(buttonText);
        return btn;
    }

    public static void playStartup(Context context){
        try {
            MediaPlayer player = MediaPlayer.create(context, R.raw.gears);
            player.start();
            player.wait();
            player.release();
        }catch (Exception e){ }

    }
}




