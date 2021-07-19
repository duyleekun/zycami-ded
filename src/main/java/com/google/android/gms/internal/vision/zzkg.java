/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzkj;
import com.google.android.gms.internal.vision.zzkk;
import com.google.android.gms.internal.vision.zzkl;
import com.google.android.gms.internal.vision.zzkp;
import com.google.android.gms.internal.vision.zzkr;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class zzkg
extends AbstractMap {
    private final int zzabk;
    private List zzabl;
    private Map zzabm;
    private volatile zzkr zzabn;
    private Map zzabo;
    private volatile zzkl zzabp;
    private boolean zzuy;

    private zzkg(int n10) {
        this.zzabk = n10;
        Map map = Collections.emptyList();
        this.zzabl = map;
        map = Collections.emptyMap();
        this.zzabm = map;
        this.zzabo = map = Collections.emptyMap();
    }

    public /* synthetic */ zzkg(int n10, zzkj zzkj2) {
        this(n10);
    }

    private final int zza(Comparable comparable) {
        int n10;
        Comparable comparable2;
        List list = this.zzabl;
        int n11 = list.size() + -1;
        if (n11 >= 0) {
            comparable2 = (Comparable)((zzkp)this.zzabl.get(n11)).getKey();
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
            Comparable comparable3 = (Comparable)((zzkp)this.zzabl.get(n12)).getKey();
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

    public static /* synthetic */ Object zza(zzkg zzkg2, int n10) {
        return zzkg2.zzcd(n10);
    }

    public static /* synthetic */ void zza(zzkg zzkg2) {
        zzkg2.zziq();
    }

    public static /* synthetic */ List zzb(zzkg zzkg2) {
        return zzkg2.zzabl;
    }

    public static /* synthetic */ Map zzc(zzkg zzkg2) {
        return zzkg2.zzabm;
    }

    public static zzkg zzcb(int n10) {
        zzkj zzkj2 = new zzkj(n10);
        return zzkj2;
    }

    private final Object zzcd(int n10) {
        this.zziq();
        Object object = ((zzkp)this.zzabl.remove(n10)).getValue();
        Object object2 = this.zzabm;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.zzir().entrySet().iterator();
            List list = this.zzabl;
            Map.Entry entry = (Map.Entry)object2.next();
            zzkp zzkp2 = new zzkp(this, entry);
            list.add(zzkp2);
            object2.remove();
        }
        return object;
    }

    public static /* synthetic */ Map zzd(zzkg zzkg2) {
        return zzkg2.zzabo;
    }

    private final void zziq() {
        boolean bl2 = this.zzuy;
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private final SortedMap zzir() {
        this.zziq();
        NavigableMap navigableMap = this.zzabm;
        boolean bl2 = navigableMap.isEmpty();
        if (bl2 && !(bl2 = (navigableMap = this.zzabm) instanceof TreeMap)) {
            this.zzabm = navigableMap = new NavigableMap();
            this.zzabo = navigableMap = navigableMap.descendingMap();
        }
        return (SortedMap)this.zzabm;
    }

    public void clear() {
        this.zziq();
        Object object = this.zzabl;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            object = this.zzabl;
            object.clear();
        }
        if (!(bl2 = (object = this.zzabm).isEmpty())) {
            object = this.zzabm;
            object.clear();
        }
    }

    public boolean containsKey(Object object) {
        Map map;
        boolean bl2;
        int n10 = this.zza((Comparable)(object = (Comparable)object));
        return n10 >= 0 || (bl2 = (map = this.zzabm).containsKey(object));
        {
        }
    }

    public Set entrySet() {
        zzkr zzkr2 = this.zzabn;
        if (zzkr2 == null) {
            this.zzabn = zzkr2 = new zzkr(this, null);
        }
        return this.zzabn;
    }

    public boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof zzkg;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (zzkg)object;
        n12 = this.size();
        if (n12 != (n11 = ((zzkg)object).size())) {
            return false;
        }
        n11 = this.zzin();
        if (n11 != (n10 = ((zzkg)object).zzin())) {
            Set set = this.entrySet();
            object = ((zzkg)object).entrySet();
            return set.equals(object);
        }
        for (n10 = 0; n10 < n11; ++n10) {
            Map.Entry entry;
            Map.Entry entry2 = this.zzcc(n10);
            boolean bl3 = entry2.equals(entry = ((zzkg)object).zzcc(n10));
            if (bl3) continue;
            return false;
        }
        if (n11 != n12) {
            Map map = this.zzabm;
            object = ((zzkg)object).zzabm;
            return map.equals(object);
        }
        return bl2;
    }

    public Object get(Object object) {
        int n10 = this.zza((Comparable)(object = (Comparable)object));
        if (n10 >= 0) {
            return ((zzkp)this.zzabl.get(n10)).getValue();
        }
        return this.zzabm.get(object);
    }

    public int hashCode() {
        int n10 = this.zzin();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            zzkp zzkp2 = (zzkp)this.zzabl.get(i10);
            int n12 = zzkp2.hashCode();
            n11 += n12;
        }
        Map map = this.zzabm;
        n10 = map.size();
        if (n10 > 0) {
            map = this.zzabm;
            n10 = map.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public final boolean isImmutable() {
        return this.zzuy;
    }

    public /* synthetic */ Object put(Object object, Object object2) {
        object = (Comparable)object;
        return this.zza((Comparable)object, object2);
    }

    public Object remove(Object object) {
        this.zziq();
        object = (Comparable)object;
        int n10 = this.zza((Comparable)object);
        if (n10 >= 0) {
            return this.zzcd(n10);
        }
        Map map = this.zzabm;
        n10 = (int)(map.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        return this.zzabm.remove(object);
    }

    public int size() {
        int n10 = this.zzabl.size();
        int n11 = this.zzabm.size();
        return n10 + n11;
    }

    public final Object zza(Comparable comparable, Object object) {
        Object object2;
        int n10;
        this.zziq();
        int n11 = this.zza(comparable);
        if (n11 >= 0) {
            return ((zzkp)this.zzabl.get(n11)).setValue(object);
        }
        this.zziq();
        Object object3 = this.zzabl;
        int n12 = object3.isEmpty();
        if (n12 != 0 && (n12 = (object3 = this.zzabl) instanceof ArrayList) == 0) {
            n10 = this.zzabk;
            object3 = new ArrayList(n10);
            this.zzabl = object3;
        }
        if ((n11 = -(n11 + 1)) >= (n12 = this.zzabk)) {
            return this.zzir().put(comparable, object);
        }
        object3 = this.zzabl;
        n12 = object3.size();
        if (n12 == (n10 = this.zzabk)) {
            object3 = this.zzabl;
            object3 = (zzkp)object3.remove(n10 += -1);
            object2 = this.zzir();
            Comparable comparable2 = (Comparable)((zzkp)object3).getKey();
            object3 = ((zzkp)object3).getValue();
            object2.put(comparable2, object3);
        }
        object3 = this.zzabl;
        object2 = new zzkp(this, comparable, object);
        object3.add(n11, object2);
        return null;
    }

    public final Map.Entry zzcc(int n10) {
        return (Map.Entry)this.zzabl.get(n10);
    }

    public void zzej() {
        boolean bl2 = this.zzuy;
        if (!bl2) {
            Map map = this.zzabm;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzabm);
            this.zzabm = map;
            map = this.zzabo;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzabo);
            this.zzabo = map;
            this.zzuy = bl2 = true;
        }
    }

    public final int zzin() {
        return this.zzabl.size();
    }

    public final Iterable zzio() {
        Map map = this.zzabm;
        boolean bl2 = map.isEmpty();
        if (bl2) {
            return zzkk.zziy();
        }
        return this.zzabm.entrySet();
    }

    public final Set zzip() {
        zzkl zzkl2 = this.zzabp;
        if (zzkl2 == null) {
            this.zzabp = zzkl2 = new zzkl(this, null);
        }
        return this.zzabp;
    }
}

