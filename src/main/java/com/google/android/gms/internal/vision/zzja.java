/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhq;
import com.google.android.gms.internal.vision.zzhu;
import com.google.android.gms.internal.vision.zzib;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzix;
import com.google.android.gms.internal.vision.zzjc;
import com.google.android.gms.internal.vision.zzjd;
import com.google.android.gms.internal.vision.zzjg;
import com.google.android.gms.internal.vision.zzji;
import com.google.android.gms.internal.vision.zzjk;
import com.google.android.gms.internal.vision.zzjl;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjr;
import com.google.android.gms.internal.vision.zzjt;
import com.google.android.gms.internal.vision.zzjv;
import com.google.android.gms.internal.vision.zzjx;
import com.google.android.gms.internal.vision.zzjy;
import com.google.android.gms.internal.vision.zzke;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzkh;
import com.google.android.gms.internal.vision.zzkx;
import java.lang.reflect.Method;

public final class zzja
implements zzke {
    private static final zzjk zzzy;
    private final zzjk zzzx;

    static {
        zzjd zzjd2 = new zzjd();
        zzzy = zzjd2;
    }

    public zzja() {
        zzjk[] zzjkArray = new zzjk[2];
        zzjk zzjk2 = zzib.zzgq();
        zzjkArray[0] = zzjk2;
        zzjk2 = zzja.zzhw();
        zzjkArray[1] = zzjk2;
        zzjc zzjc2 = new zzjc(zzjkArray);
        this(zzjc2);
    }

    private zzja(zzjk zzjk2) {
        this.zzzx = zzjk2 = (zzjk)zzie.zza(zzjk2, "messageInfoFactory");
    }

    private static boolean zza(zzjl zzjl2) {
        int n10;
        int n11 = zzjl2.zzid();
        return n11 == (n10 = zzjy.zzabd);
    }

    private static zzjk zzhw() {
        Object[] objectArray;
        String string2;
        Object object = "com.google.protobuf.DescriptorMessageInfoFactory";
        try {
            object = Class.forName((String)object);
            string2 = "getInstance";
            objectArray = null;
        }
        catch (Exception exception) {
            return zzzy;
        }
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        string2 = null;
        objectArray = new Object[]{};
        object = ((Method)object).invoke(null, objectArray);
        return (zzjk)object;
    }

    public final zzkf zze(Class object) {
        Object object2 = zzid.class;
        zzkh.zzg((Class)object);
        Object object3 = this.zzzx;
        zzjl zzjl2 = object3.zzb((Class)object);
        boolean bl2 = zzjl2.zzie();
        if (bl2) {
            boolean bl3 = ((Class)object2).isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = zzkh.zziu();
                object2 = zzhu.zzgk();
                object3 = zzjl2.zzif();
                return zzjt.zza((zzkx)object, (zzhq)object2, (zzjn)object3);
            }
            object = zzkh.zzis();
            object2 = zzhu.zzgl();
            object3 = zzjl2.zzif();
            return zzjt.zza((zzkx)object, (zzhq)object2, (zzjn)object3);
        }
        boolean bl4 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl4) {
            bl4 = zzja.zza(zzjl2);
            if (bl4) {
                zzjv zzjv2 = zzjx.zzih();
                zzix zzix2 = zzix.zzhv();
                zzkx zzkx2 = zzkh.zziu();
                zzhq zzhq2 = zzhu.zzgk();
                zzjg zzjg2 = zzji.zzib();
                return zzjr.zza((Class)object, zzjl2, zzjv2, zzix2, zzkx2, zzhq2, zzjg2);
            }
            zzjv zzjv3 = zzjx.zzih();
            zzix zzix3 = zzix.zzhv();
            zzkx zzkx3 = zzkh.zziu();
            zzjg zzjg3 = zzji.zzib();
            return zzjr.zza((Class)object, zzjl2, zzjv3, zzix3, zzkx3, null, zzjg3);
        }
        bl4 = zzja.zza(zzjl2);
        if (bl4) {
            zzjv zzjv4 = zzjx.zzig();
            zzix zzix4 = zzix.zzhu();
            zzkx zzkx4 = zzkh.zzis();
            zzhq zzhq3 = zzhu.zzgl();
            zzjg zzjg4 = zzji.zzia();
            return zzjr.zza((Class)object, zzjl2, zzjv4, zzix4, zzkx4, zzhq3, zzjg4);
        }
        zzjv zzjv5 = zzjx.zzig();
        zzix zzix5 = zzix.zzhu();
        zzkx zzkx5 = zzkh.zzit();
        zzjg zzjg5 = zzji.zzia();
        return zzjr.zza((Class)object, zzjl2, zzjv5, zzix5, zzkx5, null, zzjg5);
    }
}

