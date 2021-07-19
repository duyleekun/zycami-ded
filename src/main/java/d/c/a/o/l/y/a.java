/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.c.a.o.l.y;

import android.text.TextUtils;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.l.g;
import d.c.a.o.l.h;
import d.c.a.o.l.m;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class a
implements n {
    private final n a;
    private final m b;

    public a(n n10) {
        this(n10, null);
    }

    public a(n n10, m m10) {
        this.a = n10;
        this.b = m10;
    }

    private static List c(Collection object) {
        int n10 = object.size();
        ArrayList<g> arrayList = new ArrayList<g>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            String string2 = (String)object.next();
            g g10 = new g(string2);
            arrayList.add(g10);
        }
        return arrayList;
    }

    public n$a b(Object object, int n10, int n11, f c10) {
        Object object2 = this.b;
        Object object3 = null;
        if ((object2 = object2 != null ? (g)((m)object2).b(object, n10, n11) : null) == null) {
            object2 = this.f(object, n10, n11, (f)c10);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                return null;
            }
            h h10 = this.e(object, n10, n11, (f)c10);
            object3 = new g((String)object2, h10);
            object2 = this.b;
            if (object2 != null) {
                ((m)object2).c(object, n10, n11, object3);
            }
            object2 = object3;
        }
        object = this.d(object, n10, n11, (f)c10);
        object3 = this.a;
        Object object4 = object3.b(object2, n10, n11, (f)c10);
        if (object4 != null && (n11 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            c10 = ((n$a)object4).a;
            object = d.c.a.o.l.y.a.c((Collection)object);
            object4 = ((n$a)object4).c;
            n$a n$a = new n$a(c10, (List)object, (d)object4);
            return n$a;
        }
        return object4;
    }

    public List d(Object object, int n10, int n11, f f10) {
        return Collections.emptyList();
    }

    public h e(Object object, int n10, int n11, f f10) {
        return h.b;
    }

    public abstract String f(Object var1, int var2, int var3, f var4);
}

