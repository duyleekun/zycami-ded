/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import d.v.c.i1.h2;
import java.util.List;

public final class a1
implements Observer {
    public final /* synthetic */ h2 a;

    public /* synthetic */ a1(h2 h22) {
        this.a = h22;
    }

    public final void onChanged(Object object) {
        h2 h22 = this.a;
        object = (List)object;
        h22.O0((List)object);
    }
}

