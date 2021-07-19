/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.a;

import e.a.w0.a.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
implements e.a.s0.b,
a {
    public List a;
    public volatile boolean b;

    public b() {
    }

    public b(Iterable object) {
        boolean bl2;
        e.a.w0.b.a.g(object, "resources is null");
        Object object2 = new LinkedList();
        this.a = object2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (e.a.s0.b)object.next();
            e.a.w0.b.a.g(object2, "Disposable item is null");
            List list = this.a;
            list.add(object2);
        }
    }

    public b(e.a.s0.b ... bArray) {
        LinkedList linkedList;
        e.a.w0.b.a.g(bArray, "resources is null");
        this.a = linkedList = new LinkedList();
        for (e.a.s0.b b10 : bArray) {
            e.a.w0.b.a.g(b10, "Disposable item is null");
            List list = this.a;
            list.add(b10);
        }
    }

    public boolean a(e.a.s0.b b10) {
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
    public boolean b(e.a.s0.b b10) {
        List<e.a.s0.b> list = "d is null";
        e.a.w0.b.a.g(b10, (String)((Object)list));
        boolean bl2 = this.b;
        if (!bl2) {
            synchronized (this) {
                bl2 = this.b;
                if (!bl2) {
                    list = this.a;
                    if (list == null) {
                        this.a = list = new List<e.a.s0.b>();
                    }
                    list.add(b10);
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
    public boolean c(e.a.s0.b b10) {
        Object object = "Disposable item is null";
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
            return object != null && (bl3 = object.remove(b10));
            {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d(e.a.s0.b ... bArray) {
        List<e.a.s0.b> list = "ds is null";
        e.a.w0.b.a.g(bArray, (String)((Object)list));
        int n10 = this.b;
        int n11 = 0;
        if (n10 == 0) {
            synchronized (this) {
                n10 = (int)(this.b ? 1 : 0);
                if (n10 == 0) {
                    list = this.a;
                    if (list == null) {
                        this.a = list = new List<e.a.s0.b>();
                    }
                    int n12 = bArray.length;
                    while (true) {
                        if (n11 >= n12) {
                            return true;
                        }
                        e.a.s0.b b10 = bArray[n11];
                        String string2 = "d is null";
                        e.a.w0.b.a.g(b10, string2);
                        list.add(b10);
                        ++n11;
                    }
                }
            }
        }
        n10 = bArray.length;
        int n13 = 0;
        while (n13 < n10) {
            e.a.s0.b b11 = bArray[n13];
            b11.dispose();
            ++n13;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispose() {
        List list;
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
            list = this.a;
            this.a = null;
        }
        this.f(list);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        List list;
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.b;
            if (bl2) {
                return;
            }
            list = this.a;
            this.a = null;
        }
        this.f(list);
    }

    public void f(List object) {
        int n10;
        if (object == null) {
            return;
        }
        ArrayList<Throwable> arrayList = null;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            e.a.s0.b b10 = (e.a.s0.b)object.next();
            try {
                b10.dispose();
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

    public boolean isDisposed() {
        return this.b;
    }
}

