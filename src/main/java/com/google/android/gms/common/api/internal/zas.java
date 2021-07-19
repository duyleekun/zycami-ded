/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.api.internal.zau;
import com.google.android.gms.common.api.internal.zav;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public final class zas
implements zabs {
    private final Context mContext;
    private final Looper zabj;
    private final zaaw zaee;
    private final zabe zaef;
    private final zabe zaeg;
    private final Map zaeh;
    private final Set zaei;
    private final Api$Client zaej;
    private Bundle zaek;
    private ConnectionResult zael;
    private ConnectionResult zaem;
    private boolean zaen;
    private final Lock zaeo;
    private int zaep;

    private zas(Context context, zaaw zaaw2, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, Api$AbstractClientBuilder api$AbstractClientBuilder, Api$Client api$Client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        Object object;
        zas zas2 = this;
        Map map5 = new Map();
        map5 = Collections.newSetFromMap(map5);
        this.zaei = map5;
        this.zael = null;
        this.zaem = null;
        this.zaen = false;
        this.zaep = 0;
        Object object2 = context;
        this.mContext = context;
        this.zaee = zaaw2;
        Object object3 = lock;
        this.zaeo = lock;
        this.zabj = looper;
        Object object4 = api$Client;
        this.zaej = api$Client;
        Object object5 = new zau(this, null);
        object4 = object;
        Object object6 = context;
        zau zau2 = object5;
        object5 = map4;
        map5 = object;
        object3 = zau2;
        object = new zabe(context, zaaw2, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, zau2);
        this.zaef = object;
        boolean bl2 = false;
        object3 = new zav(this, null);
        object4 = map5;
        object5 = map3;
        object = api$AbstractClientBuilder;
        map5 = new Map(context, zaaw2, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, api$AbstractClientBuilder, arrayList, (zabt)object3);
        this.zaeg = map5;
        map5 = new Map();
        object2 = map2.keySet().iterator();
        while (bl2 = object2.hasNext()) {
            object4 = (Api$AnyClientKey)object2.next();
            object6 = zas2.zaef;
            ((SimpleArrayMap)((Object)map5)).put(object4, object6);
        }
        object2 = map.keySet().iterator();
        while (bl2 = object2.hasNext()) {
            object4 = (Api$AnyClientKey)object2.next();
            object6 = zas2.zaeg;
            ((SimpleArrayMap)((Object)map5)).put(object4, object6);
        }
        zas2.zaeh = map5 = Collections.unmodifiableMap(map5);
    }

    public static /* synthetic */ ConnectionResult zaa(zas zas2, ConnectionResult connectionResult) {
        zas2.zael = connectionResult;
        return connectionResult;
    }

    public static zas zaa(Context context, zaaw zaaw2, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api$AbstractClientBuilder api$AbstractClientBuilder, ArrayList arrayList) {
        zas zas2;
        Object object;
        boolean bl2;
        Object object2;
        Object object3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator iterator2 = map.entrySet().iterator();
        boolean bl3 = false;
        Object object4 = null;
        Api$Client api$Client = null;
        while (bl3 = iterator2.hasNext()) {
            object4 = iterator2.next();
            object2 = (Api$Client)object4.getValue();
            bl2 = object2.providesSignIn();
            if (bl2) {
                api$Client = object2;
            }
            if (bl2 = object2.requiresSignIn()) {
                object4 = (Api$AnyClientKey)object4.getKey();
                arrayMap.put(object4, object2);
                continue;
            }
            object4 = (Api$AnyClientKey)object4.getKey();
            arrayMap2.put(object4, object2);
        }
        int n10 = arrayMap.isEmpty() ^ 1;
        object4 = "CompositeGoogleApiClient should not be used without any APIs that require sign-in.";
        Preconditions.checkState(n10 != 0, object4);
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        iterator2 = map2.keySet().iterator();
        while (bl3 = iterator2.hasNext()) {
            object4 = (Api)((Object)iterator2.next());
            object2 = ((Api)object4).getClientKey();
            bl2 = arrayMap.containsKey(object2);
            if (bl2) {
                object2 = (Boolean)object3.get(object4);
                arrayMap3.put(object4, object2);
                continue;
            }
            boolean bl4 = arrayMap2.containsKey(object2);
            if (bl4) {
                object2 = (Boolean)object3.get(object4);
                arrayMap4.put(object4, object2);
                continue;
            }
            object3 = new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            throw object3;
        }
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        int n11 = arrayList.size();
        iterator2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            object4 = arrayList;
            object2 = arrayList.get(n10);
            object2 = (zaq)object2;
            object = ((zaq)object2).mApi;
            bl2 = arrayMap3.containsKey(object);
            if (bl2) {
                arrayList2.add(object2);
                continue;
            }
            object = ((zaq)object2).mApi;
            bl2 = arrayMap4.containsKey(object);
            if (bl2) {
                arrayList3.add(object2);
                continue;
            }
            object3 = new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            throw object3;
        }
        object3 = zas2;
        iterator2 = context;
        object4 = zaaw2;
        object2 = lock;
        object = looper;
        zas2 = new zas(context, zaaw2, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, api$AbstractClientBuilder, api$Client, arrayList2, arrayList3, arrayMap3, arrayMap4);
        return zas2;
    }

    public static /* synthetic */ Lock zaa(zas zas2) {
        return zas2.zaeo;
    }

    private final void zaa(int n10, boolean bl2) {
        this.zaee.zab(n10, bl2);
        this.zaem = null;
        this.zael = null;
    }

    private final void zaa(Bundle bundle) {
        Bundle bundle2 = this.zaek;
        if (bundle2 == null) {
            this.zaek = bundle;
            return;
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void zaa(ConnectionResult var1_1) {
        var2_2 = this.zaep;
        var3_3 = 1;
        if (var2_2 == var3_3) ** GOTO lbl14
        var3_3 = 2;
        if (var2_2 != var3_3) {
            var1_1 = new Exception();
            var4_4 = "CompositeGAC";
            var5_6 = "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor";
            Log.wtf((String)var4_4, (String)var5_6, (Throwable)var1_1);
        } else {
            var4_5 = this.zaee;
            var4_5.zac((ConnectionResult)var1_1);
lbl14:
            // 2 sources

            this.zay();
        }
        this.zaep = 0;
    }

    public static /* synthetic */ void zaa(zas zas2, int n10, boolean bl2) {
        zas2.zaa(n10, bl2);
    }

    public static /* synthetic */ void zaa(zas zas2, Bundle bundle) {
        zas2.zaa(bundle);
    }

    private final boolean zaa(BaseImplementation$ApiMethodImpl object) {
        object = ((BaseImplementation$ApiMethodImpl)object).getClientKey();
        Preconditions.checkArgument(this.zaeh.containsKey(object), "GoogleApiClient is not configured to use the API required for this call.");
        object = (zabe)this.zaeh.get(object);
        zabe zabe2 = this.zaeg;
        return object.equals(zabe2);
    }

    public static /* synthetic */ boolean zaa(zas zas2, boolean bl2) {
        zas2.zaen = bl2;
        return bl2;
    }

    private final PendingIntent zaaa() {
        Api$Client api$Client = this.zaej;
        if (api$Client == null) {
            return null;
        }
        api$Client = this.mContext;
        int n10 = System.identityHashCode(this.zaee);
        Intent intent = this.zaej.getSignInIntent();
        return PendingIntent.getActivity((Context)api$Client, (int)n10, (Intent)intent, (int)0x8000000);
    }

    public static /* synthetic */ ConnectionResult zab(zas zas2, ConnectionResult connectionResult) {
        zas2.zaem = connectionResult;
        return connectionResult;
    }

    public static /* synthetic */ void zab(zas zas2) {
        zas2.zax();
    }

    private static boolean zab(ConnectionResult connectionResult) {
        boolean bl2;
        return connectionResult != null && (bl2 = connectionResult.isSuccess());
    }

    public static /* synthetic */ boolean zac(zas zas2) {
        return zas2.zaen;
    }

    public static /* synthetic */ ConnectionResult zad(zas zas2) {
        return zas2.zaem;
    }

    public static /* synthetic */ zabe zae(zas zas2) {
        return zas2.zaeg;
    }

    public static /* synthetic */ zabe zaf(zas zas2) {
        return zas2.zaef;
    }

    /*
     * Unable to fully structure code
     */
    private final void zax() {
        block9: {
            block7: {
                block8: {
                    var1_1 = this.zael;
                    var2_2 = zas.zab((ConnectionResult)var1_1);
                    if (var2_2 == 0) break block7;
                    var1_1 = this.zaem;
                    var2_2 = zas.zab((ConnectionResult)var1_1);
                    var3_3 = 1;
                    if (var2_2 != 0 || (var2_2 = this.zaz()) != 0) break block8;
                    var1_1 = this.zaem;
                    if (var1_1 != null) {
                        var4_4 = this.zaep;
                        if (var4_4 == var3_3) {
                            this.zay();
                            return;
                        }
                        this.zaa((ConnectionResult)var1_1);
                        this.zaef.disconnect();
                        return;
                    }
                    break block9;
                }
                var2_2 = this.zaep;
                if (var2_2 == var3_3) ** GOTO lbl32
                var3_3 = 2;
                if (var2_2 != var3_3) {
                    var1_1 = new AssertionError();
                    var5_6 = "CompositeGAC";
                    var6_9 = "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor";
                    Log.wtf((String)var5_6, (String)var6_9, (Throwable)var1_1);
                } else {
                    var1_1 = this.zaee;
                    var5_7 = this.zaek;
                    var1_1.zab(var5_7);
lbl32:
                    // 2 sources

                    this.zay();
                }
                this.zaep = 0;
                return;
            }
            var1_1 = this.zael;
            if (var1_1 != null && (var2_2 = zas.zab((ConnectionResult)(var1_1 = this.zaem))) != 0) {
                this.zaeg.disconnect();
                var1_1 = this.zael;
                this.zaa((ConnectionResult)var1_1);
                return;
            }
            var1_1 = this.zael;
            if (var1_1 != null && (var5_8 = this.zaem) != null) {
                var6_10 = this.zaeg;
                var4_5 = var6_10.zahs;
                var7_11 = this.zaef;
                var8_12 = var7_11.zahs;
                if (var4_5 < var8_12) {
                    var1_1 = var5_8;
                }
                this.zaa((ConnectionResult)var1_1);
            }
        }
    }

    private final void zay() {
        boolean bl2;
        Iterator iterator2 = this.zaei.iterator();
        while (bl2 = iterator2.hasNext()) {
            SignInConnectionListener signInConnectionListener = (SignInConnectionListener)iterator2.next();
            signInConnectionListener.onComplete();
        }
        this.zaei.clear();
    }

    private final boolean zaz() {
        int n10;
        int n11;
        ConnectionResult connectionResult = this.zaem;
        return connectionResult != null && (n11 = connectionResult.getErrorCode()) == (n10 = 4);
    }

    public final ConnectionResult blockingConnect() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final ConnectionResult blockingConnect(long l10, TimeUnit timeUnit) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void connect() {
        this.zaep = 2;
        this.zaen = false;
        this.zaem = null;
        this.zael = null;
        this.zaef.connect();
        this.zaeg.connect();
    }

    public final void disconnect() {
        this.zaem = null;
        this.zael = null;
        this.zaep = 0;
        this.zaef.disconnect();
        this.zaeg.disconnect();
        this.zay();
    }

    public final void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Object object = printWriter.append(string2).append("authClient");
        String string3 = ":";
        ((PrintWriter)object).println(string3);
        object = this.zaeg;
        String string4 = String.valueOf(string2);
        String string5 = "  ";
        string4 = string4.concat(string5);
        ((zabe)object).dump(string4, fileDescriptor, printWriter, stringArray);
        printWriter.append(string2).append("anonClient").println(string3);
        object = this.zaef;
        string2 = String.valueOf(string2).concat(string5);
        ((zabe)object).dump(string2, fileDescriptor, printWriter, stringArray);
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        boolean bl2 = this.zaa(baseImplementation$ApiMethodImpl);
        if (bl2) {
            bl2 = this.zaz();
            if (bl2) {
                PendingIntent pendingIntent = this.zaaa();
                Status status = new Status(4, null, pendingIntent);
                baseImplementation$ApiMethodImpl.setFailedResult(status);
                return baseImplementation$ApiMethodImpl;
            }
            return this.zaeg.enqueue(baseImplementation$ApiMethodImpl);
        }
        return this.zaef.enqueue(baseImplementation$ApiMethodImpl);
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        boolean bl2 = this.zaa(baseImplementation$ApiMethodImpl);
        if (bl2) {
            bl2 = this.zaz();
            if (bl2) {
                PendingIntent pendingIntent = this.zaaa();
                Status status = new Status(4, null, pendingIntent);
                baseImplementation$ApiMethodImpl.setFailedResult(status);
                return baseImplementation$ApiMethodImpl;
            }
            return this.zaeg.execute(baseImplementation$ApiMethodImpl);
        }
        return this.zaef.execute(baseImplementation$ApiMethodImpl);
    }

    public final ConnectionResult getConnectionResult(Api object) {
        Object object2 = this.zaeh;
        Object object3 = ((Api)object).getClientKey();
        boolean bl2 = (object2 = (zabe)object2.get(object3)).equals(object3 = this.zaeg);
        if (bl2) {
            bl2 = this.zaz();
            if (bl2) {
                object3 = this.zaaa();
                object = new ConnectionResult(4, (PendingIntent)object3);
                return object;
            }
            return this.zaeg.getConnectionResult((Api)object);
        }
        return this.zaef.getConnectionResult((Api)object);
    }

    public final boolean isConnected() {
        int n10;
        block8: {
            block7: {
                Object object = this.zaeo;
                object.lock();
                try {
                    object = this.zaef;
                }
                catch (Throwable throwable) {
                    this.zaeo.unlock();
                    throw throwable;
                }
                boolean n11 = ((zabe)object).isConnected();
                n10 = 1;
                if (!n11) break block7;
                object = this.zaeg;
                boolean bl2 = ((zabe)object).isConnected();
                if (bl2) break block8;
                boolean bl3 = this.zaz();
                if (bl3) break block8;
                int n12 = this.zaep;
                if (n12 == n10) break block8;
            }
            n10 = 0;
        }
        this.zaeo.unlock();
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isConnecting() {
        Lock lock = this.zaeo;
        lock.lock();
        try {
            void var2_6;
            int bl2 = this.zaep;
            int n10 = 2;
            if (bl2 == n10) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
                lock = null;
            }
            this.zaeo.unlock();
            return (boolean)var2_6;
        }
        catch (Throwable throwable) {
            this.zaeo.unlock();
            throw throwable;
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener object) {
        block12: {
            int n10;
            boolean bl2;
            block13: {
                Object object2;
                block11: {
                    object2 = this.zaeo;
                    object2.lock();
                    bl2 = this.isConnecting();
                    if (bl2) break block11;
                    bl2 = this.isConnected();
                    if (!bl2) break block12;
                }
                object2 = this.zaeg;
                bl2 = ((zabe)object2).isConnected();
                if (bl2) break block12;
                object2 = this.zaei;
                object2.add(object);
                n10 = this.zaep;
                bl2 = true;
                if (n10 != 0) break block13;
                this.zaep = (int)(bl2 ? 1 : 0);
            }
            n10 = 0;
            object = null;
            this.zaem = null;
            object = this.zaeg;
            ((zabe)object).connect();
            return bl2;
        }
        this.zaeo.unlock();
        return false;
        finally {
            this.zaeo.unlock();
        }
    }

    public final void maybeSignOut() {
        Object object = this.zaeo;
        object.lock();
        try {
            boolean bl2 = this.isConnecting();
            Object object2 = this.zaeg;
            ((zabe)object2).disconnect();
            int n10 = 4;
            this.zaem = object2 = new ConnectionResult(n10);
            if (bl2) {
                object2 = this.zabj;
                object = new zap((Looper)object2);
                object2 = new zat(this);
                object.post((Runnable)object2);
            } else {
                this.zay();
            }
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zaw() {
        this.zaef.zaw();
        this.zaeg.zaw();
    }
}

