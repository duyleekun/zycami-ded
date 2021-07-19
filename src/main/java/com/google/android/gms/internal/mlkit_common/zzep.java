/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzem;
import com.google.android.gms.internal.mlkit_common.zzen;
import com.google.android.gms.internal.mlkit_common.zzeo;
import com.google.android.gms.internal.mlkit_common.zzer;
import com.google.android.gms.internal.mlkit_common.zzet;
import com.google.android.gms.internal.mlkit_common.zzev;
import com.google.android.gms.internal.mlkit_common.zzex;
import com.google.android.gms.internal.mlkit_common.zzey;
import com.google.android.gms.internal.mlkit_common.zzez;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzif;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzep
implements Serializable,
Iterable {
    public static final zzep zza;
    private static final zzev zzb;
    private static final Comparator zzd;
    private int zzc = 0;

    static {
        byte[] byArray = zzfs.zzb;
        Object object = new zzez(byArray);
        zza = object;
        boolean bl2 = zzen.zza();
        byArray = null;
        object = bl2 ? new zzey(null) : new zzet(null);
        zzb = object;
        zzd = object = new zzer();
    }

    public static /* synthetic */ int zza(byte by2) {
        return zzep.zzb(by2);
    }

    public static zzep zza(String object) {
        Charset charset = zzfs.zza;
        object = ((String)object).getBytes(charset);
        zzez zzez2 = new zzez((byte[])object);
        return zzez2;
    }

    private static int zzb(byte by2) {
        return by2 & 0xFF;
    }

    public static int zzb(int n10, int n11, int n12) {
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

    public static zzex zzc(int n10) {
        zzex zzex2 = new zzex(n10, null);
        return zzex2;
    }

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        int n10 = this.zzc;
        if (n10 == 0) {
            n10 = this.zza();
            if ((n10 = this.zza(n10, 0, n10)) == 0) {
                n10 = 1;
            }
            this.zzc = n10;
        }
        return n10;
    }

    public /* synthetic */ Iterator iterator() {
        zzeo zzeo2 = new zzeo(this);
        return zzeo2;
    }

    public final String toString() {
        int n10;
        Locale locale = Locale.ROOT;
        int n11 = 3;
        Object[] objectArray = new Object[n11];
        Object object = Integer.toHexString(System.identityHashCode(this));
        String string2 = null;
        objectArray[0] = object;
        objectArray[1] = object = Integer.valueOf(this.zza());
        int n12 = this.zza();
        if (n12 <= (n10 = 50)) {
            object = zzif.zza(this);
        } else {
            n12 = 47;
            object = String.valueOf(zzif.zza(this.zza(0, n12)));
            string2 = "...";
            object = ((String)object).concat(string2);
        }
        objectArray[2] = object;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objectArray);
    }

    public abstract byte zza(int var1);

    public abstract int zza();

    public abstract int zza(int var1, int var2, int var3);

    public abstract zzep zza(int var1, int var2);

    public abstract String zza(Charset var1);

    public abstract void zza(zzem var1);

    public abstract byte zzb(int var1);

    public final String zzb() {
        Charset charset = zzfs.zza;
        int n10 = this.zza();
        if (n10 == 0) {
            return "";
        }
        return this.zza(charset);
    }

    public abstract boolean zzc();

    public final int zzd() {
        return this.zzc;
    }
}

