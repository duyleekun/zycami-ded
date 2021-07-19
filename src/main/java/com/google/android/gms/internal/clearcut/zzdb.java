/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzcy;
import com.google.android.gms.internal.clearcut.zzcz;
import com.google.android.gms.internal.clearcut.zzfd;

public final class zzdb
extends zzcy {
    private zzdb() {
        super(null);
    }

    public /* synthetic */ zzdb(zzcz zzcz2) {
        this();
    }

    private static zzcn zzc(Object object, long l10) {
        return (zzcn)zzfd.zzo(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzdb.zzc(object, l10).zzv();
    }

    public final void zza(Object object, Object object2, long l10) {
        zzcn zzcn2 = zzdb.zzc(object, l10);
        object2 = zzdb.zzc(object2, l10);
        int n10 = zzcn2.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = zzcn2.zzu();
            if (!bl2) {
                zzcn2 = zzcn2.zzi(n11 += n10);
            }
            zzcn2.addAll(object2);
        }
        if (n10 > 0) {
            object2 = zzcn2;
        }
        zzfd.zza(object, l10, object2);
    }
}

