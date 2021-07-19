/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhp;
import com.google.android.gms.internal.vision.zzid$zzd;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzlk;
import com.google.android.gms.internal.vision.zzlr;

public final class zzid$zzg
extends zzhp {
    public final Object zzgk;
    public final zzjn zzyp;
    public final zzjn zzyq;
    public final zzid$zzd zzyr;

    public zzid$zzg(zzjn object, Object object2, zzjn zzjn2, zzid$zzd zzid$zzd, Class object3) {
        if (object != null) {
            object3 = zzid$zzd.zzyd;
            zzlk zzlk2 = zzlk.zzadp;
            if (object3 == zzlk2 && zzjn2 == null) {
                object = new IllegalArgumentException("Null messageDefaultInstance");
                throw object;
            }
            this.zzyp = object;
            this.zzgk = object2;
            this.zzyq = zzjn2;
            this.zzyr = zzid$zzd;
            return;
        }
        object = new IllegalArgumentException("Null containingTypeDefaultInstance");
        throw object;
    }

    public final Object zzl(Object object) {
        zzlr zzlr2;
        zzlr zzlr3 = this.zzyr.zzyd.zzjk();
        if (zzlr3 == (zzlr2 = zzlr.zzaeh)) {
            zzlr3 = null;
            int n10 = (Integer)object;
            object = ((zzig)null).zzh(n10);
        }
        return object;
    }
}

