/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zab;

public final class zae
extends zab {
    private final BaseImplementation$ApiMethodImpl zaco;

    public zae(int n10, BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        super(n10);
        this.zaco = baseImplementation$ApiMethodImpl;
    }

    public final void zaa(Status status) {
        this.zaco.setFailedResult(status);
    }

    public final void zaa(GoogleApiManager$zaa object) {
        BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl;
        try {
            baseImplementation$ApiMethodImpl = this.zaco;
        }
        catch (RuntimeException runtimeException) {
            ((zab)this).zaa(runtimeException);
            return;
        }
        object = ((GoogleApiManager$zaa)object).zaab();
        baseImplementation$ApiMethodImpl.run((Api$AnyClient)object);
    }

    public final void zaa(zaab zaab2, boolean bl2) {
        BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl = this.zaco;
        zaab2.zaa(baseImplementation$ApiMethodImpl, bl2);
    }

    public final void zaa(RuntimeException object) {
        String string2 = object.getClass().getSimpleName();
        object = ((Throwable)object).getLocalizedMessage();
        int n10 = String.valueOf(string2).length() + 2;
        int n11 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Status status = new Status(10, (String)object);
        this.zaco.setFailedResult(status);
    }
}

