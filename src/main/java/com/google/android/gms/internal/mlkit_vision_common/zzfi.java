/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzea;
import com.google.android.gms.internal.mlkit_vision_common.zzec;
import com.google.android.gms.internal.mlkit_vision_common.zzeh;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzfb;
import com.google.android.gms.internal.mlkit_vision_common.zzfh;
import com.google.android.gms.internal.mlkit_vision_common.zzfk;
import com.google.android.gms.internal.mlkit_vision_common.zzfo;
import com.google.android.gms.internal.mlkit_vision_common.zzfp;
import com.google.android.gms.internal.mlkit_vision_common.zzfq;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzfs;
import com.google.android.gms.internal.mlkit_vision_common.zzfv;
import com.google.android.gms.internal.mlkit_vision_common.zzfy;
import com.google.android.gms.internal.mlkit_vision_common.zzga;
import com.google.android.gms.internal.mlkit_vision_common.zzgc;
import com.google.android.gms.internal.mlkit_vision_common.zzgd;
import com.google.android.gms.internal.mlkit_vision_common.zzgh;
import com.google.android.gms.internal.mlkit_vision_common.zzgj;
import com.google.android.gms.internal.mlkit_vision_common.zzgk;
import com.google.android.gms.internal.mlkit_vision_common.zzgz;
import java.lang.reflect.Method;

public final class zzfi
implements zzgk {
    private static final zzfs zzb;
    private final zzfs zza;

    static {
        zzfh zzfh2 = new zzfh();
        zzb = zzfh2;
    }

    public zzfi() {
        zzfs[] zzfsArray = new zzfs[2];
        zzfs zzfs2 = zzeh.zza();
        zzfsArray[0] = zzfs2;
        zzfs2 = zzfi.zza();
        zzfsArray[1] = zzfs2;
        zzfk zzfk2 = new zzfk(zzfsArray);
        this(zzfk2);
    }

    private zzfi(zzfs zzfs2) {
        this.zza = zzfs2 = (zzfs)zzem.zza((Object)zzfs2, "messageInfoFactory");
    }

    private static zzfs zza() {
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
        return (zzfs)object;
    }

    private static boolean zza(zzfp zzfp2) {
        int n10;
        int n11 = zzfp2.zza();
        return n11 == (n10 = zzgd.zza);
    }

    public final zzgh zza(Class object) {
        Object object2 = zzej.class;
        zzgj.zza((Class)object);
        Object object3 = this.zza;
        zzfp zzfp2 = object3.zzb((Class)object);
        boolean bl2 = zzfp2.zzb();
        if (bl2) {
            boolean bl3 = ((Class)object2).isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = zzgj.zzc();
                object2 = zzec.zza();
                object3 = zzfp2.zzc();
                return zzfy.zza((zzgz)object, (zzea)object2, (zzfr)object3);
            }
            object = zzgj.zza();
            object2 = zzec.zzb();
            object3 = zzfp2.zzc();
            return zzfy.zza((zzgz)object, (zzea)object2, (zzfr)object3);
        }
        boolean bl4 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl4) {
            bl4 = zzfi.zza(zzfp2);
            if (bl4) {
                zzga zzga2 = zzgc.zzb();
                zzfb zzfb2 = zzfb.zzb();
                zzgz zzgz2 = zzgj.zzc();
                zzea zzea2 = zzec.zza();
                zzfo zzfo2 = zzfq.zzb();
                return zzfv.zza((Class)object, zzfp2, zzga2, zzfb2, zzgz2, zzea2, zzfo2);
            }
            zzga zzga3 = zzgc.zzb();
            zzfb zzfb3 = zzfb.zzb();
            zzgz zzgz3 = zzgj.zzc();
            zzfo zzfo3 = zzfq.zzb();
            return zzfv.zza((Class)object, zzfp2, zzga3, zzfb3, zzgz3, null, zzfo3);
        }
        bl4 = zzfi.zza(zzfp2);
        if (bl4) {
            zzga zzga4 = zzgc.zza();
            zzfb zzfb4 = zzfb.zza();
            zzgz zzgz4 = zzgj.zza();
            zzea zzea3 = zzec.zzb();
            zzfo zzfo4 = zzfq.zza();
            return zzfv.zza((Class)object, zzfp2, zzga4, zzfb4, zzgz4, zzea3, zzfo4);
        }
        zzga zzga5 = zzgc.zza();
        zzfb zzfb5 = zzfb.zza();
        zzgz zzgz5 = zzgj.zzb();
        zzfo zzfo5 = zzfq.zza();
        return zzfv.zza((Class)object, zzfp2, zzga5, zzfb5, zzgz5, null, zzfo5);
    }
}

