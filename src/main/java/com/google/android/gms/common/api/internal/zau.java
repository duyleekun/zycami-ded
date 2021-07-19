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

public final class zau
implements zabt {
    private final /* synthetic */ zas zaeq;

    private zau(zas zas2) {
        this.zaeq = zas2;
    }

    public /* synthetic */ zau(zas zas2, zat zat2) {
        this(zas2);
    }

    public final void zab(int n10, boolean bl2) {
        Object object;
        block16: {
            object = zas.zaa(this.zaeq);
            object.lock();
            object = this.zaeq;
            boolean bl3 = zas.zac((zas)object);
            if (bl3) break block16;
            object = this.zaeq;
            object = zas.zad((zas)object);
            if (object == null) break block16;
            object = this.zaeq;
            object = zas.zad((zas)object);
            bl3 = ((ConnectionResult)object).isSuccess();
            if (!bl3) break block16;
            zabs zabs2 = this.zaeq;
            bl3 = true;
            zas.zaa((zas)zabs2, bl3);
            zabs2 = this.zaeq;
            zabs2 = zas.zae((zas)zabs2);
            ((zabe)zabs2).onConnectionSuspended(n10);
            return;
        }
        object = this.zaeq;
        zas.zaa((zas)object, false);
        object = this.zaeq;
        try {
            zas.zaa((zas)object, n10, bl2);
            zas.zaa(this.zaeq).unlock();
            return;
        }
        finally {
            zas.zaa(this.zaeq).unlock();
        }
    }

    public final void zab(Bundle object) {
        Object object2 = zas.zaa(this.zaeq);
        object2.lock();
        try {
            object2 = this.zaeq;
            zas.zaa((zas)object2, object);
            object = this.zaeq;
            object2 = ConnectionResult.RESULT_SUCCESS;
            zas.zaa((zas)object, (ConnectionResult)object2);
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
            zas.zaa((zas)object2, (ConnectionResult)object);
            object = this.zaeq;
            zas.zab((zas)object);
            return;
        }
        finally {
            zas.zaa(this.zaeq).unlock();
        }
    }
}

