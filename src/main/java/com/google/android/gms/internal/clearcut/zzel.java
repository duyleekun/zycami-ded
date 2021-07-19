/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzei;
import com.google.android.gms.internal.clearcut.zzej;
import com.google.android.gms.internal.clearcut.zzek;
import com.google.android.gms.internal.clearcut.zzer;
import java.util.Iterator;

public final class zzel
extends zzer {
    private final /* synthetic */ zzei zzos;

    private zzel(zzei zzei2) {
        this.zzos = zzei2;
        super(zzei2, null);
    }

    public /* synthetic */ zzel(zzei zzei2, zzej zzej2) {
        this(zzei2);
    }

    public final Iterator iterator() {
        zzei zzei2 = this.zzos;
        zzek zzek2 = new zzek(zzei2, null);
        return zzek2;
    }
}

