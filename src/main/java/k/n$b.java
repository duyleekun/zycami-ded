/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Array;
import k.n;
import k.p;

public class n$b
extends n {
    public final /* synthetic */ n a;

    public n$b(n n10) {
        this.a = n10;
    }

    public void a(p p10, Object object) {
        if (object == null) {
            return;
        }
        int n10 = Array.getLength(object);
        for (int i10 = 0; i10 < n10; ++i10) {
            n n11 = this.a;
            Object object2 = Array.get(object, i10);
            n11.a(p10, object2);
        }
    }
}

