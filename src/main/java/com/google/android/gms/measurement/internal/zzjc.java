/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkk;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public final class zzjc
extends zzjv {
    private String zzb;
    private boolean zzc;
    private long zzd;

    public zzjc(zzkd zzkd2) {
        super(zzkd2);
    }

    public final boolean zzaz() {
        return false;
    }

    public final Pair zzc(String string2, zzaf object) {
        boolean bl2;
        zzlc.zzb();
        zzae zzae2 = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zzay;
        boolean bl3 = zzae2.zzn(null, zzdv2);
        if (bl3 && !(bl2 = ((zzaf)object).zzf())) {
            object = Boolean.FALSE;
            string2 = new Pair((Object)"", object);
            return string2;
        }
        return this.zzd(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Pair zzd(String object) {
        long l10;
        long l11;
        long l12;
        Object object2 = "";
        this.zzg();
        Object object3 = this.zzx.zzax();
        long l13 = object3.elapsedRealtime();
        Object object4 = this.zzb;
        if (object4 != null && (l12 = (l11 = l13 - (l10 = this.zzd)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            object2 = this.zzc;
            return new Pair(object4, object2);
        }
        object4 = this.zzx.zzc();
        zzdv zzdv2 = zzdw.zza;
        long l14 = ((zzae)object4).zzj((String)object, zzdv2);
        this.zzd = l13 += l14;
        boolean bl2 = true;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(bl2);
        try {
            object = this.zzx;
            object = ((zzfl)object).zzaw();
            object = AdvertisingIdClient.getAdvertisingIdInfo((Context)object);
            if (object != null) {
                this.zzb = object3 = ((AdvertisingIdClient$Info)object).getId();
                this.zzc = bl2 = ((AdvertisingIdClient$Info)object).isLimitAdTrackingEnabled();
            }
            if ((object = this.zzb) == null) {
                this.zzb = object2;
            }
        }
        catch (Exception exception) {
            object3 = this.zzx.zzat().zzj();
            String string2 = "Unable to get advertising id";
            ((zzeg)object3).zzb(string2, exception);
            this.zzb = object2;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        object2 = this.zzb;
        object3 = this.zzc;
        return new Pair(object2, object3);
    }

    public final String zzf(String object) {
        this.zzg();
        object = (String)this.zzd((String)object).first;
        MessageDigest messageDigest = zzkk.zzN();
        if (messageDigest == null) {
            return null;
        }
        Locale locale = Locale.US;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        object = ((String)object).getBytes();
        object = messageDigest.digest((byte[])object);
        BigInteger bigInteger = new BigInteger(n10, (byte[])object);
        objectArray[0] = bigInteger;
        return String.format(locale, "%032X", objectArray);
    }
}

