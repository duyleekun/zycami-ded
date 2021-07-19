/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package com.google.firebase;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp$GlobalBackgroundStateListener
implements BackgroundDetector$BackgroundStateChangeListener {
    private static AtomicReference INSTANCE;

    static {
        AtomicReference atomicReference;
        INSTANCE = atomicReference = new AtomicReference();
    }

    private FirebaseApp$GlobalBackgroundStateListener() {
    }

    public static /* synthetic */ void access$100(Context context) {
        FirebaseApp$GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(context);
    }

    private static void ensureBackgroundStateListenerRegistered(Context object) {
        Object object2;
        boolean bl2 = PlatformVersion.isAtLeastIceCreamSandwich();
        if (bl2 && (bl2 = (object2 = object.getApplicationContext()) instanceof Application)) {
            AtomicReference atomicReference;
            boolean bl3;
            object = (Application)object.getApplicationContext();
            object2 = INSTANCE.get();
            if (object2 == null && (bl3 = (atomicReference = INSTANCE).compareAndSet(null, object2 = new FirebaseApp$GlobalBackgroundStateListener()))) {
                BackgroundDetector.initialize((Application)object);
                object = BackgroundDetector.getInstance();
                ((BackgroundDetector)object).addListener((BackgroundDetector$BackgroundStateChangeListener)object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onBackgroundStateChanged(boolean bl2) {
        Object object = FirebaseApp.access$300();
        synchronized (object) {
            Object object2 = FirebaseApp.INSTANCES;
            object2 = object2.values();
            Object object3 = new ArrayList(object2);
            object3 = ((ArrayList)object3).iterator();
            boolean bl3;
            while (bl3 = object3.hasNext()) {
                object2 = object3.next();
                AtomicBoolean atomicBoolean = FirebaseApp.access$500((FirebaseApp)(object2 = (FirebaseApp)object2));
                boolean bl4 = atomicBoolean.get();
                if (!bl4) continue;
                FirebaseApp.access$600((FirebaseApp)object2, bl2);
            }
            return;
        }
    }
}

