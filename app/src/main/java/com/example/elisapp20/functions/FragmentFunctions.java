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
    private static int ti = 0;
    public static final Ticket[] tickets = {
            // Einzel- & Tageskarten
            new Ticket(ti++,"Fahrkarte Einzeln",4),
            new Ticket(ti++,"Kurzstrecke",2),
            new Ticket(ti++,"Streifenkarte",15),
            new Ticket(ti++,"Single Tageskarte",8),
            new Ticket(ti++,"Gruppen Tageskarte",15),
            new Ticket(ti++,"Kinder Tageskarte",3),
            // Vielfahrer
            new Ticket(ti++,"IsarCard",60),
            new Ticket(ti++,"IsarCard 9Uhr",50),
            new Ticket(ti++,"IsarCard 65",45),
            new Ticket(ti++,"IsarCard S",30),
            new Ticket(ti++,"Tarif Ausbildung I",40),
            new Ticket(ti++,"Tarif Ausbildung II",43),
            new Ticket(ti++,"Tarif Ausbildung Plus",15),
            new Ticket(ti++,"Ticket Semester",201),
            // München Besucher
            new Ticket(ti++,"CityTourCard",20),
            new Ticket(ti++,"Airport City Day Ticket",15),
            new Ticket(ti++,"München Card",14),
            // Sonstige
            new Ticket(ti++,"Pepeparadies Karte",420),
            new Ticket(ti++,"Kintoticket",69),
            new Ticket(ti++,"SEA LIFE Ticket",23),
            new Ticket(ti++,"Oberland MVV Ticket",24),
            new Ticket(ti++,"Bayern Ticket",25),

    };

    public static final String[] TicketTypes = {
            "Einzel & Tageskarten",
            "Vielfahrer",
            "München Besucher",
            "Sonstige",
    };

    public static int[] getFromToTicketIndexes(int ticketTypeId){
        switch (ticketTypeId){
            case 0:
                return new int[]{0,5};
            case 1:
                return new int[]{6,13};
            case 2:
                return new int[]{14,16};
            case 3:
                return new int[]{17,21};
        }
        return new int[]{0,0};
    }

    public static Button createFrameSwitchButton(@NonNull View view, int btnID, int resId, Bundle bundle){
        Button btn = (Button) view.findViewById(btnID);
        return overrideFrameSwitchButton(view, btn,resId,bundle);
    }

    public static Button overrideFrameSwitchButton(@NonNull View view, Button btn, int resId, Bundle bundle){
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
                navctrlr.navigate(resId,bundle,no);
            }
        });
        if(resId == R.id.to_buyPage) {
            btn.setText(tickets[bundle.getInt("ticketId")].name);
        }

        return btn;
    }

    public static Button createTransitionButton(View view, int btnID, int resId, String buttonText, Bundle bundle){
        Button button = createFrameSwitchButton(view,btnID,resId,bundle);
        button.setText(buttonText);
        return button;
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




