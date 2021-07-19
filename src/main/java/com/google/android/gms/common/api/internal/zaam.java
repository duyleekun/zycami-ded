/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zaam
implements BaseGmsClient$ConnectionProgressReportCallbacks {
    private final Api mApi;
    private final boolean zaec;
    private final WeakReference zagk;

    public zaam(zaak zaak2, Api api, boolean bl2) {
        WeakReference<zaak> weakReference;
        this.zagk = weakReference = new WeakReference<zaak>(zaak2);
        this.mApi = api;
        this.zaec = bl2;
    }

    public static /* synthetic */ boolean zaa(zaam zaam2) {
        return zaam2.zaec;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        boolean bl2;
        boolean bl3;
        Looper looper;
        zaak zaak2 = (zaak)this.zagk.get();
        if (zaak2 == null) {
            return;
        }
        Object object = Looper.myLooper();
        if (object == (looper = ((GoogleApiClient)zaak.zad((zaak)zaak2).zaee).getLooper())) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        String string2 = "onReportServiceBinding must be called on the GoogleApiClient handler thread";
        Preconditions.checkState(bl3, string2);
        object = zaak.zac(zaak2);
        object.lock();
        bl3 = zaak.zaa(zaak2, 0);
        if (!bl3) {
            zaak.zac(zaak2).unlock();
            return;
        }
        bl3 = connectionResult.isSuccess();
        if (!bl3) {
            object = this.mApi;
            boolean bl4 = this.zaec;
            zaak.zaa(zaak2, connectionResult, (Api)object, bl4);
        }
        if (!(bl2 = zaak.zal(zaak2))) return;
        zaak.zak(zaak2);
        return;
    }
}

