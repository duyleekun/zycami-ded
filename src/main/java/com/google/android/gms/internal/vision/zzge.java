/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzha;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zziu;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzge
implements zzjn {
    public int zzte = 0;

    public static void zza(Iterable object, List object2) {
        int n10;
        zzie.checkNotNull(object);
        int n11 = object instanceof zziu;
        String string2 = " is null.";
        String string3 = "Element at index ";
        int n12 = 37;
        if (n11 != 0) {
            boolean bl2;
            object = ((zziu)object).zzhs();
            List list = object2;
            list = (zziu)object2;
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
                boolean bl3 = object3 instanceof zzgs;
                if (bl3) {
                    object3 = (zzgs)object3;
                    list.zzc((zzgs)object3);
                    continue;
                }
                object3 = (String)object3;
                list.add(object3);
            }
            return;
        }
        n11 = object instanceof zzjz;
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

    public final byte[] toByteArray() {
        Object object;
        int n10;
        try {
            n10 = this.zzgz();
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
        object = zzhl.zze(byArray);
        this.zzb((zzhl)object);
        ((zzhl)object).zzgb();
        return byArray;
    }

    public void zzak(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final zzgs zzee() {
        Object object;
        int n10;
        try {
            n10 = this.zzgz();
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
        zzha zzha2 = zzgs.zzaw(n10);
        object = zzha2.zzfq();
        this.zzb((zzhl)object);
        return zzha2.zzfp();
    }

    public int zzef() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

