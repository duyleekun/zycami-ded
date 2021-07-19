/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.c0;

import d.v.b.c0.e;
import d.v.b.c0.e$a;
import d.v.d.h.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b
implements e {
    public static final byte f = 0;
    public static final byte g = 1;
    public static final byte h = 2;
    public Object a;
    public Object b;
    public Object c;
    public List d;
    public byte e;

    public b() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.d = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.e = (byte)3;
    }

    public b(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.d = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.e = (byte)3;
        this.a = object;
    }

    public b(Object object, Object object2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.d = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.e = (byte)3;
        this.b = object;
        this.c = object2;
    }

    public b(Object object, Object object2, Object object3) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.d = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.e = (byte)3;
        this.a = object;
        this.b = object2;
        this.c = object3;
    }

    private boolean i(int n10) {
        int n11 = this.e & n10;
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    public void a() {
        this.e = 0;
    }

    public void b() {
        this.d.clear();
    }

    public void c(Object object, Object object2) {
        this.b = object;
        this.c = object2;
    }

    public void d() {
        Object object;
        int n10;
        int n11 = this.j();
        if (n11 == 0) {
            d.v.d.h.f.a("current is not support");
            return;
        }
        for (n11 = 0; n11 < (n10 = (object = this.d).size()); ++n11) {
            object = (e$a)this.d.get(n11);
            Object object2 = this.a;
            byte by2 = this.e;
            object.a(object2, by2);
        }
    }

    public Object e() {
        return this.b;
    }

    public Object f() {
        return this.c;
    }

    public void g(e$a e$a) {
        this.d.remove(e$a);
    }

    public Object get() {
        return this.a;
    }

    public void h(e$a e$a) {
        List list = this.d;
        boolean bl2 = list.contains(e$a);
        if (!bl2) {
            list = this.d;
            list.add(e$a);
        }
    }

    public boolean j() {
        return this.i(1);
    }

    public boolean k() {
        return this.i(2);
    }

    public void l(boolean bl2) {
        byte by2;
        byte by3;
        this.e = bl2 ? (by3 = (byte)(this.e | 1)) : (by2 = (byte)(this.e & 0xFFFFFFFE));
    }

    public void m(boolean bl2, Object object, Object object2) {
        this.c(object, object2);
        this.l(bl2);
    }

    public void n(boolean bl2) {
        byte by2;
        byte by3;
        this.e = bl2 ? (by3 = (byte)(this.e | 2)) : (by2 = (byte)(this.e & 0xFFFFFFFD));
        this.d();
    }

    public void set(Object object) {
        this.a = object;
        this.d();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseParameter{mT=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", mMinT=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", mMaxT=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", mStatus=");
        byte by2 = this.e;
        stringBuilder.append(by2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

