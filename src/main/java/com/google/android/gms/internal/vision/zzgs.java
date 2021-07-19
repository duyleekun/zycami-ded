/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgl;
import com.google.android.gms.internal.vision.zzgt;
import com.google.android.gms.internal.vision.zzgu;
import com.google.android.gms.internal.vision.zzgv;
import com.google.android.gms.internal.vision.zzgw;
import com.google.android.gms.internal.vision.zzgy;
import com.google.android.gms.internal.vision.zzgz;
import com.google.android.gms.internal.vision.zzha;
import com.google.android.gms.internal.vision.zzhc;
import com.google.android.gms.internal.vision.zzhf;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzkt;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzgs
implements Serializable,
Iterable {
    public static final zzgs zztt;
    private static final zzgy zztu;
    private static final Comparator zztv;
    private int zzoc = 0;

    static {
        byte[] byArray = zzie.zzys;
        Object object = new zzhc(byArray);
        zztt = object;
        boolean bl2 = zzgl.zzel();
        byArray = null;
        object = bl2 ? new zzhf(null) : new zzgw(null);
        zztu = object;
        zztv = object = new zzgu();
    }

    private static int zza(byte by2) {
        return by2 & 0xFF;
    }

    public static zzgs zza(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        zzgs.zze(n10, n12, n13);
        byArray = zztu.zzd(byArray, n10, n11);
        zzhc zzhc2 = new zzhc(byArray);
        return zzhc2;
    }

    public static zzha zzaw(int n10) {
        zzha zzha2 = new zzha(n10, null);
        return zzha2;
    }

    public static /* synthetic */ int zzb(byte by2) {
        return zzgs.zza(by2);
    }

    public static zzgs zzb(byte[] byArray, int n10, int n11) {
        zzgz zzgz2 = new zzgz(byArray, n10, n11);
        return zzgz2;
    }

    public static zzgs zzd(byte[] byArray) {
        zzhc zzhc2 = new zzhc(byArray);
        return zzhc2;
    }

    public static int zze(int n10, int n11, int n12) {
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

    public static zzgs zzv(String object) {
        Charset charset = zzie.UTF_8;
        object = ((String)object).getBytes(charset);
        zzhc zzhc2 = new zzhc((byte[])object);
        return zzhc2;
    }

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        int n10 = this.zzoc;
        if (n10 == 0) {
            n10 = this.size();
            if ((n10 = this.zzd(n10, 0, n10)) == 0) {
                n10 = 1;
            }
            this.zzoc = n10;
        }
        return n10;
    }

    public /* synthetic */ Iterator iterator() {
        zzgv zzgv2 = new zzgv(this);
        return zzgv2;
    }

    public abstract int size();

    public final String toString() {
        int n10;
        Locale locale = Locale.ROOT;
        int n11 = 3;
        Object[] objectArray = new Object[n11];
        Object object = Integer.toHexString(System.identityHashCode(this));
        String string2 = null;
        objectArray[0] = object;
        objectArray[1] = object = Integer.valueOf(this.size());
        int n12 = this.size();
        if (n12 <= (n10 = 50)) {
            object = zzkt.zzd(this);
        } else {
            n12 = 47;
            object = String.valueOf(zzkt.zzd(this.zzi(0, n12)));
            string2 = "...";
            object = ((String)object).concat(string2);
        }
        objectArray[2] = object;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objectArray);
    }

    public abstract String zza(Charset var1);

    public abstract void zza(zzgt var1);

    public abstract void zza(byte[] var1, int var2, int var3, int var4);

    public abstract byte zzau(int var1);

    public abstract byte zzav(int var1);

    public abstract int zzd(int var1, int var2, int var3);

    public final String zzfl() {
        Charset charset = zzie.UTF_8;
        int n10 = this.size();
        if (n10 == 0) {
            return "";
        }
        return this.zza(charset);
    }

    public abstract boolean zzfm();

    public final int zzfn() {
        return this.zzoc;
    }

    public abstract zzgs zzi(int var1, int var2);
}

