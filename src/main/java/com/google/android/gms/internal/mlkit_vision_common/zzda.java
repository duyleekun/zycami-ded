/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdn;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzge;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzda
implements zzfr {
    public int zza = 0;

    public static void zza(Iterable object, List object2) {
        int n10;
        zzem.zza(object);
        int n11 = object instanceof zzfc;
        String string2 = " is null.";
        String string3 = "Element at index ";
        int n12 = 37;
        if (n11 != 0) {
            boolean bl2;
            object = ((zzfc)object).zzd();
            List list = object2;
            list = (zzfc)object2;
            int n13 = object2.size();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object3 = object.next();
                if (object3 == null) {
                    int n14 = list.size() - n13;
                    object3 = new StringBuilder(n12);
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append(n14);
                    ((StringBuilder)object3).append(string2);
                    object = ((StringBuilder)object3).toString();
                    for (int i10 = list.size() + -1; i10 >= n13; i10 += -1) {
                        list.remove(i10);
                    }
                    object2 = new NullPointerException((String)object);
                    throw object2;
                }
                boolean bl3 = object3 instanceof zzdf;
                if (bl3) {
                    object3 = (zzdf)object3;
                    list.zza((zzdf)object3);
                    continue;
                }
                object3 = (String)object3;
                list.add(object3);
            }
            return;
        }
        n11 = object instanceof zzge;
        if (n11 != 0) {
            object = (Collection)object;
            object2.addAll(object);
            return;
        }
        n11 = object2 instanceof ArrayList;
        if (n11 != 0 && (n11 = object instanceof Collection) != 0) {
            List list = object2;
            list = (ArrayList)object2;
            n10 = object2.size();
            Object object4 = object;
            object4 = (Collection)object;
            int n15 = object4.size();
            ((ArrayList)list).ensureCapacity(n10 += n15);
        }
        n11 = object2.size();
        object = ((Iterable)object).iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object5 = object.next();
            if (object5 == null) {
                int n16 = object2.size() - n11;
                object5 = new StringBuilder(n12);
                ((StringBuilder)object5).append(string3);
                ((StringBuilder)object5).append(n16);
                ((StringBuilder)object5).append(string2);
                object = ((StringBuilder)object5).toString();
                for (int i11 = object2.size() + -1; i11 >= n11; i11 += -1) {
                    ((List)object2).remove(i11);
                }
                object2 = new NullPointerException((String)object);
                throw object2;
            }
            object2.add(object5);
        }
    }

    public void zza(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final zzdf zze() {
        Object object;
        int n10;
        try {
            n10 = this.zzj();
        }
        catch (IOException iOException) {
            String string2 = "ByteString";
            String string3 = this.getClass().getName();
            int n11 = String.valueOf(string3).length() + 62;
            int n12 = string2.length();
            StringBuilder stringBuilder = new StringBuilder(n11 += n12);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string3);
            stringBuilder.append(" to a ");
            stringBuilder.append(string2);
            stringBuilder.append(" threw an IOException (should never happen).");
            string2 = stringBuilder.toString();
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        zzdn zzdn2 = zzdf.zzc(n10);
        object = zzdn2.zzb();
        this.zza((zzdw)object);
        return zzdn2.zza();
    }

    public final byte[] zzf() {
        Object object;
        int n10;
        try {
            n10 = this.zzj();
        }
        catch (IOException iOException) {
            String string2 = "byte array";
            String string3 = this.getClass().getName();
            int n11 = String.valueOf(string3).length() + 62;
            int n12 = string2.length();
            StringBuilder stringBuilder = new StringBuilder(n11 += n12);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string3);
            stringBuilder.append(" to a ");
            stringBuilder.append(string2);
            stringBuilder.append(" threw an IOException (should never happen).");
            string2 = stringBuilder.toString();
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        byte[] byArray = new byte[n10];
        object = zzdw.zza(byArray);
        this.zza((zzdw)object);
        ((zzdw)object).zzb();
        return byArray;
    }

    public int zzg() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

