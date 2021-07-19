/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.zaai;
import com.google.android.gms.common.api.internal.zaaj;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zacp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

public final class zaah
implements zabd {
    private final zabe zaft;
    private boolean zafu = false;

    public zaah(zabe zabe2) {
        this.zaft = zabe2;
    }

    public static /* synthetic */ zabe zaa(zaah zaah2) {
        return zaah2.zaft;
    }

    public final void begin() {
    }

    public final void connect() {
        boolean bl2 = this.zafu;
        if (bl2) {
            bl2 = false;
            this.zafu = false;
            zabe zabe2 = this.zaft;
            zaaj zaaj2 = new zaaj(this, this);
            zabe2.zaa(zaaj2);
        }
    }

    public final boolean disconnect() {
        boolean bl2 = this.zafu;
        if (bl2) {
            return false;
        }
        Object object = this.zaft.zaee;
        bl2 = ((zaaw)object).zaax();
        boolean bl3 = true;
        if (bl2) {
            this.zafu = bl3;
            object = this.zaft.zaee.zahe.iterator();
            while (bl3 = object.hasNext()) {
                zacm zacm2 = (zacm)object.next();
                zacm2.zabv();
            }
            return false;
        }
        this.zaft.zaf(null);
        return bl3;
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        return this.execute(baseImplementation$ApiMethodImpl);
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        int n10;
        Object object;
        Object object2;
        block22: {
            object2 = this.zaft;
            object2 = ((zabe)object2).zaee;
            object2 = ((zaaw)object2).zahf;
            ((zacp)object2).zab(baseImplementation$ApiMethodImpl);
            object2 = this.zaft;
            object2 = ((zabe)object2).zaee;
            object = baseImplementation$ApiMethodImpl.getClientKey();
            object2 = ((zaaw)object2).zagz;
            object2 = object2.get(object);
            object2 = (Api$Client)object2;
            object = "Appropriate Api was not requested.";
            Preconditions.checkNotNull(object2, object);
            n10 = object2.isConnected();
            if (n10 != 0) break block22;
            object = this.zaft;
            object = ((zabe)object).zahp;
            Api$AnyClientKey api$AnyClientKey = baseImplementation$ApiMethodImpl.getClientKey();
            n10 = object.containsKey(api$AnyClientKey);
            if (n10 == 0) break block22;
            n10 = 17;
            object2 = new Status(n10);
            baseImplementation$ApiMethodImpl.setFailedResult((Status)object2);
        }
        if ((n10 = object2 instanceof SimpleClientAdapter) != 0) {
            object2 = (SimpleClientAdapter)object2;
            object2 = ((SimpleClientAdapter)object2).getClient();
        }
        try {
            baseImplementation$ApiMethodImpl.run((Api$AnyClient)object2);
        }
        catch (DeadObjectException deadObjectException) {
            object2 = this.zaft;
            object = new zaai(this, this);
            ((zabe)object2).zaa((zabf)object);
        }
        return baseImplementation$ApiMethodImpl;
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int n10) {
        this.zaft.zaf(null);
        zabt zabt2 = this.zaft.zaht;
        boolean bl2 = this.zafu;
        zabt2.zab(n10, bl2);
    }

    public final void zaa(ConnectionResult connectionResult, Api api, boolean bl2) {
    }

    public final void zaam() {
        boolean bl2 = this.zafu;
        if (bl2) {
            bl2 = false;
            this.zafu = false;
            zacp zacp2 = this.zaft.zaee.zahf;
            zacp2.release();
            this.disconnect();
        }
    }
}

