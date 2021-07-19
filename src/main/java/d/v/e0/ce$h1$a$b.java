/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce$h1$a;
import e.a.v0.o;

public class ce$h1$a$b
implements o {
    public final /* synthetic */ ce$h1$a a;

    public ce$h1$a$b(ce$h1$a ce$h1$a) {
        this.a = ce$h1$a;
    }

    public Integer a(Object object) {
        int n10;
        object = this.a;
        int[] nArray = object.c.a;
        int n11 = 3;
        nArray[n11] = n10 = nArray[n11] + 1;
        float f10 = (float)n10 * 100.0f;
        float f11 = ((ce$h1$a)object).b;
        return (int)(f10 / f11);
    }
}

