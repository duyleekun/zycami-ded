/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.c;
import d.c.a.o.k.n$a;
import d.c.a.o.k.s;
import d.c.a.u.k;

public class n
implements s {
    private final boolean a;
    private final boolean b;
    private final s c;
    private final n$a d;
    private final c e;
    private int f;
    private boolean g;

    public n(s object, boolean bl2, boolean bl3, c c10, n$a n$a) {
        object = (s)k.d(object);
        this.c = object;
        this.a = bl2;
        this.b = bl3;
        this.e = c10;
        this.d = object = (n$a)k.d(n$a);
    }

    public void a() {
        synchronized (this) {
            block6: {
                int n10 = this.g;
                if (n10 != 0) break block6;
                n10 = this.f + 1;
                this.f = n10;
                return;
            }
            String string2 = "Cannot acquire a recycled resource";
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
    }

    public Class b() {
        return this.c.b();
    }

    public s c() {
        return this.c;
    }

    public boolean d() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        int n10;
        synchronized (this) {
            int n11 = this.f;
            if (n11 <= 0) {
                String string2 = "Cannot release a recycled or not yet acquired resource";
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            n10 = 1;
            this.f = n11 -= n10;
            if (n11 != 0) return;
        }
        if (n10 == 0) return;
        n$a n$a = this.d;
        c c10 = this.e;
        n$a.d(c10, this);
    }

    public Object get() {
        return this.c.get();
    }

    public int getSize() {
        return this.c.getSize();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void recycle() {
        synchronized (this) {
            int n10 = this.f;
            if (n10 > 0) {
                String string2 = "Cannot recycle a resource while it is still acquired";
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            n10 = (int)(this.g ? 1 : 0);
            if (n10 != 0) {
                String string3 = "Cannot recycle a resource that has already been recycled";
                IllegalStateException illegalStateException = new IllegalStateException(string3);
                throw illegalStateException;
            }
            n10 = 1;
            this.g = n10;
            n10 = (int)(this.b ? 1 : 0);
            if (n10 != 0) {
                s s10 = this.c;
                s10.recycle();
            }
            return;
        }
    }

    public String toString() {
        synchronized (this) {
            CharSequence charSequence = new StringBuilder();
            Object object = "EngineResource{isMemoryCacheable=";
            charSequence.append((String)object);
            boolean c10 = this.a;
            charSequence.append(c10);
            object = ", listener=";
            charSequence.append((String)object);
            object = this.d;
            charSequence.append(object);
            object = ", key=";
            charSequence.append((String)object);
            object = this.e;
            charSequence.append(object);
            object = ", acquired=";
            charSequence.append((String)object);
            int n10 = this.f;
            charSequence.append(n10);
            object = ", isRecycled=";
            charSequence.append((String)object);
            boolean bl2 = this.g;
            charSequence.append(bl2);
            object = ", resource=";
            charSequence.append((String)object);
            object = this.c;
            charSequence.append(object);
            char c11 = '}';
            charSequence.append(c11);
            charSequence = charSequence.toString();
            return charSequence;
        }
    }
}

