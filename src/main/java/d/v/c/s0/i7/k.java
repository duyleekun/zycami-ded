/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.view.ViewGroup
 */
package d.v.c.s0.i7;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.core.util.Pools$SynchronizedPool;
import d.v.c.s0.i7.k$a;
import d.v.c.s0.i7.k$b;
import d.v.c.s0.i7.k$c;
import d.v.c.s0.i7.k$d;
import d.v.c.s0.i7.k$f;
import java.util.Objects;

public class k {
    private static final String f = "AsyncLayoutInflatePlus";
    private Pools$SynchronizedPool a;
    public k$b b;
    public Handler c;
    public k$c d;
    private Handler.Callback e;

    public k(Context object) {
        Object object2 = new Pools$SynchronizedPool(10);
        this.a = object2;
        object2 = new k$a(this);
        this.e = object2;
        object2 = new k$b((Context)object);
        this.b = object2;
        object2 = this.e;
        super((Handler.Callback)object2);
        this.c = object;
        super(null);
        this.d = object;
    }

    public void a() {
        this.b.a();
    }

    public void b() {
        this.c.removeCallbacksAndMessages(null);
        this.e = null;
    }

    public void c(int n10, ViewGroup viewGroup, k$f k$f) {
        Objects.requireNonNull(k$f, "callback argument may not be null!");
        k$d k$d = this.d();
        k$d.a = this;
        k$d.c = n10;
        k$d.b = viewGroup;
        k$d.e = k$f;
        this.d.a(k$d);
    }

    public k$d d() {
        k$d k$d = (k$d)this.a.acquire();
        if (k$d == null) {
            k$d = new k$d();
        }
        return k$d;
    }

    public void e(k$d k$d) {
        k$d.e = null;
        k$d.a = null;
        k$d.b = null;
        k$d.c = 0;
        k$d.d = null;
        this.a.release(k$d);
    }
}

