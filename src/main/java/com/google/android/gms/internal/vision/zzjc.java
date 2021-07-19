/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjk;
import com.google.android.gms.internal.vision.zzjl;

public final class zzjc
implements zzjk {
    private zzjk[] zzaab;

    public zzjc(zzjk ... zzjkArray) {
        this.zzaab = zzjkArray;
    }

    public final boolean zza(Class clazz) {
        for (zzjk zzjk2 : this.zzaab) {
            boolean bl2 = zzjk2.zza(clazz);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final zzjl zzb(Class object) {
        for (zzjk zzjk2 : this.zzaab) {
            boolean bl2 = zzjk2.zza((Class)object);
            if (!bl2) continue;
            return zzjk2.zzb((Class)object);
        }
        String string2 = "No factory is available for message type: ";
        int n10 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }
}

