/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzhn;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zziv;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzjb;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjd;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjw;
import java.lang.reflect.Method;

public final class zzip
implements zzjj {
    private static final zziv zzb;
    private final zziv zza;

    static {
        zzin zzin2 = new zzin();
        zzb = zzin2;
    }

    public zzip() {
        int n10 = 2;
        zziv[] zzivArray = new zziv[n10];
        Object object = zzhn.zza();
        Object[] objectArray = null;
        zzivArray[0] = object;
        object = "com.google.protobuf.DescriptorMessageInfoFactory";
        object = Class.forName((String)object);
        String string2 = "getInstance";
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        string2 = null;
        objectArray = new Object[]{};
        object = ((Method)object).invoke(null, objectArray);
        try {
            object = (zziv)object;
        }
        catch (Exception exception) {
            object = zzb;
        }
        zzivArray[1] = object;
        zzio zzio2 = new zzio(zzivArray);
        zzia.zzb(zzio2, "messageInfoFactory");
        this.zza = zzio2;
    }

    private static boolean zzb(zziu zziu2) {
        int n10;
        int n11 = zziu2.zzc();
        if (n11 == (n10 = 1)) {
            return n10 != 0;
        }
        return false;
    }

    public final zzji zza(Class object) {
        Object object2 = zzhs.class;
        zzjk.zza((Class)object);
        Object object3 = this.zza;
        zziu zziu2 = object3.zzc((Class)object);
        boolean bl2 = zziu2.zza();
        if (bl2) {
            boolean bl3 = ((Class)object2).isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = zzjk.zzC();
                object2 = zzhh.zza();
                object3 = zziu2.zzb();
                return zzjb.zzf((zzjw)object, (zzhf)object2, (zzix)object3);
            }
            object = zzjk.zzA();
            object2 = zzhh.zzb();
            object3 = zziu2.zzb();
            return zzjb.zzf((zzjw)object, (zzhf)object2, (zzix)object3);
        }
        boolean bl4 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (bl4) {
            bl4 = zzip.zzb(zziu2);
            if (bl4) {
                zzjc zzjc2 = zzjd.zzb();
                zzil zzil2 = zzil.zzd();
                zzjw zzjw2 = zzjk.zzC();
                zzhf zzhf2 = zzhh.zza();
                zzis zzis2 = zzit.zzb();
                object = zzja.zzk((Class)object, zziu2, zzjc2, zzil2, zzjw2, zzhf2, zzis2);
            } else {
                zzjc zzjc3 = zzjd.zzb();
                zzil zzil3 = zzil.zzd();
                zzjw zzjw3 = zzjk.zzC();
                Object var11_21 = null;
                zzis zzis3 = zzit.zzb();
                object = zzja.zzk((Class)object, zziu2, zzjc3, zzil3, zzjw3, null, zzis3);
            }
        } else {
            bl4 = zzip.zzb(zziu2);
            if (bl4) {
                zzjc zzjc4 = zzjd.zza();
                zzil zzil4 = zzil.zzc();
                zzjw zzjw4 = zzjk.zzA();
                zzhf zzhf3 = zzhh.zzb();
                zzis zzis4 = zzit.zza();
                object = zzja.zzk((Class)object, zziu2, zzjc4, zzil4, zzjw4, zzhf3, zzis4);
            } else {
                zzjc zzjc5 = zzjd.zza();
                zzil zzil5 = zzil.zzc();
                zzjw zzjw5 = zzjk.zzB();
                Object var11_23 = null;
                zzis zzis5 = zzit.zza();
                object = zzja.zzk((Class)object, zziu2, zzjc5, zzil5, zzjw5, null, zzis5);
            }
        }
        return object;
    }
}

