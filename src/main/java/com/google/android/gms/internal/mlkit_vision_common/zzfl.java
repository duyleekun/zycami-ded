/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzem;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzfl
extends LinkedHashMap {
    private static final zzfl zzb;
    private boolean zza = true;

    static {
        zzfl zzfl2;
        zzb = zzfl2 = new zzfl();
        zzfl2.zza = false;
    }

    private zzfl() {
    }

    private zzfl(Map map) {
        super(map);
    }

    private static int zza(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return zzem.zzc((byte[])object);
        }
        bl2 = object instanceof zzel;
        if (!bl2) {
            return object.hashCode();
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    private final void zzd() {
        boolean bl2 = this.zza;
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void clear() {
        this.zzd();
        super.clear();
    }

    public final Set entrySet() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean equals(Object object) {
        boolean bl2 = object instanceof Map;
        if (!bl2) return false;
        object = (Map)object;
        bl2 = true;
        if (this != object) {
            int n10;
            int n11 = this.size();
            if (n11 != (n10 = object.size())) {
                return false;
            }
            Iterator iterator2 = this.entrySet().iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                Map.Entry entry = iterator2.next();
                Object k10 = entry.getKey();
                boolean bl3 = object.containsKey(k10);
                if (!bl3) return false;
                Object v10 = entry.getValue();
                entry = entry.getKey();
                entry = object.get(entry);
                boolean bl4 = v10 instanceof byte[];
                if (bl4 && (bl4 = entry instanceof byte[])) {
                    byte[] byArray = (byte[])v10;
                    entry = (Map.Entry)((byte[])entry);
                    n10 = (int)(Arrays.equals(byArray, (byte[])entry) ? 1 : 0);
                } else {
                    n10 = (int)(v10.equals(entry) ? 1 : 0);
                }
                if (n10 != 0) continue;
                return false;
            }
        }
        boolean bl5 = bl2;
        if (!bl5) return false;
        return bl2;
    }

    public final int hashCode() {
        int n10;
        Iterator iterator2 = this.entrySet().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Map.Entry entry = iterator2.next();
            Object k10 = entry.getKey();
            int n12 = zzfl.zza(k10);
            entry = entry.getValue();
            n10 = zzfl.zza(entry) ^ n12;
            n11 += n10;
        }
        return n11;
    }

    public final Object put(Object object, Object object2) {
        this.zzd();
        zzem.zza(object);
        zzem.zza(object2);
        return super.put(object, object2);
    }

    public final void putAll(Map map) {
        boolean bl2;
        this.zzd();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            zzem.zza(object);
            object = map.get(object);
            zzem.zza(object);
        }
        super.putAll(map);
    }

    public final Object remove(Object object) {
        this.zzd();
        return super.remove(object);
    }

    public final zzfl zza() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            zzfl zzfl2 = new zzfl();
            return zzfl2;
        }
        zzfl zzfl3 = new zzfl((Map)this);
        return zzfl3;
    }

    public final void zza(zzfl zzfl2) {
        this.zzd();
        boolean bl2 = zzfl2.isEmpty();
        if (!bl2) {
            this.putAll((Map)zzfl2);
        }
    }

    public final void zzb() {
        this.zza = false;
    }

    public final boolean zzc() {
        return this.zza;
    }
}

