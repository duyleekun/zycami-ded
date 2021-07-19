/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzje;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzgb
implements zzix {
    public int zzb = 0;

    public static void zzbs(Iterable object, List object2) {
        block11: {
            block10: {
                int n10;
                String string2;
                String string3;
                int n11;
                block9: {
                    boolean bl2;
                    zzia.zza(object);
                    n11 = object instanceof zzih;
                    string3 = " is null.";
                    string2 = "Element at index ";
                    n10 = 37;
                    if (n11 == 0) break block9;
                    object = ((zzih)object).zzh();
                    List list = object2;
                    list = (zzih)object2;
                    int n12 = object2.size();
                    object = object.iterator();
                    while (bl2 = object.hasNext()) {
                        Object object3 = object.next();
                        if (object3 == null) {
                            int n13 = list.size();
                            object3 = new StringBuilder(n10);
                            ((StringBuilder)object3).append(string2);
                            ((StringBuilder)object3).append(n13 -= n12);
                            ((StringBuilder)object3).append(string3);
                            object = ((StringBuilder)object3).toString();
                            int n14 = list.size();
                            while ((n14 += -1) >= n12) {
                                list.remove(n14);
                            }
                            object2 = new NullPointerException((String)object);
                            throw object2;
                        }
                        boolean bl3 = object3 instanceof zzgs;
                        if (bl3) {
                            object3 = (zzgs)object3;
                            list.zzf((zzgs)object3);
                            continue;
                        }
                        object3 = (String)object3;
                        list.add(object3);
                    }
                    break block10;
                }
                n11 = object instanceof zzje;
                if (n11 == 0) {
                    int n15;
                    n11 = object2 instanceof ArrayList;
                    if (n11 != 0 && (n11 = object instanceof Collection) != 0) {
                        List list = object2;
                        list = (ArrayList)object2;
                        n15 = object2.size();
                        int n16 = ((Collection)object).size();
                        ((ArrayList)list).ensureCapacity(n15 += n16);
                    }
                    n11 = object2.size();
                    object = ((Iterable)object).iterator();
                    while ((n15 = object.hasNext()) != 0) {
                        Object object4 = object.next();
                        if (object4 == null) {
                            int n17 = object2.size();
                            object4 = new StringBuilder(n10);
                            ((StringBuilder)object4).append(string2);
                            ((StringBuilder)object4).append(n17 -= n11);
                            ((StringBuilder)object4).append(string3);
                            object = ((StringBuilder)object4).toString();
                            int n18 = object2.size();
                            while ((n18 += -1) >= n11) {
                                ((List)object2).remove(n18);
                            }
                            object2 = new NullPointerException((String)object);
                            throw object2;
                        }
                        object2.add(object4);
                    }
                }
                break block11;
            }
            return;
        }
        object2.addAll((Collection)object);
    }

    public final zzgs zzbo() {
        Object object;
        int n10;
        try {
            n10 = this.zzbw();
        }
        catch (IOException iOException) {
            String string2 = this.getClass().getName();
            int n11 = String.valueOf(string2).length();
            StringBuilder stringBuilder = new StringBuilder(n11 += 72);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string2);
            stringBuilder.append(" to a ByteString threw an IOException (should never happen).");
            string2 = stringBuilder.toString();
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        object = zzgs.zzb;
        byte[] byArray = new byte[n10];
        object = zzgz.zzt(byArray);
        this.zzbv((zzgz)object);
        ((zzgz)object).zzC();
        object = new zzgq(byArray);
        return object;
    }

    public final byte[] zzbp() {
        Object object;
        int n10;
        try {
            n10 = this.zzbw();
        }
        catch (IOException iOException) {
            String string2 = this.getClass().getName();
            int n11 = String.valueOf(string2).length();
            StringBuilder stringBuilder = new StringBuilder(n11 += 72);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string2);
            stringBuilder.append(" to a byte array threw an IOException (should never happen).");
            string2 = stringBuilder.toString();
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        byte[] byArray = new byte[n10];
        object = zzgz.zzt(byArray);
        this.zzbv((zzgz)object);
        ((zzgz)object).zzC();
        return byArray;
    }

    public int zzbq() {
        throw null;
    }

    public void zzbr(int n10) {
        throw null;
    }
}

