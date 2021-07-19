/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgn;
import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzju;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzgs
implements Iterable,
Serializable {
    private static final zzgn zza;
    public static final zzgs zzb;
    private static final Comparator zzd;
    private int zzc = 0;

    static {
        byte[] byArray = zzia.zzc;
        Object object = new zzgq(byArray);
        zzb = object;
        boolean bl2 = zzgd.zza();
        byArray = null;
        object = bl2 ? new zzgr(null) : new zzgl(null);
        zza = object;
        zzd = object = new zzgj();
    }

    public static zzgs zzj(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        zzgs.zzn(n10, n12, n13);
        byArray = zza.zza(byArray, n10, n11);
        zzgq zzgq2 = new zzgq(byArray);
        return zzgq2;
    }

    public static zzgs zzk(String object) {
        Charset charset = zzia.zza;
        object = ((String)object).getBytes(charset);
        zzgq zzgq2 = new zzgq((byte[])object);
        return zzgq2;
    }

    public static int zzn(int n10, int n11, int n12) {
        int n13 = n11 - n10;
        int n14 = n10 | n11 | n13;
        int n15 = n12 - n11;
        if ((n14 |= n15) < 0) {
            if (n10 >= 0) {
                if (n11 < n10) {
                    StringBuilder stringBuilder = new StringBuilder(66);
                    stringBuilder.append("Beginning index larger than ending index: ");
                    stringBuilder.append(n10);
                    stringBuilder.append(", ");
                    stringBuilder.append(n11);
                    String string2 = stringBuilder.toString();
                    IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
                    throw indexOutOfBoundsException;
                }
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("End index: ");
                stringBuilder.append(n11);
                stringBuilder.append(" >= ");
                stringBuilder.append(n12);
                String string3 = stringBuilder.toString();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string3);
                throw indexOutOfBoundsException;
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Beginning index: ");
            stringBuilder.append(n10);
            stringBuilder.append(" < 0");
            String string4 = stringBuilder.toString();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string4);
            throw indexOutOfBoundsException;
        }
        return n13;
    }

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        int n10 = this.zzc;
        if (n10 == 0) {
            n10 = this.zzc();
            if ((n10 = this.zzi(n10, 0, n10)) == 0) {
                n10 = 1;
            }
            this.zzc = n10;
        }
        return n10;
    }

    public final String toString() {
        int n10;
        Locale locale = Locale.ROOT;
        int n11 = 3;
        Object[] objectArray = new Object[n11];
        Object object = Integer.toHexString(System.identityHashCode(this));
        String string2 = null;
        objectArray[0] = object;
        objectArray[1] = object = Integer.valueOf(this.zzc());
        int n12 = this.zzc();
        if (n12 <= (n10 = 50)) {
            object = zzju.zza(this);
        } else {
            n12 = 47;
            object = String.valueOf(zzju.zza(this.zze(0, n12)));
            string2 = "...";
            object = ((String)object).concat(string2);
        }
        objectArray[2] = object;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objectArray);
    }

    public abstract byte zza(int var1);

    public abstract byte zzb(int var1);

    public abstract int zzc();

    public abstract zzgs zze(int var1, int var2);

    public abstract void zzf(zzgh var1);

    public abstract String zzg(Charset var1);

    public abstract boolean zzh();

    public abstract int zzi(int var1, int var2, int var3);

    public final String zzl(Charset object) {
        int n10 = this.zzc();
        object = n10 == 0 ? "" : this.zzg((Charset)object);
        return object;
    }

    public final int zzm() {
        return this.zzc;
    }
}

