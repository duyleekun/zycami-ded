/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.c.a.o.l;

import android.text.TextUtils;
import d.c.a.o.l.i;
import d.c.a.o.l.j;
import d.c.a.o.l.j$b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j$a {
    private static final String d = "User-Agent";
    private static final String e;
    private static final Map f;
    private boolean a;
    private Map b;
    private boolean c;

    static {
        Object object = j$a.g();
        e = object;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>(2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Object object2 = new j$b((String)object);
            object = Collections.singletonList(object2);
            object2 = d;
            hashMap.put(object2, object);
        }
        f = Collections.unmodifiableMap(hashMap);
    }

    public j$a() {
        Map map;
        boolean bl2;
        this.a = bl2 = true;
        this.b = map = f;
        this.c = bl2;
    }

    private Map d() {
        boolean bl2;
        int n10 = this.b.size();
        HashMap hashMap = new HashMap(n10);
        Iterator iterator2 = this.b.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Collection collection = (Collection)entry.getValue();
            ArrayList arrayList = new ArrayList(collection);
            entry = entry.getKey();
            hashMap.put(entry, arrayList);
        }
        return hashMap;
    }

    private void e() {
        boolean bl2 = this.a;
        if (bl2) {
            Map map;
            bl2 = false;
            this.a = false;
            this.b = map = this.d();
        }
    }

    private List f(String string2) {
        ArrayList arrayList = (ArrayList)this.b.get(string2);
        if (arrayList == null) {
            arrayList = new ArrayList();
            Map map = this.b;
            map.put(string2, arrayList);
        }
        return arrayList;
    }

    public static String g() {
        String string2 = System.getProperty("http.agent");
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return string2;
        }
        n10 = string2.length();
        int n11 = string2.length();
        StringBuilder stringBuilder = new StringBuilder(n11);
        for (n11 = 0; n11 < n10; ++n11) {
            char c10;
            char c11 = string2.charAt(n11);
            if ((c11 > (c10 = '\u001f') || c11 == (c10 = '\t')) && c11 < (c10 = '\u007f')) {
                stringBuilder.append(c11);
                continue;
            }
            c11 = '?';
            stringBuilder.append(c11);
        }
        return stringBuilder.toString();
    }

    public j$a a(String string2, i i10) {
        String string3;
        boolean bl2 = this.c;
        if (bl2 && (bl2 = (string3 = d).equalsIgnoreCase(string2))) {
            return this.h(string2, i10);
        }
        this.e();
        this.f(string2).add(i10);
        return this;
    }

    public j$a b(String string2, String string3) {
        j$b j$b = new j$b(string3);
        return this.a(string2, j$b);
    }

    public j c() {
        this.a = true;
        Map map = this.b;
        j j10 = new j(map);
        return j10;
    }

    public j$a h(String string2, i object) {
        boolean bl2;
        this.e();
        if (object == null) {
            object = this.b;
            object.remove(string2);
        } else {
            List list = this.f(string2);
            list.clear();
            list.add(object);
        }
        boolean bl3 = this.c;
        if (bl3 && (bl2 = ((String)(object = d)).equalsIgnoreCase(string2))) {
            bl2 = false;
            string2 = null;
            this.c = false;
        }
        return this;
    }

    public j$a i(String string2, String object) {
        if (object == null) {
            object = null;
        } else {
            j$b j$b = new j$b((String)object);
            object = j$b;
        }
        return this.h(string2, (i)object);
    }
}

