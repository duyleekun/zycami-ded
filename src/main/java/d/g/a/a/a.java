/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.a$a;
import d.g.a.a.c;
import d.g.a.a.c$b;
import d.g.a.a.h;
import d.g.a.a.k;
import d.g.a.a.l;
import i.a.b.f;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a {
    public static final a$a a;

    static {
        a$a a$a;
        a = a$a = new a$a();
    }

    private a() {
    }

    public static String[] a(String string2, List iterator2) {
        Object object;
        if (iterator2 != null) {
            boolean bl2;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                boolean bl3;
                Set set;
                object = (h)iterator2.next();
                if (object == null || (set = object.a()) == null || !(bl3 = (set = object.a()).contains(string2))) continue;
                return object.b(string2);
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No pinyin dict contains word: ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        iterator2 = new Iterator(string2);
        throw iterator2;
    }

    public static String b(String string2, c$b object, String string3) {
        List list = Collections.unmodifiableList(((c$b)object).a());
        f f10 = l.a(((c$b)object).a());
        object = ((c$b)object).b();
        return d.g.a.a.a.c(string2, f10, list, string3, (k)object);
    }

    public static String c(String string2, f object, List object2, String string3, k object3) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            int n11;
            if (object != null && object3 != null) {
                int n12;
                object = ((f)object).m(string2);
                object = object3.a((Collection)object);
                object3 = a;
                Collections.sort(object, object3);
                object3 = new StringBuffer();
                int n13 = 0;
                int n14 = 0;
                while (n13 < (n12 = string2.length())) {
                    Object object4;
                    n12 = object.size();
                    if (n14 < n12 && n13 == (n12 = ((i.a.a.a)(object4 = (i.a.b.a)object.get(n14))).getStart())) {
                        int n15;
                        object4 = d.g.a.a.a.a(((i.a.b.a)object.get(n14)).c(), (List)object2);
                        for (int i10 = 0; i10 < (n15 = ((String[])object4).length); ++i10) {
                            String string4 = object4[i10].toUpperCase();
                            ((StringBuffer)object3).append(string4);
                            n15 = ((Object)object4).length + -1;
                            if (i10 == n15) continue;
                            ((StringBuffer)object3).append(string3);
                        }
                        object4 = (i.a.b.a)object.get(n14);
                        n12 = ((i.a.a.a)object4).size();
                        n13 += n12;
                        ++n14;
                    } else {
                        n12 = string2.charAt(n13);
                        object4 = c.g((char)n12);
                        ((StringBuffer)object3).append((String)object4);
                        ++n13;
                    }
                    if (n13 == (n12 = string2.length())) continue;
                    ((StringBuffer)object3).append(string3);
                }
                return ((StringBuffer)object3).toString();
            }
            object = new StringBuffer();
            for (n10 = 0; n10 < (n11 = string2.length()); ++n10) {
                object2 = c.g(string2.charAt(n10));
                ((StringBuffer)object).append((String)object2);
                n11 = string2.length() + -1;
                if (n10 == n11) continue;
                ((StringBuffer)object).append(string3);
            }
            string2 = ((StringBuffer)object).toString();
        }
        return string2;
    }
}

