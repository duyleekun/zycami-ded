/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.t;
import g.z;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import k.c;
import k.e$a;
import k.h$a;
import k.o;
import k.s;

public final class s$b {
    private final o a;
    private g.e$a b;
    private t c;
    private final List d;
    private final List e;
    private Executor f;
    private boolean g;

    public s$b() {
        o o10 = o.g();
        this(o10);
    }

    public s$b(o o10) {
        ArrayList arrayList;
        this.d = arrayList = new ArrayList();
        this.e = arrayList = new ArrayList();
        this.a = o10;
    }

    public s$b(s s10) {
        boolean bl2;
        Object object;
        Object object2;
        Object object3 = new ArrayList();
        this.d = object3;
        object3 = new ArrayList();
        this.e = object3;
        this.a = object3 = o.g();
        Object object4 = s10.b;
        this.b = object4;
        this.c = object4 = s10.c;
        object4 = s10.d;
        int n10 = object4.size();
        int n11 = ((o)object3).e();
        n10 -= n11;
        for (n11 = 1; n11 < n10; ++n11) {
            object2 = this.d;
            object = (h$a)s10.d.get(n11);
            object2.add(object);
        }
        object3 = null;
        object4 = s10.e;
        n10 = object4.size();
        object2 = this.a;
        int n12 = ((o)object2).b();
        for (n11 = 0; n11 < (n10 -= n12); ++n11) {
            object2 = this.e;
            object = (e$a)s10.e.get(n11);
            object2.add(object);
        }
        this.f = object3 = s10.f;
        this.g = bl2 = s10.g;
    }

    public s$b a(e$a e$a) {
        List list = this.e;
        Objects.requireNonNull(e$a, "factory == null");
        list.add(e$a);
        return this;
    }

    public s$b b(h$a h$a) {
        List list = this.d;
        Objects.requireNonNull(h$a, "factory == null");
        list.add(h$a);
        return this;
    }

    public s$b c(String object) {
        Objects.requireNonNull(object, "baseUrl == null");
        object = t.C((String)object);
        return this.e((t)object);
    }

    public s$b d(URL object) {
        Objects.requireNonNull(object, "baseUrl == null");
        object = t.C(((URL)object).toString());
        return this.e((t)object);
    }

    public s$b e(t object) {
        Objects.requireNonNull(object, "baseUrl == null");
        Object object2 = ((t)object).L();
        int n10 = object2.size() + -1;
        object2 = object2.get(n10);
        CharSequence charSequence = "";
        boolean bl2 = ((String)charSequence).equals(object2);
        if (bl2) {
            this.c = object;
            return this;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("baseUrl must end in /: ");
        ((StringBuilder)charSequence).append(object);
        object = ((StringBuilder)charSequence).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public s f() {
        Object object = this.c;
        if (object != null) {
            s s10;
            object = this.b;
            if (object == null) {
                object = new Object();
            }
            ArrayList<c> arrayList = object;
            object = this.f;
            if (object == null) {
                object = this.a.c();
            }
            ArrayList<c> arrayList2 = object;
            Object object2 = this.e;
            object = new Object(object2);
            object2 = this.a.a((Executor)((Object)arrayList2));
            object.addAll(object2);
            int n10 = this.d.size() + 1;
            int n11 = this.a.e();
            object2 = new ArrayList(n10 += n11);
            Object object3 = new c();
            object2.add(object3);
            object3 = this.d;
            object2.addAll(object3);
            object3 = this.a.d();
            object2.addAll(object3);
            object3 = this.c;
            List list = Collections.unmodifiableList(object2);
            List list2 = Collections.unmodifiableList(object);
            boolean bl2 = this.g;
            object2 = s10;
            s10 = new s((g.e$a)((Object)arrayList), (t)object3, list, list2, (Executor)((Object)arrayList2), bl2);
            return s10;
        }
        object = new Object("Base URL required.");
        throw object;
    }

    public List g() {
        return this.e;
    }

    public s$b h(g.e$a e$a) {
        Objects.requireNonNull(e$a, "factory == null");
        this.b = e$a;
        return this;
    }

    public s$b i(Executor executor) {
        Objects.requireNonNull(executor, "executor == null");
        this.f = executor;
        return this;
    }

    public s$b j(z e$a) {
        Objects.requireNonNull(e$a, "client == null");
        e$a = e$a;
        return this.h(e$a);
    }

    public List k() {
        return this.d;
    }

    public s$b l(boolean bl2) {
        this.g = bl2;
        return this;
    }
}

