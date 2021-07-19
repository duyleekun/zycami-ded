/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.Player;
import java.util.List;
import java.util.Map;

public interface PlayerNotificationManager$CustomActionReceiver {
    public Map createCustomActions(Context var1, int var2);

    public List getCustomActions(Player var1);

    public void onCustomAction(Player var1, String var2, Intent var3);
}

