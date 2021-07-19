/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.c.a.o.l;

import android.text.TextUtils;
import d.c.a.o.l.h;
import d.c.a.o.l.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j
implements h {
    private final Map c;
    private volatile Map d;

    public j(Map map) {
        this.c = map = Collections.unmodifiableMap(map);
    }

    private String b(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = ((i)list.get(i10)).a();
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) continue;
            stringBuilder.append(string2);
            char c10 = list.size() + -1;
            if (i10 == c10) continue;
            c10 = ',';
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    private Map c() {
        boolean bl2;
        HashMap hashMap = new HashMap();
        Iterator iterator2 = this.c.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Object object = (List)entry.getValue();
            boolean bl3 = TextUtils.isEmpty((CharSequence)(object = this.b((List)object)));
            if (bl3) continue;
            entry = entry.getKey();
            hashMap.put(entry, object);
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map a() {
        Map map = this.d;
        if (map != null) return this.d;
        synchronized (this) {
            map = this.d;
            if (map != null) return this.d;
            map = this.c();
            this.d = map = Collections.unmodifiableMap(map);
            return this.d;
        }
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof j;
        if (bl2) {
            object = (j)object;
            Map map = this.c;
            object = ((j)object).c;
            return map.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LazyHeaders{headers=");
        Map map = this.c;
        stringBuilder.append(map);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

