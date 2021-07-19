/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfg;
import com.google.android.gms.internal.mlkit_common.zzfi;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfr;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzgl;
import com.google.android.gms.internal.mlkit_common.zzgq;
import com.google.android.gms.internal.mlkit_common.zzgr;
import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzgw;
import com.google.android.gms.internal.mlkit_common.zzgy;
import com.google.android.gms.internal.mlkit_common.zzgz;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhe;
import com.google.android.gms.internal.mlkit_common.zzhf;
import com.google.android.gms.internal.mlkit_common.zzhg;
import com.google.android.gms.internal.mlkit_common.zzhi;
import com.google.android.gms.internal.mlkit_common.zzhn;
import com.google.android.gms.internal.mlkit_common.zzhq;
import com.google.android.gms.internal.mlkit_common.zzhr;
import com.google.android.gms.internal.mlkit_common.zzht;
import com.google.android.gms.internal.mlkit_common.zzij;
import java.lang.reflect.Method;

public final class zzgo
implements zzhq {
    private static final zzgy zzb;
    private final zzgy zza;

    static {
        zzgr zzgr2 = new zzgr();
        zzb = zzgr2;
    }

    public zzgo() {
        zzgy[] zzgyArray = new zzgy[2];
        zzgy zzgy2 = zzfr.zza();
        zzgyArray[0] = zzgy2;
        zzgy2 = zzgo.zza();
        zzgyArray[1] = zzgy2;
        zzgq zzgq2 = new zzgq(zzgyArray);
        this(zzgq2);
    }

    private zzgo(zzgy zzgy2) {
        this.zza = zzgy2 = (zzgy)zzfs.zza((Object)zzgy2, "messageInfoFactory");
    }

    private static zzgy zza() {
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
        return (zzgy)object;
    }

    private static boolean zza(zzgz zzgz2) {
        int n10;
        int n11 = zzgz2.zza();
        return n11 == (n10 = zzhn.zza);
    }

    public final zzhr zza(Class object) {
        Object object2 = zzfq.class;
        zzht.zza((Class)object);
        Object object3 = this.zza;
        zzgz zzgz2 = object3.zzb((Class)object);
        boolean bl2 = zzgz2.zzb();
        if (bl2) {
            boolean bl3 = ((Class)object2).isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = zzht.zzc();
                object2 = zzfi.zza();
                object3 = zzgz2.zzc();
                return zzhe.zza((zzij)object, (zzfg)object2, (zzhb)object3);
            }
            object = zzht.zza();
            object2 = zzfi.zzb();
            object3 = zzgz2.zzc();
            return zzhe.zza((zzij)object, (zzfg)object2, (zzhb)object3);
        }
        boolean bl4 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl4) {
            bl4 = zzgo.zza(zzgz2);
            if (bl4) {
                zzhg zzhg2 = zzhi.zzb();
                zzgl zzgl2 = zzgl.zzb();
                zzij zzij2 = zzht.zzc();
                zzfg zzfg2 = zzfi.zza();
                zzgu zzgu2 = zzgw.zzb();
                return zzhf.zza((Class)object, zzgz2, zzhg2, zzgl2, zzij2, zzfg2, zzgu2);
            }
            zzhg zzhg3 = zzhi.zzb();
            zzgl zzgl3 = zzgl.zzb();
            zzij zzij3 = zzht.zzc();
            zzgu zzgu3 = zzgw.zzb();
            return zzhf.zza((Class)object, zzgz2, zzhg3, zzgl3, zzij3, null, zzgu3);
        }
        bl4 = zzgo.zza(zzgz2);
        if (bl4) {
            zzhg zzhg4 = zzhi.zza();
            zzgl zzgl4 = zzgl.zza();
            zzij zzij4 = zzht.zza();
            zzfg zzfg3 = zzfi.zzb();
            zzgu zzgu4 = zzgw.zza();
            return zzhf.zza((Class)object, zzgz2, zzhg4, zzgl4, zzij4, zzfg3, zzgu4);
        }
        zzhg zzhg5 = zzhi.zza();
        zzgl zzgl5 = zzgl.zza();
        zzij zzij5 = zzht.zzb();
        zzgu zzgu5 = zzgw.zza();
        return zzhf.zza((Class)object, zzgz2, zzhg5, zzgl5, zzij5, null, zzgu5);
    }
}

