/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 */
package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;

public class ShortcutManagerCompat$1
extends BroadcastReceiver {
    public final /* synthetic */ IntentSender val$callback;

    public ShortcutManagerCompat$1(IntentSender intentSender) {
        this.val$callback = intentSender;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onReceive(Context context, Intent intent) {
        IntentSender intentSender;
        try {
            intentSender = this.val$callback;
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            return;
        }
        intentSender.sendIntent(context, 0, null, null, null);
    }
}

