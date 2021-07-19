/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import d.v.c.n1.i2;
import java.util.List;

public final class u
implements Observer {
    public final /* synthetic */ i2 a;

    public /* synthetic */ u(i2 i22) {
        this.a = i22;
    }

    public final void onChanged(Object object) {
        i2 i22 = this.a;
        object = (List)object;
        i22.L((List)object);
    }
}

