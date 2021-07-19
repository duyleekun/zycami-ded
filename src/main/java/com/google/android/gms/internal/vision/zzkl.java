/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzkg;
import com.google.android.gms.internal.vision.zzki;
import com.google.android.gms.internal.vision.zzkj;
import com.google.android.gms.internal.vision.zzkr;
import java.util.Iterator;

public final class zzkl
extends zzkr {
    private final /* synthetic */ zzkg zzabv;

    private zzkl(zzkg zzkg2) {
        this.zzabv = zzkg2;
        super(zzkg2, null);
    }

    public /* synthetic */ zzkl(zzkg zzkg2, zzkj zzkj2) {
        this(zzkg2);
    }

    public final Iterator iterator() {
        zzkg zzkg2 = this.zzabv;
        zzki zzki2 = new zzki(zzkg2, null);
        return zzki2;
    }
}

