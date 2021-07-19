/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import bleshadow.dagger.internal.ReferenceReleasingProviderManager;
import c.a.l.l;
import c.b.a.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class n
implements c {
    private static final Object d;
    public static final /* synthetic */ boolean e;
    private final c a;
    private volatile Object b;
    private volatile WeakReference c;

    static {
        Object object;
        d = object = new Object();
    }

    private n(c c10) {
        this.a = c10;
    }

    public static n a(c c10, ReferenceReleasingProviderManager referenceReleasingProviderManager) {
        c10 = (c)l.a(c10);
        n n10 = new n(c10);
        referenceReleasingProviderManager.e(n10);
        return n10;
    }

    private Object b() {
        Object object = this.b;
        if (object != null) {
            return object;
        }
        object = this.c;
        if (object != null) {
            return this.c.get();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Object object = this.b;
        if (object == null) return;
        WeakReference<Object> weakReference = d;
        if (object == weakReference) return;
        synchronized (this) {
            this.c = weakReference = new WeakReference<Object>(object);
            object = null;
            this.b = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        Object object = this.b;
        WeakReference weakReference = this.c;
        if (weakReference == null) return;
        if (object != null) return;
        synchronized (this) {
            object = this.b;
            weakReference = this.c;
            if (weakReference == null) return;
            if (object != null) return;
            object = this.c;
            if ((object = ((Reference)object).get()) == null) return;
            this.b = object;
            object = null;
            this.c = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get() {
        Object object;
        Object object2 = this.b();
        if (object2 == null) {
            synchronized (this) {
                object2 = this.b();
                if (object2 == null) {
                    object2 = this.a;
                    if ((object2 = object2.get()) == null) {
                        object2 = d;
                    }
                    this.b = object2;
                }
            }
        }
        if (object2 != (object = d)) return object2;
        return null;
    }
}

