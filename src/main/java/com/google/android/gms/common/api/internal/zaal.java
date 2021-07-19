/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.internal.zaak;

public final class zaal
implements Runnable {
    private final /* synthetic */ zaak zagj;

    public zaal(zaak zaak2) {
        this.zagj = zaak2;
    }

    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight = zaak.zab(this.zagj);
        Context context = zaak.zaa(this.zagj);
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}

