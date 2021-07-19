/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 */
package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.app.JobIntentService$WorkEnqueuer;

public final class JobIntentService$CompatWorkEnqueuer
extends JobIntentService$WorkEnqueuer {
    private final Context mContext;
    private final PowerManager.WakeLock mLaunchWakeLock;
    public boolean mLaunchingService;
    private final PowerManager.WakeLock mRunWakeLock;
    public boolean mServiceProcessing;

    public JobIntentService$CompatWorkEnqueuer(Context context, ComponentName object) {
        super((ComponentName)object);
        Object object2 = context.getApplicationContext();
        this.mContext = object2;
        context = (PowerManager)context.getSystemService("power");
        super();
        String string2 = object.getClassName();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(":launch");
        object2 = ((StringBuilder)object2).toString();
        int n10 = 1;
        object2 = context.newWakeLock(n10, (String)object2);
        this.mLaunchWakeLock = object2;
        object2.setReferenceCounted(false);
        object2 = new StringBuilder();
        object = object.getClassName();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(":run");
        object = ((StringBuilder)object2).toString();
        context = context.newWakeLock(n10, (String)object);
        this.mRunWakeLock = context;
        context.setReferenceCounted(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void enqueueWork(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent = this.mComponentName;
        intent2.setComponent((ComponentName)intent);
        intent = this.mContext.startService(intent2);
        if (intent == null) return;
        synchronized (this) {
            boolean bl2 = this.mLaunchingService;
            if (bl2) return;
            this.mLaunchingService = bl2 = true;
            bl2 = this.mServiceProcessing;
            if (bl2) return;
            intent = this.mLaunchWakeLock;
            long l10 = 60000L;
            intent.acquire(l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void serviceProcessingFinished() {
        synchronized (this) {
            boolean bl2 = this.mServiceProcessing;
            if (bl2) {
                PowerManager.WakeLock wakeLock;
                bl2 = this.mLaunchingService;
                if (bl2) {
                    wakeLock = this.mLaunchWakeLock;
                    long l10 = 60000L;
                    wakeLock.acquire(l10);
                }
                bl2 = false;
                wakeLock = null;
                this.mServiceProcessing = false;
                wakeLock = this.mRunWakeLock;
                wakeLock.release();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void serviceProcessingStarted() {
        synchronized (this) {
            boolean bl2 = this.mServiceProcessing;
            if (!bl2) {
                this.mServiceProcessing = bl2 = true;
                PowerManager.WakeLock wakeLock = this.mRunWakeLock;
                long l10 = 600000L;
                wakeLock.acquire(l10);
                wakeLock = this.mLaunchWakeLock;
                wakeLock.release();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void serviceStartReceived() {
        synchronized (this) {
            Object var1_1 = null;
            this.mLaunchingService = false;
            return;
        }
    }
}

