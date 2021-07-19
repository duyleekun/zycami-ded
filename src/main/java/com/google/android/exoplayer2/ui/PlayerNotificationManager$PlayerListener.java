/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$Events;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$1;

public class PlayerNotificationManager$PlayerListener
implements Player$EventListener {
    public final /* synthetic */ PlayerNotificationManager this$0;

    private PlayerNotificationManager$PlayerListener(PlayerNotificationManager playerNotificationManager) {
        this.this$0 = playerNotificationManager;
    }

    public /* synthetic */ PlayerNotificationManager$PlayerListener(PlayerNotificationManager playerNotificationManager, PlayerNotificationManager$1 playerNotificationManager$1) {
        this(playerNotificationManager);
    }

    public void onEvents(Player object, Player$Events player$Events) {
        Object object2 = object = (Object)new int[8];
        object2[0] = 5;
        object2[1] = 6;
        object2[2] = 8;
        object2[3] = false;
        object2[4] = 13;
        object2[5] = 12;
        object2[6] = 9;
        object2[7] = 10;
        boolean bl2 = player$Events.containsAny((int[])object);
        if (bl2) {
            object = this.this$0;
            PlayerNotificationManager.access$400((PlayerNotificationManager)object);
        }
    }
}

