/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.x;

import com.zhiyun.account.data.database.model.UserInfo;
import d.v.c.v0.x.a;
import d.v.c.v0.x.b$a;
import d.v.c.v0.x.b$b;
import d.v.c.v0.x.c;
import d.v.e.l.m1;
import java.util.HashSet;
import java.util.Set;
import k.d;
import k.f;

public class b
implements c {
    private static final String b = "zycami";
    private final d.v.a.f.c.d.d a;

    private b() {
        d.v.a.f.c.d.d d10;
        this.a = d10 = d.v.a.f.c.d.d.F();
    }

    public /* synthetic */ b(b$a a10) {
        this();
    }

    public static /* synthetic */ void f(b b10, a a10) {
        b10.i(a10);
    }

    private void g(a object) {
        Set set = d.v.c.v0.x.d.a.D().C();
        HashSet<Object> hashSet = new HashSet<Object>(set);
        object = ((a)object).toString();
        hashSet.add(object);
        d.v.c.v0.x.d.a.D().J(hashSet);
    }

    private void h() {
        Object object = d.v.c.v0.x.d.a.D().C();
        int n10 = object.size();
        if (n10 != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Object object2 = (String)object.next();
                Class<a> clazz = a.class;
                if ((object2 = (a)d.v.e.l.q2.c.a(clazz, (String)object2)) == null) continue;
                int n11 = ((a)object2).e();
                String string2 = ((a)object2).d();
                String string3 = ((a)object2).a();
                object2 = ((a)object2).c();
                this.m(n11, string2, string3, (String)object2);
            }
        }
    }

    private void i(a object) {
        synchronized (this) {
            Object object2 = d.v.c.v0.x.d.a.D();
            object2 = ((d.v.c.v0.x.d.a)object2).C();
            HashSet hashSet = new HashSet(object2);
            object = ((a)object).toString();
            hashSet.remove(object);
            object = d.v.c.v0.x.d.a.D();
            ((d.v.c.v0.x.d.a)object).J(hashSet);
            return;
        }
    }

    public static b j() {
        return b$b.a();
    }

    private void k(int n10) {
        this.h();
        String string2 = d.v.c.v0.x.d.a.D().G();
        if (string2 == null) {
            string2 = m1.A();
        }
        String string3 = m1.A();
        this.m(n10, string2, string3, b);
    }

    private void l(int n10) {
        this.h();
        String string2 = m1.A();
        d.v.c.v0.x.d.a.D().M(string2);
        this.m(n10, string2, null, b);
    }

    private void m(int n10, String object, String string2, String string3) {
        a a10 = new a(n10, (String)object, string2, string3);
        this.g(a10);
        d d10 = d.v.c.v0.l.b.a.a(n10, (String)object, string2, "Android", string3);
        object = new b$a(this, a10);
        d10.h((f)object);
    }

    public void a(int n10) {
        this.l(n10);
    }

    public void b() {
        Object object = this.a;
        boolean n10 = ((d.v.a.f.c.d.d)object).Q();
        if (n10) {
            object = this.a.L();
            int n11 = ((UserInfo)object).getId();
            this.k(n11);
        }
    }

    public void c() {
        Object object = this.a;
        boolean n10 = ((d.v.a.f.c.d.d)object).Q();
        if (n10) {
            object = this.a.L();
            int n11 = ((UserInfo)object).getId();
            this.k(n11);
        }
    }

    public void d(int n10) {
        this.k(n10);
    }

    public void e() {
        Object object = this.a;
        boolean n10 = ((d.v.a.f.c.d.d)object).Q();
        if (n10) {
            object = this.a.L();
            int n11 = ((UserInfo)object).getId();
            this.l(n11);
        }
    }
}

