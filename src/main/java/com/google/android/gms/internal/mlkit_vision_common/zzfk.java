/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzfp;
import com.google.android.gms.internal.mlkit_vision_common.zzfs;

public final class zzfk
implements zzfs {
    private zzfs[] zza;

    public zzfk(zzfs ... zzfsArray) {
        this.zza = zzfsArray;
    }

    public final boolean zza(Class clazz) {
        for (zzfs zzfs2 : this.zza) {
            boolean bl2 = zzfs2.zza(clazz);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final zzfp zzb(Class object) {
        for (zzfs zzfs2 : this.zza) {
            boolean bl2 = zzfs2.zza((Class)object);
            if (!bl2) continue;
            return zzfs2.zzb((Class)object);
        }
        String string2 = "No factory is available for message type: ";
        int n10 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }
}

