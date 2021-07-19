/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhv;
import com.google.android.gms.internal.mlkit_common.zzhw;
import com.google.android.gms.internal.mlkit_common.zzhx;
import com.google.android.gms.internal.mlkit_common.zzib;
import com.google.android.gms.internal.mlkit_common.zzid;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class zzhs
extends AbstractMap {
    private final int zza;
    private List zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzid zze;
    private Map zzf;
    private volatile zzhx zzg;

    private zzhs(int n10) {
        this.zza = n10;
        Map map = Collections.emptyList();
        this.zzb = map;
        map = Collections.emptyMap();
        this.zzc = map;
        this.zzf = map = Collections.emptyMap();
    }

    public /* synthetic */ zzhs(int n10, zzhv zzhv2) {
        this(n10);
    }

    private final int zza(Comparable comparable) {
        int n10;
        Comparable comparable2;
        List list = this.zzb;
        int n11 = list.size() + -1;
        if (n11 >= 0) {
            comparable2 = (Comparable)((zzib)this.zzb.get(n11)).getKey();
            n10 = comparable.compareTo(comparable2);
            if (n10 > 0) {
                return -(n11 + 2);
            }
            if (n10 == 0) {
                return n11;
            }
        }
        n10 = 0;
        comparable2 = null;
        while (n10 <= n11) {
            int n12 = (n10 + n11) / 2;
            Comparable comparable3 = (Comparable)((zzib)this.zzb.get(n12)).getKey();
            int n13 = comparable.compareTo(comparable3);
            if (n13 < 0) {
                n11 = n12 + -1;
                continue;
            }
            if (n13 > 0) {
                n10 = n12 + 1;
                continue;
            }
            return n12;
        }
        return -(n10 + 1);
    }

    public static zzhs zza(int n10) {
        zzhv zzhv2 = new zzhv(n10);
        return zzhv2;
    }

    public static /* synthetic */ Object zza(zzhs zzhs2, int n10) {
        return zzhs2.zzc(n10);
    }

    public static /* synthetic */ void zza(zzhs zzhs2) {
        zzhs2.zzf();
    }

    public static /* synthetic */ List zzb(zzhs zzhs2) {
        return zzhs2.zzb;
    }

    private final Object zzc(int n10) {
        this.zzf();
        Object object = ((zzib)this.zzb.remove(n10)).getValue();
        Object object2 = this.zzc;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.zzg().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry)object2.next();
            zzib zzib2 = new zzib(this, entry);
            list.add(zzib2);
            object2.remove();
        }
        return object;
    }

    public static /* synthetic */ Map zzc(zzhs zzhs2) {
        return zzhs2.zzc;
    }

    public static /* synthetic */ Map zzd(zzhs zzhs2) {
        return zzhs2.zzf;
    }

    private final void zzf() {
        boolean bl2 = this.zzd;
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private final SortedMap zzg() {
        this.zzf();
        NavigableMap navigableMap = this.zzc;
        boolean bl2 = navigableMap.isEmpty();
        if (bl2 && !(bl2 = (navigableMap = this.zzc) instanceof TreeMap)) {
            this.zzc = navigableMap = new NavigableMap();
            this.zzf = navigableMap = navigableMap.descendingMap();
        }
        return (SortedMap)this.zzc;
    }

    public void clear() {
        this.zzf();
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

    public boolean containsKey(Object object) {
        Map map;
        boolean bl2;
        int n10 = this.zza((Comparable)(object = (Comparable)object));
        return n10 >= 0 || (bl2 = (map = this.zzc).containsKey(object));
        {
        }
    }

    public Set entrySet() {
        zzid zzid2 = this.zze;
        if (zzid2 == null) {
            this.zze = zzid2 = new zzid(this, null);
        }
        return this.zze;
    }

    public boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof zzhs;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (zzhs)object;
        n12 = this.size();
        if (n12 != (n11 = ((zzhs)object).size())) {
            return false;
        }
        n11 = this.zzc();
        if (n11 != (n10 = ((zzhs)object).zzc())) {
            Set set = this.entrySet();
            object = ((zzhs)object).entrySet();
            return set.equals(object);
        }
        for (n10 = 0; n10 < n11; ++n10) {
            Map.Entry entry;
            Map.Entry entry2 = this.zzb(n10);
            boolean bl3 = entry2.equals(entry = ((zzhs)object).zzb(n10));
            if (bl3) continue;
            return false;
        }
        if (n11 != n12) {
            Map map = this.zzc;
            object = ((zzhs)object).zzc;
            return map.equals(object);
        }
        return bl2;
    }

    public Object get(Object object) {
        int n10 = this.zza((Comparable)(object = (Comparable)object));
        if (n10 >= 0) {
            return ((zzib)this.zzb.get(n10)).getValue();
        }
        return this.zzc.get(object);
    }

    public int hashCode() {
        int n10 = this.zzc();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            zzib zzib2 = (zzib)this.zzb.get(i10);
            int n12 = zzib2.hashCode();
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

    public /* synthetic */ Object put(Object object, Object object2) {
        object = (Comparable)object;
        return this.zza((Comparable)object, object2);
    }

    public Object remove(Object object) {
        this.zzf();
        object = (Comparable)object;
        int n10 = this.zza((Comparable)object);
        if (n10 >= 0) {
            return this.zzc(n10);
        }
        Map map = this.zzc;
        n10 = (int)(map.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        return this.zzc.remove(object);
    }

    public int size() {
        int n10 = this.zzb.size();
        int n11 = this.zzc.size();
        return n10 + n11;
    }

    public final Object zza(Comparable comparable, Object object) {
        Object object2;
        int n10;
        this.zzf();
        int n11 = this.zza(comparable);
        if (n11 >= 0) {
            return ((zzib)this.zzb.get(n11)).setValue(object);
        }
        this.zzf();
        Object object3 = this.zzb;
        int n12 = object3.isEmpty();
        if (n12 != 0 && (n12 = (object3 = this.zzb) instanceof ArrayList) == 0) {
            n10 = this.zza;
            object3 = new ArrayList(n10);
            this.zzb = object3;
        }
        if ((n11 = -(n11 + 1)) >= (n12 = this.zza)) {
            return this.zzg().put(comparable, object);
        }
        object3 = this.zzb;
        n12 = object3.size();
        if (n12 == (n10 = this.zza)) {
            object3 = this.zzb;
            object3 = (zzib)object3.remove(n10 += -1);
            object2 = this.zzg();
            Comparable comparable2 = (Comparable)((zzib)object3).getKey();
            object3 = ((zzib)object3).getValue();
            object2.put(comparable2, object3);
        }
        object3 = this.zzb;
        object2 = new zzib(this, comparable, object);
        object3.add(n11, object2);
        return null;
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

    public final Map.Entry zzb(int n10) {
        return (Map.Entry)this.zzb.get(n10);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Iterable zzd() {
        Map map = this.zzc;
        boolean bl2 = map.isEmpty();
        if (bl2) {
            return zzhw.zza();
        }
        return this.zzc.entrySet();
    }

    public final Set zze() {
        zzhx zzhx2 = this.zzg;
        if (zzhx2 == null) {
            this.zzg = zzhx2 = new zzhx(this, null);
        }
        return this.zzg;
    }
}

