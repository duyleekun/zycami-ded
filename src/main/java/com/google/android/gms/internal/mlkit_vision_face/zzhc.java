/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfu;
import com.google.android.gms.internal.mlkit_vision_face.zzfw;
import com.google.android.gms.internal.mlkit_vision_face.zzgb;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzgv;
import com.google.android.gms.internal.mlkit_vision_face.zzhb;
import com.google.android.gms.internal.mlkit_vision_face.zzhe;
import com.google.android.gms.internal.mlkit_vision_face.zzhi;
import com.google.android.gms.internal.mlkit_vision_face.zzhj;
import com.google.android.gms.internal.mlkit_vision_face.zzhk;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzhm;
import com.google.android.gms.internal.mlkit_vision_face.zzhp;
import com.google.android.gms.internal.mlkit_vision_face.zzhs;
import com.google.android.gms.internal.mlkit_vision_face.zzhu;
import com.google.android.gms.internal.mlkit_vision_face.zzhw;
import com.google.android.gms.internal.mlkit_vision_face.zzhx;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzid;
import com.google.android.gms.internal.mlkit_vision_face.zzie;
import com.google.android.gms.internal.mlkit_vision_face.zzit;
import java.lang.reflect.Method;

public final class zzhc
implements zzie {
    private static final zzhm zzb;
    private final zzhm zza;

    static {
        zzhb zzhb2 = new zzhb();
        zzb = zzhb2;
    }

    public zzhc() {
        zzhm[] zzhmArray = new zzhm[2];
        zzhm zzhm2 = zzgb.zza();
        zzhmArray[0] = zzhm2;
        zzhm2 = zzhc.zza();
        zzhmArray[1] = zzhm2;
        zzhe zzhe2 = new zzhe(zzhmArray);
        this(zzhe2);
    }

    private zzhc(zzhm zzhm2) {
        this.zza = zzhm2 = (zzhm)zzgg.zza((Object)zzhm2, "messageInfoFactory");
    }

    private static zzhm zza() {
        Object[] objectArray;
        String string2;
        Object object = "com.google.protobuf.DescriptorMessageInfoFactory";
        try {
            object = Class.forName((String)object);
            string2 = "getInstance";
            objectArray = null;
        }
        catch (Exception exception) {
            return zzb;
        }
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        string2 = null;
        objectArray = new Object[]{};
        object = ((Method)object).invoke(null, objectArray);
        return (zzhm)object;
    }

    private static boolean zza(zzhj zzhj2) {
        int n10;
        int n11 = zzhj2.zza();
        return n11 == (n10 = zzhx.zza);
    }

    public final zzib zza(Class object) {
        Object object2 = zzgd.class;
        zzid.zza((Class)object);
        Object object3 = this.zza;
        zzhj zzhj2 = object3.zzb((Class)object);
        boolean bl2 = zzhj2.zzb();
        if (bl2) {
            boolean bl3 = ((Class)object2).isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = zzid.zzc();
                object2 = zzfw.zza();
                object3 = zzhj2.zzc();
                return zzhs.zza((zzit)object, (zzfu)object2, (zzhl)object3);
            }
            object = zzid.zza();
            object2 = zzfw.zzb();
            object3 = zzhj2.zzc();
            return zzhs.zza((zzit)object, (zzfu)object2, (zzhl)object3);
        }
        boolean bl4 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl4) {
            bl4 = zzhc.zza(zzhj2);
            if (bl4) {
                zzhu zzhu2 = zzhw.zzb();
                zzgv zzgv2 = zzgv.zzb();
                zzit zzit2 = zzid.zzc();
                zzfu zzfu2 = zzfw.zza();
                zzhi zzhi2 = zzhk.zzb();
                return zzhp.zza((Class)object, zzhj2, zzhu2, zzgv2, zzit2, zzfu2, zzhi2);
            }
            zzhu zzhu3 = zzhw.zzb();
            zzgv zzgv3 = zzgv.zzb();
            zzit zzit3 = zzid.zzc();
            zzhi zzhi3 = zzhk.zzb();
            return zzhp.zza((Class)object, zzhj2, zzhu3, zzgv3, zzit3, null, zzhi3);
        }
        bl4 = zzhc.zza(zzhj2);
        if (bl4) {
            zzhu zzhu4 = zzhw.zza();
            zzgv zzgv4 = zzgv.zza();
            zzit zzit4 = zzid.zza();
            zzfu zzfu3 = zzfw.zzb();
            zzhi zzhi4 = zzhk.zza();
            return zzhp.zza((Class)object, zzhj2, zzhu4, zzgv4, zzit4, zzfu3, zzhi4);
        }
        zzhu zzhu5 = zzhw.zza();
        zzgv zzgv5 = zzgv.zza();
        zzit zzit5 = zzid.zzb();
        zzhi zzhi5 = zzhk.zza();
        return zzhp.zza((Class)object, zzhj2, zzhu5, zzgv5, zzit5, null, zzhi5);
    }
}

