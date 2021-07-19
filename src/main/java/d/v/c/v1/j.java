/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.lifecycle.Observer;
import d.v.c.v1.o;
import d.v.h.k.b;
import java.util.List;

public final class j
implements Observer {
    public final /* synthetic */ o a;
    public final /* synthetic */ b b;

    public /* synthetic */ j(o o10, b b10) {
        this.a = o10;
        this.b = b10;
    }

    public final void onChanged(Object object) {
        o o10 = this.a;
        b b10 = this.b;
        object = (List)object;
        o10.H(b10, (List)object);
    }
}

