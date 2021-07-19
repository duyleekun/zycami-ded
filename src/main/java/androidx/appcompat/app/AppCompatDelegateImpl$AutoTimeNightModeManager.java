/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.IntentFilter
 */
package androidx.appcompat.app;

import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager;
import androidx.appcompat.app.TwilightManager;

public class AppCompatDelegateImpl$AutoTimeNightModeManager
extends AppCompatDelegateImpl$AutoNightModeManager {
    private final TwilightManager mTwilightManager;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$AutoTimeNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl, TwilightManager twilightManager) {
        this.this$0 = appCompatDelegateImpl;
        super(appCompatDelegateImpl);
        this.mTwilightManager = twilightManager;
    }

    public IntentFilter createIntentFilterForBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        return intentFilter;
    }

    public int getApplyableNightMode() {
        TwilightManager twilightManager = this.mTwilightManager;
        int n10 = twilightManager.isNight();
        n10 = n10 != 0 ? 2 : 1;
        return n10;
    }

    public void onChange() {
        this.this$0.applyDayNight();
    }
}

