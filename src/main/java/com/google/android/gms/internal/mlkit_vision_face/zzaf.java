/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzag;
import com.google.android.gms.internal.mlkit_vision_face.zzah;
import com.google.android.gms.internal.mlkit_vision_face.zzaj;
import com.google.android.gms.internal.mlkit_vision_face.zzal;
import com.google.android.gms.internal.mlkit_vision_face.zzam;
import com.google.android.gms.internal.mlkit_vision_face.zzan;
import com.google.android.gms.internal.mlkit_vision_face.zzap;
import com.google.android.gms.internal.mlkit_vision_face.zzbk;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzaf
extends AbstractMap
implements Serializable {
    private static final Object zzd;
    public transient int[] zza;
    public transient Object[] zzb;
    public transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    static {
        Object object;
        zzd = object = new Object();
    }

    public zzaf() {
        this.zzb(3);
    }

    public zzaf(int n10) {
        this.zzb(12);
    }

    private final int zza(int n10, int n11, int n12, int n13) {
        Object object = zzam.zza(n11);
        n11 += -1;
        if (n13 != 0) {
            zzam.zza(object, n12 &= n11, ++n13);
        }
        Object object2 = this.zze;
        int[] nArray = this.zza;
        for (int i10 = 0; i10 <= n10; ++i10) {
            int n14 = zzam.zza(object2, i10);
            while (n14 != 0) {
                int n15 = n14 + -1;
                int n16 = nArray[n15];
                int n17 = ~n10 & n16 | i10;
                int n18 = n17 & n11;
                int n19 = zzam.zza(object, n18);
                zzam.zza(object, n18, n14);
                nArray[n15] = n14 = zzam.zza(n17, n19, n11);
                n14 = n16 & n10;
            }
        }
        this.zze = object;
        this.zzc(n11);
        return n11;
    }

    public static /* synthetic */ int zza(zzaf zzaf2) {
        return zzaf2.zzf;
    }

    private final int zza(Object object) {
        int n10;
        int n11;
        int n12 = this.zza();
        int n13 = -1;
        if (n12 != 0) {
            return n13;
        }
        Object object2 = this.zze;
        n12 = zzap.zza(object);
        int n14 = n12 & (n11 = this.zzi());
        int n15 = zzam.zza(object2, n14);
        if (n15 == 0) {
            return n13;
        }
        n14 = ~n11;
        do {
            Object object3;
            int[] nArray;
            int n16;
            if ((n16 = (n10 = (nArray = this.zza)[n15 += -1]) & n14) != (n12 &= n14) || (n16 = (int)(com.google.android.gms.internal.mlkit_vision_face.zzh.zza(object, object3 = this.zzb[n15]) ? 1 : 0)) == 0) continue;
            return n15;
        } while ((n15 = n10 & n11) != 0);
        return n13;
    }

    public static /* synthetic */ Object zza(zzaf zzaf2, Object object) {
        return zzaf2.zzb(object);
    }

    public static int zzb(int n10, int n11) {
        return n10 + -1;
    }

    public static /* synthetic */ int zzb(zzaf zzaf2) {
        return zzaf2.zzi();
    }

    public static /* synthetic */ int zzb(zzaf zzaf2, Object object) {
        return zzaf2.zza(object);
    }

    private final Object zzb(Object object) {
        int n10 = this.zza();
        if (n10 != 0) {
            return zzd;
        }
        int n11 = this.zzi();
        Object object2 = this.zze;
        int[] nArray = this.zza;
        Object[] objectArray = this.zzb;
        Object object3 = object;
        int n12 = zzam.zza(object, null, n11, object2, nArray, objectArray, null);
        if (n12 == (n10 = -1)) {
            return zzd;
        }
        object3 = this.zzc[n12];
        this.zza(n12, n11);
        this.zzg = n12 = this.zzg + -1;
        this.zzc();
        return object3;
    }

    private final void zzb(int n10) {
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            this.zzf = n10 = zzbk.zza(n10, n11, -1 >>> 2);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Expected size must be >= 0");
        throw illegalArgumentException;
    }

    public static /* synthetic */ Object zzc(zzaf zzaf2) {
        return zzaf2.zze;
    }

    private final void zzc(int n10) {
        n10 = Integer.numberOfLeadingZeros(n10);
        n10 = 32 - n10;
        this.zzf = n10 = zzam.zza(this.zzf, n10, 31);
    }

    public static /* synthetic */ int zzd(zzaf zzaf2) {
        int n10;
        int n11 = zzaf2.zzg;
        zzaf2.zzg = n10 = n11 + -1;
        return n11;
    }

    public static /* synthetic */ Object zzh() {
        return zzd;
    }

    private final int zzi() {
        int n10 = this.zzf & 0x1F;
        int n11 = 1;
        return (n11 << n10) - n11;
    }

    public final void clear() {
        boolean bl2 = this.zza();
        if (bl2) {
            return;
        }
        this.zzc();
        Object object = this.zzb();
        int n10 = 0;
        if (object != null) {
            int n11;
            this.zzf = n11 = zzbk.zza(this.size(), 3, -1 >>> 2);
            object.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        object = this.zzb;
        int n12 = this.zzg;
        Arrays.fill(object, 0, n12, null);
        object = this.zzc;
        n12 = this.zzg;
        Arrays.fill(object, 0, n12, null);
        object = this.zze;
        n10 = object instanceof byte[];
        if (n10 != 0) {
            object = (byte[])object;
            Arrays.fill((byte[])object, (byte)0);
        } else {
            n10 = object instanceof short[];
            if (n10 != 0) {
                object = (short[])object;
                Arrays.fill((short[])object, (short)0);
            } else {
                object = (int[])object;
                Arrays.fill((int[])object, 0);
            }
        }
        object = this.zza;
        n10 = this.zzg;
        Arrays.fill((int[])object, 0, n10, 0);
        this.zzg = 0;
    }

    public final boolean containsKey(Object object) {
        int n10;
        Map map = this.zzb();
        if (map != null) {
            return map.containsKey(object);
        }
        int n11 = this.zza(object);
        return n11 != (n10 = -1);
    }

    public final boolean containsValue(Object object) {
        int n10;
        Map map = this.zzb();
        if (map != null) {
            return map.containsValue(object);
        }
        map = null;
        for (int i10 = 0; i10 < (n10 = this.zzg); ++i10) {
            Object object2 = this.zzc[i10];
            n10 = (int)(com.google.android.gms.internal.mlkit_vision_face.zzh.zza(object, object2) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public final Set entrySet() {
        Set set = this.zzi;
        if (set == null) {
            this.zzi = set = new zzaj(this);
        }
        return set;
    }

    public final Object get(Object object) {
        int n10;
        Map map = this.zzb();
        if (map != null) {
            return map.get(object);
        }
        int n11 = this.zza(object);
        if (n11 == (n10 = -1)) {
            return null;
        }
        return this.zzc[n11];
    }

    public final boolean isEmpty() {
        int n10 = this.size();
        return n10 == 0;
    }

    public final Set keySet() {
        Set set = this.zzh;
        if (set == null) {
            this.zzh = set = new zzal(this);
        }
        return set;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final Object put(Object object, Object object2) {
        int n10;
        Map map;
        int n11;
        int n12;
        int n13;
        float f10;
        int n14;
        zzaf zzaf2 = this;
        Object object3 = object;
        Object object4 = object2;
        int n15 = this.zza();
        int n16 = 1;
        if (n15 != 0) {
            Object object5;
            n15 = this.zza();
            String string2 = "Arrays already allocated";
            com.google.android.gms.internal.mlkit_vision_face.zzj.zza(n15 != 0, (Object)string2);
            n15 = this.zzf;
            n14 = 4;
            f10 = 5.6E-45f;
            n13 = Math.max(n15 + 1, 2);
            n12 = Integer.highestOneBit(n13);
            double d10 = 1.0;
            double d11 = (double)n12 * d10;
            n11 = (int)d11;
            n13 = n13 > n11 && (n12 <<= 1) <= 0 ? 0x40000000 : n12;
            n14 = Math.max(n14, n13);
            zzaf2.zze = object5 = zzam.zza(n14);
            zzaf2.zzc(n14 -= n16);
            int[] nArray = new int[n15];
            zzaf2.zza = nArray;
            Object[] objectArray = new Object[n15];
            zzaf2.zzb = objectArray;
            Object[] objectArray2 = new Object[n15];
            zzaf2.zzc = objectArray2;
        }
        if ((map = this.zzb()) != null) {
            return map.put(object3, object4);
        }
        int[] nArray = zzaf2.zza;
        Object[] objectArray = zzaf2.zzb;
        Object[] objectArray3 = zzaf2.zzc;
        n12 = zzaf2.zzg;
        n11 = n12 + 1;
        Object object6 = zzaf2.zze;
        int n17 = zzap.zza(object);
        int n18 = n17 & (n10 = this.zzi());
        int n19 = zzam.zza(object6, n18);
        if (n19 == 0) {
            if (n11 > n10) {
                n15 = zzam.zzb(n10);
                n10 = zzaf2.zza(n10, n15, n17, n12);
            } else {
                Object object7 = zzaf2.zze;
                zzam.zza(object7, n18, n11);
            }
        } else {
            n18 = ~n10;
            int n20 = n17 & n18;
            int n21 = 0;
            while (true) {
                Object object8;
                int n22;
                int n23;
                if ((n23 = (n22 = nArray[n19 -= n16]) & n18) == n20 && (n23 = (int)(com.google.android.gms.internal.mlkit_vision_face.zzh.zza(object3, object8 = objectArray[n19]) ? 1 : 0)) != 0) {
                    object3 = objectArray3[n19];
                    objectArray3[n19] = object4;
                    return object3;
                }
                n23 = n22 & n10;
                n14 = n21 + 1;
                if (n23 == 0) {
                    n13 = 9;
                    if (n14 >= n13) {
                        n15 = this.zzi() + n16;
                        n14 = 1065353216;
                        f10 = 1.0f;
                        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n15, f10);
                        n15 = this.zzd();
                        while (true) {
                            if (n15 < 0) {
                                zzaf2.zze = linkedHashMap;
                                zzaf2.zza = null;
                                zzaf2.zzb = null;
                                zzaf2.zzc = null;
                                this.zzc();
                                return linkedHashMap.put(object3, object4);
                            }
                            Object object9 = zzaf2.zzb[n15];
                            Object object10 = zzaf2.zzc[n15];
                            linkedHashMap.put(object9, object10);
                            n15 = zzaf2.zza(n15);
                        }
                    }
                    if (n11 > n10) {
                        n15 = zzam.zzb(n10);
                        n10 = zzaf2.zza(n10, n15, n17, n12);
                        break;
                    }
                    nArray[n19] = n14 = zzam.zza(n22, n11, n10);
                    break;
                }
                n21 = n14;
                n19 = n23;
            }
        }
        int[] nArray2 = zzaf2.zza;
        n15 = nArray2.length;
        if (n11 > n15) {
            n14 = -1 >>> 2;
            f10 = 1.9999999f;
            n13 = n15 >>> 1;
            n13 = Math.max(n16, n13) + n15;
            n16 |= n13;
            if ((n16 = Math.min(n14, n16)) != n15) {
                int[] nArray3 = Arrays.copyOf(zzaf2.zza, n16);
                zzaf2.zza = nArray3;
                Object[] objectArray4 = Arrays.copyOf(zzaf2.zzb, n16);
                zzaf2.zzb = objectArray4;
                Object[] objectArray5 = Arrays.copyOf(zzaf2.zzc, n16);
                zzaf2.zzc = objectArray5;
            }
        }
        int[] nArray4 = zzaf2.zza;
        nArray4[n12] = n16 = zzam.zza(n17, 0, n10);
        zzaf2.zzb[n12] = object3;
        zzaf2.zzc[n12] = object4;
        zzaf2.zzg = n11;
        this.zzc();
        return null;
    }

    public final Object remove(Object object) {
        Object object2 = this.zzb();
        if (object2 != null) {
            return object2.remove(object);
        }
        if ((object = this.zzb(object)) == (object2 = zzd)) {
            object = null;
        }
        return object;
    }

    public final int size() {
        Map map = this.zzb();
        if (map != null) {
            return map.size();
        }
        return this.zzg;
    }

    public final Collection values() {
        Collection collection = this.zzj;
        if (collection == null) {
            this.zzj = collection = new zzan(this);
        }
        return collection;
    }

    public final int zza(int n10) {
        int n11 = this.zzg;
        if (++n10 < n11) {
            return n10;
        }
        return -1;
    }

    public final void zza(int n10, int n11) {
        int n12 = this.size() + -1;
        int n13 = 0;
        int[] nArray = null;
        int n14 = 0;
        Object object = null;
        if (n10 < n12) {
            int n15;
            Object object2;
            Object object3;
            Object[] objectArray = this.zzb;
            objectArray[n10] = object3 = objectArray[n12];
            Object[] objectArray2 = this.zzc;
            objectArray2[n10] = object2 = objectArray2[n12];
            objectArray[n12] = null;
            objectArray2[n12] = null;
            object = this.zza;
            object[n10] = n15 = object[n12];
            object[n12] = 0;
            object = this.zze;
            n13 = zzap.zza(object3) & n11;
            n14 = zzam.zza(object, n13);
            if (n14 == ++n12) {
                Object object4 = this.zze;
                zzam.zza(object4, n13, ++n10);
                return;
            }
            while (true) {
                int n16;
                if ((n16 = (n15 = (nArray = this.zza)[n14 += -1]) & n11) == n12) {
                    ++n10;
                    nArray[n14] = n10 = zzam.zza(n15, n10, n11);
                    return;
                }
                n14 = n16;
            }
        }
        this.zzb[n10] = null;
        this.zzc[n10] = null;
        this.zza[n10] = 0;
    }

    public final boolean zza() {
        Object object = this.zze;
        return object == null;
    }

    public final Map zzb() {
        Object object = this.zze;
        boolean bl2 = object instanceof Map;
        if (bl2) {
            return (Map)object;
        }
        return null;
    }

    public final void zzc() {
        int n10;
        this.zzf = n10 = this.zzf + 32;
    }

    public final int zzd() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return -1;
        }
        return 0;
    }

    public final Iterator zze() {
        Object object = this.zzb();
        if (object != null) {
            return object.keySet().iterator();
        }
        object = new zzae(this);
        return object;
    }

    public final Iterator zzf() {
        Object object = this.zzb();
        if (object != null) {
            return object.entrySet().iterator();
        }
        object = new zzah(this);
        return object;
    }

    public final Iterator zzg() {
        Object object = this.zzb();
        if (object != null) {
            return object.values().iterator();
        }
        object = new zzag(this);
        return object;
    }
}

