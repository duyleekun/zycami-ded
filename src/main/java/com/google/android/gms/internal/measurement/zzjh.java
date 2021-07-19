/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzix;

public final class zzjh
implements zziu {
    private final zzix zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public zzjh(zzix object, String object2, Object[] objectArray) {
        void var8_11;
        Object object3;
        Object object4;
        block11: {
            int n10;
            int n11;
            this.zza = object;
            this.zzb = object2;
            this.zzc = objectArray;
            int n12 = 1;
            int n13 = 0;
            objectArray = null;
            try {
                n13 = ((String)object2).charAt(0);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                object2 = ((String)object2).toCharArray();
                object4 = new String((char[])object2);
                try {
                    n13 = ((String)object4).charAt(0);
                    object2 = object4;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2) {
                    try {
                        n11 = ((String)object4).length();
                        char[] cArray = new char[n11];
                        n10 = ((String)object4).length();
                        ((String)object4).getChars(0, n10, cArray, 0);
                        object3 = new String(cArray);
                    }
                    catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3) {
                        // empty catch block
                        break block11;
                    }
                    try {
                        n13 = ((String)object3).charAt(0);
                        object2 = object3;
                    }
                    catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException4) {
                        object4 = object3;
                        break block11;
                    }
                }
            }
            int n14 = 55296;
            if (n13 < n14) {
                this.zzd = n13;
                return;
            }
            n13 &= 0x1FFF;
            n11 = 13;
            while (true) {
                n10 = n12 + 1;
                if ((n12 = (int)((String)object2).charAt(n12)) < n14) {
                    this.zzd = n12 = n12 << n11 | n13;
                    return;
                }
                n12 = (n12 & 0x1FFF) << n11;
                n13 |= n12;
                n11 += 13;
                n12 = n10;
            }
        }
        Object[] objectArray2 = new Object[2];
        objectArray2[0] = object4;
        objectArray2[n12] = object2 = Integer.valueOf(((Object)object2).length);
        object = String.format("Failed parsing '%s' with charArray.length of %d", objectArray2);
        object3 = new IllegalStateException((String)object, (Throwable)var8_11);
        throw object3;
    }

    public final boolean zza() {
        int n10 = this.zzd;
        int n11 = 2;
        return (n10 &= n11) == n11;
    }

    public final zzix zzb() {
        return this.zza;
    }

    public final int zzc() {
        int n10 = this.zzd;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            return n11;
        }
        return 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}

