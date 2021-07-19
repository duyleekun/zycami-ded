/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.b;
import java.util.ArrayList;
import java.util.List;

public final class c
extends b {
    public final List a;
    public final Object b;
    public boolean c;

    public c() {
        Object object = new ArrayList();
        this.a = object;
        this.b = object = new Object();
        this.c = false;
    }

    public final boolean a() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final b b(Runnable runnable) {
        Object object = this.b;
        synchronized (object) {
            boolean bl2 = this.c;
            if (bl2) {
                runnable.run();
            } else {
                List list = this.a;
                list.add(runnable);
            }
            return this;
        }
    }
}

