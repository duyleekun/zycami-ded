/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager;

public class AppCompatDelegateImpl$AutoNightModeManager$1
extends BroadcastReceiver {
    public final /* synthetic */ AppCompatDelegateImpl$AutoNightModeManager this$1;

    public AppCompatDelegateImpl$AutoNightModeManager$1(AppCompatDelegateImpl$AutoNightModeManager autoNightModeManager) {
        this.this$1 = autoNightModeManager;
    }

    public void onReceive(Context context, Intent intent) {
        this.this$1.onChange();
    }
}

