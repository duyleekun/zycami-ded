/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package d.v.b.e0;

import android.content.Context;
import android.view.OrientationEventListener;
import d.v.b.e0.a;
import d.v.b.e0.a$a;
import java.util.ArrayList;
import java.util.Iterator;

public class b
implements a {
    private static final int d = 60;
    private static final int e = 360;
    private static final int f = 180;
    private final OrientationEventListener a;
    private final ArrayList b;
    private int c = 0;

    public b(Context context) {
        Object object;
        this.b = object = new Object();
        super(this, context);
        this.a = object;
    }

    public static /* synthetic */ void f(b b10, int n10) {
        b10.g(n10);
    }

    private void g(int n10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = 360)) {
            int n12;
            int n13 = this.c;
            if ((n13 = Math.abs(n10 - n13)) > (n12 = 180)) {
                n13 = 360 - n13;
            }
            if (n13 < (n12 = 60)) {
                return;
            }
            if ((n10 = (n10 + 45) / 90 * 90 % n11) != (n11 = this.c)) {
                this.c = n10;
                this.h();
            }
        }
    }

    private void h() {
        boolean bl2;
        Iterator iterator2 = this.b.iterator();
        while (bl2 = iterator2.hasNext()) {
            a$a a$a = (a$a)iterator2.next();
            int n10 = this.c;
            a$a.a(n10);
        }
    }

    private static boolean i(int n10) {
        int n11 = 340;
        n10 = n10 <= n11 && n10 >= (n11 = 20) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean j(int n10) {
        int n11 = 160;
        n10 = n10 > n11 && n10 < (n11 = 200) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean k(int n10) {
        int n11 = 250;
        n10 = n10 > n11 && n10 < (n11 = 290) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean l(int n10) {
        int n11 = 70;
        n10 = n10 > n11 && n10 < (n11 = 110) ? 1 : 0;
        return n10 != 0;
    }

    public static int m(int n10, int n11) {
        boolean bl2 = d.v.b.e0.b.k(n10);
        if (bl2) {
            n11 = 3;
        } else {
            bl2 = d.v.b.e0.b.j(n10);
            if (bl2) {
                n11 = 2;
            } else {
                bl2 = d.v.b.e0.b.l(n10);
                if (bl2) {
                    n11 = 1;
                } else if ((n10 = (int)(d.v.b.e0.b.i(n10) ? 1 : 0)) != 0) {
                    n11 = 0;
                }
            }
        }
        return n11;
    }

    public void a(a$a a$a) {
        this.b.remove(a$a);
    }

    public int b() {
        return this.c;
    }

    public void c(boolean bl2) {
        if (bl2) {
            OrientationEventListener orientationEventListener = this.a;
            orientationEventListener.enable();
        } else {
            OrientationEventListener orientationEventListener = this.a;
            orientationEventListener.disable();
        }
    }

    public void close() {
        this.a.disable();
        this.b.clear();
    }

    public void d() {
        int n10 = this.c;
        this.g(n10);
    }

    public void e(a$a a$a) {
        ArrayList arrayList = this.b;
        boolean bl2 = arrayList.contains(a$a);
        if (bl2) {
            return;
        }
        this.b.add(a$a);
    }
}

