/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhp;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzhv;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzd;
import com.google.android.gms.internal.vision.zzid$zzg;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzlr;
import java.util.ArrayList;
import java.util.List;

public abstract class zzid$zze
extends zzid
implements zzjp {
    public zzht zzyg;

    public zzid$zze() {
        zzht zzht2;
        this.zzyg = zzht2 = zzht.zzgh();
    }

    public final Object zzc(zzhp object) {
        object = zzid.zzb((zzhp)object);
        Object object2 = ((zzid$zzg)object).zzyp;
        Object object3 = (zzid)this.zzgx();
        if (object2 == object3) {
            object2 = this.zzyg;
            object3 = ((zzid$zzg)object).zzyr;
            if ((object2 = ((zzht)object2).zza((zzhv)object3)) == null) {
                return ((zzid$zzg)object).zzgk;
            }
            object3 = ((zzid$zzg)object).zzyr;
            boolean bl2 = ((zzid$zzd)object3).zzye;
            if (bl2) {
                Object object4;
                object3 = ((zzid$zzd)object3).zzyd.zzjk();
                if (object3 == (object4 = zzlr.zzaeh)) {
                    object3 = new ArrayList();
                    object2 = ((List)object2).iterator();
                    while (bl2 = object2.hasNext()) {
                        object4 = object2.next();
                        object4 = ((zzid$zzg)object).zzl(object4);
                        object3.add(object4);
                    }
                    return object3;
                }
                return object2;
            }
            return ((zzid$zzg)object).zzl(object2);
        }
        object = new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        throw object;
    }

    public final zzht zzhe() {
        zzht zzht2 = this.zzyg;
        boolean bl2 = zzht2.isImmutable();
        if (bl2) {
            this.zzyg = zzht2 = (zzht)this.zzyg.clone();
        }
        return this.zzyg;
    }
}

