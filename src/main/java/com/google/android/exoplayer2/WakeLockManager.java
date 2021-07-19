/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 */
package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Log;

public final class WakeLockManager {
    private static final String TAG = "WakeLockManager";
    private static final String WAKE_LOCK_TAG = "ExoPlayer:WakeLockManager";
    private boolean enabled;
    private final PowerManager powerManager;
    private boolean stayAwake;
    private PowerManager.WakeLock wakeLock;

    public WakeLockManager(Context context) {
        context = (PowerManager)context.getApplicationContext().getSystemService("power");
        this.powerManager = context;
    }

    private void updateWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null) {
            return;
        }
        boolean bl2 = this.enabled;
        if (bl2 && (bl2 = this.stayAwake)) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void setEnabled(boolean bl2) {
        PowerManager.WakeLock wakeLock;
        if (bl2 && (wakeLock = this.wakeLock) == null) {
            wakeLock = this.powerManager;
            if (wakeLock == null) {
                Log.w(TAG, "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            String string2 = WAKE_LOCK_TAG;
            this.wakeLock = wakeLock = wakeLock.newWakeLock(1, string2);
            wakeLock.setReferenceCounted(false);
        }
        this.enabled = bl2;
        this.updateWakeLock();
    }

    public void setStayAwake(boolean bl2) {
        this.stayAwake = bl2;
        this.updateWakeLock();
    }
}

