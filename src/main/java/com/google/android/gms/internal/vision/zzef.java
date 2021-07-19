/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzey;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class zzef
implements Serializable,
Map {
    private static final Map.Entry[] zzmx = new Map.Entry[0];
    private transient zzej zzmy;
    private transient zzej zzmz;
    private transient zzeb zzna;

    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean containsKey(Object object) {
        return (object = this.get(object)) != null;
    }

    public boolean containsValue(Object object) {
        return ((zzeb)this.values()).contains(object);
    }

    public /* synthetic */ Set entrySet() {
        zzej zzej2 = this.zzmy;
        if (zzej2 == null) {
            this.zzmy = zzej2 = this.zzcw();
        }
        return zzej2;
    }

    public boolean equals(Object set) {
        if (this == set) {
            return true;
        }
        boolean bl2 = set instanceof Map;
        if (bl2) {
            set = (Map)((Object)set);
            Set set2 = this.entrySet();
            set = set.entrySet();
            return set2.equals(set);
        }
        return false;
    }

    public abstract Object get(Object var1);

    public final Object getOrDefault(Object object, Object object2) {
        if ((object = this.get(object)) != null) {
            return object;
        }
        return object2;
    }

    public int hashCode() {
        return zzey.zza((zzej)this.entrySet());
    }

    public boolean isEmpty() {
        int n10 = this.size();
        return n10 == 0;
    }

    public /* synthetic */ Set keySet() {
        zzej zzej2 = this.zzmz;
        if (zzej2 == null) {
            this.zzmz = zzej2 = this.zzcx();
        }
        return zzej2;
    }

    public final Object put(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void putAll(Map object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final Object remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public String toString() {
        int n10 = this.size();
        if (n10 >= 0) {
            boolean bl2;
            long l10 = (long)n10 << 3;
            long l11 = 0x40000000L;
            l10 = Math.min(l10, l11);
            n10 = (int)l10;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append('{');
            n10 = 1;
            Iterator iterator2 = this.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                String string2;
                Map.Entry entry = iterator2.next();
                if (n10 == 0) {
                    string2 = ", ";
                    stringBuilder.append(string2);
                }
                n10 = 0;
                string2 = null;
                Object k10 = entry.getKey();
                stringBuilder.append(k10);
                char c10 = '=';
                stringBuilder.append(c10);
                entry = entry.getValue();
                stringBuilder.append(entry);
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
        String string3 = "size";
        int n11 = string3.length() + 40;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(string3);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(n10);
        String string4 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    public /* synthetic */ Collection values() {
        zzeb zzeb2 = this.zzna;
        if (zzeb2 == null) {
            this.zzna = zzeb2 = this.zzcy();
        }
        return zzeb2;
    }

    public abstract zzej zzcw();

    public abstract zzej zzcx();

    public abstract zzeb zzcy();
}

