/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzex;
import com.google.android.gms.internal.mlkit_vision_face.zzfa;
import com.google.android.gms.internal.mlkit_vision_face.zzfb;
import com.google.android.gms.internal.mlkit_vision_face.zzfc;
import com.google.android.gms.internal.mlkit_vision_face.zzfd;
import com.google.android.gms.internal.mlkit_vision_face.zzff;
import com.google.android.gms.internal.mlkit_vision_face.zzfh;
import com.google.android.gms.internal.mlkit_vision_face.zzfj;
import com.google.android.gms.internal.mlkit_vision_face.zzfm;
import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzip;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzez
implements Serializable,
Iterable {
    public static final zzez zza;
    private static final zzff zzb;
    private static final Comparator zzd;
    private int zzc = 0;

    static {
        byte[] byArray = zzgg.zzb;
        Object object = new zzfj(byArray);
        zza = object;
        boolean bl2 = zzex.zza();
        byArray = null;
        object = bl2 ? new zzfm(null) : new zzfd(null);
        zzb = object;
        zzd = object = new zzfb();
    }

    public static /* synthetic */ int zza(byte by2) {
        return zzez.zzb(by2);
    }

    public static zzez zza(String object) {
        Charset charset = zzgg.zza;
        object = ((String)object).getBytes(charset);
        zzfj zzfj2 = new zzfj((byte[])object);
        return zzfj2;
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

    public static zzfh zzc(int n10) {
        zzfh zzfh2 = new zzfh(n10, null);
        return zzfh2;
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
        zzfc zzfc2 = new zzfc(this);
        return zzfc2;
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
            object = zzip.zza(this);
        } else {
            n12 = 47;
            object = String.valueOf(zzip.zza(this.zza(0, n12)));
            string2 = "...";
            object = ((String)object).concat(string2);
        }
        objectArray[2] = object;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objectArray);
    }

    public abstract byte zza(int var1);

    public abstract int zza();

    public abstract int zza(int var1, int var2, int var3);

    public abstract zzez zza(int var1, int var2);

    public abstract String zza(Charset var1);

    public abstract void zza(zzfa var1);

    public abstract byte zzb(int var1);

    public final String zzb() {
        Charset charset = zzgg.zza;
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

