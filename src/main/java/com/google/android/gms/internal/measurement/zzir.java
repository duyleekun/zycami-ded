/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzia;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzir
extends LinkedHashMap {
    private static final zzir zzb;
    private boolean zza = true;

    static {
        zzir zzir2;
        zzb = zzir2 = new zzir();
        zzir2.zza = false;
    }

    private zzir() {
    }

    private zzir(Map map) {
        super(map);
    }

    public static zzir zza() {
        return zzb;
    }

    private static int zzf(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return zzia.zzg((byte[])object);
        }
        bl2 = object instanceof zzhu;
        if (!bl2) {
            return object.hashCode();
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    private final void zzg() {
        boolean bl2 = this.zza;
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void clear() {
        this.zzg();
        super.clear();
    }

    public final Set entrySet() {
        boolean bl2 = this.isEmpty();
        Set<Object> set = bl2 ? Collections.emptySet() : super.entrySet();
        return set;
    }

    public final boolean equals(Object object) {
        int n10 = object instanceof Map;
        if (n10 != 0) {
            if (this != (object = (Map)object)) {
                int n11;
                n10 = this.size();
                if (n10 == (n11 = object.size())) {
                    Iterator iterator2 = this.entrySet().iterator();
                    while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        Map.Entry entry = iterator2.next();
                        Object object2 = entry.getKey();
                        boolean bl2 = object.containsKey(object2);
                        if (bl2) {
                            object2 = entry.getValue();
                            entry = entry.getKey();
                            entry = object.get(entry);
                            boolean bl3 = object2 instanceof byte[];
                            if (bl3 && (bl3 = entry instanceof byte[])) {
                                object2 = (byte[])object2;
                                entry = (Map.Entry)((byte[])entry);
                                n11 = (int)(Arrays.equals(object2, (byte[])entry) ? 1 : 0);
                            } else {
                                n11 = (int)(object2.equals(entry) ? 1 : 0);
                            }
                            if (n11 != 0) continue;
                        }
                        break;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int n10;
        Iterator iterator2 = this.entrySet().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Map.Entry entry = iterator2.next();
            Object k10 = entry.getKey();
            int n12 = zzir.zzf(k10);
            entry = entry.getValue();
            n10 = zzir.zzf(entry) ^ n12;
            n11 += n10;
        }
        return n11;
    }

    public final Object put(Object object, Object object2) {
        this.zzg();
        zzia.zza(object);
        zzia.zza(object2);
        return super.put(object, object2);
    }

    public final void putAll(Map map) {
        boolean bl2;
        this.zzg();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            zzia.zza(object);
            object = map.get(object);
            zzia.zza(object);
        }
        super.putAll(map);
    }

    public final Object remove(Object object) {
        this.zzg();
        return super.remove(object);
    }

    public final void zzb(zzir zzir2) {
        this.zzg();
        boolean bl2 = zzir2.isEmpty();
        if (!bl2) {
            this.putAll((Map)zzir2);
        }
    }

    public final zzir zzc() {
        boolean bl2 = this.isEmpty();
        zzir zzir2 = bl2 ? new zzir() : new zzir((Map)this);
        return zzir2;
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }
}

