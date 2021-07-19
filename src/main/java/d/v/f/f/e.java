/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 *  android.view.WindowManager
 */
package d.v.f.f;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public abstract class e
extends OrientationEventListener {
    private int a;

    public e(Context context) {
        super(context);
        int n10;
        this.a = n10 = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    private static boolean b(int n10) {
        int n11 = 340;
        n10 = n10 <= n11 && n10 >= (n11 = 20) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean c(int n10) {
        int n11 = 160;
        n10 = n10 > n11 && n10 < (n11 = 200) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean d(int n10) {
        int n11 = 250;
        n10 = n10 > n11 && n10 < (n11 = 290) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean e(int n10) {
        int n11 = 70;
        n10 = n10 > n11 && n10 < (n11 = 110) ? 1 : 0;
        return n10 != 0;
    }

    public static int g(int n10, int n11) {
        boolean bl2 = e.d(n10);
        if (bl2) {
            n11 = 3;
        } else {
            bl2 = e.c(n10);
            if (bl2) {
                n11 = 2;
            } else {
                bl2 = e.e(n10);
                if (bl2) {
                    n11 = 1;
                } else if ((n10 = (int)(e.b(n10) ? 1 : 0)) != 0) {
                    n11 = 0;
                }
            }
        }
        return n11;
    }

    public int a() {
        return this.a;
    }

    public abstract void f(int var1);

    public void onOrientationChanged(int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        n11 = this.a;
        n11 = this.a;
        if (n11 != (n10 = e.g(n10, n11))) {
            this.a = n10;
            this.f(n10);
        }
    }
}

