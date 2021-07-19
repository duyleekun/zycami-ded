/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.c.a.u;

import android.view.View;
import d.c.a.f$b;
import d.c.a.s.j.o;
import d.c.a.u.n$a;
import java.util.Arrays;

public class n
implements f$b,
o {
    private int[] a;
    private n$a b;

    public n() {
    }

    public n(View view) {
        n$a n$a;
        this.b = n$a = new n$a(view);
        n$a.p(this);
    }

    public int[] a(Object object, int n10, int n11) {
        object = this.a;
        if (object == null) {
            return null;
        }
        n10 = ((Object)object).length;
        return Arrays.copyOf((int[])object, n10);
    }

    public void b(View view) {
        Object object = this.a;
        if (object == null && (object = (Object)this.b) == null) {
            object = new n$a;
            object(view);
            this.b = object;
            object.p(this);
        }
    }

    public void d(int n10, int n11) {
        int[] nArray = new int[]{n10, n11};
        this.a = nArray;
        this.b = null;
    }
}

