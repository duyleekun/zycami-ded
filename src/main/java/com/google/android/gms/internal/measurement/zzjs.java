/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjl;
import com.google.android.gms.internal.measurement.zzjo;
import com.google.android.gms.internal.measurement.zzjp;
import com.google.android.gms.internal.measurement.zzjr;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class zzjs
extends AbstractMap {
    private final int zza;
    private List zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzjr zze;
    private Map zzf;

    public /* synthetic */ zzjs(int n10, zzjl zzjl2) {
        this.zza = n10;
        Map map = Collections.emptyList();
        this.zzb = map;
        map = Collections.emptyMap();
        this.zzc = map;
        this.zzf = map = Collections.emptyMap();
    }

    public static /* synthetic */ void zzg(zzjs zzjs2) {
        zzjs2.zzm();
    }

    public static /* synthetic */ List zzh(zzjs zzjs2) {
        return zzjs2.zzb;
    }

    public static /* synthetic */ Map zzi(zzjs zzjs2) {
        return zzjs2.zzc;
    }

    public static /* synthetic */ Object zzj(zzjs zzjs2, int n10) {
        return zzjs2.zzk(n10);
    }

    private final Object zzk(int n10) {
        this.zzm();
        Object object = ((zzjp)this.zzb.remove(n10)).getValue();
        Object object2 = this.zzc;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.zzn().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry)object2.next();
            Comparable comparable = (Comparable)entry.getKey();
            entry = entry.getValue();
            zzjp zzjp2 = new zzjp(this, comparable, entry);
            list.add(zzjp2);
            object2.remove();
        }
        return object;
    }

    private final int zzl(Comparable comparable) {
        int n10;
        List list = this.zzb;
        int n11 = list.size() + -1;
        int n12 = 0;
        if (n11 >= 0) {
            Comparable comparable2 = ((zzjp)this.zzb.get(n11)).zza();
            n10 = comparable.compareTo(comparable2);
            if (n10 > 0) {
                return -(n11 + 2);
            }
            if (n10 == 0) {
                return n11;
            }
        }
        while (n12 <= n11) {
            n10 = (n12 + n11) / 2;
            Comparable comparable3 = ((zzjp)this.zzb.get(n10)).zza();
            int n13 = comparable.compareTo(comparable3);
            if (n13 < 0) {
                n11 = n10 += -1;
                continue;
            }
            if (n13 > 0) {
                n12 = ++n10;
                continue;
            }
            return n10;
        }
        return -(n12 + 1);
    }

    private final void zzm() {
        boolean bl2 = this.zzd;
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private final SortedMap zzn() {
        this.zzm();
        NavigableMap navigableMap = this.zzc;
        boolean bl2 = navigableMap.isEmpty();
        if (bl2 && !(bl2 = (navigableMap = this.zzc) instanceof TreeMap)) {
            this.zzc = navigableMap = new NavigableMap();
            this.zzf = navigableMap = navigableMap.descendingMap();
        }
        return (SortedMap)this.zzc;
    }

    public final void clear() {
        this.zzm();
        Object object = this.zzb;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            object = this.zzb;
            object.clear();
        }
        if (!(bl2 = (object = this.zzc).isEmpty())) {
            object = this.zzc;
            object.clear();
        }
    }

    public final boolean containsKey(Object object) {
        Map map;
        boolean bl2;
        int n10 = this.zzl((Comparable)(object = (Comparable)object));
        return n10 >= 0 || (bl2 = (map = this.zzc).containsKey(object));
        {
        }
    }

    public final Set entrySet() {
        zzjr zzjr2 = this.zze;
        if (zzjr2 == null) {
            this.zze = zzjr2 = new zzjr(this, null);
        }
        return this.zze;
    }

    public final boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof zzjs;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (zzjs)object;
        n12 = this.size();
        if (n12 != (n11 = ((zzjs)object).size())) {
            return false;
        }
        n11 = this.zzc();
        if (n11 == (n10 = ((zzjs)object).zzc())) {
            for (n10 = 0; n10 < n11; ++n10) {
                Map.Entry entry;
                Map.Entry entry2 = this.zzd(n10);
                boolean bl3 = entry2.equals(entry = ((zzjs)object).zzd(n10));
                if (bl3) continue;
                return false;
            }
            if (n11 != n12) {
                Map map = this.zzc;
                object = ((zzjs)object).zzc;
                return map.equals(object);
            }
            return bl2;
        }
        Set set = this.entrySet();
        object = ((zzjs)object).entrySet();
        return set.equals(object);
    }

    public final Object get(Object object) {
        int n10 = this.zzl((Comparable)(object = (Comparable)object));
        if (n10 >= 0) {
            return ((zzjp)this.zzb.get(n10)).getValue();
        }
        return this.zzc.get(object);
    }

    public final int hashCode() {
        int n10 = this.zzc();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            zzjp zzjp2 = (zzjp)this.zzb.get(i10);
            int n12 = zzjp2.hashCode();
            n11 += n12;
        }
        Map map = this.zzc;
        n10 = map.size();
        if (n10 > 0) {
            map = this.zzc;
            n10 = map.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public final Object remove(Object object) {
        this.zzm();
        object = (Comparable)object;
        int n10 = this.zzl((Comparable)object);
        if (n10 >= 0) {
            return this.zzk(n10);
        }
        Map map = this.zzc;
        n10 = (int)(map.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        return this.zzc.remove(object);
    }

    public final int size() {
        int n10 = this.zzb.size();
        int n11 = this.zzc.size();
        return n10 + n11;
    }

    public void zza() {
        boolean bl2 = this.zzd;
        if (!bl2) {
            Map map = this.zzc;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
            this.zzc = map;
            map = this.zzf;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
            this.zzf = map;
            this.zzd = bl2 = true;
        }
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Map.Entry zzd(int n10) {
        return (Map.Entry)this.zzb.get(n10);
    }

    public final Iterable zze() {
        Object object = this.zzc;
        boolean bl2 = object.isEmpty();
        object = bl2 ? zzjo.zza() : this.zzc.entrySet();
        return object;
    }

    public final Object zzf(Comparable comparable, Object object) {
        Object object2;
        int n10;
        this.zzm();
        int n11 = this.zzl(comparable);
        if (n11 >= 0) {
            return ((zzjp)this.zzb.get(n11)).setValue(object);
        }
        this.zzm();
        Object object3 = this.zzb;
        int n12 = object3.isEmpty();
        if (n12 != 0 && (n12 = (object3 = this.zzb) instanceof ArrayList) == 0) {
            n10 = this.zza;
            object3 = new ArrayList(n10);
            this.zzb = object3;
        }
        if ((n11 = -(n11 + 1)) >= (n12 = this.zza)) {
            return this.zzn().put(comparable, object);
        }
        object3 = this.zzb;
        n12 = object3.size();
        if (n12 == (n10 = this.zza)) {
            object3 = this.zzb;
            object3 = (zzjp)object3.remove(n10 += -1);
            object2 = this.zzn();
            Comparable comparable2 = ((zzjp)object3).zza();
            object3 = ((zzjp)object3).getValue();
            object2.put(comparable2, object3);
        }
        object3 = this.zzb;
        object2 = new zzjp(this, comparable, object);
        object3.add(n11, object2);
        return null;
    }
}

