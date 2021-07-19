/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.a;

import d.v.d.i.a.c;
import d.v.d.i.a.c$a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class a
implements c {
    public static final byte f = 1;
    public static final byte g = 2;
    public Object a;
    public Object b;
    public Object c;
    public List d;
    public byte e;

    public a() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.d = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.e = (byte)3;
    }

    private boolean h(int n10) {
        int n11 = this.e & n10;
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    private void k(boolean bl2, int n10) {
        if (bl2) {
            int n11;
            byte by2;
            this.e = by2 = (byte)(this.e | n11);
        } else {
            byte by3;
            byte by4 = this.e;
            this.e = by3 = (byte)(by4 & (n11 ^= 0xFFFFFFFF));
        }
    }

    public void a(c$a c$a) {
        this.d.remove(c$a);
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
        for (int i10 = 0; i10 < (n10 = (object = this.d).size()); ++i10) {
            object = (c$a)this.d.get(i10);
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

    public void g(c$a c$a) {
        if (c$a == null) {
            return;
        }
        List list = this.d;
        boolean bl2 = list.contains(c$a);
        if (!bl2) {
            list = this.d;
            list.add(c$a);
        }
    }

    public Object get() {
        return this.a;
    }

    public boolean i() {
        return this.h(1);
    }

    public boolean j() {
        return this.h(2);
    }

    public void l(boolean bl2) {
        this.k(bl2, 1);
    }

    public void m(boolean bl2) {
        this.k(bl2, 2);
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

