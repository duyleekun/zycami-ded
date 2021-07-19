/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import com.google.android.gms.internal.vision.zzbr;
import com.google.android.gms.internal.vision.zzdf;
import java.util.Objects;

public final class zzav
extends zzbr {
    private final zzdf zzfw;
    private final Context zzg;

    public zzav(Context context, zzdf zzdf2) {
        Objects.requireNonNull(context, "Null context");
        this.zzg = context;
        this.zzfw = zzdf2;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        Context context;
        Object object2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof zzbr;
        if (bl4 && (bl4 = (object2 = this.zzg).equals(context = ((zzbr)(object = (zzbr)object)).zzaa())) && ((object2 = this.zzfw) == null ? (object = ((zzbr)object).zzab()) == null : (bl2 = object2.equals(object = ((zzbr)object).zzab())))) {
            return bl3;
        }
        return false;
    }

    public final int hashCode() {
        Context context = this.zzg;
        int n10 = context.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        zzdf zzdf2 = this.zzfw;
        if (zzdf2 == null) {
            n11 = 0;
            zzdf2 = null;
        } else {
            n11 = zzdf2.hashCode();
        }
        return n10 ^ n11;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zzg);
        String string3 = String.valueOf(this.zzfw);
        int n10 = String.valueOf(string2).length() + 46;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("FlagsContext{context=");
        stringBuilder.append(string2);
        stringBuilder.append(", hermeticFileOverrides=");
        stringBuilder.append(string3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final Context zzaa() {
        return this.zzg;
    }

    public final zzdf zzab() {
        return this.zzfw;
    }
}

