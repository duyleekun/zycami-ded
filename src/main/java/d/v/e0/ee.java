/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package d.v.e0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.zhiyun.protocol.constants.BoxWorkingMode;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.e0.ee$b;
import d.v.y.c.s1.n.d;

public class ee {
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    private static final int m = 3;
    private static final int n = 4;
    private static final int o = 5;
    private static final int p = 6;
    private static final int q = 7;
    private static final int r = 8;
    private static final int s = 9;
    private static final long t = 5000L;
    private Boolean a;
    private Integer b;
    private WorkingMode c;
    private BoxWorkingMode d;
    private Integer e;
    private Integer f;
    private ee$b g;
    private Handler h;
    private Handler i;

    public ee() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.h = handler = new Handler(looper);
        looper = Looper.getMainLooper();
        super(this, looper);
        this.i = handler;
    }

    public static /* synthetic */ ee$b a(ee ee2) {
        return ee2.g;
    }

    public static /* synthetic */ void b(ee ee2, Integer n10, long l10, Runnable runnable) {
        ee2.c(n10, l10, runnable);
    }

    private void c(Integer n10, long l10, Runnable runnable) {
        Handler handler = this.h;
        handler.removeCallbacksAndMessages(null);
        int n11 = n10;
        int n12 = 100;
        if (n11 < n12) {
            n10 = this.h;
            n10.postDelayed(runnable, l10);
        }
    }

    private void d(d object) {
        Boolean bl2;
        boolean n10 = ((d)object).i();
        if (!n10) {
            return;
        }
        boolean bl3 = ((d)object).p();
        boolean bl4 = ((Boolean)(object = Boolean.valueOf(bl3))).equals(bl2 = this.a);
        if (bl4) {
            return;
        }
        this.a = object;
        bl3 = (Boolean)object;
        boolean bl5 = false;
        bl2 = null;
        if (bl3) {
            this.i.removeMessages(0);
            object = this.i;
            int n11 = 1;
            bl3 = object.hasMessages(n11);
            if (!bl3) {
                object = this.i;
                object.sendEmptyMessage(n11);
            }
        } else {
            object = this.i;
            bl3 = object.hasMessages(0);
            if (!bl3) {
                object = this.i;
                long l10 = 5000L;
                object.sendEmptyMessageDelayed(0, l10);
            }
        }
    }

    private void e(d object) {
        Integer n10;
        boolean bl2 = ((d)object).k();
        if (!bl2) {
            return;
        }
        int n11 = ((d)object).d();
        bl2 = ((Integer)(object = Integer.valueOf(n11))).equals(n10 = this.f);
        if (bl2) {
            return;
        }
        this.f = object;
        object = this.i.obtainMessage(6, object);
        this.i.sendMessage((Message)object);
    }

    private void f(d object) {
        Integer n10;
        boolean bl2 = ((d)object).l();
        if (!bl2) {
            return;
        }
        int n11 = ((d)object).e();
        bl2 = ((Integer)(object = Integer.valueOf(n11))).equals(n10 = this.e);
        if (bl2) {
            return;
        }
        this.e = object;
        object = this.i.obtainMessage(5, object);
        this.i.sendMessage((Message)object);
    }

    private void g(d object) {
        Integer n10;
        boolean bl2 = ((d)object).n();
        if (!bl2) {
            return;
        }
        int n11 = ((d)object).g();
        bl2 = ((Integer)(object = Integer.valueOf(n11))).equals(n10 = this.b);
        if (bl2) {
            return;
        }
        this.b = object;
        object = this.i.obtainMessage(2, object);
        this.i.sendMessage((Message)object);
    }

    private void h(d object) {
        BoxWorkingMode boxWorkingMode;
        boolean bl2 = object.j();
        if (!bl2) {
            return;
        }
        if ((object = object.c()) == (boxWorkingMode = this.d)) {
            return;
        }
        this.d = object;
        object = this.i.obtainMessage(4, object);
        this.i.sendMessage((Message)object);
    }

    private void i(d object) {
        WorkingMode workingMode;
        boolean bl2 = object.o();
        if (!bl2) {
            return;
        }
        if ((object = object.h()) == (workingMode = this.c)) {
            return;
        }
        this.c = object;
        object = this.i.obtainMessage(3, object);
        this.i.sendMessage((Message)object);
    }

    public void j(ee$b ee$b) {
        this.g = ee$b;
    }

    public void k(d d10) {
        ee$b ee$b = this.g;
        if (ee$b == null) {
            return;
        }
        this.d(d10);
        this.g(d10);
        this.i(d10);
        this.h(d10);
        this.f(d10);
        this.e(d10);
    }
}

