/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.clearcut;

import android.net.Uri;
import com.google.android.gms.internal.clearcut.zzae;
import com.google.android.gms.internal.clearcut.zzan;

public final class zzao {
    private final String zzef;
    private final Uri zzeg;
    private final String zzeh;
    private final String zzei;
    private final boolean zzej;
    private final boolean zzek;

    public zzao(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private zzao(String string2, Uri uri, String string3, String string4, boolean bl2, boolean bl3) {
        this.zzef = string2;
        this.zzeg = uri;
        this.zzeh = string3;
        this.zzei = string4;
        this.zzej = bl2;
        this.zzek = bl3;
    }

    public static /* synthetic */ String zza(zzao zzao2) {
        return zzao2.zzef;
    }

    public static /* synthetic */ Uri zzb(zzao zzao2) {
        return zzao2.zzeg;
    }

    public static /* synthetic */ String zzc(zzao zzao2) {
        return zzao2.zzeh;
    }

    public static /* synthetic */ String zzd(zzao zzao2) {
        return zzao2.zzei;
    }

    public static /* synthetic */ boolean zze(zzao zzao2) {
        return zzao2.zzek;
    }

    public static /* synthetic */ boolean zzf(zzao zzao2) {
        return zzao2.zzej;
    }

    public final zzae zza(String string2, Object object, zzan zzan2) {
        return zzae.zzb(this, string2, object, zzan2);
    }

    public final zzae zza(String string2, String string3) {
        return zzae.zzb(this, string2, null);
    }

    public final zzae zzc(String string2, boolean bl2) {
        return zzae.zzb(this, string2, false);
    }

    public final zzao zzc(String object) {
        boolean bl2 = this.zzej;
        if (!bl2) {
            String string2 = this.zzef;
            Uri uri = this.zzeg;
            String string3 = this.zzei;
            boolean bl3 = this.zzek;
            zzao zzao2 = new zzao(string2, uri, (String)object, string3, bl2, bl3);
            return zzao2;
        }
        object = new IllegalStateException("Cannot set GServices prefix and skip GServices");
        throw object;
    }

    public final zzao zzd(String string2) {
        String string3 = this.zzef;
        Uri uri = this.zzeg;
        String string4 = this.zzeh;
        boolean bl2 = this.zzej;
        boolean bl3 = this.zzek;
        zzao zzao2 = new zzao(string3, uri, string4, string2, bl2, bl3);
        return zzao2;
    }
}

