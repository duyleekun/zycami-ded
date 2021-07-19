/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import d.v.c.x0.b.p;
import java.util.List;

public final class j
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ j(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (List)object;
        p10.O((List)object);
    }
}

