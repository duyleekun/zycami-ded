/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgi;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zziv;
import com.google.android.gms.internal.vision.zziw;
import com.google.android.gms.internal.vision.zzix;
import com.google.android.gms.internal.vision.zzjz;
import com.google.android.gms.internal.vision.zzky;
import com.google.android.gms.internal.vision.zzld;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zziz
extends zzix {
    private static final Class zzzw = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zziz() {
        super(null);
    }

    public /* synthetic */ zziz(zziw zziw2) {
        this();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static List zza(Object object, long l10, int n10) {
        void var4_12;
        List list = zziz.zzd(object, l10);
        boolean bl2 = list.isEmpty();
        if (bl2) {
            void var4_7;
            bl2 = list instanceof zziu;
            if (bl2) {
                zziv zziv2 = new zziv(n10);
            } else {
                bl2 = list instanceof zzjz;
                if (bl2 && (bl2 = list instanceof zzik)) {
                    zzik zzik2;
                    zzik zzik3 = zzik2 = ((zzik)list).zzan(n10);
                } else {
                    ArrayList arrayList = new ArrayList(n10);
                }
            }
            zzld.zza(object, l10, var4_7);
            return (List)var4_12;
        }
        Object object2 = zzzw;
        Class<?> clazz = list.getClass();
        bl2 = ((Class)object2).isAssignableFrom(clazz);
        if (bl2) {
            int n11 = list.size() + n10;
            object2 = new Object(n11);
            ((ArrayList)object2).addAll(list);
            zzld.zza(object, l10, object2);
        } else {
            bl2 = list instanceof zzky;
            if (!bl2) {
                bl2 = list instanceof zzjz;
                if (!bl2) return (List)var4_12;
                bl2 = list instanceof zzik;
                if (!bl2) return (List)var4_12;
                object2 = list;
                object2 = (zzik)list;
                boolean bl3 = object2.zzei();
                if (bl3) return (List)var4_12;
                int n12 = list.size() + n10;
                zzik zzik4 = object2.zzan(n12);
                zzld.zza(object, l10, zzik4);
                return (List)var4_12;
            }
            int n13 = list.size() + n10;
            object2 = new Object(n13);
            zzky zzky2 = (zzky)list;
            ((zzgi)object2).addAll((Collection)zzky2);
            zzld.zza(object, l10, object2);
        }
        List list2 = object2;
        return (List)var4_12;
    }

    private static List zzd(Object object, long l10) {
        return (List)zzld.zzp(object, l10);
    }

    public final List zza(Object object, long l10) {
        return zziz.zza(object, l10, 10);
    }

    public final void zza(Object object, Object object2, long l10) {
        object2 = zziz.zzd(object2, l10);
        int n10 = object2.size();
        List list = zziz.zza(object, l10, n10);
        int n11 = list.size();
        int n12 = object2.size();
        if (n11 > 0 && n12 > 0) {
            list.addAll(object2);
        }
        if (n11 > 0) {
            object2 = list;
        }
        zzld.zza(object, l10, object2);
    }

    public final void zzb(Object object, long l10) {
        zzik zzik2 = (zzik)zzld.zzp(object, l10);
        boolean bl2 = zzik2 instanceof zziu;
        if (bl2) {
            zzik2 = ((zziu)((Object)zzik2)).zzht();
        } else {
            Class clazz = zzzw;
            Class<?> clazz2 = zzik2.getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                return;
            }
            bl2 = zzik2 instanceof zzjz;
            if (bl2 && (bl2 = zzik2 instanceof zzik)) {
                boolean bl3 = (zzik2 = (zzik)zzik2).zzei();
                if (bl3) {
                    zzik2.zzej();
                }
                return;
            }
            zzik2 = Collections.unmodifiableList(zzik2);
        }
        zzld.zza(object, l10, zzik2);
    }
}

