/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaas;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

public final class zaar
extends zac {
    private final WeakReference zagk;

    public zaar(zaak zaak2) {
        WeakReference<zaak> weakReference;
        this.zagk = weakReference = new WeakReference<zaak>(zaak2);
    }

    public final void zab(zaj zaj2) {
        zaak zaak2 = (zaak)this.zagk.get();
        if (zaak2 == null) {
            return;
        }
        zabe zabe2 = zaak.zad(zaak2);
        zaas zaas2 = new zaas(this, zaak2, zaak2, zaj2);
        zabe2.zaa(zaas2);
    }
}

