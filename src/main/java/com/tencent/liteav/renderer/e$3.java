/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.opengl.f;
import com.tencent.liteav.renderer.e;

public class e$3
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ e c;

    public e$3(e e10, int n10, int n11) {
        this.c = e10;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        int n10;
        Object object = this.c;
        ((e)object).m = n10 = this.a;
        ((e)object).n = n10 = this.b;
        if ((object = e.a((e)object)) != null) {
            int n11;
            f f10 = e.a(this.c);
            object = e.b(this.c);
            Object object2 = null;
            Object object3 = object[0];
            int[] nArray = e.b(this.c);
            int n12 = nArray[3];
            if (n12 == (n11 = 1)) {
                n12 = n11;
            } else {
                n12 = 0;
                nArray = null;
            }
            int n13 = e.b(this.c)[4];
            object2 = this.c;
            int n14 = ((e)object2).m;
            int n15 = ((e)object2).n;
            Object object4 = e.b((e)object2)[n11];
            object2 = e.b(this.c);
            Object object5 = object2[2];
            n11 = n13;
            n13 = n14;
            n14 = n15;
            n15 = object4;
            object4 = object5;
            object5 = true;
            f10.a((int)object3, n12 != 0, n11, n13, n14, n15, (int)object4, (boolean)object5, false);
        }
    }
}

