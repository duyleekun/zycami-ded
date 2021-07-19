/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzej;
import com.google.android.gms.internal.clearcut.zzel;
import com.google.android.gms.internal.clearcut.zzem;
import com.google.android.gms.internal.clearcut.zzep;
import com.google.android.gms.internal.clearcut.zzer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class zzei
extends AbstractMap {
    private boolean zzgu;
    private final int zzol;
    private List zzom;
    private Map zzon;
    private volatile zzer zzoo;
    private Map zzop;
    private volatile zzel zzoq;

    private zzei(int n10) {
        this.zzol = n10;
        Map map = Collections.emptyList();
        this.zzom = map;
        map = Collections.emptyMap();
        this.zzon = map;
        this.zzop = map = Collections.emptyMap();
    }

    public /* synthetic */ zzei(int n10, zzej zzej2) {
        this(n10);
    }

    private final int zza(Comparable comparable) {
        int n10;
        Comparable comparable2;
        List list = this.zzom;
        int n11 = list.size() + -1;
        if (n11 >= 0) {
            comparable2 = (Comparable)((zzep)this.zzom.get(n11)).getKey();
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
            Comparable comparable3 = (Comparable)((zzep)this.zzom.get(n12)).getKey();
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

    public static /* synthetic */ Object zza(zzei zzei2, int n10) {
        return zzei2.zzal(n10);
    }

    public static /* synthetic */ void zza(zzei zzei2) {
        zzei2.zzdu();
    }

    public static zzei zzaj(int n10) {
        zzej zzej2 = new zzej(n10);
        return zzej2;
    }

    private final Object zzal(int n10) {
        this.zzdu();
        Object object = ((zzep)this.zzom.remove(n10)).getValue();
        Object object2 = this.zzon;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.zzdv().entrySet().iterator();
            List list = this.zzom;
            Map.Entry entry = (Map.Entry)object2.next();
            zzep zzep2 = new zzep(this, entry);
            list.add(zzep2);
            object2.remove();
        }
        return object;
    }

    public static /* synthetic */ List zzb(zzei zzei2) {
        return zzei2.zzom;
    }

    public static /* synthetic */ Map zzc(zzei zzei2) {
        return zzei2.zzon;
    }

    public static /* synthetic */ Map zzd(zzei zzei2) {
        return zzei2.zzop;
    }

    private final void zzdu() {
        boolean bl2 = this.zzgu;
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private final SortedMap zzdv() {
        this.zzdu();
        NavigableMap navigableMap = this.zzon;
        boolean bl2 = navigableMap.isEmpty();
        if (bl2 && !(bl2 = (navigableMap = this.zzon) instanceof TreeMap)) {
            this.zzon = navigableMap = new NavigableMap();
            this.zzop = navigableMap = navigableMap.descendingMap();
        }
        return (SortedMap)this.zzon;
    }

    public void clear() {
        this.zzdu();
        Object object = this.zzom;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            object = this.zzom;
            object.clear();
        }
        if (!(bl2 = (object = this.zzon).isEmpty())) {
            object = this.zzon;
            object.clear();
        }
    }

    public boolean containsKey(Object object) {
        Map map;
        boolean bl2;
        int n10 = this.zza((Comparable)(object = (Comparable)object));
        return n10 >= 0 || (bl2 = (map = this.zzon).containsKey(object));
        {
        }
    }

    public Set entrySet() {
        zzer zzer2 = this.zzoo;
        if (zzer2 == null) {
            this.zzoo = zzer2 = new zzer(this, null);
        }
        return this.zzoo;
    }

    public boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof zzei;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (zzei)object;
        n12 = this.size();
        if (n12 != (n11 = ((zzei)object).size())) {
            return false;
        }
        n11 = this.zzdr();
        if (n11 != (n10 = ((zzei)object).zzdr())) {
            Set set = this.entrySet();
            object = ((zzei)object).entrySet();
            return set.equals(object);
        }
        for (n10 = 0; n10 < n11; ++n10) {
            Map.Entry entry;
            Map.Entry entry2 = this.zzak(n10);
            boolean bl3 = entry2.equals(entry = ((zzei)object).zzak(n10));
            if (bl3) continue;
            return false;
        }
        if (n11 != n12) {
            Map map = this.zzon;
            object = ((zzei)object).zzon;
            return map.equals(object);
        }
        return bl2;
    }

    public Object get(Object object) {
        int n10 = this.zza((Comparable)(object = (Comparable)object));
        if (n10 >= 0) {
            return ((zzep)this.zzom.get(n10)).getValue();
        }
        return this.zzon.get(object);
    }

    public int hashCode() {
        int n10 = this.zzdr();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            zzep zzep2 = (zzep)this.zzom.get(i10);
            int n12 = zzep2.hashCode();
            n11 += n12;
        }
        Map map = this.zzon;
        n10 = map.size();
        if (n10 > 0) {
            map = this.zzon;
            n10 = map.hashCode();
            n11 += n10;
        }
        return n11;
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    public /* synthetic */ Object put(Object object, Object object2) {
        object = (Comparable)object;
        return this.zza((Comparable)object, object2);
    }

    public Object remove(Object object) {
        this.zzdu();
        object = (Comparable)object;
        int n10 = this.zza((Comparable)object);
        if (n10 >= 0) {
            return this.zzal(n10);
        }
        Map map = this.zzon;
        n10 = (int)(map.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        return this.zzon.remove(object);
    }

    public int size() {
        int n10 = this.zzom.size();
        int n11 = this.zzon.size();
        return n10 + n11;
    }

    public final Object zza(Comparable comparable, Object object) {
        Object object2;
        int n10;
        this.zzdu();
        int n11 = this.zza(comparable);
        if (n11 >= 0) {
            return ((zzep)this.zzom.get(n11)).setValue(object);
        }
        this.zzdu();
        Object object3 = this.zzom;
        int n12 = object3.isEmpty();
        if (n12 != 0 && (n12 = (object3 = this.zzom) instanceof ArrayList) == 0) {
            n10 = this.zzol;
            object3 = new ArrayList(n10);
            this.zzom = object3;
        }
        if ((n11 = -(n11 + 1)) >= (n12 = this.zzol)) {
            return this.zzdv().put(comparable, object);
        }
        object3 = this.zzom;
        n12 = object3.size();
        if (n12 == (n10 = this.zzol)) {
            object3 = this.zzom;
            object3 = (zzep)object3.remove(n10 += -1);
            object2 = this.zzdv();
            Comparable comparable2 = (Comparable)((zzep)object3).getKey();
            object3 = ((zzep)object3).getValue();
            object2.put(comparable2, object3);
        }
        object3 = this.zzom;
        object2 = new zzep(this, comparable, object);
        object3.add(n11, object2);
        return null;
    }

    public final Map.Entry zzak(int n10) {
        return (Map.Entry)this.zzom.get(n10);
    }

    public final int zzdr() {
        return this.zzom.size();
    }

    public final Iterable zzds() {
        Map map = this.zzon;
        boolean bl2 = map.isEmpty();
        if (bl2) {
            return zzem.zzdx();
        }
        return this.zzon.entrySet();
    }

    public final Set zzdt() {
        zzel zzel2 = this.zzoq;
        if (zzel2 == null) {
            this.zzoq = zzel2 = new zzel(this, null);
        }
        return this.zzoq;
    }

    public void zzv() {
        boolean bl2 = this.zzgu;
        if (!bl2) {
            Map map = this.zzon;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzon);
            this.zzon = map;
            map = this.zzop;
            bl2 = map.isEmpty();
            map = bl2 ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzop);
            this.zzop = map;
            this.zzgu = bl2 = true;
        }
    }
}

