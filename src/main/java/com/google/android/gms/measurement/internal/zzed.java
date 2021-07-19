/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzkk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class zzed
extends zzgf {
    public static final AtomicReference zza;
    public static final AtomicReference zzb;
    public static final AtomicReference zzc;

    static {
        AtomicReference atomicReference;
        zza = atomicReference = new AtomicReference();
        zzb = atomicReference = new AtomicReference();
        zzc = atomicReference = new AtomicReference();
    }

    public zzed(zzfl zzfl2) {
        super(zzfl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final String zzi(String stringArray, String[] object, String[] object2, AtomicReference atomicReference) {
        CharSequence charSequence;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkNotNull(atomicReference);
        int n10 = ((String[])object).length;
        int n11 = ((String[])object2).length;
        int n12 = 0;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        Preconditions.checkArgument(n10 != 0);
        while (n12 < (n10 = ((String[])object).length)) {
            charSequence = object[n12];
            n10 = (int)(zzkk.zzS((String)stringArray, (String)charSequence) ? 1 : 0);
            if (n10 != 0) {
                synchronized (atomicReference) {
                    stringArray = atomicReference.get();
                    stringArray = stringArray;
                    if (stringArray == null) {
                        int n13 = ((String[])object2).length;
                        stringArray = new String[n13];
                        atomicReference.set(stringArray);
                    }
                    if ((charSequence = stringArray[n12]) == null) {
                        charSequence = new StringBuilder();
                        object2 = object2[n12];
                        ((StringBuilder)charSequence).append((String)object2);
                        object2 = "(";
                        ((StringBuilder)charSequence).append((String)object2);
                        object = object[n12];
                        ((StringBuilder)charSequence).append((String)object);
                        object = ")";
                        ((StringBuilder)charSequence).append((String)object);
                        charSequence = ((StringBuilder)charSequence).toString();
                        stringArray[n12] = charSequence;
                    }
                    return charSequence;
                }
            }
            ++n12;
        }
        return stringArray;
    }

    public final boolean zza() {
        return false;
    }

    public final boolean zzb() {
        int n10;
        this.zzx.zzas();
        Object object = this.zzx;
        boolean bl2 = ((zzfl)object).zzq();
        return bl2 && (bl2 = Log.isLoggable((String)(object = this.zzx.zzat().zzn()), (int)(n10 = 3)));
    }

    public final String zzc(String string2) {
        if (string2 == null) {
            return null;
        }
        boolean bl2 = this.zzb();
        if (!bl2) {
            return string2;
        }
        String[] stringArray = zzgi.zzc;
        String[] stringArray2 = zzgi.zza;
        AtomicReference atomicReference = zza;
        return zzed.zzi(string2, stringArray, stringArray2, atomicReference);
    }

    public final String zzd(String string2) {
        if (string2 == null) {
            return null;
        }
        boolean bl2 = this.zzb();
        if (!bl2) {
            return string2;
        }
        String[] stringArray = zzgj.zzb;
        String[] stringArray2 = zzgj.zza;
        AtomicReference atomicReference = zzb;
        return zzed.zzi(string2, stringArray, stringArray2, atomicReference);
    }

    public final String zze(String string2) {
        if (string2 == null) {
            return null;
        }
        boolean bl2 = this.zzb();
        if (!bl2) {
            return string2;
        }
        Object object = "_exp_";
        bl2 = string2.startsWith((String)object);
        if (bl2) {
            object = new StringBuilder();
            object.append("experiment_id(");
            object.append(string2);
            object.append(")");
            return object.toString();
        }
        object = zzgk.zzb;
        String[] stringArray = zzgk.zza;
        AtomicReference atomicReference = zzc;
        return zzed.zzi(string2, object, stringArray, atomicReference);
    }

    public final String zzf(Bundle bundle) {
        boolean bl2;
        if (bundle == null) {
            return null;
        }
        boolean bl3 = this.zzb();
        if (!bl3) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bundle[{");
        Iterator iterator2 = bundle.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object[] objectArray;
            int n10;
            Object object = (String)iterator2.next();
            int n11 = stringBuilder.length();
            if (n11 != (n10 = 8)) {
                objectArray = ", ";
                stringBuilder.append((String)objectArray);
            }
            objectArray = this.zzd((String)object);
            stringBuilder.append((String)objectArray);
            objectArray = "=";
            stringBuilder.append((String)objectArray);
            object = bundle.get((String)object);
            n11 = object instanceof Bundle;
            if (n11 != 0) {
                n11 = 1;
                objectArray = new Object[n11];
                n10 = 0;
                objectArray[0] = object;
                object = this.zzh(objectArray);
            } else {
                n11 = object instanceof Object[];
                if (n11 != 0) {
                    object = object;
                    object = this.zzh((Object[])object);
                } else {
                    n11 = object instanceof ArrayList;
                    if (n11 != 0) {
                        object = ((ArrayList)object).toArray();
                        object = this.zzh((Object[])object);
                    } else {
                        object = String.valueOf(object);
                    }
                }
            }
            stringBuilder.append((String)object);
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    public final String zzh(Object[] objectArray) {
        if (objectArray == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "[";
        stringBuilder.append(string2);
        for (Object object : objectArray) {
            int n10;
            int n11 = object instanceof Bundle;
            if (n11 != 0) {
                object = (Bundle)object;
                object = this.zzf((Bundle)object);
            } else {
                object = String.valueOf(object);
            }
            if (object == null) continue;
            n11 = stringBuilder.length();
            if (n11 != (n10 = 1)) {
                String string3 = ", ";
                stringBuilder.append(string3);
            }
            stringBuilder.append((String)object);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

