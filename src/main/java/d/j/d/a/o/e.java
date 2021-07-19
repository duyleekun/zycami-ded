/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.f;
import d.j.d.a.i;
import d.j.d.a.o.h;
import java.util.concurrent.ExecutionException;

public final class e
implements f,
d.j.d.a.h,
i {
    private final Object a;
    private final int b;
    private final h c;
    private int d;
    private Exception e;
    private boolean f;

    public e(int n10, h h10) {
        Object object;
        this.a = object = new Object();
        this.b = n10;
        this.c = h10;
    }

    private void a() {
        int n10 = this.d;
        int n11 = this.b;
        if (n10 >= n11) {
            Object object = this.e;
            if (object != null) {
                object = this.c;
                Exception exception = this.e;
                ExecutionException executionException = new ExecutionException("a task failed", exception);
                ((h)object).z(executionException);
                return;
            }
            n10 = (int)(this.f ? 1 : 0);
            if (n10 != 0) {
                this.c.B();
                return;
            }
            object = this.c;
            n11 = 0;
            Object var4_5 = null;
            ((h)object).A(null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onCanceled() {
        Object object = this.a;
        synchronized (object) {
            int n10 = this.d;
            int n11 = 1;
            this.d = n10 += n11;
            this.f = n11;
            this.a();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onFailure(Exception exception) {
        Object object = this.a;
        synchronized (object) {
            int n10;
            this.d = n10 = this.d + 1;
            this.e = exception;
            this.a();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onSuccess(Object object) {
        object = this.a;
        synchronized (object) {
            int n10;
            this.d = n10 = this.d + 1;
            this.a();
            return;
        }
    }
}

