/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzba;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbe;
import com.google.android.gms.internal.clearcut.zzbh;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzff;
import java.nio.charset.Charset;

public class zzbi
extends zzbh {
    public final byte[] zzfp;

    public zzbi(byte[] byArray) {
        this.zzfp = byArray;
    }

    public final boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof zzbb;
        if (n11 == 0) {
            return false;
        }
        n11 = ((zzbb)this).size();
        Object object2 = object;
        object2 = (zzbb)object;
        int n12 = ((zzbb)object2).size();
        if (n11 != n12) {
            return false;
        }
        n11 = ((zzbb)this).size();
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = object instanceof zzbi;
        if (n10 != 0) {
            object = (zzbi)object;
            n10 = this.zzab();
            n11 = ((zzbb)object).zzab();
            if (n10 != 0 && n11 != 0 && n10 != n11) {
                return false;
            }
            n10 = ((zzbb)this).size();
            return ((zzbh)this).zza((zzbb)object, 0, n10);
        }
        return object.equals(this);
    }

    public int size() {
        return this.zzfp.length;
    }

    public final int zza(int n10, int n11, int n12) {
        byte[] byArray = this.zzfp;
        int n13 = this.zzac();
        return zzci.zza(n10, byArray, n13, n12);
    }

    public final zzbb zza(int n10, int n11) {
        n10 = ((zzbb)this).size();
        byte[] byArray = null;
        if ((n10 = zzbb.zzb(0, n11, n10)) == 0) {
            return zzbb.zzfi;
        }
        byArray = this.zzfp;
        int n12 = this.zzac();
        zzbe zzbe2 = new zzbe(byArray, n12, n10);
        return zzbe2;
    }

    public final String zza(Charset charset) {
        byte[] byArray = this.zzfp;
        int n10 = this.zzac();
        int n11 = ((zzbb)this).size();
        String string2 = new String(byArray, n10, n11, charset);
        return string2;
    }

    public final void zza(zzba zzba2) {
        byte[] byArray = this.zzfp;
        int n10 = this.zzac();
        int n11 = ((zzbb)this).size();
        zzba2.zza(byArray, n10, n11);
    }

    public final boolean zza(zzbb object, int n10, int n11) {
        n10 = ((zzbb)object).size();
        if (n11 <= n10) {
            n10 = ((zzbb)object).size();
            if (n11 <= n10) {
                n10 = object instanceof zzbi;
                if (n10 != 0) {
                    object = (zzbi)object;
                    byte[] byArray = this.zzfp;
                    byte[] byArray2 = ((zzbi)object).zzfp;
                    int n12 = this.zzac() + n11;
                    n11 = this.zzac();
                    int n13 = ((zzbi)object).zzac();
                    while (n11 < n12) {
                        byte by2 = byArray[n11];
                        byte by3 = byArray2[n13];
                        if (by2 != by3) {
                            return false;
                        }
                        ++n11;
                        ++n13;
                    }
                    return true;
                }
                object = ((zzbb)object).zza(0, n11);
                zzbb zzbb2 = ((zzbb)this).zza(0, n11);
                return ((zzbb)object).equals(zzbb2);
            }
            int n14 = ((zzbb)object).size();
            StringBuilder stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(n11);
            stringBuilder.append(", ");
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        n10 = ((zzbb)this).size();
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Length too large: ");
        stringBuilder.append(n11);
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final boolean zzaa() {
        int n10 = this.zzac();
        byte[] byArray = this.zzfp;
        int n11 = ((zzbb)this).size() + n10;
        return zzff.zze(byArray, n10, n11);
    }

    public int zzac() {
        return 0;
    }

    public byte zzj(int n10) {
        return this.zzfp[n10];
    }
}

