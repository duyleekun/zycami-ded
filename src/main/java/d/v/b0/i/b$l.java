/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.b0.i;

import android.content.Context;
import d.v.b0.i.b;
import d.v.b0.i.b$l$a;
import d.v.b0.i.b$l$b;
import d.v.b0.i.b$l$c;
import d.v.b0.i.b$l$d;

public class b$l
implements Runnable {
    public final /* synthetic */ b a;

    public b$l(b b10) {
        this.a = b10;
    }

    public void run() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5 = b.a0(this.a);
        int n10 = b.m0((Context)object5, (String)(object4 = "graphics/controller.bundle"));
        if (n10 <= 0) {
            return;
        }
        object5 = b.a0(this.a);
        int n11 = b.m0((Context)object5, "pta/controller_config.bundle");
        int[] nArray = new int[2];
        int n12 = 0;
        object4 = null;
        nArray[0] = n11;
        if (n11 > 0) {
            object3 = this.a;
            object2 = new b$l$a(this, n10, n11);
            object3.F1((Runnable)object2);
        }
        object5 = b.a0(this.a);
        object3 = "pta/default_bg.bundle";
        n11 = b.m0((Context)object5, (String)object3);
        int n13 = 1;
        nArray[n13] = n11;
        if (n11 > 0) {
            object3 = this.a;
            object2 = new b$l$b(this, n10, n11);
            object3.F1((Runnable)object2);
        }
        object5 = b.a0(this.a);
        object3 = "graphics/fxaa.bundle";
        int n14 = b.m0((Context)object5, (String)object3);
        n11 = b.H0().length;
        object5 = new int[n11];
        while (n12 < (n13 = ((String[])(object3 = b.H0())).length)) {
            object3 = b.a0(this.a);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("pta/gesture/");
            object = b.H0()[n12];
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            n13 = b.m0(object3, (String)object2);
            object5[n12] = n13;
            ++n12;
        }
        object = b.R0(this.a, (int[])object5);
        object5 = this.a;
        object4 = new b$l$c(this, n10, (int[])object);
        ((b)object5).F1((Runnable)object4);
        object5 = this.a;
        object3 = object4;
        object2 = this;
        object4 = new b$l$d(this, n10, n14, nArray, (int[])object);
        ((b)object5).F1((Runnable)object4);
    }
}

