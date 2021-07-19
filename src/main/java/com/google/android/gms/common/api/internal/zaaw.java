/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$Builder;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaax;
import com.google.android.gms.common.api.internal.zaay;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabb;
import com.google.android.gms.common.api.internal.zabc;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zacp;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.api.internal.zax;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager$GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zaaw
extends GoogleApiClient
implements zabt {
    private final Context mContext;
    private final Looper zabj;
    private final int zacb;
    private final GoogleApiAvailability zacd;
    private final Api$AbstractClientBuilder zace;
    private boolean zach;
    private final Lock zaeo;
    private final ClientSettings zaet;
    private final Map zaew;
    public final Queue zafc;
    private final GmsClientEventManager zags;
    private zabs zagt;
    private volatile boolean zagu;
    private long zagv;
    private long zagw;
    private final zabb zagx;
    private zabq zagy;
    public final Map zagz;
    public Set zaha;
    private final ListenerHolders zahb;
    private final ArrayList zahc;
    private Integer zahd;
    public Set zahe;
    public final zacp zahf;
    private final GmsClientEventManager$GmsClientEventState zahg;

    public zaaw(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api$AbstractClientBuilder api$AbstractClientBuilder, Map map, List list, List list2, Map map2, int n10, int n11, ArrayList arrayList, boolean bl2) {
        GmsClientEventManager gmsClientEventManager;
        boolean bl3;
        zaaw zaaw2 = this;
        Object object = looper;
        Object object2 = map2;
        int n12 = n10;
        Object object3 = null;
        this.zagt = null;
        Object object4 = new LinkedList();
        this.zafc = object4;
        boolean bl4 = ClientLibraryUtils.isPackageSide();
        long l10 = bl4 ? 10000L : 120000L;
        zaaw2.zagv = l10;
        zaaw2.zagw = l10 = 5000L;
        zaaw2.zaha = object4;
        zaaw2.zahb = object4 = new ListenerHolders();
        zaaw2.zahd = null;
        zaaw2.zahe = null;
        object3 = new zaax(this);
        zaaw2.zahg = object3;
        object4 = context;
        zaaw2.mContext = context;
        object4 = lock;
        zaaw2.zaeo = lock;
        bl4 = false;
        zaaw2.zach = false;
        zaaw2.zags = object4 = new GmsClientEventManager(looper, (GmsClientEventManager$GmsClientEventState)object3);
        zaaw2.zabj = object;
        super(this, looper);
        zaaw2.zagx = object3;
        object = googleApiAvailability;
        zaaw2.zacd = googleApiAvailability;
        zaaw2.zacb = n12;
        if (n12 >= 0) {
            object = n11;
            zaaw2.zahd = object;
        }
        object = map;
        zaaw2.zaew = map;
        zaaw2.zagz = object2;
        object = arrayList;
        zaaw2.zahc = arrayList;
        super((Map)object2);
        zaaw2.zahf = object;
        object = list.iterator();
        while (bl3 = object.hasNext()) {
            object2 = (GoogleApiClient$ConnectionCallbacks)object.next();
            gmsClientEventManager = zaaw2.zags;
            gmsClientEventManager.registerConnectionCallbacks((GoogleApiClient$ConnectionCallbacks)object2);
        }
        object = list2.iterator();
        while (bl3 = object.hasNext()) {
            object2 = (GoogleApiClient$OnConnectionFailedListener)object.next();
            gmsClientEventManager = zaaw2.zags;
            gmsClientEventManager.registerConnectionFailedListener((GoogleApiClient$OnConnectionFailedListener)object2);
        }
        object2 = clientSettings;
        zaaw2.zaet = clientSettings;
        object = api$AbstractClientBuilder;
        zaaw2.zace = api$AbstractClientBuilder;
    }

    private final void resume() {
        block4: {
            Lock lock = this.zaeo;
            lock.lock();
            boolean bl2 = this.zagu;
            if (!bl2) break block4;
            this.zaau();
        }
        return;
        finally {
            this.zaeo.unlock();
        }
    }

    public static int zaa(Iterable object, boolean bl2) {
        int n10;
        object = object.iterator();
        int n11 = 0;
        int n12 = 0;
        while (true) {
            boolean bl3 = object.hasNext();
            n10 = 1;
            if (!bl3) break;
            Api$Client api$Client = (Api$Client)object.next();
            boolean bl4 = api$Client.requiresSignIn();
            if (bl4) {
                n11 = n10;
            }
            if (!(bl3 = api$Client.providesSignIn())) continue;
            n12 = n10;
        }
        if (n11 != 0) {
            if (n12 != 0 && bl2) {
                return 2;
            }
            return n10;
        }
        return 3;
    }

    private final void zaa(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean bl2) {
        PendingResult pendingResult = Common.zapi.zaa(googleApiClient);
        zaba zaba2 = new zaba(this, statusPendingResult, bl2, googleApiClient);
        pendingResult.setResultCallback(zaba2);
    }

    public static /* synthetic */ void zaa(zaaw zaaw2) {
        zaaw2.resume();
    }

    public static /* synthetic */ void zaa(zaaw zaaw2, GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean bl2) {
        zaaw2.zaa(googleApiClient, statusPendingResult, true);
    }

    private final void zaau() {
        this.zags.enableCallbacks();
        this.zagt.connect();
    }

    private final void zaav() {
        block4: {
            Lock lock = this.zaeo;
            lock.lock();
            boolean bl2 = this.zaaw();
            if (!bl2) break block4;
            this.zaau();
        }
        return;
        finally {
            this.zaeo.unlock();
        }
    }

    public static /* synthetic */ void zab(zaaw zaaw2) {
        zaaw2.zaav();
    }

    public static /* synthetic */ Context zac(zaaw zaaw2) {
        return zaaw2.mContext;
    }

    private final void zae(int n10) {
        Object object;
        block12: {
            block15: {
                block16: {
                    zabe zabe2;
                    Object object2;
                    Object object3;
                    int n11;
                    Object object4;
                    int n12;
                    block14: {
                        int n13;
                        block13: {
                            int n14;
                            int n15;
                            block11: {
                                block10: {
                                    object = this.zahd;
                                    if (object != null) break block10;
                                    object = n10;
                                    this.zahd = object;
                                    break block11;
                                }
                                n12 = (Integer)object;
                                if (n12 != n10) break block12;
                            }
                            object = this.zagt;
                            if (object != null) {
                                return;
                            }
                            object = this.zagz.values().iterator();
                            n13 = 0;
                            object4 = null;
                            n11 = 0;
                            object3 = null;
                            while (true) {
                                n15 = object.hasNext();
                                n14 = 1;
                                if (n15 == 0) break;
                                object2 = (Api$Client)object.next();
                                boolean bl2 = object2.requiresSignIn();
                                if (bl2) {
                                    n13 = n14;
                                }
                                if ((n15 = (int)(object2.providesSignIn() ? 1 : 0)) == 0) continue;
                                n11 = n14;
                            }
                            object = this.zahd;
                            n12 = (Integer)object;
                            if (n12 == n14) break block13;
                            n15 = 2;
                            if (n12 == n15 && n13 != 0) {
                                n12 = (int)(this.zach ? 1 : 0);
                                if (n12 != 0) {
                                    zax zax2;
                                    object4 = this.mContext;
                                    object3 = this.zaeo;
                                    object2 = this.zabj;
                                    GoogleApiAvailability googleApiAvailability = this.zacd;
                                    Map map = this.zagz;
                                    ClientSettings clientSettings = this.zaet;
                                    Map map2 = this.zaew;
                                    Api$AbstractClientBuilder api$AbstractClientBuilder = this.zace;
                                    ArrayList arrayList = this.zahc;
                                    object = zax2;
                                    zaaw zaaw2 = this;
                                    zax2 = new zax((Context)object4, (Lock)object3, (Looper)object2, googleApiAvailability, map, clientSettings, map2, api$AbstractClientBuilder, arrayList, this, true);
                                    this.zagt = zax2;
                                    return;
                                }
                                object = this.mContext;
                                object3 = this.zaeo;
                                object2 = this.zabj;
                                GoogleApiAvailability googleApiAvailability = this.zacd;
                                Map map = this.zagz;
                                ClientSettings clientSettings = this.zaet;
                                Map map3 = this.zaew;
                                Api$AbstractClientBuilder api$AbstractClientBuilder = this.zace;
                                ArrayList arrayList = this.zahc;
                                object4 = this;
                                this.zagt = object = zas.zaa((Context)object, this, (Lock)object3, (Looper)object2, googleApiAvailability, map, clientSettings, map3, api$AbstractClientBuilder, arrayList);
                                return;
                            }
                            break block14;
                        }
                        if (n13 == 0) break block15;
                        if (n11 != 0) break block16;
                    }
                    if ((n12 = (int)(this.zach ? 1 : 0)) != 0 && n11 == 0) {
                        zax zax3;
                        object4 = this.mContext;
                        object3 = this.zaeo;
                        object2 = this.zabj;
                        GoogleApiAvailability googleApiAvailability = this.zacd;
                        Map map = this.zagz;
                        ClientSettings clientSettings = this.zaet;
                        Map map4 = this.zaew;
                        Api$AbstractClientBuilder api$AbstractClientBuilder = this.zace;
                        ArrayList arrayList = this.zahc;
                        object = zax3;
                        zaaw zaaw3 = this;
                        zax3 = new zax((Context)object4, (Lock)object3, (Looper)object2, googleApiAvailability, map, clientSettings, map4, api$AbstractClientBuilder, arrayList, this, false);
                        this.zagt = zax3;
                        return;
                    }
                    object4 = this.mContext;
                    object2 = this.zaeo;
                    Looper looper = this.zabj;
                    GoogleApiAvailability googleApiAvailability = this.zacd;
                    Map map = this.zagz;
                    ClientSettings clientSettings = this.zaet;
                    Map map5 = this.zaew;
                    Api$AbstractClientBuilder api$AbstractClientBuilder = this.zace;
                    ArrayList arrayList = this.zahc;
                    object = zabe2;
                    object3 = this;
                    zabe2 = new zabe((Context)object4, this, (Lock)object2, looper, googleApiAvailability, map, clientSettings, map5, api$AbstractClientBuilder, arrayList, this);
                    this.zagt = zabe2;
                    return;
                }
                object = new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                throw object;
            }
            object = new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            throw object;
        }
        String string2 = zaaw.zaf(n10);
        String string3 = zaaw.zaf(this.zahd);
        int n16 = String.valueOf(string2).length() + 51;
        int n17 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n16 += n17);
        stringBuilder.append("Cannot use sign-in mode: ");
        stringBuilder.append(string2);
        stringBuilder.append(". Mode was already set to ");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    private static String zaf(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return "UNKNOWN";
                }
                return "SIGN_IN_MODE_NONE";
            }
            return "SIGN_IN_MODE_OPTIONAL";
        }
        return "SIGN_IN_MODE_REQUIRED";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ConnectionResult blockingConnect() {
        int n10;
        Object object = Looper.myLooper();
        Looper looper = Looper.getMainLooper();
        int n11 = 1;
        if (object != looper) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        String string2 = "blockingConnect must not be called on the UI thread";
        Preconditions.checkState(n10 != 0, string2);
        object = this.zaeo;
        object.lock();
        try {
            block13: {
                block11: {
                    int n12;
                    block12: {
                        block10: {
                            n10 = this.zacb;
                            if (n10 < 0) break block10;
                            object = this.zahd;
                            if (object == null) {
                                n11 = 0;
                            }
                            object = "Sign-in mode should have been set explicitly by auto-manage.";
                            Preconditions.checkState(n11 != 0, object);
                            break block11;
                        }
                        object = this.zahd;
                        if (object != null) break block12;
                        object = this.zagz;
                        object = object.values();
                        n10 = zaaw.zaa((Iterable)object, false);
                        this.zahd = object = Integer.valueOf(n10);
                        break block11;
                    }
                    n10 = (Integer)object;
                    if (n10 == (n12 = 2)) break block13;
                }
                object = this.zahd;
                n10 = (Integer)object;
                this.zae(n10);
                object = this.zags;
                ((GmsClientEventManager)object).enableCallbacks();
                object = this.zagt;
                object = object.blockingConnect();
                return object;
            }
            String string3 = "Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.";
            object = new IllegalStateException(string3);
            throw object;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ConnectionResult blockingConnect(long l10, TimeUnit timeUnit) {
        int n10;
        Looper looper;
        Object object = Looper.myLooper();
        if (object != (looper = Looper.getMainLooper())) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        String string2 = "blockingConnect must not be called on the UI thread";
        Preconditions.checkState(n10 != 0, string2);
        Preconditions.checkNotNull((Object)timeUnit, "TimeUnit must not be null");
        object = this.zaeo;
        object.lock();
        try {
            block11: {
                block10: {
                    int n11;
                    block9: {
                        object = this.zahd;
                        if (object != null) break block9;
                        object = this.zagz;
                        object = object.values();
                        n10 = zaaw.zaa((Iterable)object, false);
                        this.zahd = object = Integer.valueOf(n10);
                        break block10;
                    }
                    n10 = (Integer)object;
                    if (n10 == (n11 = 2)) break block11;
                }
                object = this.zahd;
                n10 = (Integer)object;
                this.zae(n10);
                object = this.zags;
                ((GmsClientEventManager)object).enableCallbacks();
                object = this.zagt;
                ConnectionResult connectionResult = object.blockingConnect(l10, timeUnit);
                return connectionResult;
            }
            String string3 = "Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.";
            IllegalStateException illegalStateException = new IllegalStateException(string3);
            throw illegalStateException;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    /*
     * WARNING - void declaration
     */
    public final PendingResult clearDefaultAccountAndReconnect() {
        void var2_5;
        Preconditions.checkState(((GoogleApiClient)this).isConnected(), "GoogleApiClient is not connected yet.");
        Object object = this.zahd;
        int bl2 = (Integer)object;
        AtomicReference<Object> atomicReference = null;
        int n10 = 2;
        if (bl2 != n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        Preconditions.checkState((boolean)var2_5, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        object = new StatusPendingResult(this);
        Object object2 = this.zagz;
        Object object3 = Common.CLIENT_KEY;
        boolean bl5 = object2.containsKey(object3);
        if (bl5) {
            this.zaa(this, (StatusPendingResult)object, false);
        } else {
            atomicReference = new AtomicReference<Object>();
            object2 = new zaay(this, atomicReference, (StatusPendingResult)object);
            object3 = new zaaz(this, (StatusPendingResult)object);
            Object object4 = this.mContext;
            GoogleApiClient$Builder googleApiClient$Builder = new GoogleApiClient$Builder((Context)object4);
            object4 = Common.API;
            googleApiClient$Builder = googleApiClient$Builder.addApi((Api)object4);
            object2 = googleApiClient$Builder.addConnectionCallbacks((GoogleApiClient$ConnectionCallbacks)object2).addOnConnectionFailedListener((GoogleApiClient$OnConnectionFailedListener)object3);
            object3 = this.zagx;
            object2 = ((GoogleApiClient$Builder)object2).setHandler((Handler)object3).build();
            atomicReference.set(object2);
            ((GoogleApiClient)object2).connect();
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void connect() {
        Object object = this.zaeo;
        object.lock();
        try {
            String string2;
            block11: {
                int n10;
                block9: {
                    int n11;
                    block10: {
                        block8: {
                            n10 = this.zacb;
                            n11 = 0;
                            string2 = null;
                            if (n10 < 0) break block8;
                            object = this.zahd;
                            if (object != null) {
                                n11 = 1;
                            }
                            object = "Sign-in mode should have been set explicitly by auto-manage.";
                            Preconditions.checkState(n11 != 0, object);
                            break block9;
                        }
                        object = this.zahd;
                        if (object != null) break block10;
                        object = this.zagz;
                        object = object.values();
                        n10 = zaaw.zaa(object, false);
                        this.zahd = object = Integer.valueOf(n10);
                        break block9;
                    }
                    n10 = (Integer)object;
                    if (n10 == (n11 = 2)) break block11;
                }
                object = this.zahd;
                n10 = (Integer)object;
                ((GoogleApiClient)this).connect(n10);
                return;
            }
            string2 = "Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.";
            object = new IllegalStateException(string2);
            throw object;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void connect(int n10) {
        Object object = this.zaeo;
        object.lock();
        int n11 = 3;
        int n12 = 1;
        if (n10 != n11 && n10 != n12 && n10 != (n11 = 2)) {
            n12 = 0;
        }
        n11 = 33;
        try {
            StringBuilder stringBuilder = new StringBuilder(n11);
            object = "Illegal sign-in mode: ";
            stringBuilder.append((String)object);
            stringBuilder.append(n10);
            object = stringBuilder.toString();
            Preconditions.checkArgument(n12 != 0, object);
            this.zae(n10);
            this.zaau();
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void disconnect() {
        boolean bl2;
        Object object = this.zaeo;
        object.lock();
        object = this.zahf;
        ((zacp)object).release();
        object = this.zagt;
        if (object != null) {
            object.disconnect();
        }
        object = this.zahb;
        ((ListenerHolders)object).release();
        object = this.zafc;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (BaseImplementation$ApiMethodImpl)object2;
            ((BasePendingResult)object2).zaa((zacs)null);
            ((PendingResult)object2).cancel();
        }
        object = this.zafc;
        object.clear();
        object = this.zagt;
        if (object == null) {
            this.zaeo.unlock();
            return;
        }
        this.zaaw();
        object = this.zags;
        ((GmsClientEventManager)object).disableCallbacks();
        return;
    }

    public final void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Object object = printWriter.append(string2).append("mContext=");
        Object object2 = this.mContext;
        ((PrintWriter)object).println(object2);
        object = printWriter.append(string2).append("mResuming=");
        int n10 = this.zagu;
        ((PrintWriter)object).print(n10 != 0);
        object = printWriter.append(" mWorkQueue.size()=");
        n10 = this.zafc.size();
        ((PrintWriter)object).print(n10);
        object = this.zahf;
        object2 = printWriter.append(" mUnconsumedApiCalls.size()=");
        int n11 = ((zacp)object).zakz.size();
        ((PrintWriter)object2).println(n11);
        object = this.zagt;
        if (object != null) {
            object.dump(string2, fileDescriptor, printWriter, stringArray);
        }
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        boolean bl2;
        Object object = baseImplementation$ApiMethodImpl.getClientKey();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkArgument(bl2, "This task can not be enqueued (it's probably a Batch or malformed)");
        object = this.zagz;
        Object object2 = baseImplementation$ApiMethodImpl.getClientKey();
        bl2 = object.containsKey(object2);
        object2 = baseImplementation$ApiMethodImpl.getApi();
        object2 = object2 != null ? baseImplementation$ApiMethodImpl.getApi().getName() : "the API";
        int n10 = String.valueOf(object2).length() + 65;
        StringBuilder stringBuilder = new StringBuilder(n10);
        String string2 = "GoogleApiClient is not configured to use ";
        stringBuilder.append(string2);
        stringBuilder.append((String)object2);
        stringBuilder.append(" required for this call.");
        object2 = stringBuilder.toString();
        Preconditions.checkArgument(bl2, object2);
        object = this.zaeo;
        object.lock();
        try {
            object = this.zagt;
            if (object == null) {
                object = this.zafc;
                object.add(baseImplementation$ApiMethodImpl);
                return baseImplementation$ApiMethodImpl;
            }
            baseImplementation$ApiMethodImpl = object.enqueue(baseImplementation$ApiMethodImpl);
            return baseImplementation$ApiMethodImpl;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl object) {
        Object object2;
        block20: {
            block21: {
                boolean bl2;
                object2 = ((BaseImplementation$ApiMethodImpl)object).getClientKey();
                if (object2 != null) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    object2 = null;
                }
                Preconditions.checkArgument(bl2, "This task can not be executed (it's probably a Batch or malformed)");
                object2 = this.zagz;
                Object object3 = ((BaseImplementation$ApiMethodImpl)object).getClientKey();
                bl2 = object2.containsKey(object3);
                object3 = ((BaseImplementation$ApiMethodImpl)object).getApi();
                object3 = object3 != null ? ((BaseImplementation$ApiMethodImpl)object).getApi().getName() : "the API";
                int n10 = String.valueOf(object3).length() + 65;
                StringBuilder stringBuilder = new StringBuilder(n10);
                String string2 = "GoogleApiClient is not configured to use ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object3);
                stringBuilder.append(" required for this call.");
                object3 = stringBuilder.toString();
                Preconditions.checkArgument(bl2, object3);
                object2 = this.zaeo;
                object2.lock();
                object2 = this.zagt;
                if (object2 == null) break block20;
                bl2 = this.zagu;
                if (!bl2) break block21;
                object2 = this.zafc;
                object2.add(object);
                while (true) {
                    object2 = this.zafc;
                    break;
                }
                {
                    bl2 = object2.isEmpty();
                    if (bl2) break;
                    object2 = this.zafc;
                    object2 = object2.remove();
                    object2 = (BaseImplementation$ApiMethodImpl)object2;
                    object3 = this.zahf;
                    ((zacp)object3).zab((BasePendingResult)object2);
                    object3 = Status.RESULT_INTERNAL_ERROR;
                    ((BaseImplementation$ApiMethodImpl)object2).setFailedResult((Status)object3);
                    continue;
                }
                this.zaeo.unlock();
                return object;
            }
            object2 = this.zagt;
            object = object2.execute((BaseImplementation$ApiMethodImpl)object);
            return object;
        }
        object2 = "GoogleApiClient is not connected yet.";
        try {
            object = new IllegalStateException((String)object2);
            throw object;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final Api$Client getClient(Api$AnyClientKey object) {
        object = (Api$Client)this.zagz.get(object);
        Preconditions.checkNotNull(object, "Appropriate Api was not requested.");
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ConnectionResult getConnectionResult(Api object) {
        Object object2 = "GoogleApiClientImpl";
        Object object3 = this.zaeo;
        object3.lock();
        try {
            boolean bl2 = ((GoogleApiClient)this).isConnected();
            if (!bl2 && !(bl2 = this.zagu)) {
                object2 = "Cannot invoke getConnectionResult unless GoogleApiClient is connected";
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object3 = this.zagz;
            Api$AnyClientKey api$AnyClientKey = ((Api)object).getClientKey();
            bl2 = object3.containsKey(api$AnyClientKey);
            if (bl2) {
                object3 = this.zagt;
                if ((object3 = object3.getConnectionResult((Api)object)) != null) return object3;
                bl2 = this.zagu;
                if (bl2) {
                    object = ConnectionResult.RESULT_SUCCESS;
                    return object;
                }
                object3 = this.zaay();
                Log.w((String)object2, (String)object3);
                object = ((Api)object).getName();
                object = String.valueOf(object);
                object3 = " requested in getConnectionResult is not connected but is not present in the failed  connections map";
                object = ((String)object).concat((String)object3);
                object3 = new Exception();
                Log.wtf((String)object2, (String)object, (Throwable)object3);
                int n10 = 8;
                bl2 = false;
                object3 = null;
                object = new ConnectionResult(n10, null);
                return object;
            }
            object = ((Api)object).getName();
            object = String.valueOf(object);
            object3 = " was never registered with GoogleApiClient";
            object = ((String)object).concat((String)object3);
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zabj;
    }

    public final boolean hasApi(Api object) {
        Map map = this.zagz;
        object = ((Api)object).getClientKey();
        return map.containsKey(object);
    }

    public final boolean hasConnectedApi(Api object) {
        boolean bl2;
        boolean bl3 = ((GoogleApiClient)this).isConnected();
        if (!bl3) {
            return false;
        }
        Map map = this.zagz;
        object = ((Api)object).getClientKey();
        return (object = (Api$Client)map.get(object)) != null && (bl2 = object.isConnected());
    }

    public final boolean isConnected() {
        boolean bl2;
        zabs zabs2 = this.zagt;
        return zabs2 != null && (bl2 = zabs2.isConnected());
    }

    public final boolean isConnecting() {
        boolean bl2;
        zabs zabs2 = this.zagt;
        return zabs2 != null && (bl2 = zabs2.isConnecting());
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        return this.zags.isConnectionCallbacksRegistered(googleApiClient$ConnectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        return this.zags.isConnectionFailedListenerRegistered(googleApiClient$OnConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        boolean bl2;
        zabs zabs2 = this.zagt;
        return zabs2 != null && (bl2 = zabs2.maybeSignIn(signInConnectionListener));
    }

    public final void maybeSignOut() {
        zabs zabs2 = this.zagt;
        if (zabs2 != null) {
            zabs2.maybeSignOut();
        }
    }

    public final void reconnect() {
        ((GoogleApiClient)this).disconnect();
        ((GoogleApiClient)this).connect();
    }

    public final void registerConnectionCallbacks(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        this.zags.registerConnectionCallbacks(googleApiClient$ConnectionCallbacks);
    }

    public final void registerConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this.zags.registerConnectionFailedListener(googleApiClient$OnConnectionFailedListener);
    }

    public final ListenerHolder registerListener(Object object) {
        Object object2 = this.zaeo;
        object2.lock();
        try {
            object2 = this.zahb;
            Looper looper = this.zabj;
            String string2 = "NO_TYPE";
            object = ((ListenerHolders)object2).zaa(object, looper, string2);
            return object;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void stopAutoManage(FragmentActivity object) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity)object);
        int n10 = this.zacb;
        if (n10 >= 0) {
            object = zaj.zaa(lifecycleActivity);
            int n11 = this.zacb;
            ((zaj)object).zaa(n11);
            return;
        }
        object = new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        throw object;
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks) {
        this.zags.unregisterConnectionCallbacks(googleApiClient$ConnectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this.zags.unregisterConnectionFailedListener(googleApiClient$OnConnectionFailedListener);
    }

    public final void zaa(zacm zacm2) {
        HashSet<zacm> hashSet = this.zaeo;
        hashSet.lock();
        try {
            hashSet = this.zahe;
            if (hashSet == null) {
                this.zahe = hashSet = new HashSet<zacm>();
            }
            hashSet = this.zahe;
            hashSet.add(zacm2);
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final boolean zaaw() {
        boolean bl2 = this.zagu;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        this.zagu = false;
        this.zagx.removeMessages(2);
        Object object = this.zagx;
        bl3 = true;
        object.removeMessages((int)(bl3 ? 1 : 0));
        object = this.zagy;
        if (object != null) {
            ((zabq)((Object)object)).unregister();
            bl2 = false;
            object = null;
            this.zagy = null;
        }
        return bl3;
    }

    public final boolean zaax() {
        Object object;
        block4: {
            object = this.zaeo;
            object.lock();
            object = this.zahe;
            if (object != null) break block4;
            this.zaeo.unlock();
            return false;
        }
        try {
            boolean bl2 = object.isEmpty() ^ true;
            return bl2;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final String zaay() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ((GoogleApiClient)this).dump("", null, printWriter, null);
        return stringWriter.toString();
    }

    public final void zab(int n10, boolean bl2) {
        Object object;
        int n11 = 2;
        int n12 = 1;
        if (n10 == n12 && !bl2 && !(bl2 = this.zagu)) {
            this.zagu = n12;
            object = this.zagy;
            if (object == null && !(bl2 = ClientLibraryUtils.isPackageSide())) {
                object = this.zacd;
                Context context = this.mContext.getApplicationContext();
                zabc zabc2 = new zabc(this);
                object = ((GoogleApiAvailability)object).zaa(context, zabc2);
                this.zagy = object;
            }
            object = this.zagx;
            Message message = object.obtainMessage(n12);
            long l10 = this.zagv;
            object.sendMessageDelayed(message, l10);
            object = this.zagx;
            message = object.obtainMessage(n11);
            l10 = this.zagw;
            object.sendMessageDelayed(message, l10);
        }
        this.zahf.zabx();
        this.zags.onUnintentionalDisconnection(n10);
        object = this.zags;
        object.disableCallbacks();
        if (n10 == n11) {
            this.zaau();
        }
    }

    public final void zab(Bundle bundle) {
        Object object;
        boolean bl2;
        while (!(bl2 = (object = this.zafc).isEmpty())) {
            object = (BaseImplementation$ApiMethodImpl)this.zafc.remove();
            ((GoogleApiClient)this).execute((BaseImplementation$ApiMethodImpl)object);
        }
        this.zags.onConnectionSuccess(bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zab(zacm object) {
        Object object2 = this.zaeo;
        object2.lock();
        try {
            object2 = this.zahe;
            String string2 = "GoogleApiClientImpl";
            if (object2 == null) {
                object = "Attempted to remove pending transform when no transforms are registered.";
                object2 = new Exception();
                Log.wtf((String)string2, (String)object, (Throwable)object2);
                return;
            }
            boolean bl2 = object2.remove(object);
            if (!bl2) {
                object = "Failed to remove pending transform - this may lead to memory leaks!";
                object2 = new Exception();
                Log.wtf((String)string2, (String)object, (Throwable)object2);
                return;
            }
            bl2 = this.zaax();
            if (bl2) return;
            object = this.zagt;
            object.zaw();
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zac(ConnectionResult object) {
        Object object2 = this.zacd;
        Context context = this.mContext;
        int n10 = ((ConnectionResult)object).getErrorCode();
        boolean bl2 = ((GoogleApiAvailabilityLight)object2).isPlayServicesPossiblyUpdating(context, n10);
        if (!bl2) {
            this.zaaw();
        }
        if (!(bl2 = this.zagu)) {
            object2 = this.zags;
            ((GmsClientEventManager)object2).onConnectionFailure((ConnectionResult)object);
            object = this.zags;
            ((GmsClientEventManager)object).disableCallbacks();
        }
    }
}

