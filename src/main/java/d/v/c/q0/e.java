/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.c.q0;

import android.util.SparseArray;

public class e {
    private boolean a;
    private Object b;
    private SparseArray c;

    public e() {
        SparseArray sparseArray;
        this.c = sparseArray = new SparseArray();
    }

    public Object a() {
        return this.b;
    }

    public SparseArray b() {
        return this.c;
    }

    public boolean c() {
        return this.a;
    }

    public e d(int n10, Object object) {
        this.c.put(n10, object);
        return this;
    }

    public e e(boolean bl2) {
        this.a = bl2;
        return this;
    }

    public e f(Object object) {
        this.b = object;
        return this;
    }
}

