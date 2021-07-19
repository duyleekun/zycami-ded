/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.vision;

import android.net.Uri;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzbp;
import com.google.android.gms.internal.vision.zzcw;

public final class zzbo {
    public final String zzgt;
    public final Uri zzgu;
    public final String zzgv;
    public final String zzgw;
    public final boolean zzgx;
    public final boolean zzgy;
    public final boolean zzgz;
    public final boolean zzha;
    public final zzcw zzhb;

    public zzbo(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzbo(String string2, Uri uri, String string3, String string4, boolean bl2, boolean bl3, boolean bl4, boolean bl5, zzcw zzcw2) {
        this.zzgt = string2;
        this.zzgu = uri;
        this.zzgv = string3;
        this.zzgw = string4;
        this.zzgx = bl2;
        this.zzgy = bl3;
        this.zzgz = bl4;
        this.zzha = bl5;
        this.zzhb = zzcw2;
    }

    public final zzbi zza(String string2, Object object, zzbp zzbp2) {
        return zzbi.zzb(this, string2, object, zzbp2, true);
    }

    public final zzbo zzf(String object) {
        boolean bl2 = this.zzgx;
        if (!bl2) {
            String string2 = this.zzgt;
            Uri uri = this.zzgu;
            String string3 = this.zzgw;
            boolean bl3 = this.zzgy;
            boolean bl4 = this.zzgz;
            boolean bl5 = this.zzha;
            zzcw zzcw2 = this.zzhb;
            zzbo zzbo2 = new zzbo(string2, uri, (String)object, string3, bl2, bl3, bl4, bl5, zzcw2);
            return zzbo2;
        }
        object = new IllegalStateException("Cannot set GServices prefix and skip GServices");
        throw object;
    }
}

