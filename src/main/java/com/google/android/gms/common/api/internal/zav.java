/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zas;
import com.google.android.gms.common.api.internal.zat;

public final class zav
implements zabt {
    private final /* synthetic */ zas zaeq;

    private zav(zas zas2) {
        this.zaeq = zas2;
    }

    public /* synthetic */ zav(zas zas2, zat zat2) {
        this(zas2);
    }

    public final void zab(int n10, boolean bl2) {
        Object object = zas.zaa(this.zaeq);
        object.lock();
        try {
            object = this.zaeq;
            boolean bl3 = zas.zac((zas)object);
            if (bl3) {
                object = this.zaeq;
                zas.zaa((zas)object, false);
                object = this.zaeq;
                zas.zaa((zas)object, n10, bl2);
                return;
            }
            zabs zabs2 = this.zaeq;
            bl3 = true;
            zas.zaa((zas)zabs2, bl3);
            zabs2 = this.zaeq;
            zabs2 = zas.zaf((zas)zabs2);
            ((zabe)zabs2).onConnectionSuspended(n10);
            return;
        }
        finally {
            zas.zaa(this.zaeq).unlock();
        }
    }

    public final void zab(Bundle object) {
        object = zas.zaa(this.zaeq);
        object.lock();
        try {
            object = this.zaeq;
            ConnectionResult connectionResult = ConnectionResult.RESULT_SUCCESS;
            zas.zab((zas)object, connectionResult);
            object = this.zaeq;
            zas.zab((zas)object);
            return;
        }
        finally {
            zas.zaa(this.zaeq).unlock();
        }
    }

    public final void zac(ConnectionResult object) {
        Object object2 = zas.zaa(this.zaeq);
        object2.lock();
        try {
            object2 = this.zaeq;
            zas.zab((zas)object2, (ConnectionResult)object);
            object = this.zaeq;
            zas.zab((zas)object);
            return;
        }
        finally {
            zas.zaa(this.zaeq).unlock();
        }
    }
}

