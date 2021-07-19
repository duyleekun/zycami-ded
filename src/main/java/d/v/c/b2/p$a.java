/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package d.v.c.b2;

import android.os.Handler;
import android.os.Message;
import d.v.c.b2.p;
import java.lang.ref.WeakReference;

public class p$a
extends Handler {
    private static final int e = 2;
    private static final int f = 1;
    private final WeakReference a;
    private final Runnable b;
    private final Runnable c;
    private boolean d;

    public p$a(p p10) {
        WeakReference<p> weakReference = new WeakReference<p>(this);
        this.b = weakReference;
        super(this);
        this.c = weakReference;
        this.a = weakReference = new WeakReference<p>(p10);
    }

    private /* synthetic */ void d() {
        this.j();
        this.a();
    }

    private /* synthetic */ void f() {
        this.h();
    }

    private void i(int n10) {
        Message message = this.obtainMessage();
        message.what = n10;
        this.sendMessage(message);
    }

    private void j() {
        this.i(1);
    }

    public void a() {
        Runnable runnable = this.b;
        this.postDelayed(runnable, 40);
    }

    public p b() {
        return (p)this.a.get();
    }

    public boolean c() {
        return this.d;
    }

    public /* synthetic */ void e() {
        this.d();
    }

    public /* synthetic */ void g() {
        this.f();
    }

    public void h() {
        this.d = false;
        this.i(2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        p p10 = this.b();
        if (p10 != null) {
            int n10 = message.what;
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    p.q(p10);
                }
            } else {
                p.p(p10);
            }
        }
    }

    public void k() {
        boolean bl2 = this.hasMessages(2);
        if (bl2) {
            return;
        }
        this.d = true;
        Runnable runnable = this.c;
        this.postDelayed(runnable, 800L);
    }

    public void l() {
        boolean bl2 = this.hasMessages(1);
        if (bl2) {
            return;
        }
        this.a();
    }

    public void m() {
        this.d = false;
        Runnable runnable = this.c;
        this.removeCallbacks(runnable);
        this.removeMessages(2);
    }

    public void n() {
        Runnable runnable = this.b;
        this.removeCallbacks(runnable);
        this.removeMessages(1);
    }
}

