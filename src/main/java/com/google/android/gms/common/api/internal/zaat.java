/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaal;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.internal.ClientSettings;

public final class zaat
implements GoogleApiClient$ConnectionCallbacks,
GoogleApiClient$OnConnectionFailedListener {
    private final /* synthetic */ zaak zagj;

    private zaat(zaak zaak2) {
        this.zagj = zaak2;
    }

    public /* synthetic */ zaat(zaak zaak2, zaal zaal2) {
        this(zaak2);
    }

    public final void onConnected(Bundle object) {
        object = zaak.zai(this.zagj);
        boolean bl2 = ((ClientSettings)object).isSignInClientDisconnectFixEnabled();
        if (bl2) {
            block11: {
                object = zaak.zac(this.zagj);
                object.lock();
                object = this.zagj;
                object = zaak.zaf((zaak)object);
                if (object != null) break block11;
                zaak.zac(this.zagj).unlock();
                return;
            }
            try {
                object = this.zagj;
                object = zaak.zaf((zaak)object);
                zaak zaak2 = this.zagj;
                zaar zaar2 = new zaar(zaak2);
                object.zaa(zaar2);
                return;
            }
            finally {
                zaak.zac(this.zagj).unlock();
            }
        }
        object = zaak.zaf(this.zagj);
        zaak zaak3 = this.zagj;
        zaar zaar3 = new zaar(zaak3);
        object.zaa(zaar3);
    }

    public final void onConnectionFailed(ConnectionResult object) {
        Object object2 = zaak.zac(this.zagj);
        object2.lock();
        try {
            object2 = this.zagj;
            boolean bl2 = zaak.zab((zaak)object2, (ConnectionResult)object);
            if (bl2) {
                object = this.zagj;
                zaak.zaj((zaak)object);
                object = this.zagj;
                zaak.zak((zaak)object);
            } else {
                object2 = this.zagj;
                zaak.zaa((zaak)object2, (ConnectionResult)object);
            }
            return;
        }
        finally {
            zaak.zac(this.zagj).unlock();
        }
    }

    public final void onConnectionSuspended(int n10) {
    }
}

