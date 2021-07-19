/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.o0.v0;
import java.util.List;

public final class m
implements Observer {
    public final /* synthetic */ v0 a;

    public /* synthetic */ m(v0 v02) {
        this.a = v02;
    }

    public final void onChanged(Object object) {
        v0 v02 = this.a;
        object = (List)object;
        v02.w((List)object);
    }
}

