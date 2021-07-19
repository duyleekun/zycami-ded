/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcj;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzdi
extends LinkedHashMap {
    private static final zzdi zzme;
    private boolean zzfa = true;

    static {
        zzdi zzdi2;
        zzme = zzdi2 = new zzdi();
        zzdi2.zzfa = false;
    }

    private zzdi() {
    }

    private zzdi(Map map) {
        super(map);
    }

    public static zzdi zzbz() {
        return zzme;
    }

    private final void zzcb() {
        boolean bl2 = this.zzfa;
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private static int zzf(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return zzci.hashCode((byte[])object);
        }
        bl2 = object instanceof zzcj;
        if (!bl2) {
            return object.hashCode();
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void clear() {
        this.zzcb();
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
            int n12 = zzdi.zzf(k10);
            entry = entry.getValue();
            n10 = zzdi.zzf(entry) ^ n12;
            n11 += n10;
        }
        return n11;
    }

    public final boolean isMutable() {
        return this.zzfa;
    }

    public final Object put(Object object, Object object2) {
        this.zzcb();
        zzci.checkNotNull(object);
        zzci.checkNotNull(object2);
        return super.put(object, object2);
    }

    public final void putAll(Map map) {
        boolean bl2;
        this.zzcb();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            zzci.checkNotNull(object);
            object = map.get(object);
            zzci.checkNotNull(object);
        }
        super.putAll(map);
    }

    public final Object remove(Object object) {
        this.zzcb();
        return super.remove(object);
    }

    public final void zza(zzdi zzdi2) {
        this.zzcb();
        boolean bl2 = zzdi2.isEmpty();
        if (!bl2) {
            this.putAll((Map)zzdi2);
        }
    }

    public final zzdi zzca() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            zzdi zzdi2 = new zzdi();
            return zzdi2;
        }
        zzdi zzdi3 = new zzdi((Map)this);
        return zzdi3;
    }

    public final void zzv() {
        this.zzfa = false;
    }
}

