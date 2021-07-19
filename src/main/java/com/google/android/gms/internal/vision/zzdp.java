/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzdr;
import com.google.android.gms.internal.vision.zzds;
import com.google.android.gms.internal.vision.zzdt;
import com.google.android.gms.internal.vision.zzdu;
import com.google.android.gms.internal.vision.zzdv;
import com.google.android.gms.internal.vision.zzdx;
import com.google.android.gms.internal.vision.zzea;
import com.google.android.gms.internal.vision.zzec;
import com.google.android.gms.internal.vision.zzfc;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzdp
extends AbstractMap
implements Serializable {
    private static final Object zzmf;
    private transient int size;
    private transient Object zzmg;
    public transient int[] zzmh;
    public transient Object[] zzmi;
    public transient Object[] zzmj;
    private transient int zzmk;
    private transient Set zzml;
    private transient Set zzmm;
    private transient Collection zzmn;

    static {
        Object object;
        zzmf = object = new Object();
    }

    public zzdp() {
        int n10 = 1;
        zzde.checkArgument(n10 != 0, "Expected size must be >= 0");
        this.zzmk = n10 = zzfc.zzc(3, n10, -1 >>> 2);
    }

    private final int indexOf(Object object) {
        int n10;
        int n11;
        int n12 = this.zzce();
        int n13 = -1;
        if (n12 != 0) {
            return n13;
        }
        Object object2 = this.zzmg;
        n12 = zzec.zzf(object);
        int n14 = n12 & (n11 = this.zzcg());
        int n15 = zzea.zza(object2, n14);
        if (n15 == 0) {
            return n13;
        }
        n14 = ~n11;
        do {
            Object object3;
            int[] nArray;
            int n16;
            if ((n16 = (n10 = (nArray = this.zzmh)[n15 += -1]) & n14) != (n12 &= n14) || (n16 = (int)(zzcz.equal(object, object3 = this.zzmi[n15]) ? 1 : 0)) == 0) continue;
            return n15;
        } while ((n15 = n10 & n11) != 0);
        return n13;
    }

    private final int zza(int n10, int n11, int n12, int n13) {
        Object object = zzea.zzv(n11);
        n11 += -1;
        if (n13 != 0) {
            zzea.zza(object, n12 &= n11, ++n13);
        }
        Object object2 = this.zzmg;
        int[] nArray = this.zzmh;
        for (int i10 = 0; i10 <= n10; ++i10) {
            int n14 = zzea.zza(object2, i10);
            while (n14 != 0) {
                int n15 = n14 + -1;
                int n16 = nArray[n15];
                int n17 = ~n10 & n16 | i10;
                int n18 = n17 & n11;
                int n19 = zzea.zza(object, n18);
                zzea.zza(object, n18, n14);
                nArray[n15] = n14 = zzea.zzb(n17, n19, n11);
                n14 = n16 & n10;
            }
        }
        this.zzmg = object;
        this.zzs(n11);
        return n11;
    }

    public static /* synthetic */ int zza(zzdp zzdp2) {
        return zzdp2.zzmk;
    }

    public static /* synthetic */ Object zza(zzdp zzdp2, Object object) {
        return zzdp2.zze(object);
    }

    public static /* synthetic */ int zzb(zzdp zzdp2) {
        return zzdp2.zzcg();
    }

    public static /* synthetic */ int zzb(zzdp zzdp2, Object object) {
        return zzdp2.indexOf(object);
    }

    public static /* synthetic */ Object zzc(zzdp zzdp2) {
        return zzdp2.zzmg;
    }

    private final int zzcg() {
        int n10 = this.zzmk & 0x1F;
        int n11 = 1;
        return (n11 << n10) - n11;
    }

    public static /* synthetic */ Object zzcm() {
        return zzmf;
    }

    public static /* synthetic */ int zzd(zzdp zzdp2) {
        int n10;
        int n11 = zzdp2.size;
        zzdp2.size = n10 = n11 + -1;
        return n11;
    }

    private final Object zze(Object object) {
        int n10 = this.zzce();
        if (n10 != 0) {
            return zzmf;
        }
        int n11 = this.zzcg();
        Object object2 = this.zzmg;
        int[] nArray = this.zzmh;
        Object[] objectArray = this.zzmi;
        Object object3 = object;
        int n12 = zzea.zza(object, null, n11, object2, nArray, objectArray, null);
        if (n12 == (n10 = -1)) {
            return zzmf;
        }
        object3 = this.zzmj[n12];
        this.zzf(n12, n11);
        this.size = n12 = this.size + -1;
        this.zzch();
        return object3;
    }

    public static int zzg(int n10, int n11) {
        return n10 + -1;
    }

    private final void zzs(int n10) {
        n10 = Integer.numberOfLeadingZeros(n10);
        n10 = 32 - n10;
        this.zzmk = n10 = zzea.zzb(this.zzmk, n10, 31);
    }

    public final void clear() {
        boolean bl2 = this.zzce();
        if (bl2) {
            return;
        }
        this.zzch();
        Object object = this.zzcf();
        int n10 = 0;
        if (object != null) {
            int n11;
            this.zzmk = n11 = zzfc.zzc(this.size(), 3, -1 >>> 2);
            object.clear();
            this.zzmg = null;
            this.size = 0;
            return;
        }
        object = this.zzmi;
        int n12 = this.size;
        Arrays.fill(object, 0, n12, null);
        object = this.zzmj;
        n12 = this.size;
        Arrays.fill(object, 0, n12, null);
        object = this.zzmg;
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
        object = this.zzmh;
        n10 = this.size;
        Arrays.fill((int[])object, 0, n10, 0);
        this.size = 0;
    }

    public final boolean containsKey(Object object) {
        int n10;
        Map map = this.zzcf();
        if (map != null) {
            return map.containsKey(object);
        }
        int n11 = this.indexOf(object);
        return n11 != (n10 = -1);
    }

    public final boolean containsValue(Object object) {
        int n10;
        Map map = this.zzcf();
        if (map != null) {
            return map.containsValue(object);
        }
        map = null;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            Object object2 = this.zzmj[i10];
            n10 = (int)(zzcz.equal(object, object2) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public final Set entrySet() {
        Set set = this.zzmm;
        if (set == null) {
            this.zzmm = set = new zzdt(this);
        }
        return set;
    }

    public final Object get(Object object) {
        int n10;
        Map map = this.zzcf();
        if (map != null) {
            return map.get(object);
        }
        int n11 = this.indexOf(object);
        if (n11 == (n10 = -1)) {
            return null;
        }
        return this.zzmj[n11];
    }

    public final boolean isEmpty() {
        int n10 = this.size();
        return n10 == 0;
    }

    public final Set keySet() {
        Set set = this.zzml;
        if (set == null) {
            this.zzml = set = new zzdv(this);
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
        zzdp zzdp2 = this;
        Object object3 = object;
        Object object4 = object2;
        int n15 = this.zzce();
        int n16 = 1;
        if (n15 != 0) {
            Object object5;
            n15 = this.zzce();
            String string2 = "Arrays already allocated";
            zzde.checkState(n15 != 0, string2);
            n15 = this.zzmk;
            n14 = 4;
            f10 = 5.6E-45f;
            n13 = Math.max(n15 + 1, 2);
            n12 = Integer.highestOneBit(n13);
            double d10 = 1.0;
            double d11 = (double)n12 * d10;
            n11 = (int)d11;
            n13 = n13 > n11 && (n12 <<= 1) <= 0 ? 0x40000000 : n12;
            n14 = Math.max(n14, n13);
            zzdp2.zzmg = object5 = zzea.zzv(n14);
            zzdp2.zzs(n14 -= n16);
            int[] nArray = new int[n15];
            zzdp2.zzmh = nArray;
            Object[] objectArray = new Object[n15];
            zzdp2.zzmi = objectArray;
            Object[] objectArray2 = new Object[n15];
            zzdp2.zzmj = objectArray2;
        }
        if ((map = this.zzcf()) != null) {
            return map.put(object3, object4);
        }
        int[] nArray = zzdp2.zzmh;
        Object[] objectArray = zzdp2.zzmi;
        Object[] objectArray3 = zzdp2.zzmj;
        n12 = zzdp2.size;
        n11 = n12 + 1;
        Object object6 = zzdp2.zzmg;
        int n17 = zzec.zzf(object);
        int n18 = n17 & (n10 = this.zzcg());
        int n19 = zzea.zza(object6, n18);
        if (n19 == 0) {
            if (n11 > n10) {
                n15 = zzea.zzw(n10);
                n10 = zzdp2.zza(n10, n15, n17, n12);
            } else {
                Object object7 = zzdp2.zzmg;
                zzea.zza(object7, n18, n11);
            }
        } else {
            n18 = ~n10;
            int n20 = n17 & n18;
            int n21 = 0;
            while (true) {
                Object object8;
                int n22;
                int n23;
                if ((n23 = (n22 = nArray[n19 -= n16]) & n18) == n20 && (n23 = (int)(zzcz.equal(object3, object8 = objectArray[n19]) ? 1 : 0)) != 0) {
                    object3 = objectArray3[n19];
                    objectArray3[n19] = object4;
                    return object3;
                }
                n23 = n22 & n10;
                n14 = n21 + 1;
                if (n23 == 0) {
                    n13 = 9;
                    if (n14 >= n13) {
                        n15 = this.zzcg() + n16;
                        n14 = 1065353216;
                        f10 = 1.0f;
                        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n15, f10);
                        n15 = this.zzci();
                        while (true) {
                            if (n15 < 0) {
                                zzdp2.zzmg = linkedHashMap;
                                zzdp2.zzmh = null;
                                zzdp2.zzmi = null;
                                zzdp2.zzmj = null;
                                this.zzch();
                                return linkedHashMap.put(object3, object4);
                            }
                            Object object9 = zzdp2.zzmi[n15];
                            Object object10 = zzdp2.zzmj[n15];
                            linkedHashMap.put(object9, object10);
                            n15 = zzdp2.zzt(n15);
                        }
                    }
                    if (n11 > n10) {
                        n15 = zzea.zzw(n10);
                        n10 = zzdp2.zza(n10, n15, n17, n12);
                        break;
                    }
                    nArray[n19] = n14 = zzea.zzb(n22, n11, n10);
                    break;
                }
                n21 = n14;
                n19 = n23;
            }
        }
        int[] nArray2 = zzdp2.zzmh;
        n15 = nArray2.length;
        if (n11 > n15) {
            n14 = -1 >>> 2;
            f10 = 1.9999999f;
            n13 = n15 >>> 1;
            n13 = Math.max(n16, n13) + n15;
            n16 |= n13;
            if ((n16 = Math.min(n14, n16)) != n15) {
                int[] nArray3 = Arrays.copyOf(zzdp2.zzmh, n16);
                zzdp2.zzmh = nArray3;
                Object[] objectArray4 = Arrays.copyOf(zzdp2.zzmi, n16);
                zzdp2.zzmi = objectArray4;
                Object[] objectArray5 = Arrays.copyOf(zzdp2.zzmj, n16);
                zzdp2.zzmj = objectArray5;
            }
        }
        int[] nArray4 = zzdp2.zzmh;
        nArray4[n12] = n16 = zzea.zzb(n17, 0, n10);
        zzdp2.zzmi[n12] = object3;
        zzdp2.zzmj[n12] = object4;
        zzdp2.size = n11;
        this.zzch();
        return null;
    }

    public final Object remove(Object object) {
        Object object2 = this.zzcf();
        if (object2 != null) {
            return object2.remove(object);
        }
        if ((object = this.zze(object)) == (object2 = zzmf)) {
            object = null;
        }
        return object;
    }

    public final int size() {
        Map map = this.zzcf();
        if (map != null) {
            return map.size();
        }
        return this.size;
    }

    public final Collection values() {
        Collection collection = this.zzmn;
        if (collection == null) {
            this.zzmn = collection = new zzdx(this);
        }
        return collection;
    }

    public final boolean zzce() {
        Object object = this.zzmg;
        return object == null;
    }

    public final Map zzcf() {
        Object object = this.zzmg;
        boolean bl2 = object instanceof Map;
        if (bl2) {
            return (Map)object;
        }
        return null;
    }

    public final void zzch() {
        int n10;
        this.zzmk = n10 = this.zzmk + 32;
    }

    public final int zzci() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return -1;
        }
        return 0;
    }

    public final Iterator zzcj() {
        Object object = this.zzcf();
        if (object != null) {
            return object.keySet().iterator();
        }
        object = new zzds(this);
        return object;
    }

    public final Iterator zzck() {
        Object object = this.zzcf();
        if (object != null) {
            return object.entrySet().iterator();
        }
        object = new zzdr(this);
        return object;
    }

    public final Iterator zzcl() {
        Object object = this.zzcf();
        if (object != null) {
            return object.values().iterator();
        }
        object = new zzdu(this);
        return object;
    }

    public final void zzf(int n10, int n11) {
        int n12 = this.size() + -1;
        int n13 = 0;
        int[] nArray = null;
        int n14 = 0;
        Object object = null;
        if (n10 < n12) {
            int n15;
            Object object2;
            Object object3;
            Object[] objectArray = this.zzmi;
            objectArray[n10] = object3 = objectArray[n12];
            Object[] objectArray2 = this.zzmj;
            objectArray2[n10] = object2 = objectArray2[n12];
            objectArray[n12] = null;
            objectArray2[n12] = null;
            object = this.zzmh;
            object[n10] = n15 = object[n12];
            object[n12] = 0;
            object = this.zzmg;
            n13 = zzec.zzf(object3) & n11;
            n14 = zzea.zza(object, n13);
            if (n14 == ++n12) {
                Object object4 = this.zzmg;
                zzea.zza(object4, n13, ++n10);
                return;
            }
            while (true) {
                int n16;
                if ((n16 = (n15 = (nArray = this.zzmh)[n14 += -1]) & n11) == n12) {
                    ++n10;
                    nArray[n14] = n10 = zzea.zzb(n15, n10, n11);
                    return;
                }
                n14 = n16;
            }
        }
        this.zzmi[n10] = null;
        this.zzmj[n10] = null;
        this.zzmh[n10] = 0;
    }

    public final int zzt(int n10) {
        int n11 = this.size;
        if (++n10 < n11) {
            return n10;
        }
        return -1;
    }
}

