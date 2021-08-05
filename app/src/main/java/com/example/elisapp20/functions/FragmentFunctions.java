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

    public static final Ticket[] tickets = {
            new Ticket(0,"Streifenkarte",15),
            new Ticket(1,"Tageskarte",10),
            new Ticket(2,"Pepekarte",420),
            new Ticket(3,"Jahreskarte",400),
            new Ticket(4,"Monatskarte",40),
            new Ticket(5,"Kinderparadies",666),

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

    public static void playStartup(Context context){
        try {
            MediaPlayer player = MediaPlayer.create(context, R.raw.gears);
            player.start();
            player.wait();
            player.release();
        }catch (Exception e){ }

    }
}




