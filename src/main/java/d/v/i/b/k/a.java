/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class a
implements Consumer {
    public final /* synthetic */ IntConsumer a;

    public /* synthetic */ a(IntConsumer intConsumer) {
        this.a = intConsumer;
    }

    public final void accept(Object object) {
        IntConsumer intConsumer = this.a;
        int n10 = (Integer)object;
        intConsumer.accept(n10);
    }
}

