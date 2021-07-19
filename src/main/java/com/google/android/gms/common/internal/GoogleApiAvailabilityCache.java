/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.internal.Preconditions;

public class GoogleApiAvailabilityCache {
    private final SparseIntArray zaos;
    private GoogleApiAvailabilityLight zaot;

    public GoogleApiAvailabilityCache() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        this(googleApiAvailability);
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        SparseIntArray sparseIntArray;
        this.zaos = sparseIntArray = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zaot = googleApiAvailabilityLight;
    }

    public void flush() {
        this.zaos.clear();
    }

    public int getClientAvailability(Context context, Api$Client api$Client) {
        int n10;
        int n11;
        Object object;
        int n12;
        block5: {
            SparseIntArray sparseIntArray;
            int n13;
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(api$Client);
            int n14 = api$Client.requiresGooglePlayServices();
            n12 = 0;
            if (n14 == 0) {
                return 0;
            }
            object = this.zaos;
            n11 = api$Client.getMinApkVersion();
            n14 = object.get(n11, n10 = -1);
            if (n14 != n10) {
                return n14;
            }
            for (int i10 = 0; i10 < (n13 = (sparseIntArray = this.zaos).size()); ++i10) {
                SparseIntArray sparseIntArray2;
                sparseIntArray = this.zaos;
                n13 = sparseIntArray.keyAt(i10);
                if (n13 <= n11 || (n13 = (sparseIntArray2 = this.zaos).get(n13)) != 0) {
                    continue;
                }
                break block5;
            }
            n12 = n14;
        }
        if (n12 == n10) {
            object = this.zaot;
            n12 = ((GoogleApiAvailabilityLight)object).isGooglePlayServicesAvailable(context, n11);
        }
        this.zaos.put(n11, n12);
        return n12;
    }
}

