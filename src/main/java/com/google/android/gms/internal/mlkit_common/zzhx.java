/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhs;
import com.google.android.gms.internal.mlkit_common.zzhu;
import com.google.android.gms.internal.mlkit_common.zzhv;
import com.google.android.gms.internal.mlkit_common.zzid;
import java.util.Iterator;

public final class zzhx
extends zzid {
    private final /* synthetic */ zzhs zza;

    private zzhx(zzhs zzhs2) {
        this.zza = zzhs2;
        super(zzhs2, null);
    }

    public /* synthetic */ zzhx(zzhs zzhs2, zzhv zzhv2) {
        this(zzhs2);
    }

    public final Iterator iterator() {
        zzhs zzhs2 = this.zza;
        zzhu zzhu2 = new zzhu(zzhs2, null);
        return zzhu2;
    }
}

