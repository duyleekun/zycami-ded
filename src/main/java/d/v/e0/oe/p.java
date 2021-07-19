/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.e0.oe;

import android.util.SparseArray;

public class p {
    private final SparseArray a;
    private final Object b;

    public p() {
        this(10);
    }

    public p(int n10) {
        SparseArray sparseArray;
        this.a = sparseArray = new SparseArray(n10);
        this.b = this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object = this.b;
        synchronized (object) {
            SparseArray sparseArray = this.a;
            sparseArray.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object b(int n10) {
        Object object = this.b;
        synchronized (object) {
            Object object2 = this.a;
            object2 = object2.get(n10);
            if (object2 != null) {
                SparseArray sparseArray = this.a;
                sparseArray.delete(n10);
            }
            return object2;
        }
    }

    public Object c(int n10) {
        return this.a.get(n10);
    }

    public Object d(int n10, Object object) {
        return this.a.get(n10, object);
    }

    public int e(int n10) {
        return this.a.indexOfKey(n10);
    }

    public int f(Object object) {
        return this.a.indexOfValue(object);
    }

    public int g(int n10) {
        return this.a.keyAt(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(int n10, Object object) {
        Object object2 = this.b;
        synchronized (object2) {
            SparseArray sparseArray = this.a;
            sparseArray.put(n10, object);
            return;
        }
    }

    public Object i(int n10) {
        return this.b(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void j(int n10) {
        Object object = this.b;
        synchronized (object) {
            SparseArray sparseArray = this.a;
            sparseArray.removeAt(n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k(int n10, int n11) {
        Object object = this.b;
        synchronized (object) {
            SparseArray sparseArray = this.a;
            sparseArray.removeAtRange(n10, n11);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l(int n10, Object object) {
        Object object2 = this.b;
        synchronized (object2) {
            SparseArray sparseArray = this.a;
            sparseArray.setValueAt(n10, object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int m() {
        Object object = this.b;
        synchronized (object) {
            SparseArray sparseArray = this.a;
            return sparseArray.size();
        }
    }

    public Object n(int n10) {
        return this.a.valueAt(n10);
    }
}

