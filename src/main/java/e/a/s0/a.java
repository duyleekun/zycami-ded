/*
 * Decompiled with CFR 0.151.
 */
package e.a.s0;

import e.a.s0.b;
import e.a.w0.i.k;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;

public final class a
implements b,
e.a.w0.a.a {
    public k a;
    public volatile boolean b;

    public a() {
    }

    public a(Iterable object) {
        boolean bl2;
        e.a.w0.b.a.g(object, "disposables is null");
        Object object2 = new k();
        this.a = object2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (b)object.next();
            e.a.w0.b.a.g(object2, "A Disposable item in the disposables sequence is null");
            k k10 = this.a;
            k10.a(object2);
        }
    }

    public a(b ... bArray) {
        k k10;
        e.a.w0.b.a.g(bArray, "disposables is null");
        int n10 = bArray.length + 1;
        this.a = k10 = new k(n10);
        for (b b10 : bArray) {
            e.a.w0.b.a.g(b10, "A Disposable in the disposables array is null");
            k k11 = this.a;
            k11.a(b10);
        }
    }

    public boolean a(b b10) {
        boolean bl2 = this.c(b10);
        if (bl2) {
            b10.dispose();
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(b b10) {
        Object object = "disposable is null";
        e.a.w0.b.a.g(b10, (String)object);
        boolean bl2 = this.b;
        if (!bl2) {
            synchronized (this) {
                bl2 = this.b;
                if (!bl2) {
                    object = this.a;
                    if (object == null) {
                        this.a = object = new k();
                    }
                    ((k)object).a(b10);
                    return true;
                }
            }
        }
        b10.dispose();
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(b b10) {
        Object object = "disposables is null";
        e.a.w0.b.a.g(b10, (String)object);
        boolean bl2 = this.b;
        if (bl2) {
            return false;
        }
        synchronized (this) {
            boolean bl3;
            bl2 = this.b;
            if (bl2) {
                return false;
            }
            object = this.a;
            return object != null && (bl3 = ((k)object).e(b10));
            {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d(b ... bArray) {
        Object object = "disposables is null";
        e.a.w0.b.a.g(bArray, (String)object);
        int n10 = this.b;
        int n11 = 0;
        if (n10 == 0) {
            synchronized (this) {
                n10 = (int)(this.b ? 1 : 0);
                if (n10 == 0) {
                    int n12;
                    object = this.a;
                    int n13 = 1;
                    if (object == null) {
                        n12 = bArray.length + n13;
                        this.a = object = new k(n12);
                    }
                    n12 = bArray.length;
                    while (true) {
                        if (n11 >= n12) {
                            return n13 != 0;
                        }
                        b b10 = bArray[n11];
                        String string2 = "A Disposable in the disposables array is null";
                        e.a.w0.b.a.g(b10, string2);
                        ((k)object).a(b10);
                        ++n11;
                    }
                }
            }
        }
        n10 = bArray.length;
        int n14 = 0;
        while (n14 < n10) {
            b b11 = bArray[n14];
            b11.dispose();
            ++n14;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispose() {
        k k10;
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.b;
            if (bl2) {
                return;
            }
            this.b = bl2 = true;
            k10 = this.a;
            this.a = null;
        }
        this.f(k10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        k k10;
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.b;
            if (bl2) {
                return;
            }
            k10 = this.a;
            this.a = null;
        }
        this.f(k10);
    }

    public void f(k object) {
        if (object == null) {
            return;
        }
        ArrayList<Throwable> arrayList = null;
        object = object.b();
        int n10 = ((Object[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = object[i10];
            boolean bl2 = object2 instanceof b;
            if (!bl2) continue;
            object2 = (b)object2;
            try {
                object2.dispose();
                continue;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                if (arrayList == null) {
                    arrayList = new ArrayList<Throwable>();
                }
                arrayList.add(throwable);
            }
        }
        if (arrayList != null) {
            int n11 = arrayList.size();
            if (n11 == (n10 = 1)) {
                throw ExceptionHelper.f((Throwable)arrayList.get(0));
            }
            object = new CompositeException(arrayList);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int g() {
        boolean bl2 = this.b;
        int n10 = 0;
        if (bl2) {
            return 0;
        }
        synchronized (this) {
            bl2 = this.b;
            if (bl2) {
                return 0;
            }
            k k10 = this.a;
            if (k10 == null) return n10;
            return k10.g();
        }
    }

    public boolean isDisposed() {
        return this.b;
    }
}

