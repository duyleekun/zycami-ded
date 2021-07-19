/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$BaseClientBuilder;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.api.internal.zaw;
import com.google.android.gms.common.api.internal.zaz;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings$OptionalApiSettings;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zax
implements zabs {
    private final Looper zabj;
    private final GoogleApiManager zabm;
    private final Lock zaeo;
    private final ClientSettings zaet;
    private final Map zaeu;
    private final Map zaev;
    private final Map zaew;
    private final zaaw zaex;
    private final GoogleApiAvailabilityLight zaey;
    private final Condition zaez;
    private final boolean zafa;
    private final boolean zafb;
    private final Queue zafc;
    private boolean zafd;
    private Map zafe;
    private Map zaff;
    private zaaa zafg;
    private ConnectionResult zafh;

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api$AbstractClientBuilder api$AbstractClientBuilder, ArrayList arrayList, zaaw zaaw2, boolean n10) {
        int n11;
        zaw zaw2;
        boolean bl2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        zax zax2 = this;
        Object object5 = new HashMap();
        this.zaeu = object5;
        object5 = new HashMap();
        this.zaev = object5;
        this.zafc = object5;
        object5 = lock;
        this.zaeo = lock;
        this.zabj = looper;
        this.zaez = object5 = lock.newCondition();
        object5 = googleApiAvailabilityLight;
        this.zaey = googleApiAvailabilityLight;
        object5 = zaaw2;
        this.zaex = zaaw2;
        object5 = map2;
        this.zaew = map2;
        this.zaet = clientSettings;
        int n12 = n10;
        this.zafa = n10;
        HashMap<Api$AnyClientKey, Api> hashMap = new HashMap<Api$AnyClientKey, Api>();
        object5 = map2.keySet().iterator();
        while ((n12 = object5.hasNext()) != 0) {
            object4 = (Api)object5.next();
            object3 = ((Api)object4).getClientKey();
            hashMap.put((Api$AnyClientKey)object3, (Api)object4);
        }
        HashMap hashMap2 = new HashMap();
        int n13 = arrayList.size();
        float f10 = 0.0f;
        object4 = null;
        for (n12 = 0; n12 < n13; ++n12) {
            object3 = arrayList;
            object2 = arrayList.get(n12);
            object2 = (zaq)object2;
            object = ((zaq)object2).mApi;
            hashMap2.put((Api)object, object2);
        }
        Iterator iterator2 = map.entrySet().iterator();
        int n14 = 1;
        float f11 = Float.MIN_VALUE;
        n12 = n14;
        f10 = f11;
        n13 = 0;
        float f12 = 0.0f;
        object5 = null;
        int n15 = 0;
        float f13 = 0.0f;
        object3 = null;
        while (bl2 = iterator2.hasNext()) {
            Api$AbstractClientBuilder api$AbstractClientBuilder2;
            float f14;
            int n16;
            float f15;
            int n17;
            float f16;
            int n18;
            object2 = iterator2.next();
            Object object6 = object2;
            object6 = (Map.Entry)object2;
            object2 = object6.getKey();
            object2 = (Api)hashMap.get(object2);
            Object object7 = object = object6.getValue();
            object7 = (Api$Client)object;
            boolean bl3 = object7.requiresGooglePlayServices();
            if (bl3) {
                object5 = (Boolean)zax2.zaew.get(object2);
                n13 = (int)(((Boolean)object5).booleanValue() ? 1 : 0);
                n18 = n12;
                f16 = f10;
                if (n13 == 0) {
                    n17 = n14;
                    f15 = f11;
                    n16 = n14;
                    f14 = f11;
                } else {
                    n16 = n15;
                    f14 = f13;
                    n17 = n14;
                    f15 = f11;
                }
            } else {
                n17 = n13;
                f15 = f12;
                n16 = n15;
                f14 = f13;
                n18 = 0;
                f16 = 0.0f;
            }
            Object object8 = object5 = hashMap2.get(object2);
            object8 = (zaq)object5;
            object5 = api$AbstractClientBuilder2;
            object4 = context;
            object3 = object2;
            object2 = looper;
            object = object7;
            zaw2 = api$AbstractClientBuilder2;
            api$AbstractClientBuilder2 = api$AbstractClientBuilder;
            object5 = new zaw(context, (Api)object3, looper, (Api$Client)object7, (zaq)object8, clientSettings, api$AbstractClientBuilder);
            object5 = zax2.zaeu;
            object4 = (Api$AnyClientKey)object6.getKey();
            object5.put(object4, zaw2);
            n13 = (int)(object7.requiresSignIn() ? 1 : 0);
            if (n13 != 0) {
                object5 = zax2.zaev;
                object4 = (Api$AnyClientKey)object6.getKey();
                object5.put(object4, zaw2);
            }
            n13 = n17;
            f12 = f15;
            n12 = n18;
            f10 = f16;
            n15 = n16;
            f13 = f14;
        }
        if (n13 != 0 && n12 == 0 && n15 == 0) {
            n11 = n14;
        } else {
            n11 = 0;
            zaw2 = null;
        }
        zax2.zafb = n11;
        zax2.zabm = object5 = GoogleApiManager.zabc();
    }

    private final ConnectionResult zaa(Api$AnyClientKey object) {
        block9: {
            Object object2 = this.zaeo;
            object2.lock();
            object2 = this.zaeu;
            object = object2.get(object);
            object = (zaw)object;
            object2 = this.zafe;
            if (object2 == null || object == null) break block9;
            object = ((GoogleApi)object).zak();
            object = object2.get(object);
            object = (ConnectionResult)object;
            return object;
        }
        this.zaeo.unlock();
        return null;
        finally {
            this.zaeo.unlock();
        }
    }

    public static /* synthetic */ ConnectionResult zaa(zax zax2, ConnectionResult connectionResult) {
        zax2.zafh = connectionResult;
        return connectionResult;
    }

    public static /* synthetic */ Map zaa(zax zax2, Map map) {
        zax2.zafe = map;
        return map;
    }

    public static /* synthetic */ Lock zaa(zax zax2) {
        return zax2.zaeo;
    }

    private final boolean zaa(zaw object, ConnectionResult connectionResult) {
        boolean bl2 = connectionResult.isSuccess();
        if (!bl2 && !(bl2 = connectionResult.hasResolution())) {
            int n10;
            boolean bl3;
            Object object2 = this.zaew;
            Api api = ((GoogleApi)object).getApi();
            bl2 = (Boolean)(object2 = (Boolean)object2.get(api));
            if (bl2 && (bl3 = (object = ((zaw)object).zaab()).requiresGooglePlayServices()) && (bl3 = ((GoogleApiAvailabilityLight)(object = this.zaey)).isUserResolvableError(n10 = connectionResult.getErrorCode()))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean zaa(zax zax2, zaw zaw2, ConnectionResult connectionResult) {
        return zax2.zaa(zaw2, connectionResult);
    }

    public static /* synthetic */ boolean zaa(zax zax2, boolean bl2) {
        zax2.zafd = false;
        return false;
    }

    private final boolean zaac() {
        block12: {
            block13: {
                Object object = this.zaeo;
                object.lock();
                boolean bl2 = this.zafd;
                if (!bl2) break block12;
                bl2 = this.zafa;
                if (!bl2) break block12;
                object = this.zaev;
                object = object.keySet();
                try {
                    object = object.iterator();
                }
                catch (Throwable throwable) {
                    this.zaeo.unlock();
                    throw throwable;
                }
                while (true) {
                    boolean bl3 = object.hasNext();
                    if (!bl3) break block13;
                    Object object2 = object.next();
                    object2 = (Api$AnyClientKey)object2;
                    object2 = this.zaa((Api$AnyClientKey)object2);
                    if (object2 == null) break;
                    if (bl3 = ((ConnectionResult)object2).isSuccess()) continue;
                    break;
                }
                this.zaeo.unlock();
                return false;
            }
            this.zaeo.unlock();
            return true;
        }
        this.zaeo.unlock();
        return false;
    }

    private final void zaad() {
        boolean bl2;
        Object object = this.zaet;
        if (object == null) {
            Set set;
            object = this.zaex;
            ((zaaw)object).zaha = set = Collections.emptySet();
            return;
        }
        Object object2 = this.zaet.getRequiredScopes();
        object = new Object(object2);
        object2 = this.zaet.getOptionalApiSettings();
        Iterator iterator2 = object2.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object3 = (Api)iterator2.next();
            ConnectionResult connectionResult = this.getConnectionResult((Api)object3);
            if (connectionResult == null || !(bl3 = connectionResult.isSuccess())) continue;
            object3 = ((ClientSettings$OptionalApiSettings)object2.get((Object)object3)).mScopes;
            object.addAll(object3);
        }
        this.zaex.zaha = object;
    }

    private final void zaae() {
        Object object;
        boolean bl2;
        while (!(bl2 = (object = this.zafc).isEmpty())) {
            object = (BaseImplementation$ApiMethodImpl)this.zafc.remove();
            this.execute((BaseImplementation$ApiMethodImpl)object);
        }
        this.zaex.zab((Bundle)null);
    }

    private final ConnectionResult zaaf() {
        boolean bl2;
        Iterator iterator2 = this.zaeu.values().iterator();
        int n10 = 0;
        Object object = null;
        Object object2 = null;
        int n11 = 0;
        while (bl2 = iterator2.hasNext()) {
            int n12;
            int n13;
            Object object3 = (zaw)iterator2.next();
            Object object4 = ((GoogleApi)object3).getApi();
            object3 = ((GoogleApi)object3).zak();
            Object object5 = this.zafe;
            int n14 = ((ConnectionResult)(object3 = (ConnectionResult)object5.get(object3))).isSuccess();
            if (n14 != 0 || (n14 = ((Boolean)(object5 = (Boolean)this.zaew.get(object4))).booleanValue()) != 0 && (n14 = ((ConnectionResult)object3).hasResolution()) == 0 && (n14 = (int)(((GoogleApiAvailabilityLight)(object5 = this.zaey)).isUserResolvableError(n13 = ((ConnectionResult)object3).getErrorCode()) ? 1 : 0)) == 0) continue;
            n14 = ((ConnectionResult)object3).getErrorCode();
            if (n14 == (n13 = 4) && (n14 = (int)(this.zafa ? 1 : 0)) != 0) {
                object4 = ((Api)object4).zah();
                n12 = ((Api$BaseClientBuilder)object4).getPriority();
                if (object2 != null && n11 <= n12) continue;
                object2 = object3;
                n11 = n12;
                continue;
            }
            object4 = ((Api)object4).zah();
            n12 = ((Api$BaseClientBuilder)object4).getPriority();
            if (object != null && n10 <= n12) continue;
            object = object3;
            n10 = n12;
        }
        if (object != null && object2 != null && n10 > n11) {
            return object2;
        }
        return object;
    }

    public static /* synthetic */ Map zab(zax zax2, Map map) {
        zax2.zaff = map;
        return map;
    }

    private final boolean zab(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        int n10;
        int n11;
        Object object = baseImplementation$ApiMethodImpl.getClientKey();
        AbstractSafeParcelable abstractSafeParcelable = this.zaa((Api$AnyClientKey)object);
        if (abstractSafeParcelable != null && (n11 = abstractSafeParcelable.getErrorCode()) == (n10 = 4)) {
            GoogleApiManager googleApiManager = this.zabm;
            object = ((zaw)this.zaeu.get(object)).zak();
            int n12 = System.identityHashCode(this.zaex);
            object = googleApiManager.zaa((zai)object, n12);
            abstractSafeParcelable = new Status(n10, null, (PendingIntent)object);
            baseImplementation$ApiMethodImpl.setFailedResult((Status)abstractSafeParcelable);
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean zab(zax zax2) {
        return zax2.zafd;
    }

    public static /* synthetic */ Map zac(zax zax2) {
        return zax2.zaeu;
    }

    public static /* synthetic */ Map zad(zax zax2) {
        return zax2.zafe;
    }

    public static /* synthetic */ boolean zae(zax zax2) {
        return zax2.zafb;
    }

    public static /* synthetic */ ConnectionResult zaf(zax zax2) {
        return zax2.zaaf();
    }

    public static /* synthetic */ Map zag(zax zax2) {
        return zax2.zaff;
    }

    public static /* synthetic */ ConnectionResult zah(zax zax2) {
        return zax2.zafh;
    }

    public static /* synthetic */ void zai(zax zax2) {
        zax2.zaad();
    }

    public static /* synthetic */ void zaj(zax zax2) {
        zax2.zaae();
    }

    public static /* synthetic */ zaaw zak(zax zax2) {
        return zax2.zaex;
    }

    public static /* synthetic */ Condition zal(zax zax2) {
        return zax2.zaez;
    }

    public static /* synthetic */ Map zam(zax zax2) {
        return zax2.zaev;
    }

    public final ConnectionResult blockingConnect() {
        Object object;
        boolean bl2;
        this.connect();
        while (bl2 = this.isConnecting()) {
            try {
                object = this.zaez;
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
        object = this.zafh;
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
                object = this.zaez;
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
        ConnectionResult connectionResult = this.zafh;
        if (connectionResult != null) {
            return connectionResult;
        }
        connectionResult = new ConnectionResult(13, null);
        return connectionResult;
    }

    public final void connect() {
        Lock lock = this.zaeo;
        lock.lock();
        boolean bl2 = this.zafd;
        if (bl2) {
            this.zaeo.unlock();
            return;
        }
        bl2 = true;
        this.zafd = bl2;
        bl2 = false;
        lock = null;
        try {
            this.zafe = null;
            this.zaff = null;
            this.zafg = null;
            this.zafh = null;
            Object object = this.zabm;
            ((GoogleApiManager)object).zao();
            object = this.zabm;
            Object object2 = this.zaeu;
            object2 = object2.values();
            object = ((GoogleApiManager)object).zaa((Iterable)object2);
            Object object3 = this.zabj;
            object2 = new HandlerExecutor((Looper)object3);
            object3 = new zaz(this, null);
            ((Task)object).addOnCompleteListener((Executor)object2, (OnCompleteListener)object3);
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void disconnect() {
        this.zaeo.lock();
        Condition condition = null;
        try {
            boolean bl2;
            this.zafd = false;
            condition = null;
            this.zafe = null;
            this.zaff = null;
            Object object = this.zafg;
            if (object != null) {
                ((zaaa)object).cancel();
                this.zafg = null;
            }
            this.zafh = null;
            while (!(bl2 = (object = this.zafc).isEmpty())) {
                object = this.zafc;
                object = object.remove();
                object = (BaseImplementation$ApiMethodImpl)object;
                ((BasePendingResult)object).zaa((zacs)null);
                ((PendingResult)object).cancel();
            }
            condition = this.zaez;
            condition.signalAll();
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        boolean bl2 = this.zafa;
        if (bl2 && (bl2 = this.zab(baseImplementation$ApiMethodImpl))) {
            return baseImplementation$ApiMethodImpl;
        }
        bl2 = this.isConnected();
        if (!bl2) {
            this.zafc.add(baseImplementation$ApiMethodImpl);
            return baseImplementation$ApiMethodImpl;
        }
        this.zaex.zahf.zab(baseImplementation$ApiMethodImpl);
        Map map = this.zaeu;
        Api$AnyClientKey api$AnyClientKey = baseImplementation$ApiMethodImpl.getClientKey();
        return ((zaw)map.get(api$AnyClientKey)).doRead(baseImplementation$ApiMethodImpl);
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        Api$AnyClientKey api$AnyClientKey = baseImplementation$ApiMethodImpl.getClientKey();
        boolean bl2 = this.zafa;
        if (bl2 && (bl2 = this.zab(baseImplementation$ApiMethodImpl))) {
            return baseImplementation$ApiMethodImpl;
        }
        this.zaex.zahf.zab(baseImplementation$ApiMethodImpl);
        return ((zaw)this.zaeu.get(api$AnyClientKey)).doWrite(baseImplementation$ApiMethodImpl);
    }

    public final ConnectionResult getConnectionResult(Api object) {
        object = ((Api)object).getClientKey();
        return this.zaa((Api$AnyClientKey)object);
    }

    public final boolean isConnected() {
        boolean bl2;
        block4: {
            Object object;
            block3: {
                object = this.zaeo;
                object.lock();
                try {
                    object = this.zafe;
                    if (object == null) break block3;
                }
                catch (Throwable throwable) {
                    this.zaeo.unlock();
                    throw throwable;
                }
                object = this.zafh;
                if (object != null) break block3;
                bl2 = true;
                break block4;
            }
            bl2 = false;
            object = null;
        }
        this.zaeo.unlock();
        return bl2;
    }

    public final boolean isConnecting() {
        boolean bl2;
        block4: {
            Object object;
            block3: {
                object = this.zaeo;
                object.lock();
                try {
                    object = this.zafe;
                    if (object != null) break block3;
                }
                catch (Throwable throwable) {
                    this.zaeo.unlock();
                    throw throwable;
                }
                bl2 = this.zafd;
                if (!bl2) break block3;
                bl2 = true;
                break block4;
            }
            bl2 = false;
            object = null;
        }
        this.zaeo.unlock();
        return bl2;
    }

    public final boolean maybeSignIn(SignInConnectionListener object) {
        block15: {
            Object object2 = this.zaeo;
            object2.lock();
            boolean bl2 = this.zafd;
            if (!bl2) break block15;
            bl2 = this.zaac();
            if (bl2) break block15;
            object2 = this.zabm;
            ((GoogleApiManager)object2).zao();
            this.zafg = object2 = new zaaa(this, (SignInConnectionListener)object);
            object = this.zabm;
            object2 = this.zaev;
            object2 = object2.values();
            object = ((GoogleApiManager)object).zaa((Iterable)object2);
            Object object3 = this.zabj;
            object2 = new HandlerExecutor((Looper)object3);
            object3 = this.zafg;
            ((Task)object).addOnCompleteListener((Executor)object2, (OnCompleteListener)object3);
            return true;
        }
        this.zaeo.unlock();
        return false;
        finally {
            this.zaeo.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void maybeSignOut() {
        Object object = this.zaeo;
        object.lock();
        try {
            boolean bl2;
            int n10;
            Object object2;
            object = this.zabm;
            ((GoogleApiManager)object).maybeSignOut();
            object = this.zafg;
            if (object != null) {
                ((zaaa)object).cancel();
                object = null;
                this.zafg = null;
            }
            if ((object = this.zaff) == null) {
                object2 = this.zaev;
                n10 = object2.size();
                this.zaff = object = new ArrayMap(n10);
            }
            n10 = 4;
            object = new ConnectionResult(n10);
            object2 = this.zaev;
            object2 = object2.values();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (zaw)object3;
                Map map = this.zaff;
                object3 = ((GoogleApi)object3).zak();
                map.put(object3, object);
            }
            object = this.zafe;
            if (object == null) return;
            object2 = this.zaff;
            object.putAll(object2);
            return;
        }
        finally {
            this.zaeo.unlock();
        }
    }

    public final void zaw() {
    }
}

