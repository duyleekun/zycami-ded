/*
 * Decompiled with CFR 0.151.
 */
package bleshadow.dagger.internal;

import bleshadow.dagger.internal.ReferenceReleasingProviderManager$Operation;
import c.a.l.l;
import c.a.l.n;
import c.a.n.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ReferenceReleasingProviderManager
implements c {
    private final Class a;
    private final Queue b;

    public ReferenceReleasingProviderManager(Class clazz) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.b = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.a = clazz = (Class)l.a(clazz);
    }

    private void f(ReferenceReleasingProviderManager$Operation referenceReleasingProviderManager$Operation) {
        boolean bl2;
        Iterator iterator2 = this.b.iterator();
        while (bl2 = iterator2.hasNext()) {
            n n10 = (n)((WeakReference)iterator2.next()).get();
            if (n10 == null) {
                iterator2.remove();
                continue;
            }
            referenceReleasingProviderManager$Operation.execute(n10);
        }
    }

    public void a() {
        ReferenceReleasingProviderManager$Operation referenceReleasingProviderManager$Operation = ReferenceReleasingProviderManager$Operation.RESTORE;
        this.f(referenceReleasingProviderManager$Operation);
    }

    public Class c() {
        return this.a;
    }

    public void d() {
        ReferenceReleasingProviderManager$Operation referenceReleasingProviderManager$Operation = ReferenceReleasingProviderManager$Operation.RELEASE;
        this.f(referenceReleasingProviderManager$Operation);
    }

    public void e(n n10) {
        Queue queue = this.b;
        WeakReference<n> weakReference = new WeakReference<n>(n10);
        queue.add(weakReference);
    }
}

