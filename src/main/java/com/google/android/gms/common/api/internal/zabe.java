/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaah;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaav;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.api.internal.zabg;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.api.internal.zar;
import com.google.android.gms.common.internal.ClientSettings;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zabe
implements zabs,
zar {
    private final Context mContext;
    private final Api$AbstractClientBuilder zace;
    public final zaaw zaee;
    private final Lock zaeo;
    private final ClientSettings zaet;
    private final Map zaew;
    private final GoogleApiAvailabilityLight zaey;
    public final Map zagz;
    private final Condition zahn;
    private final zabg zaho;
    public final Map zahp;
    private volatile zabd zahq;
    private ConnectionResult zahr;
    public int zahs;
    public final zabt zaht;

    public zabe(Context object, zaaw zaaw2, Lock lock, Looper looper, GoogleApiAvailabilityLight object2, Map map, ClientSettings clientSettings, Map map2, Api$AbstractClientBuilder api$AbstractClientBuilder, ArrayList arrayList, zabt zabt2) {
        HashMap hashMap;
        this.zahp = hashMap = new HashMap();
        hashMap = null;
        this.zahr = null;
        this.mContext = object;
        this.zaeo = lock;
        this.zaey = object2;
        this.zagz = map;
        this.zaet = clientSettings;
        this.zaew = map2;
        this.zace = api$AbstractClientBuilder;
        this.zaee = zaaw2;
        this.zaht = zabt2;
        int n10 = arrayList.size();
        zaaw2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object2 = arrayList.get(i10);
            object2 = (zaq)object2;
            ((zaq)object2).zaa(this);
        }
        super(this, looper);
        this.zaho = object;
        object = lock.newCondition();
        this.zahn = object;
        super(this);
        this.zahq = object;
    }

    public static /* synthetic */ Lock zaa(zabe zabe2) {
        return zabe2.zaeo;
    }

    public static /* synthetic */ zabd zab(zabe zabe2) {
        return zabe2.zahq;
    }

    public final ConnectionResult blockingConnect() {
        Object object;
        boolean bl2;
        this.connect();
        while (bl2 = this.isConnecting()) {
            try {
                object = this.zahn;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                object = new ConnectionResult(15, null);
                return object;
            }
            object.await();
        }
        bl2 = this.isConnected();
        if (bl2) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        object = this.zahr;
        if (object != null) {
            return object;
        }
        object = new ConnectionResult(13, null);
        return object;
    }

    public final ConnectionResult blockingConnect(long l10, TimeUnit object) {
        Object object2;
        this.connect();
        l10 = ((TimeUnit)((Object)object)).toNanos(l10);
        while ((object2 = this.isConnecting()) != 0) {
            ConnectionResult connectionResult;
            long l11 = 0L;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 <= 0) {
                this.disconnect();
                int n10 = 14;
                connectionResult = new ConnectionResult(n10, null);
                return connectionResult;
            }
            try {
                object = this.zahn;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                connectionResult = new ConnectionResult(15, null);
                return connectionResult;
            }
            l10 = object.awaitNanos(l10);
        }
        boolean bl2 = this.isConnected();
        if (bl2) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahr;
        if (connectionResult != null) {
            return connectionResult;
        }
        connectionResult = new ConnectionResult(13, null);
        return connectionResult;
    }

    public final void connect() {
        this.zahq.connect();
    }

    public final void disconnect() {
        Object object = this.zahq;
        boolean bl2 = object.disconnect();
        if (bl2) {
            object = this.zahp;
            object.clear();
        }
    }

    public final void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        boolean bl2;
        String string3 = String.valueOf(string2).concat("  ");
        Object object = printWriter.append(string2).append("mState=");
        Object object2 = this.zahq;
        ((PrintWriter)object).println(object2);
        object = this.zaew.keySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Api)object.next();
            Object object3 = printWriter.append(string2);
            String string4 = ((Api)object2).getName();
            object3 = ((PrintWriter)object3).append(string4);
            string4 = ":";
            ((PrintWriter)object3).println(string4);
            object3 = this.zagz;
            object2 = ((Api)object2).getClientKey();
            object2 = (Api$Client)object3.get(object2);
            object2.dump(string3, fileDescriptor, printWriter, stringArray);
        }
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        baseImplementation$ApiMethodImpl.zau();
        return this.zahq.enqueue(baseImplementation$ApiMethodImpl);
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        baseImplementation$ApiMethodImpl.zau();
        return this.zahq.execute(baseImplementation$ApiMethodImpl);
    }

    public final ConnectionResult getConnectionResult(Api object) {
        Object object2 = this.zagz;
        boolean bl2 = object2.containsKey(object = ((Api)object).getClientKey());
        if (bl2) {
            object2 = (Api$Client)this.zagz.get(object);
            bl2 = object2.isConnected();
            if (bl2) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            object2 = this.zahp;
            bl2 = object2.containsKey(object);
            if (bl2) {
                return (ConnectionResult)this.zahp.get(object);
            }
        }
        return null;
    }

    public final boolean isConnected() {
        return this.zahq instanceof zaah;
    }

    public final boolean isConnecting() {
        return this.zahq instanceof zaak;
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void maybeSignOut() {
    }

    public final void onConnected(Bundle bundle) {
        Object object = this.zaeo;
        object.lock();
        try {
            object = this.zahq;
            object.onConnected(bundle);
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void onConnectionSuspended(int n10) {
        Object object = this.zaeo;
        object.lock();
        try {
            object = this.zahq;
            object.onConnectionSuspended(n10);
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zaa(ConnectionResult connectionResult, Api api, boolean bl2) {
        Object object = this.zaeo;
        object.lock();
        try {
            object = this.zahq;
            object.zaa(connectionResult, api, bl2);
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zaa(zabf zabf2) {
        zabf2 = this.zaho.obtainMessage(1, zabf2);
        this.zaho.sendMessage((Message)zabf2);
    }

    public final void zaaz() {
        Object object = this.zaeo;
        object.lock();
        try {
            ClientSettings clientSettings = this.zaet;
            Map map = this.zaew;
            GoogleApiAvailabilityLight googleApiAvailabilityLight = this.zaey;
            Api$AbstractClientBuilder api$AbstractClientBuilder = this.zace;
            Lock lock = this.zaeo;
            Context context = this.mContext;
            object = this.zahq = (object = new zaak(this, clientSettings, map, googleApiAvailabilityLight, api$AbstractClientBuilder, lock, context));
            object.begin();
            object = this.zahn;
            object.signalAll();
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zab(RuntimeException runtimeException) {
        runtimeException = this.zaho.obtainMessage(2, runtimeException);
        this.zaho.sendMessage((Message)runtimeException);
    }

    public final void zaba() {
        Object object = this.zaeo;
        object.lock();
        try {
            object = this.zaee;
            ((zaaw)object).zaaw();
            object = this.zahq = (object = new zaah(this));
            object.begin();
            object = this.zahn;
            object.signalAll();
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zaf(ConnectionResult object) {
        Lock lock = this.zaeo;
        lock.lock();
        try {
            this.zahr = object;
            object = this.zahq = (object = new zaav(this));
            object.begin();
            object = this.zahn;
            object.signalAll();
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zaw() {
        boolean bl2 = this.isConnected();
        if (bl2) {
            zaah zaah2 = (zaah)this.zahq;
            zaah2.zaam();
        }
    }
}

