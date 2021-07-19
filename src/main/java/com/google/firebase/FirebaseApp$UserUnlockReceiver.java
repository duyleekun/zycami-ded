/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.google.firebase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp$UserUnlockReceiver
extends BroadcastReceiver {
    private static AtomicReference INSTANCE;
    private final Context applicationContext;

    static {
        AtomicReference atomicReference;
        INSTANCE = atomicReference = new AtomicReference();
    }

    public FirebaseApp$UserUnlockReceiver(Context context) {
        this.applicationContext = context;
    }

    public static /* synthetic */ void access$200(Context context) {
        FirebaseApp$UserUnlockReceiver.ensureReceiverRegistered(context);
    }

    private static void ensureReceiverRegistered(Context context) {
        Object object = INSTANCE.get();
        if (object == null) {
            object = new Object(context);
            AtomicReference atomicReference = INSTANCE;
            String string2 = null;
            boolean bl2 = atomicReference.compareAndSet(null, object);
            if (bl2) {
                string2 = "android.intent.action.USER_UNLOCKED";
                atomicReference = new IntentFilter(string2);
                context.registerReceiver(object, (IntentFilter)atomicReference);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceive(Context object, Intent object2) {
        object = FirebaseApp.access$300();
        synchronized (object) {
            object2 = FirebaseApp.INSTANCES;
            object2 = object2.values();
            object2 = object2.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    // MONITOREXIT @DISABLED, blocks:[2, 3, 4] lbl8 : MonitorExitStatement: MONITOREXIT : var1_1 /* !! */ 
                    this.unregister();
                    return;
                }
                Object object3 = object2.next();
                object3 = (FirebaseApp)object3;
                FirebaseApp.access$400(object3);
            }
        }
    }

    public void unregister() {
        this.applicationContext.unregisterReceiver((BroadcastReceiver)this);
    }
}

