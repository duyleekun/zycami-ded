/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager$zab;
import com.google.android.gms.common.api.internal.GoogleApiManager$zac;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zab;
import com.google.android.gms.common.api.internal.zabj;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zabm;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zah;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.api.internal.zar;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class GoogleApiManager$zaa
implements GoogleApiClient$ConnectionCallbacks,
GoogleApiClient$OnConnectionFailedListener,
zar {
    private final zai zafq;
    public final /* synthetic */ GoogleApiManager zaim;
    private final Queue zain;
    private final Api$Client zaio;
    private final Api$AnyClient zaip;
    private final zaab zaiq;
    private final Set zair;
    private final Map zais;
    private final int zait;
    private final zace zaiu;
    private boolean zaiv;
    private final List zaiw;
    private ConnectionResult zaix;

    public GoogleApiManager$zaa(GoogleApiManager object, GoogleApi googleApi) {
        Object object2;
        this.zaim = object;
        Context context = new LinkedList();
        this.zain = context;
        this.zair = context;
        super();
        this.zais = context;
        super();
        this.zaiw = context;
        context = null;
        this.zaix = null;
        Object object3 = GoogleApiManager.zaa((GoogleApiManager)object).getLooper();
        object3 = googleApi.zaa((Looper)object3, this);
        this.zaio = object3;
        int n10 = object3 instanceof SimpleClientAdapter;
        if (n10 != 0) {
            object2 = object3;
            object2 = ((SimpleClientAdapter)object3).getClient();
            this.zaip = object2;
        } else {
            this.zaip = object3;
        }
        object2 = googleApi.zak();
        this.zafq = object2;
        super();
        this.zaiq = object2;
        this.zait = n10 = googleApi.getInstanceId();
        boolean bl2 = ((Api$Client)object3).requiresSignIn();
        if (bl2) {
            context = GoogleApiManager.zab((GoogleApiManager)object);
            object = GoogleApiManager.zaa((GoogleApiManager)object);
            this.zaiu = object = googleApi.zaa(context, (Handler)object);
            return;
        }
        this.zaiu = null;
    }

    private final Feature zaa(Feature[] featureArray) {
        int n10;
        if (featureArray != null && (n10 = featureArray.length) != 0) {
            int n11;
            Feature[] featureArray2 = this.zaio.getAvailableFeatures();
            int n12 = 0;
            if (featureArray2 == null) {
                featureArray2 = new Feature[]{};
            }
            int n13 = featureArray2.length;
            ArrayMap arrayMap = new ArrayMap(n13);
            n13 = featureArray2.length;
            Object object = null;
            for (n11 = 0; n11 < n13; ++n11) {
                Object object2 = featureArray2[n11];
                String string2 = ((Feature)object2).getName();
                long l10 = ((Feature)object2).getVersion();
                object2 = l10;
                arrayMap.put(string2, object2);
            }
            n10 = featureArray.length;
            while (n12 < n10) {
                Feature feature = featureArray[n12];
                object = feature.getName();
                n11 = (int)(arrayMap.containsKey(object) ? 1 : 0);
                if (n11 != 0) {
                    long l11;
                    object = feature.getName();
                    long l12 = (Long)(object = (Long)arrayMap.get(object));
                    long l13 = l12 - (l11 = feature.getVersion());
                    n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                    if (n11 >= 0) {
                        ++n12;
                        continue;
                    }
                }
                return feature;
            }
        }
        return null;
    }

    public static /* synthetic */ void zaa(GoogleApiManager$zaa googleApiManager$zaa, GoogleApiManager$zab googleApiManager$zab) {
        googleApiManager$zaa.zaa(googleApiManager$zab);
    }

    private final void zaa(GoogleApiManager$zab object) {
        List list = this.zaiw;
        boolean bl2 = list.contains(object);
        if (!bl2) {
            return;
        }
        bl2 = this.zaiv;
        if (!bl2) {
            object = this.zaio;
            bl2 = object.isConnected();
            if (!bl2) {
                this.connect();
                return;
            }
            this.zabi();
        }
    }

    public static /* synthetic */ boolean zaa(GoogleApiManager$zaa googleApiManager$zaa, boolean bl2) {
        return googleApiManager$zaa.zac(false);
    }

    public static /* synthetic */ void zab(GoogleApiManager$zaa googleApiManager$zaa, GoogleApiManager$zab googleApiManager$zab) {
        googleApiManager$zaa.zab(googleApiManager$zab);
    }

    private final void zab(GoogleApiManager$zab object) {
        ArrayList<zab> arrayList = this.zaiw;
        boolean bl2 = arrayList.remove(object);
        if (bl2) {
            Object object2;
            zab zab2;
            int n10;
            GoogleApiManager.zaa(this.zaim).removeMessages(15, object);
            GoogleApiManager.zaa(this.zaim).removeMessages(16, object);
            object = GoogleApiManager$zab.zad((GoogleApiManager$zab)object);
            int n11 = this.zain.size();
            arrayList = new ArrayList<zab>(n11);
            Iterator iterator2 = this.zain.iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                zab2 = (zab)iterator2.next();
                boolean bl3 = zab2 instanceof zac;
                if (!bl3) continue;
                object2 = zab2;
                object2 = ((zac)zab2).zab(this);
                if (object2 == null || !(bl3 = ArrayUtils.contains((Object[])object2, object))) continue;
                arrayList.add(zab2);
            }
            n11 = arrayList.size();
            zab2 = null;
            for (n10 = 0; n10 < n11; ++n10) {
                object2 = arrayList.get(n10);
                object2 = (zab)object2;
                this.zain.remove(object2);
                UnsupportedApiCallException unsupportedApiCallException = new UnsupportedApiCallException((Feature)object);
                ((zab)object2).zaa(unsupportedApiCallException);
            }
        }
    }

    private final boolean zab(zab object) {
        int n10 = object instanceof zac;
        int n11 = 1;
        if (n10 == 0) {
            this.zac((zab)object);
            return n11 != 0;
        }
        Object object2 = object;
        object2 = (zac)object;
        Object object3 = ((zac)object2).zab(this);
        if ((object3 = this.zaa((Feature[])object3)) == null) {
            this.zac((zab)object);
            return n11 != 0;
        }
        boolean bl2 = ((zac)object2).zac(this);
        if (bl2) {
            object2 = this.zafq;
            n11 = 0;
            GoogleApiManager googleApiManager = null;
            object = new GoogleApiManager$zab((zai)object2, (Feature)object3, null);
            object2 = this.zaiw;
            n10 = object2.indexOf(object);
            int n12 = 15;
            if (n10 >= 0) {
                object = (GoogleApiManager$zab)this.zaiw.get(n10);
                GoogleApiManager.zaa(this.zaim).removeMessages(n12, object);
                object2 = GoogleApiManager.zaa(this.zaim);
                object = Message.obtain((Handler)GoogleApiManager.zaa(this.zaim), (int)n12, (Object)object);
                googleApiManager = this.zaim;
                long l10 = GoogleApiManager.zac(googleApiManager);
                object2.sendMessageDelayed((Message)object, l10);
            } else {
                this.zaiw.add(object);
                object2 = GoogleApiManager.zaa(this.zaim);
                object3 = Message.obtain((Handler)GoogleApiManager.zaa(this.zaim), (int)n12, (Object)object);
                GoogleApiManager googleApiManager2 = this.zaim;
                long l11 = GoogleApiManager.zac(googleApiManager2);
                object2.sendMessageDelayed(object3, l11);
                object2 = GoogleApiManager.zaa(this.zaim);
                object3 = GoogleApiManager.zaa(this.zaim);
                int n13 = 16;
                object = Message.obtain((Handler)object3, (int)n13, (Object)object);
                object3 = this.zaim;
                long l12 = GoogleApiManager.zad((GoogleApiManager)object3);
                object2.sendMessageDelayed((Message)object, l12);
                object = new ConnectionResult(2, null);
                n10 = (int)(this.zah((ConnectionResult)object) ? 1 : 0);
                if (n10 == 0) {
                    object2 = this.zaim;
                    n11 = this.zait;
                    ((GoogleApiManager)object2).zac((ConnectionResult)object, n11);
                }
            }
        } else {
            object = new UnsupportedApiCallException((Feature)object3);
            ((zab)object2).zaa((RuntimeException)object);
        }
        return false;
    }

    private final void zabg() {
        boolean bl2;
        this.zabl();
        Object object = ConnectionResult.RESULT_SUCCESS;
        this.zai((ConnectionResult)object);
        this.zabn();
        object = this.zais.values().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (zabw)object.next();
            Object object3 = ((zabw)object2).zajx.getRequiredFeatures();
            if ((object3 = this.zaa((Feature[])object3)) != null) {
                object.remove();
                continue;
            }
            object2 = ((zabw)object2).zajx;
            object3 = this.zaip;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                ((RegisterListenerMethod)object2).registerListener((Api$AnyClient)object3, taskCompletionSource);
            }
            catch (RemoteException remoteException) {
                object.remove();
            }
            catch (DeadObjectException deadObjectException) {
                int n10 = 1;
                this.onConnectionSuspended(n10);
                object = this.zaio;
                object.disconnect();
                break;
            }
        }
        this.zabi();
        this.zabo();
    }

    private final void zabh() {
        this.zabl();
        this.zaiv = true;
        this.zaiq.zaai();
        Handler handler = GoogleApiManager.zaa(this.zaim);
        Handler handler2 = GoogleApiManager.zaa(this.zaim);
        zai zai2 = this.zafq;
        handler2 = Message.obtain((Handler)handler2, (int)9, (Object)zai2);
        long l10 = GoogleApiManager.zac(this.zaim);
        handler.sendMessageDelayed((Message)handler2, l10);
        handler = GoogleApiManager.zaa(this.zaim);
        handler2 = GoogleApiManager.zaa(this.zaim);
        zai2 = this.zafq;
        handler2 = Message.obtain((Handler)handler2, (int)11, (Object)zai2);
        l10 = GoogleApiManager.zad(this.zaim);
        handler.sendMessageDelayed((Message)handler2, l10);
        GoogleApiManager.zae(this.zaim).flush();
    }

    private final void zabi() {
        Queue queue = this.zain;
        ArrayList arrayList = new ArrayList(queue);
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = arrayList.get(i10);
            object = (zab)object;
            Object object2 = this.zaio;
            boolean bl2 = object2.isConnected();
            if (!bl2) break;
            bl2 = this.zab((zab)object);
            if (!bl2) continue;
            object2 = this.zain;
            object2.remove(object);
        }
    }

    private final void zabn() {
        boolean bl2 = this.zaiv;
        if (bl2) {
            Handler handler = GoogleApiManager.zaa(this.zaim);
            zai zai2 = this.zafq;
            handler.removeMessages(11, (Object)zai2);
            handler = GoogleApiManager.zaa(this.zaim);
            int n10 = 9;
            zai2 = this.zafq;
            handler.removeMessages(n10, (Object)zai2);
            bl2 = false;
            handler = null;
            this.zaiv = false;
        }
    }

    private final void zabo() {
        Handler handler = GoogleApiManager.zaa(this.zaim);
        zai zai2 = this.zafq;
        int n10 = 12;
        handler.removeMessages(n10, (Object)zai2);
        handler = GoogleApiManager.zaa(this.zaim);
        zai2 = GoogleApiManager.zaa(this.zaim);
        zai zai3 = this.zafq;
        zai2 = zai2.obtainMessage(n10, zai3);
        long l10 = GoogleApiManager.zai(this.zaim);
        handler.sendMessageDelayed((Message)zai2, l10);
    }

    private final void zac(zab zab2) {
        zaab zaab2 = this.zaiq;
        boolean bl2 = this.requiresSignIn();
        zab2.zaa(zaab2, bl2);
        try {
            zab2.zaa(this);
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.onConnectionSuspended(1);
            this.zaio.disconnect();
            return;
        }
    }

    private final boolean zac(boolean bl2) {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        Object object = this.zaio;
        int n10 = object.isConnected();
        if (n10 != 0 && (n10 = (object = this.zais).size()) == 0) {
            object = this.zaiq;
            n10 = (int)(((zaab)object).zaag() ? 1 : 0);
            if (n10 != 0) {
                if (bl2) {
                    this.zabo();
                }
                return false;
            }
            this.zaio.disconnect();
            return true;
        }
        return false;
    }

    public static /* synthetic */ void zae(GoogleApiManager$zaa googleApiManager$zaa) {
        googleApiManager$zaa.zabg();
    }

    public static /* synthetic */ void zaf(GoogleApiManager$zaa googleApiManager$zaa) {
        googleApiManager$zaa.zabh();
    }

    public static /* synthetic */ Api$Client zag(GoogleApiManager$zaa googleApiManager$zaa) {
        return googleApiManager$zaa.zaio;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zah(ConnectionResult connectionResult) {
        Object object = GoogleApiManager.zabe();
        synchronized (object) {
            zai zai2;
            Object object2 = this.zaim;
            object2 = GoogleApiManager.zaf((GoogleApiManager)object2);
            if (object2 == null) return false;
            object2 = this.zaim;
            boolean bl2 = (object2 = GoogleApiManager.zag((GoogleApiManager)object2)).contains(zai2 = this.zafq);
            if (!bl2) return false;
            object2 = this.zaim;
            object2 = GoogleApiManager.zaf((GoogleApiManager)object2);
            int n10 = this.zait;
            ((zal)object2).zab(connectionResult, n10);
            return true;
        }
    }

    private final void zai(ConnectionResult connectionResult) {
        boolean bl2;
        Iterator iterator2 = this.zair.iterator();
        while (bl2 = iterator2.hasNext()) {
            zak zak2 = (zak)iterator2.next();
            String string2 = null;
            Object object = ConnectionResult.RESULT_SUCCESS;
            boolean bl3 = Objects.equal(connectionResult, object);
            if (bl3) {
                string2 = this.zaio.getEndpointPackageName();
            }
            object = this.zafq;
            zak2.zaa((zai)object, connectionResult, string2);
        }
        this.zair.clear();
    }

    public final void connect() {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        Object object = this.zaio;
        int n10 = object.isConnected();
        if (n10 == 0 && (n10 = (object = this.zaio).isConnecting()) == 0) {
            Api$Client api$Client;
            Object object2;
            object = GoogleApiManager.zae(this.zaim);
            n10 = ((GoogleApiAvailabilityCache)object).getClientAvailability((Context)(object2 = GoogleApiManager.zab(this.zaim)), api$Client = this.zaio);
            if (n10 != 0) {
                object2 = new ConnectionResult(n10, null);
                this.onConnectionFailed((ConnectionResult)object2);
                return;
            }
            object2 = this.zaim;
            api$Client = this.zaio;
            zai zai2 = this.zafq;
            object = new GoogleApiManager$zac((GoogleApiManager)object2, api$Client, zai2);
            object2 = this.zaio;
            boolean bl2 = object2.requiresSignIn();
            if (bl2) {
                object2 = this.zaiu;
                ((zace)object2).zaa((zach)object);
            }
            object2 = this.zaio;
            object2.connect((BaseGmsClient$ConnectionProgressReportCallbacks)object);
        }
    }

    public final int getInstanceId() {
        return this.zait;
    }

    public final boolean isConnected() {
        return this.zaio.isConnected();
    }

    public final void onConnected(Bundle bundle) {
        Object object;
        bundle = Looper.myLooper();
        if (bundle == (object = GoogleApiManager.zaa(this.zaim).getLooper())) {
            this.zabg();
            return;
        }
        bundle = GoogleApiManager.zaa(this.zaim);
        object = new zabj(this);
        bundle.post((Runnable)object);
    }

    public final void onConnectionFailed(ConnectionResult abstractSafeParcelable) {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        Object object = this.zaiu;
        if (object != null) {
            ((zace)object).zabs();
        }
        this.zabl();
        object = GoogleApiManager.zae(this.zaim);
        ((GoogleApiAvailabilityCache)object).flush();
        this.zai((ConnectionResult)abstractSafeParcelable);
        int n10 = ((ConnectionResult)abstractSafeParcelable).getErrorCode();
        int n11 = 4;
        if (n10 == n11) {
            abstractSafeParcelable = GoogleApiManager.zabf();
            this.zac((Status)abstractSafeParcelable);
            return;
        }
        object = this.zain;
        n10 = (int)(object.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            this.zaix = abstractSafeParcelable;
            return;
        }
        n10 = (int)(this.zah((ConnectionResult)abstractSafeParcelable) ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        object = this.zaim;
        n11 = this.zait;
        n10 = (int)(((GoogleApiManager)object).zac((ConnectionResult)abstractSafeParcelable, n11) ? 1 : 0);
        if (n10 == 0) {
            int n12 = ((ConnectionResult)abstractSafeParcelable).getErrorCode();
            if (n12 == (n10 = 18)) {
                n12 = 1;
                this.zaiv = n12;
            }
            if ((n12 = (int)(this.zaiv ? 1 : 0)) != 0) {
                abstractSafeParcelable = GoogleApiManager.zaa(this.zaim);
                object = GoogleApiManager.zaa(this.zaim);
                zai zai2 = this.zafq;
                object = Message.obtain((Handler)object, (int)9, (Object)zai2);
                long l10 = GoogleApiManager.zac(this.zaim);
                abstractSafeParcelable.sendMessageDelayed((Message)object, l10);
                return;
            }
            n10 = 17;
            String string2 = this.zafq.zan();
            int n13 = String.valueOf(string2).length() + 38;
            StringBuilder stringBuilder = new StringBuilder(n13);
            String string3 = "API: ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.append(" is not available on this device.");
            string2 = stringBuilder.toString();
            abstractSafeParcelable = new Status(n10, string2);
            this.zac((Status)abstractSafeParcelable);
        }
    }

    public final void onConnectionSuspended(int n10) {
        Object object;
        Looper looper = Looper.myLooper();
        if (looper == (object = GoogleApiManager.zaa(this.zaim).getLooper())) {
            this.zabh();
            return;
        }
        looper = GoogleApiManager.zaa(this.zaim);
        object = new zabk(this);
        looper.post((Runnable)object);
    }

    public final boolean requiresSignIn() {
        return this.zaio.requiresSignIn();
    }

    public final void resume() {
        Handler handler = GoogleApiManager.zaa(this.zaim);
        Preconditions.checkHandlerThread(handler);
        boolean bl2 = this.zaiv;
        if (bl2) {
            this.connect();
        }
    }

    public final void zaa(ConnectionResult connectionResult, Api api, boolean bl2) {
        Object object;
        api = Looper.myLooper();
        if (api == (object = GoogleApiManager.zaa(this.zaim).getLooper())) {
            this.onConnectionFailed(connectionResult);
            return;
        }
        api = GoogleApiManager.zaa(this.zaim);
        object = new zabl(this, connectionResult);
        api.post((Runnable)object);
    }

    public final void zaa(zab object) {
        boolean bl2;
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        Object object2 = this.zaio;
        boolean bl3 = object2.isConnected();
        if (bl3) {
            bl3 = this.zab((zab)object);
            if (bl3) {
                this.zabo();
                return;
            }
            this.zain.add(object);
            return;
        }
        object2 = this.zain;
        object2.add(object);
        object = this.zaix;
        if (object != null && (bl2 = ((ConnectionResult)object).hasResolution())) {
            object = this.zaix;
            this.onConnectionFailed((ConnectionResult)object);
            return;
        }
        this.connect();
    }

    public final void zaa(zak zak2) {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        this.zair.add(zak2);
    }

    public final Api$Client zaab() {
        return this.zaio;
    }

    public final void zaav() {
        Object object = GoogleApiManager.zaa(this.zaim);
        Preconditions.checkHandlerThread((Handler)object);
        int n10 = this.zaiv;
        if (n10 != 0) {
            this.zabn();
            object = GoogleApiManager.zah(this.zaim);
            Object object2 = GoogleApiManager.zab(this.zaim);
            n10 = ((GoogleApiAvailability)object).isGooglePlayServicesAvailable((Context)object2);
            int n11 = 18;
            int n12 = 8;
            if (n10 == n11) {
                object2 = "Connection timed out while waiting for Google Play services update to complete.";
                object = new Status(n12, (String)object2);
            } else {
                object2 = "API failed to connect while resuming due to an unknown error.";
                object = new Status(n12, (String)object2);
            }
            this.zac((Status)object);
            object = this.zaio;
            object.disconnect();
        }
    }

    public final void zabj() {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        Object object = GoogleApiManager.zahx;
        this.zac((Status)object);
        this.zaiq.zaah();
        object = this.zais.keySet();
        Object object2 = new ListenerHolder$ListenerKey[this.zais.size()];
        for (ListenerHolder$ListenerKey listenerHolder$ListenerKey : object.toArray((T[])object2)) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            zah zah2 = new zah(listenerHolder$ListenerKey, taskCompletionSource);
            this.zaa(zah2);
        }
        int n10 = 4;
        object = new ConnectionResult(n10);
        this.zai((ConnectionResult)object);
        object = this.zaio;
        boolean bl2 = object.isConnected();
        if (bl2) {
            object = this.zaio;
            object2 = new zabm(this);
            object.onUserSignOut((BaseGmsClient$SignOutCallbacks)object2);
        }
    }

    public final Map zabk() {
        return this.zais;
    }

    public final void zabl() {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        this.zaix = null;
    }

    public final ConnectionResult zabm() {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        return this.zaix;
    }

    public final boolean zabp() {
        return this.zac(true);
    }

    public final zad zabq() {
        zace zace2 = this.zaiu;
        if (zace2 == null) {
            return null;
        }
        return zace2.zabq();
    }

    public final void zac(Status status) {
        boolean bl2;
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        Iterator iterator2 = this.zain.iterator();
        while (bl2 = iterator2.hasNext()) {
            zab zab2 = (zab)iterator2.next();
            zab2.zaa(status);
        }
        this.zain.clear();
    }

    public final void zag(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaim));
        this.zaio.disconnect();
        this.onConnectionFailed(connectionResult);
    }
}

