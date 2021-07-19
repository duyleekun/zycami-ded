/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$Api21Impl;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager;

public class AppCompatDelegateImpl$AutoBatteryNightModeManager
extends AppCompatDelegateImpl$AutoNightModeManager {
    private final PowerManager mPowerManager;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$AutoBatteryNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        this.this$0 = appCompatDelegateImpl;
        super(appCompatDelegateImpl);
        appCompatDelegateImpl = (PowerManager)context.getApplicationContext().getSystemService("power");
        this.mPowerManager = appCompatDelegateImpl;
    }

    public IntentFilter createIntentFilterForBroadcastReceiver() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
        return null;
    }

    public int getApplyableNightMode() {
        PowerManager powerManager;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 21;
        if (n10 >= n12 && (n10 = (int)(AppCompatDelegateImpl$Api21Impl.isPowerSaveMode(powerManager = this.mPowerManager) ? 1 : 0)) != 0) {
            n11 = 2;
        }
        return n11;
    }

    public void onChange() {
        this.this$0.applyDayNight();
    }
}

