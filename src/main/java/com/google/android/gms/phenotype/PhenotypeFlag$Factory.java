/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.phenotype.PhenotypeFlag;

public class PhenotypeFlag$Factory {
    private final String zzax;
    private final Uri zzay;
    private final String zzaz;
    private final String zzba;
    private final boolean zzbb;
    private final boolean zzbc;

    public PhenotypeFlag$Factory(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private PhenotypeFlag$Factory(String string2, Uri uri, String string3, String string4, boolean bl2, boolean bl3) {
        this.zzax = string2;
        this.zzay = uri;
        this.zzaz = string3;
        this.zzba = string4;
        this.zzbb = bl2;
        this.zzbc = bl3;
    }

    public static /* synthetic */ String zza(PhenotypeFlag$Factory phenotypeFlag$Factory) {
        return phenotypeFlag$Factory.zzax;
    }

    public static /* synthetic */ Uri zzb(PhenotypeFlag$Factory phenotypeFlag$Factory) {
        return phenotypeFlag$Factory.zzay;
    }

    public static /* synthetic */ String zzc(PhenotypeFlag$Factory phenotypeFlag$Factory) {
        return phenotypeFlag$Factory.zzaz;
    }

    public static /* synthetic */ String zzd(PhenotypeFlag$Factory phenotypeFlag$Factory) {
        return phenotypeFlag$Factory.zzba;
    }

    public static /* synthetic */ boolean zze(PhenotypeFlag$Factory phenotypeFlag$Factory) {
        return phenotypeFlag$Factory.zzbc;
    }

    public static /* synthetic */ boolean zzf(PhenotypeFlag$Factory phenotypeFlag$Factory) {
        return phenotypeFlag$Factory.zzbb;
    }

    public PhenotypeFlag createFlag(String string2, String string3) {
        return PhenotypeFlag.zzb(this, string2, string3);
    }

    public PhenotypeFlag$Factory withGservicePrefix(String object) {
        boolean bl2 = this.zzbb;
        if (!bl2) {
            String string2 = this.zzax;
            Uri uri = this.zzay;
            String string3 = this.zzba;
            boolean bl3 = this.zzbc;
            PhenotypeFlag$Factory phenotypeFlag$Factory = new PhenotypeFlag$Factory(string2, uri, (String)object, string3, bl2, bl3);
            return phenotypeFlag$Factory;
        }
        object = new IllegalStateException("Cannot set GServices prefix and skip GServices");
        throw object;
    }

    public PhenotypeFlag$Factory withPhenotypePrefix(String string2) {
        String string3 = this.zzax;
        Uri uri = this.zzay;
        String string4 = this.zzaz;
        boolean bl2 = this.zzbb;
        boolean bl3 = this.zzbc;
        PhenotypeFlag$Factory phenotypeFlag$Factory = new PhenotypeFlag$Factory(string3, uri, string4, string2, bl2, bl3);
        return phenotypeFlag$Factory;
    }
}

