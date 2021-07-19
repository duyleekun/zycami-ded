/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.IntentFilter
 */
package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager$1;

public abstract class AppCompatDelegateImpl$AutoNightModeManager {
    private BroadcastReceiver mReceiver;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$AutoNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cleanup() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            try {
                AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                appCompatDelegateImpl = appCompatDelegateImpl.mContext;
                appCompatDelegateImpl.unregisterReceiver(broadcastReceiver);
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            broadcastReceiver = null;
            this.mReceiver = null;
        }
    }

    public abstract IntentFilter createIntentFilterForBroadcastReceiver();

    public abstract int getApplyableNightMode();

    public boolean isListening() {
        boolean bl2;
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            bl2 = true;
        } else {
            bl2 = false;
            broadcastReceiver = null;
        }
        return bl2;
    }

    public abstract void onChange();

    public void setup() {
        int n10;
        this.cleanup();
        IntentFilter intentFilter = this.createIntentFilterForBroadcastReceiver();
        if (intentFilter != null && (n10 = intentFilter.countActions()) != 0) {
            BroadcastReceiver broadcastReceiver = this.mReceiver;
            if (broadcastReceiver == null) {
                this.mReceiver = broadcastReceiver = new AppCompatDelegateImpl$AutoNightModeManager$1(this);
            }
            broadcastReceiver = this.this$0.mContext;
            BroadcastReceiver broadcastReceiver2 = this.mReceiver;
            broadcastReceiver.registerReceiver(broadcastReceiver2, intentFilter);
        }
    }
}

