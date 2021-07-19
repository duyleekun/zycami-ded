/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.h0$c;
import e.a.w0.e.e.m$c;
import java.util.Collection;

public final class m$c$a
implements Runnable {
    private final Collection a;
    public final /* synthetic */ m$c b;

    public m$c$a(m$c c10, Collection collection) {
        this.b = c10;
        this.a = collection;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        m$c m$c = this.b;
        synchronized (m$c) {
            object = this.b;
            object = ((m$c)object).P;
            Collection collection = this.a;
            object.remove(collection);
        }
        m$c = this.b;
        object = this.a;
        h0$c h0$c = m$c.O;
        m$c.k(m$c, object, false, h0$c);
    }
}

