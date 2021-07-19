/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzaw;
import com.google.android.gms.internal.clearcut.zzba;
import com.google.android.gms.internal.clearcut.zzbc;
import com.google.android.gms.internal.clearcut.zzbd;
import com.google.android.gms.internal.clearcut.zzbf;
import com.google.android.gms.internal.clearcut.zzbg;
import com.google.android.gms.internal.clearcut.zzbi;
import com.google.android.gms.internal.clearcut.zzbj;
import com.google.android.gms.internal.clearcut.zzci;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class zzbb
implements Serializable,
Iterable {
    public static final zzbb zzfi;
    private static final zzbf zzfj;
    private int zzfk = 0;

    static {
        byte[] byArray = zzci.zzkt;
        Object object = new zzbi(byArray);
        zzfi = object;
        boolean bl2 = zzaw.zzx();
        byArray = null;
        object = bl2 ? new zzbj(null) : new zzbd(null);
        zzfj = object;
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

    public static zzbb zzb(byte[] byArray, int n10, int n11) {
        byArray = zzfj.zzc(byArray, n10, n11);
        zzbi zzbi2 = new zzbi(byArray);
        return zzbi2;
    }

    public static zzbb zzf(String object) {
        Charset charset = zzci.UTF_8;
        object = ((String)object).getBytes(charset);
        zzbi zzbi2 = new zzbi((byte[])object);
        return zzbi2;
    }

    public static zzbg zzk(int n10) {
        zzbg zzbg2 = new zzbg(n10, null);
        return zzbg2;
    }

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        int n10 = this.zzfk;
        if (n10 == 0) {
            n10 = this.size();
            if ((n10 = this.zza(n10, 0, n10)) == 0) {
                n10 = 1;
            }
            this.zzfk = n10;
        }
        return n10;
    }

    public /* synthetic */ Iterator iterator() {
        zzbc zzbc2 = new zzbc(this);
        return zzbc2;
    }

    public abstract int size();

    public final String toString() {
        Object object = Integer.toHexString(System.identityHashCode(this));
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.size())};
        return String.format("<ByteString@%s size=%d>", objectArray);
    }

    public abstract int zza(int var1, int var2, int var3);

    public abstract zzbb zza(int var1, int var2);

    public abstract String zza(Charset var1);

    public abstract void zza(zzba var1);

    public abstract boolean zzaa();

    public final int zzab() {
        return this.zzfk;
    }

    public abstract byte zzj(int var1);

    public final String zzz() {
        Charset charset = zzci.UTF_8;
        int n10 = this.size();
        if (n10 == 0) {
            return "";
        }
        return this.zza(charset);
    }
}

