/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zza;
import com.google.android.gms.internal.mlkit_vision_common.zzd;
import com.google.android.gms.internal.mlkit_vision_common.zze;
import com.google.android.gms.internal.mlkit_vision_common.zzg;
import com.google.android.gms.internal.mlkit_vision_common.zzi;
import com.google.android.gms.internal.mlkit_vision_common.zzj;
import com.google.android.gms.internal.mlkit_vision_common.zzk;
import com.google.android.gms.internal.mlkit_vision_common.zzl;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzh
extends zze
implements List,
RandomAccess {
    private static final zzk zza;

    static {
        zzh zzh2 = zzi.zza;
        zzg zzg2 = new zzg(zzh2, 0);
        zza = zzg2;
    }

    public static zzh zza(Object object, Object object2, Object object3, Object object4) {
        int n10 = 4;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object2;
        objectArray[2] = object3;
        int n11 = 3;
        objectArray[n11] = object4;
        for (int i10 = 0; i10 < n10; ++i10) {
            object = objectArray[i10];
            if (object != null) {
                continue;
            }
            object3 = new StringBuilder(20);
            ((StringBuilder)object3).append("at index ");
            ((StringBuilder)object3).append(i10);
            object2 = ((StringBuilder)object3).toString();
            object = new NullPointerException((String)object2);
            throw object;
        }
        object = new zzi(objectArray, n10);
        return object;
    }

    public final void add(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final boolean addAll(int n10, Collection collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean contains(Object object) {
        int n10 = this.indexOf(object);
        return n10 >= 0;
    }

    public boolean equals(Object iterator2) {
        block10: {
            Object object = zzd.zza(this);
            boolean bl2 = true;
            if (iterator2 == object) {
                return bl2;
            }
            int n10 = iterator2 instanceof List;
            if (n10 != 0) {
                int n11;
                iterator2 = (List)((Object)iterator2);
                n10 = this.size();
                if (n10 == (n11 = iterator2.size())) {
                    n11 = iterator2 instanceof RandomAccess;
                    if (n11 != 0) {
                        for (n11 = 0; n11 < n10; ++n11) {
                            Object e10;
                            Object e11 = this.get(n11);
                            boolean bl3 = com.google.android.gms.internal.mlkit_vision_common.zza.zza(e11, e10 = ((List)((Object)iterator2)).get(n11));
                            if (bl3) {
                                continue;
                            }
                            break block10;
                        }
                        return bl2;
                    }
                    n10 = this.size();
                    iterator2 = iterator2.iterator();
                    for (n11 = 0; n11 < n10; ++n11) {
                        boolean bl4 = iterator2.hasNext();
                        if (bl4) {
                            Object e12 = this.get(n11);
                            Object e13 = iterator2.next();
                            bl4 = com.google.android.gms.internal.mlkit_vision_common.zza.zza(e12, e13);
                            if (bl4) {
                                continue;
                            }
                        }
                        break block10;
                    }
                    boolean bl5 = iterator2.hasNext();
                    if (!bl5) {
                        return bl2;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.size();
        int n11 = 1;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 *= 31;
            Object e10 = this.get(i10);
            int n12 = e10.hashCode();
            n11 = ~(~(n11 + n12));
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10;
        int n11 = -1;
        if (object == null) {
            return n11;
        }
        int n12 = this.size();
        if (object == null) {
            for (n10 = 0; n10 < n12; ++n10) {
                object = this.get(n10);
                if (object != null) continue;
                return n10;
            }
        } else {
            while (n10 < n12) {
                Object e10 = this.get(n10);
                boolean bl2 = object.equals(e10);
                if (bl2) {
                    return n10;
                }
                ++n10;
            }
        }
        return n11;
    }

    public /* synthetic */ Iterator iterator() {
        return ((zze)this).zza();
    }

    public int lastIndexOf(Object object) {
        int n10 = -1;
        if (object == null) {
            return n10;
        }
        if (object == null) {
            for (int i10 = this.size() + -1; i10 >= 0; i10 += -1) {
                Object e10 = this.get(i10);
                if (e10 != null) continue;
                return i10;
            }
        } else {
            for (int i11 = this.size() + -1; i11 >= 0; i11 += -1) {
                Object e11 = this.get(i11);
                boolean bl2 = object.equals(e11);
                if (!bl2) continue;
                return i11;
            }
        }
        return n10;
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzk)this.listIterator(0);
    }

    public /* synthetic */ ListIterator listIterator(int n10) {
        int n11 = this.size();
        zzd.zzb(n10, n11);
        n11 = (int)(this.isEmpty() ? 1 : 0);
        if (n11 != 0) {
            return zza;
        }
        zzg zzg2 = new zzg(this, n10);
        return zzg2;
    }

    public final Object remove(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final Object set(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public /* synthetic */ List subList(int n10, int n11) {
        return this.zza(n10, n11);
    }

    public int zza(Object[] objectArray, int n10) {
        n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object e10 = this.get(i10);
            objectArray[i10] = e10;
        }
        return n10;
    }

    public zzh zza(int n10, int n11) {
        int n12 = this.size();
        zzd.zza(n10, n11, n12);
        n12 = this.size();
        if ((n11 -= n10) == n12) {
            return this;
        }
        if (n11 == 0) {
            return zzi.zza;
        }
        zzj zzj2 = new zzj(this, n10, n11);
        return zzj2;
    }

    public final zzl zza() {
        return (zzk)this.listIterator();
    }
}

