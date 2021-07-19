/*
 * Decompiled with CFR 0.151.
 */
package l.a.n;

import java.util.ArrayList;
import l.a.n.b;

public class a {
    private final ArrayList a;

    public a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(b object) {
        synchronized (this) {
            Throwable throwable2;
            if (object != null) {
                try {
                    ArrayList arrayList = this.a;
                    boolean bl2 = arrayList.contains(object);
                    if (!bl2) {
                        arrayList = this.a;
                        arrayList.add(object);
                    }
                    return;
                }
                catch (Throwable throwable2) {}
            } else {
                object = new NullPointerException();
                throw object;
            }
            throw throwable2;
        }
    }

    public int b() {
        synchronized (this) {
            ArrayList arrayList = this.a;
            int n10 = arrayList.size();
            return n10;
        }
    }

    public void c(b b10) {
        synchronized (this) {
            ArrayList arrayList = this.a;
            arrayList.remove(b10);
            return;
        }
    }

    public void d() {
        synchronized (this) {
            ArrayList arrayList = this.a;
            arrayList.clear();
            return;
        }
    }

    public void e() {
        this.f(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(Object object) {
        int n10;
        b[] bArray;
        synchronized (this) {
            bArray = this.a;
            n10 = bArray.size();
            b[] bArray2 = new b[n10];
            bArray = bArray.toArray(bArray2);
        }
        n10 = bArray.length + -1;
        while (n10 >= 0) {
            b b10 = bArray[n10];
            b10.b(this, object);
            n10 += -1;
        }
        return;
    }
}

