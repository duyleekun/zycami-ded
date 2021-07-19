/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjl;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjy;

public final class zzkd
implements zzjl {
    private final int flags;
    private final String info;
    private final Object[] zzaal;
    private final zzjn zzaao;

    public zzkd(zzjn zzjn2, String string2, Object[] objectArray) {
        this.zzaao = zzjn2;
        this.info = string2;
        this.zzaal = objectArray;
        zzjn2 = null;
        int n10 = string2.charAt(0);
        int n11 = 55296;
        if (n10 < n11) {
            this.flags = n10;
            return;
        }
        n10 &= 0x1FFF;
        int n12 = 13;
        int n13 = 1;
        while (true) {
            int n14 = n13 + 1;
            if ((n13 = (int)string2.charAt(n13)) < n11) break;
            n13 = (n13 & 0x1FFF) << n12;
            n10 |= n13;
            n12 += 13;
            n13 = n14;
        }
        int n15 = n13 << n12;
        this.flags = n10 |= n15;
    }

    public final int zzid() {
        int n10 = this.flags;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            return zzjy.zzabd;
        }
        return zzjy.zzabe;
    }

    public final boolean zzie() {
        int n10 = this.flags;
        int n11 = 2;
        return (n10 &= n11) == n11;
    }

    public final zzjn zzif() {
        return this.zzaao;
    }

    public final String zzil() {
        return this.info;
    }

    public final Object[] zzim() {
        return this.zzaal;
    }
}

