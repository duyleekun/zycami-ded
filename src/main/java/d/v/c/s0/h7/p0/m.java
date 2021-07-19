/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.p0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.p0.q;
import java.util.List;

public final class m
implements Observer {
    public final /* synthetic */ q a;

    public /* synthetic */ m(q q10) {
        this.a = q10;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        object = (List)object;
        q10.m((List)object);
    }
}

