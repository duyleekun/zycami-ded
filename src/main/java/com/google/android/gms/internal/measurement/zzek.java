/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfo;
import java.util.Objects;

public final class zzek
extends zzff {
    private final Context zza;
    private final zzfo zzb;

    public zzek(Context context, zzfo zzfo2) {
        Objects.requireNonNull(context, "Null context");
        this.zza = context;
        this.zzb = zzfo2;
    }

    public final boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                Object object2;
                block5: {
                    Context context;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    boolean bl3 = object instanceof zzff;
                    if (!bl3 || !(bl3 = (object2 = this.zza).equals(context = ((zzff)(object = (zzff)object)).zza()))) break block4;
                    object2 = this.zzb;
                    if (object2 != null) break block5;
                    if ((object = ((zzff)object).zzb()) != null) break block4;
                    break block6;
                }
                boolean bl4 = object2.equals(object = ((zzff)object).zzb());
                if (!bl4) break block4;
            }
            return bl2;
        }
        return false;
    }

    public final int hashCode() {
        Context context = this.zza;
        int n10 = context.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        zzfo zzfo2 = this.zzb;
        if (zzfo2 == null) {
            n11 = 0;
            zzfo2 = null;
        } else {
            n11 = zzfo2.hashCode();
        }
        return n10 ^ n11;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zza);
        String string3 = String.valueOf(this.zzb);
        int n10 = String.valueOf(string2).length();
        int n11 = String.valueOf(string3).length();
        n10 = n10 + 46 + n11;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("FlagsContext{context=");
        stringBuilder.append(string2);
        stringBuilder.append(", hermeticFileOverrides=");
        stringBuilder.append(string3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final Context zza() {
        return this.zza;
    }

    public final zzfo zzb() {
        return this.zzb;
    }
}

