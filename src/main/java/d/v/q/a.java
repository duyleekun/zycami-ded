/*
 * Decompiled with CFR 0.151.
 */
package d.v.q;

import d.v.q.e;
import java.util.function.IntConsumer;

public final class a
implements IntConsumer {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ a(Object[] objectArray, Object[] objectArray2) {
        this.a = objectArray;
        this.b = objectArray2;
    }

    public final void accept(int n10) {
        Object[] objectArray = this.a;
        Object[] objectArray2 = this.b;
        e.B(objectArray, objectArray2, n10);
    }
}

