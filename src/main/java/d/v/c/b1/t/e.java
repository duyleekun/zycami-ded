/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.b1.t;

import android.content.Context;
import d.v.c.b1.t.g;
import java.util.function.IntConsumer;

public final class e
implements IntConsumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ Context b;

    public /* synthetic */ e(g g10, Context context) {
        this.a = g10;
        this.b = context;
    }

    public final void accept(int n10) {
        g g10 = this.a;
        Context context = this.b;
        g10.y4(context, n10);
    }
}

