/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zacm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public abstract class GoogleApiClient {
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set zabq;

    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        zabq = Collections.newSetFromMap(weakHashMap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void dumpAll(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Set set = zabq;
        synchronized (set) {
            int n10 = 0;
            String string3 = String.valueOf(string2);
            Object object = "  ";
            string3 = string3.concat((String)object);
            object = set.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (GoogleApiClient)object2;
                PrintWriter printWriter2 = printWriter.append(string2);
                String string4 = "GoogleApiClient#";
                printWriter2 = printWriter2.append(string4);
                int n11 = n10 + 1;
                printWriter2.println(n10);
                ((GoogleApiClient)object2).dump(string3, fileDescriptor, printWriter, stringArray);
                n10 = n11;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static Set getAllClients() {
        Set set = zabq;
        // MONITORENTER : set
        // MONITOREXIT : set
        return set;
    }

    public static /* synthetic */ Set zal() {
        return zabq;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long var1, TimeUnit var3);

    public abstract PendingResult clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public abstract void disconnect();

    public abstract void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Api$Client getClient(Api$AnyClientKey object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public abstract ConnectionResult getConnectionResult(Api var1);

    public Context getContext() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Looper getLooper() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean hasApi(Api object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public abstract boolean hasConnectedApi(Api var1);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(GoogleApiClient$ConnectionCallbacks var1);

    public abstract boolean isConnectionFailedListenerRegistered(GoogleApiClient$OnConnectionFailedListener var1);

    public boolean maybeSignIn(SignInConnectionListener object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void maybeSignOut() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(GoogleApiClient$ConnectionCallbacks var1);

    public abstract void registerConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener var1);

    public ListenerHolder registerListener(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public abstract void stopAutoManage(FragmentActivity var1);

    public abstract void unregisterConnectionCallbacks(GoogleApiClient$ConnectionCallbacks var1);

    public abstract void unregisterConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener var1);

    public void zaa(zacm object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void zab(zacm object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

