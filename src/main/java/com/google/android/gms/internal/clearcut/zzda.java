/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzav;
import com.google.android.gms.internal.clearcut.zzcw;
import com.google.android.gms.internal.clearcut.zzcx;
import com.google.android.gms.internal.clearcut.zzcy;
import com.google.android.gms.internal.clearcut.zzcz;
import com.google.android.gms.internal.clearcut.zzfa;
import com.google.android.gms.internal.clearcut.zzfd;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zzda
extends zzcy {
    private static final Class zzlv = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzda() {
        super(null);
    }

    public /* synthetic */ zzda(zzcz zzcz2) {
        this();
    }

    private static List zzb(Object object, long l10) {
        return (List)zzfd.zzo(object, l10);
    }

    public final void zza(Object object, long l10) {
        List list = (List)zzfd.zzo(object, l10);
        boolean bl2 = list instanceof zzcx;
        if (bl2) {
            list = ((zzcx)list).zzbu();
        } else {
            Class clazz = zzlv;
            Class<?> clazz2 = list.getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                return;
            }
            list = Collections.unmodifiableList(list);
        }
        zzfd.zza(object, l10, list);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final void zza(Object object, Object list, long l10) {
        int n10;
        AbstractList abstractList;
        int n11;
        block6: {
            void var9_10;
            block8: {
                block7: {
                    block5: {
                        list = zzda.zzb(list, l10);
                        n11 = list.size();
                        abstractList = zzda.zzb(object, l10);
                        n10 = abstractList.isEmpty();
                        if (n10 == 0) break block5;
                        boolean bl2 = abstractList instanceof zzcx;
                        abstractList = bl2 ? new AbstractList(n11) : new AbstractList(n11);
                        zzfd.zza(object, l10, abstractList);
                        break block6;
                    }
                    Class clazz = zzlv;
                    Class<?> clazz2 = abstractList.getClass();
                    n10 = clazz.isAssignableFrom(clazz2);
                    if (n10 == 0) break block7;
                    int n12 = abstractList.size() + n11;
                    ArrayList arrayList = new ArrayList(n12);
                    arrayList.addAll(abstractList);
                    break block8;
                }
                n10 = abstractList instanceof zzfa;
                if (n10 == 0) break block6;
                int n13 = ((List)abstractList).size() + n11;
                zzcw zzcw2 = new zzcw(n13);
                abstractList = (zzfa)abstractList;
                ((zzav)zzcw2).addAll((Collection)abstractList);
            }
            zzfd.zza(object, l10, var9_10);
            abstractList = var9_10;
        }
        n11 = abstractList.size();
        n10 = list.size();
        if (n11 > 0 && n10 > 0) {
            abstractList.addAll(list);
        }
        if (n11 > 0) {
            list = abstractList;
        }
        zzfd.zza(object, l10, list);
    }
}

