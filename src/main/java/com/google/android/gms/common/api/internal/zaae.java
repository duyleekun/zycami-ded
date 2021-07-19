/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.internal.Preconditions;

public class zaae
extends zal {
    private GoogleApiManager zabm;
    private final ArraySet zafp;

    private zaae(LifecycleFragment object) {
        super((LifecycleFragment)object);
        this.zafp = object = new ArraySet();
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public static void zaa(Activity object, GoogleApiManager googleApiManager, zai zai2) {
        String string2;
        zaae zaae2 = (zaae)(object = LifecycleCallback.getFragment((Activity)object)).getCallbackOrNull(string2 = "ConnectionlessLifecycleHelper", zaae.class);
        if (zaae2 == null) {
            zaae2 = new zaae((LifecycleFragment)object);
        }
        zaae2.zabm = googleApiManager;
        Preconditions.checkNotNull(zai2, "ApiKey cannot be null");
        zaae2.zafp.add(zai2);
        googleApiManager.zaa(zaae2);
    }

    private final void zaak() {
        Object object = this.zafp;
        boolean bl2 = ((ArraySet)object).isEmpty();
        if (!bl2) {
            object = this.zabm;
            ((GoogleApiManager)object).zaa(this);
        }
    }

    public void onResume() {
        super.onResume();
        this.zaak();
    }

    public void onStart() {
        super.onStart();
        this.zaak();
    }

    public void onStop() {
        super.onStop();
        this.zabm.zab(this);
    }

    public final void zaa(ConnectionResult connectionResult, int n10) {
        this.zabm.zaa(connectionResult, n10);
    }

    public final ArraySet zaaj() {
        return this.zafp;
    }

    public final void zao() {
        this.zabm.zao();
    }
}

