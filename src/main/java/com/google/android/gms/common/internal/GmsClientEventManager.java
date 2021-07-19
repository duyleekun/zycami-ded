/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClientEventManager$GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager
implements Handler.Callback {
    private final Handler mHandler;
    private final Object mLock;
    private final GmsClientEventManager$GmsClientEventState zaol;
    private final ArrayList zaom;
    private final ArrayList zaon;
    private final ArrayList zaoo;
    private volatile boolean zaop;
    private final AtomicInteger zaoq;
    private boolean zaor;

    public GmsClientEventManager(Looper looper, GmsClientEventManager$GmsClientEventState object) {
        AtomicInteger atomicInteger;
        Object object2 = new ArrayList();
        this.zaom = object2;
        object2 = new ArrayList();
        this.zaon = object2;
        object2 = new ArrayList();
        this.zaoo = object2;
        this.zaop = false;
        this.zaoq = atomicInteger = new AtomicInteger(0);
        this.zaor = false;
        this.mLock = object2 = new Object();
        this.zaol = object;
        super(looper, this);
        this.mHandler = object;
    }

    public final boolean areCallbacksEnabled() {
        return this.zaop;
    }

    public final void disableCallbacks() {
        this.zaop = false;
        this.zaoq.incrementAndGet();
    }

    public final void enableCallbacks() {
        this.zaop = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != n11) {
            StringBuilder stringBuilder = new StringBuilder(45);
            stringBuilder.append("Don't know how to handle message: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            Exception exception = new Exception();
            Log.wtf((String)"GmsClientEvents", (String)string2, (Throwable)exception);
            return false;
        }
        object = (GoogleApiClient$ConnectionCallbacks)((Message)object).obj;
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3;
            n10 = (int)(this.zaop ? 1 : 0);
            if (n10 && (n10 = (object3 = this.zaol).isConnected()) && (n10 = ((ArrayList)(object3 = this.zaom)).contains(object))) {
                object3 = this.zaol;
                object3 = object3.getConnectionHint();
                object.onConnected((Bundle)object3);
            }
            return n11 != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        Preconditions.checkNotNull(googleApiClient$ConnectionCallbacks);
        Object object = this.mLock;
        synchronized (object) {
            ArrayList arrayList = this.zaom;
            return arrayList.contains(googleApiClient$ConnectionCallbacks);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient$OnConnectionFailedListener);
        Object object = this.mLock;
        synchronized (object) {
            ArrayList arrayList = this.zaoo;
            return arrayList.contains(googleApiClient$OnConnectionFailedListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onConnectionFailure(ConnectionResult connectionResult) {
        Object object = this.mHandler;
        ArrayList arrayList = "onConnectionFailure must only be called on the Handler thread";
        Preconditions.checkHandlerThread(object, (String)((Object)arrayList));
        object = this.mHandler;
        int n10 = 1;
        object.removeMessages(n10);
        object = this.mLock;
        synchronized (object) {
            Serializable serializable = this.zaoo;
            arrayList = new ArrayList(serializable);
            serializable = this.zaoq;
            int n11 = ((AtomicInteger)serializable).get();
            int n12 = arrayList.size();
            int n13 = 0;
            while (true) {
                Serializable serializable2;
                if (n13 >= n12) {
                    return;
                }
                Object object2 = arrayList.get(n13);
                ++n13;
                object2 = (GoogleApiClient$OnConnectionFailedListener)object2;
                int n14 = this.zaop;
                if (n14 == 0 || (n14 = ((AtomicInteger)(serializable2 = this.zaoq)).get()) != n11) break;
                serializable2 = this.zaoo;
                n14 = (int)(((ArrayList)serializable2).contains(object2) ? 1 : 0);
                if (n14 == 0) continue;
                object2.onConnectionFailed(connectionResult);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onConnectionSuccess() {
        Object object = this.mLock;
        synchronized (object) {
            GmsClientEventManager$GmsClientEventState gmsClientEventManager$GmsClientEventState = this.zaol;
            gmsClientEventManager$GmsClientEventState = gmsClientEventManager$GmsClientEventState.getConnectionHint();
            this.onConnectionSuccess((Bundle)gmsClientEventManager$GmsClientEventState);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onConnectionSuccess(Bundle object) {
        Object object2 = this.mHandler;
        ArrayList arrayList = "onConnectionSuccess must only be called on the Handler thread";
        Preconditions.checkHandlerThread(object2, (String)((Object)arrayList));
        object2 = this.mLock;
        synchronized (object2) {
            Serializable serializable;
            int n10 = this.zaor;
            int n11 = 1;
            if (n10 == 0) {
                n10 = n11;
            } else {
                n10 = 0;
                arrayList = null;
            }
            Preconditions.checkState(n10 != 0);
            arrayList = this.mHandler;
            arrayList.removeMessages(n11);
            this.zaor = n11;
            arrayList = this.zaon;
            n10 = arrayList.size();
            if (n10 != 0) {
                n11 = 0;
                serializable = null;
            }
            Preconditions.checkState(n11 != 0);
            serializable = this.zaom;
            arrayList = new ArrayList(serializable);
            serializable = this.zaoq;
            n11 = ((AtomicInteger)serializable).get();
            int n12 = arrayList.size();
            for (int i10 = 0; i10 < n12; ++i10) {
                Object object3;
                Object object4 = arrayList.get(i10);
                object4 = (GoogleApiClient$ConnectionCallbacks)object4;
                int n13 = this.zaop;
                if (n13 == 0 || (n13 = (object3 = this.zaol).isConnected()) == 0 || (n13 = ((AtomicInteger)(object3 = this.zaoq)).get()) != n11) break;
                object3 = this.zaon;
                n13 = (int)(((ArrayList)object3).contains(object4) ? 1 : 0);
                if (n13 != 0) continue;
                object4.onConnected((Bundle)object);
            }
            object = this.zaon;
            ((ArrayList)object).clear();
            this.zaor = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onUnintentionalDisconnection(int n10) {
        Object object = this.mHandler;
        ArrayList arrayList = "onUnintentionalDisconnection must only be called on the Handler thread";
        Preconditions.checkHandlerThread(object, (String)((Object)arrayList));
        object = this.mHandler;
        int n11 = 1;
        object.removeMessages(n11);
        object = this.mLock;
        synchronized (object) {
            this.zaor = n11;
            Serializable serializable = this.zaom;
            arrayList = new ArrayList(serializable);
            serializable = this.zaoq;
            int n12 = ((AtomicInteger)serializable).get();
            int n13 = arrayList.size();
            for (int i10 = 0; i10 < n13; ++i10) {
                Serializable serializable2;
                Object object2 = arrayList.get(i10);
                object2 = (GoogleApiClient$ConnectionCallbacks)object2;
                int n14 = this.zaop;
                if (n14 == 0 || (n14 = ((AtomicInteger)(serializable2 = this.zaoq)).get()) != n12) break;
                serializable2 = this.zaom;
                n14 = (int)(((ArrayList)serializable2).contains(object2) ? 1 : 0);
                if (n14 == 0) continue;
                object2.onConnectionSuspended(n10);
            }
            ArrayList arrayList2 = this.zaon;
            arrayList2.clear();
            this.zaor = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void registerConnectionCallbacks(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        int n10;
        Preconditions.checkNotNull(googleApiClient$ConnectionCallbacks);
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.zaom;
            n10 = ((ArrayList)object2).contains(googleApiClient$ConnectionCallbacks);
            if (n10 != 0) {
                object2 = "GmsClientEvents";
                String string2 = String.valueOf(googleApiClient$ConnectionCallbacks);
                String string3 = String.valueOf(string2);
                int n11 = string3.length() + 62;
                StringBuilder stringBuilder = new StringBuilder(n11);
                string3 = "registerConnectionCallbacks(): listener ";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                string2 = " is already registered";
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                Log.w((String)object2, (String)string2);
            } else {
                object2 = this.zaom;
                ((ArrayList)object2).add(googleApiClient$ConnectionCallbacks);
            }
        }
        object = this.zaol;
        boolean bl2 = object.isConnected();
        if (bl2) {
            object = this.mHandler;
            n10 = 1;
            googleApiClient$ConnectionCallbacks = object.obtainMessage(n10, (Object)googleApiClient$ConnectionCallbacks);
            object.sendMessage((Message)googleApiClient$ConnectionCallbacks);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void registerConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener object) {
        Preconditions.checkNotNull(object);
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3 = this.zaoo;
            boolean bl2 = ((ArrayList)object3).contains(object);
            if (bl2) {
                object3 = "GmsClientEvents";
                object = String.valueOf(object);
                String string2 = String.valueOf(object);
                int n10 = string2.length() + 67;
                StringBuilder stringBuilder = new StringBuilder(n10);
                string2 = "registerConnectionFailedListener(): listener ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
                object = " is already registered";
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                Log.w((String)object3, (String)object);
            } else {
                object3 = this.zaoo;
                ((ArrayList)object3).add(object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void unregisterConnectionCallbacks(GoogleApiClient$ConnectionCallbacks object) {
        Preconditions.checkNotNull(object);
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3 = this.zaom;
            boolean bl2 = ((ArrayList)object3).remove(object);
            if (!bl2) {
                object3 = "GmsClientEvents";
                object = String.valueOf(object);
                String string2 = String.valueOf(object);
                int n10 = string2.length() + 52;
                StringBuilder stringBuilder = new StringBuilder(n10);
                string2 = "unregisterConnectionCallbacks(): listener ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
                object = " not found";
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                Log.w((String)object3, (String)object);
            } else {
                bl2 = this.zaor;
                if (bl2) {
                    object3 = this.zaon;
                    ((ArrayList)object3).add(object);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void unregisterConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener object) {
        Preconditions.checkNotNull(object);
        Object object2 = this.mLock;
        synchronized (object2) {
            Object object3 = this.zaoo;
            boolean bl2 = ((ArrayList)object3).remove(object);
            if (!bl2) {
                object3 = "GmsClientEvents";
                object = String.valueOf(object);
                String string2 = String.valueOf(object);
                int n10 = string2.length() + 57;
                StringBuilder stringBuilder = new StringBuilder(n10);
                string2 = "unregisterConnectionFailedListener(): listener ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
                object = " not found";
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                Log.w((String)object3, (String)object);
            }
            return;
        }
    }
}

