/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.net.wifi.WifiManager$WifiLock
 */
package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.google.android.exoplayer2.util.Log;

public final class WifiLockManager {
    private static final String TAG = "WifiLockManager";
    private static final String WIFI_LOCK_TAG = "ExoPlayer:WifiLockManager";
    private boolean enabled;
    private boolean stayAwake;
    private WifiManager.WifiLock wifiLock;
    private final WifiManager wifiManager;

    public WifiLockManager(Context context) {
        context = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.wifiManager = context;
    }

    private void updateWifiLock() {
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock == null) {
            return;
        }
        boolean bl2 = this.enabled;
        if (bl2 && (bl2 = this.stayAwake)) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void setEnabled(boolean bl2) {
        WifiManager.WifiLock wifiLock;
        if (bl2 && (wifiLock = this.wifiLock) == null) {
            wifiLock = this.wifiManager;
            if (wifiLock == null) {
                Log.w(TAG, "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            String string2 = WIFI_LOCK_TAG;
            this.wifiLock = wifiLock = wifiLock.createWifiLock(3, string2);
            wifiLock.setReferenceCounted(false);
        }
        this.enabled = bl2;
        this.updateWifiLock();
    }

    public void setStayAwake(boolean bl2) {
        this.stayAwake = bl2;
        this.updateWifiLock();
    }
}

